
package checkagency;

public class Shop extends Property{
    private double area; //area of the shop to calculate rent 
    
    public Shop(Shop s ) { 
        super(s.id , s.rent , s.loc);
        area = s.area;
    }
    
    public Shop(int i , double r , Address l , double a ) { 
        super(i , r , l);
        area = a;
    }
   
    public double calculateRent() { 
        return area * rent;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
    
    
}
