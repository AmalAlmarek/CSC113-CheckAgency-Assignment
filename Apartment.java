
package checkagency;
import java.util.*;
public class Apartment extends Property implements ApartmentPrice {
   private int floor;
   
   public Apartment(Apartment a ) { 
       super(a.id , a.rent , a.loc);
       floor = a.floor;
   }
   public Apartment(int i , double r , Address l , int f) { 
       super(i , r ,l );
       floor = f;
   }
   public double calculateRent() { 
   //maybe floor  is a negative number , or array index out of bond 
   try { 
        return rent * price[floor];
        
       }
       catch(ArrayIndexOutOfBoundsException e) { 
             return rent*price[0];
               }
    
   }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
   
}
