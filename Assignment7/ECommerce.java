package Assignment7;

interface Products{
    void displayDetails();
    void domain();
}

class Details{
    StringBuffer name = new StringBuffer();
    int item_id;
    double price;

}
class Electronics extends Details implements Products{
    Electronics(StringBuffer str,int i,double p){
        this.name = str;
        this.item_id = i;
        this.price = p;
    }
    public void domain() {
        System.out.println("This is an electronic item");
    }
    public void displayDetails() {
        System.out.println(name+" 's product id is: "+item_id+" and its price is"+price);
    }
}
class Grocery extends Details implements Products {
    Grocery(StringBuffer str, int i, double p) {
        this.name = str;
        this.item_id = i;
        this.price = p;
    }

    public void domain() {
        System.out.println("This is a grocery item");
    }

    public void displayDetails() {
        System.out.println(name + "'s product id is: " + item_id + " and its price is " + price);
    }
}

class Clothing extends Details implements Products {
    Clothing(StringBuffer str,int i,double p){
        this.name = str;
        this.item_id = i;
        this.price = p;
    }
    public void domain() {
        System.out.println("This is a clohing item");
    }

    public void displayDetails() {
        System.out.println(name + "'s product id is: " + item_id + " and its price is " + price);
    }
}
public class ECommerce {
    public static void main(String[] args) {
        Electronics e = new Electronics(new StringBuffer("Samsung Galaxy S24"), 234762, 50000.000);
        Grocery g = new Grocery(new StringBuffer("Cabbage"),23134,50);
        Clothing c = new Clothing(new StringBuffer("Jacket"),43209,6000);
        e.domain();
        e.displayDetails();
        g.domain();
        g.displayDetails();
        c.domain();
        c.displayDetails();
    }
    
}
