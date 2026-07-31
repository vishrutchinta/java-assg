class Utility {
    static int count = 0;

    // Method Overloading: Method 1 (Adds two integers)
    public int add(int a, int b) {
        count++;
        return a + b;
    }

    // Method Overloading: Method 2 (Adds three integers)
    public int add(int a, int b, int c) {
        count++;
        return a + b + c;
    }

    // Method Overloading: Method 3 (Adds two double values)
    public double add(double a, double b) {
        count++;
        return a + b;
    }

    // Static method to display total operations performed
    public static void displaycount() {
        System.out.println("Total addition operations performed: " + count);
    }



    public static void main(String[] args) {
        Utility util = new Utility();

        // Calling overloaded methods
        System.out.println("Sum of 10 and 20 (int): " + util.add(10, 20));
        System.out.println("Sum of 5, 10, and 15 (int): " + util.add(5, 10, 15));
        System.out.println("Sum of 4.5 and 3.2 (double): " + util.add(4.5, 3.2));

        System.out.println("----------------------------------");
        
        // Calling static method without creating a new instance
        Utility.displaycount();
    }
}