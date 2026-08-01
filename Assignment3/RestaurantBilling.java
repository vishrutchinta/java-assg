package Assignment3;
import java.util.Scanner;

public class RestaurantBilling {
    static int total_orders = 0;

    static void bill(double amount){
        double total = amount;
        System.out.println("Dine-In Bill: "+total);
        total_orders++;
    }

    static void bill(double amount,double packagingCharge){
        double total = amount+packagingCharge;
        System.out.println("Takeaway Bill: "+total);
        total_orders++;
    }

    static void bill(double amount,double deliveryCharge,double distance){
        double total = amount+deliveryCharge+(distance*5);
        System.out.println("Delivery Bill: "+total);
        total_orders++;
    }

    public static void main(String[] args) {
        Scanner st = new Scanner(System.in);
        System.out.println("START/STOP : ");
        String status = st.nextLine();
        while(!status.equals("STOP")){

        System.out.println("Enter order type (1-DineIn/2-Takeaway/3-Delivery): ");
        int type = st.nextInt();

        if(type == 1){
            System.out.println("Enter bill amount: ");
            double amount = st.nextDouble();
            bill(amount);
        }
        else if(type == 2){
            System.out.println("Enter bill amount: ");
            double amount = st.nextDouble();
            System.out.println("Enter packaging charge: ");
            double packagingCharge = st.nextDouble();
            bill(amount,packagingCharge);
        }
        else if(type == 3){
            System.out.println("Enter bill amount: ");
            double amount = st.nextDouble();
            System.out.println("Enter delivery charge: ");
            double deliveryCharge = st.nextDouble();
            System.out.println("Enter distance in km: ");
            double distance = st.nextDouble();
            bill(amount,deliveryCharge,distance);
        }

        st.nextLine();
        System.out.println("START/STOP : ");
        status = st.nextLine();

    }
    System.out.println("Total Orders : "+total_orders);

}
}
