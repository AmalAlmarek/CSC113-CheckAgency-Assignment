
package checkagency;
import java.io.Serializable;

public class Address implements Serializable {
    
    private String city; // name of the city
    private String street; // name of the street
    
    public Address (String c ,String s) { 
        city = c;
        street = s;
    }
    public String toString() { 
        return "City : "+ city + "Street : " + street; 
    }
    /*public String getCity() { 
        return city;
    }
*/
}
