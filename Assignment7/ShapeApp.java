package Assignment7;

interface Shapes {
    void draw();
    double calculateArea();
}

class Rectangle implements Shapes {
    int length, breadth;

    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void draw() {
        System.out.println("Rectangle's Drawn");
    }

    public double calculateArea() {
        return length * breadth;
    }
}

class Circle implements Shapes {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("Circle's Drawn");
    }

    public double calculateArea() {
        return 3.14 * radius * radius;
    }
}

public class ShapeApp {
    public static void main(String[] args) {
        Shapes rect = new Rectangle(3, 4);
        Shapes cir = new Circle(5);

        rect.draw();
        System.out.println("Area of Rectangle: " + rect.calculateArea());

        cir.draw();
        System.out.println("Area of Circle: " + cir.calculateArea());
    }
}