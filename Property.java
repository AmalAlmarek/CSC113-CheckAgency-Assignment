
package checkagency;
import java.io.Serializable;
public abstract class Property implements Serializable {
   protected int id ; // unique id for property
   protected double rent; // basic rent of the property
   protected Address loc; // ocation of the property (city and street)
   
   public Property(int i , double r , Address a ) { 
       id = i;
       rent = r;
       loc = a;
       
   }
   public abstract double calculateRent();
   
   public String toString() { 
       return "id : "+ id + " ,rent "+ rent + " ,Address: " +  loc.toString();
   }
}
