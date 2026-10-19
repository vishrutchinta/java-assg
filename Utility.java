class Utility {
    static int count = 0;

    public int add(int a, int b) {
        count++;
        return a + b;
    }

    public int add(int a, int b, int c) {
        count++;
        return a + b + c;
    }

    public double add(double a, double b) {
        count++;
        return a + b;
    }

    public static void displaycount() {
        System.out.println("Total addition operations performed: " + count);
    }



    public static void main(String[] args) {
        Utility obj = new Utility();

        // Calling overloaded methods
        System.out.println("Sum of 10 and 20 (int): " + obj.add(10, 20));
        System.out.println("Sum of 5, 10, and 15 (int): " + obj.add(5, 10, 15));
        System.out.println("Sum of 4.5 and 3.2 (double): " + obj.add(4.5, 3.2));

        System.out.println("----------------------------------");
        
        Utility.displaycount();
    }
}