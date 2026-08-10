package Assignment6;
import java.util.Scanner;

class Outer{
    private String orderID;
    private String orderAddress;
    private Integer transactionID;

    Outer(String id , String oa,Integer tid){
        this.orderID = id;
        this.orderAddress = oa;
        this.transactionID = tid;
    }

    class Inner{
        void display(){
            System.out.println("Order ID: "+orderID);
            System.out.println("Address :"+orderAddress);
            System.out.println("Transaction ID: "+transactionID);
        }

    }
}

interface Status{
    void showDeliveryStatus();
}

public class FoodDeliveryApplication {
    public static void main(String[] args) {
        Scanner st = new Scanner(System.in);
        System.out.println("Enter Customer's Order ID: ");
        String orderID = st.nextLine();
        System.out.println("Enter Address: ");
        String address = st.nextLine();
        System.out.println("Enter Transaction ID: ");
        Integer tid = st.nextInt();
        Outer outer = new Outer(orderID,address,tid);
        Outer.Inner inner = outer.new Inner();
        inner.display();

        Status isPreparing = new Status() {
            public void showDeliveryStatus(){
                System.out.println("Order is preparing....");
            }
        };
        Status dispatched = new Status() {
            public void showDeliveryStatus(){
                System.out.println("Order has been dispatched!");
            }
        };
        Status success = new Status(){
            public void showDeliveryStatus(){
                System.out.println("order has been deilvered successfully.");
            }
        };

        isPreparing.showDeliveryStatus();
        dispatched.showDeliveryStatus();
        success.showDeliveryStatus();
        
    }
    
}
