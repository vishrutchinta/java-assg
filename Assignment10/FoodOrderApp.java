package Assignment10;

abstract class FoodOrder {
    double baseAmount;

    FoodOrder(double baseAmount) {
        this.baseAmount = baseAmount;
    }

    abstract double calculateBill();
}

class DineInOrder extends FoodOrder {
    DineInOrder(double baseAmount) {
        super(baseAmount);
    }

    double calculateBill() {
        return baseAmount + (baseAmount * 0.10); // 10% service charge
    }
}

class TakeAwayOrder extends FoodOrder {
    TakeAwayOrder(double baseAmount) {
        super(baseAmount);
    }

    double calculateBill() {
        return baseAmount; // no service charge
    }
}

public class FoodOrderApp {
    public static void main(String[] args) {
        FoodOrder order1 = new DineInOrder(1000);
        FoodOrder order2 = new TakeAwayOrder(1000);

        System.out.println("Dine-In Bill: " + order1.calculateBill());
        System.out.println("Take-Away Bill: " + order2.calculateBill());
    }
}