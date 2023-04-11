
package checkagency;
import java.io.*;
public class CheckAgency {

    public static void main(String[] args) {
       Agency Ag = new Agency(30);
       try { 
           Ag.ReadProperty("Property.txt");
          
       System.out.println("Displaying Agency Info : ");
       Ag.Display();
       
        Ag.addProperty(new Shop(3411, 1200,new Address ("First Street" , "Dammam") , 300));
        Ag.addProperty(new Apartment(6799 , 980 , new Address("Olaya Street", "Riyadh" ), 5));
     
       Ag.saveIntoFile("file.dat");
       }
       catch(WrongTypeException e) { 
            System.out.println(e.getMessage());
       }
       catch(IOException r ) { 
           System.out.println(r.getMessage());
       }
    
}
}
