package Assignment8;

class Vehicle {
    String vehicleNumber;
    String model;
    int manufactureYear;

    Vehicle(String vehicleNumber, String model, int manufactureYear) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.manufactureYear = manufactureYear;
    }

    void displayVehicleInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Model: " + model);
        System.out.println("Manufacture Year: " + manufactureYear);
    }
}

class CarInsurance extends Vehicle {
    double premiumAmount;

    CarInsurance(String vehicleNumber, String model, int manufactureYear, double premiumAmount) {
        super(vehicleNumber, model, manufactureYear); // sets Vehicle's fields via super
        this.premiumAmount = premiumAmount;
    }

    void displayInsuranceInfo() {
        super.displayVehicleInfo(); // reuse Vehicle's display logic
        System.out.println("Car Insurance Premium: " + premiumAmount);
    }
}

class BikeInsurance extends Vehicle {
    double premiumAmount;

    BikeInsurance(String vehicleNumber, String model, int manufactureYear, double premiumAmount) {
        super(vehicleNumber, model, manufactureYear);
        this.premiumAmount = premiumAmount;
    }

    void displayInsuranceInfo() {
        super.displayVehicleInfo();
        System.out.println("Bike Insurance Premium: " + premiumAmount);
    }
}

public class VehicleInsuranceApp {
    public static void main(String[] args) {
        CarInsurance car = new CarInsurance("MH12AB1234", "Honda City", 2022, 12000.00);
        BikeInsurance bike = new BikeInsurance("MH12CD5678", "Royal Enfield", 2021, 4500.00);

        car.displayInsuranceInfo();
        System.out.println("-----");
        bike.displayInsuranceInfo();
    }
}
