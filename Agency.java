
package checkagency;
import java.io.*;
import java.util.*;
public class Agency implements InputOutput {
    private int nbp;
    private Property[] pList;
    public Agency(int size ) { 
        pList = new Property[size];
    }
    public boolean addProperty(Property p) { 
        //list is full
        if(pList.length == nbp)
            return false;
      
           
            if( p instanceof Shop ) 
            {
               if(check("Shop", p.id)!= -1)
                    return false; 
                
                pList[nbp++] = new Shop((Shop)p);
                return true ;
                
            }
            else 
                if ( p instanceof Apartment )
                {
                    if(check("Apartment", p.id)!= -1)
                    return false; 
 
                    pList[nbp++] = new Apartment((Apartment) p );
                    return true;
            }        
               
          return true; 
    }
    public int check(String prop , int id ) { 
        for( int i = 0 ; i < nbp ;i++)
            if(pList[i].id == id && pList[i].getClass().getSimpleName().equals(prop))
                return i;
            
                return -1;
                        
    }
    public Property[] retrive(String PropertyType , String city) throws WrongTypeException { 
        
        Property[] list = new Property[nbp];
        
        if(!PropertyType.equalsIgnoreCase("Shop") && !PropertyType.equalsIgnoreCase("Apartment"))
         throw new WrongTypeException("Wrong Property");
        
        int j = 0;
        for( int i = 0 ; i < nbp ; i++)
          if(pList[i].getClass().getSimpleName().equals(PropertyType) && (pList[i].loc.equals(city)) || city.length() == 0 || city == null) 
              
              if(pList[i] instanceof Shop)
                list[j++] = new Shop((Shop) pList[i]);
              else 
                  if(pList[i] instanceof Apartment)
                       list[j++] = new Apartment((Apartment) pList[i]);
                  
                    return list;
    }              
              
    public void ReadProperty(String fileName) throws FileNotFoundException  { 
        //open
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
         
        //process
        while(scan.hasNext()) {
        int idd = scan.nextInt();
        double ren = scan.nextDouble();
        char Type = scan.next().charAt(0);
        double are = scan.nextDouble();
        String cit = scan.next();
        String str = scan.next();
        
        if(Type == 'S')
        addProperty(new Shop(idd,ren, new Address(str , cit) , are ));
        else if(Type == 'A')
        addProperty(new Apartment(idd, ren , new Address(str , cit) , (int) are));
        
        }
        //close
        scan.close();
        
        
    } 
    
    public void saveIntoFile(String Filename) throws IOException , WrongTypeException{ 
        //open object file 
        File file = new File(Filename);
        FileOutputStream out = new FileOutputStream(file);
        ObjectOutputStream obOut = new ObjectOutputStream(out);
        
        Property[] list = retrive("Apartment" , "");
        for( int i = 0 ;i < nbp ; i++)
            if(list[i]!= null )
                obOut.writeObject(list[i]);
          
          Property[] list0 = retrive("Shop" , "");
            for( int i = 0 ;i < nbp ; i++)
            if(list0[i]!= null )
                obOut.writeObject(list0[i]);
            
            obOut.close();
      
            
        }
    
    public void Display() { 
        
        System.out.println("Number of Property : " +nbp);
        for( int i = 0 ; i < nbp ;i++){
            System.out.println(pList[i].getClass().getSimpleName());
           System.out.println(pList[i].toString()) ;
            System.out.println("Rent  :" +pList[i].calculateRent());
        }
        
    }
    }
    

