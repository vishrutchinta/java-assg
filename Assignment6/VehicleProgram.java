package Assignment6;

class VehicleOuter{
    private int chasis = 250701222;
    private String registration_no = "4508t6739017";
    class Inner{
        void displayPrivateVehicleDetails(){
            System.out.println("Chasis number: "+chasis);
            System.out.println("Registration Number of the car is: "+registration_no);
        }
    }
}
interface Condition {
    void status();
}

public class VehicleProgram {
    public static void main(String[] args) {
        VehicleOuter vehicle = new VehicleOuter();
        VehicleOuter.Inner veh_1 = vehicle.new Inner();
        veh_1.displayPrivateVehicleDetails();

        Condition start = new Condition() {
            public void status(){
                System.out.println("The engine has started");
            }
        };
        Condition off = new Condition() {
            public void status(){
                System.out.println("The engine has been switched off");
            }
        
        };
        start.status();
        off.status();

    }

    
}
