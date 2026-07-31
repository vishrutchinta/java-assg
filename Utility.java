class Assg3 {
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

    public static void displaycount() {
        System.out.println("Total addition operations performed: " + count);
    }



    public static void main(String[] args) {
        Assg3 util = new Assg3();

        // Calling overloaded methods
        System.out.println("Sum of 30 and 20 (int): " + util.add(30, 20));
        System.out.println("Sum of 23, 69, and 15 (int): " + util.add(23, 69, 15));
        System.out.println("Sum of 4.2 and 3.2 (double): " + util.add(4.2, 3.2));

        System.out.println("----------------------------------");
        
        // Calling static method without creating a new instance
        Assg3.displaycount();
    }
}
