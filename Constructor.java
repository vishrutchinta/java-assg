public class Constructor {
    long prn;
    String name;
    Constructor(){
        prn = 99;
    }
    Constructor(long p ,String n){
        prn = p;
        name = n;
    }
    Constructor(String n){
        name = n;
    }
    Constructor(Constructor a){
        name = a.name;
        prn = a.prn;
    }
    void print(){
        System.out.println("Name: "+name);
        System.out.println("PRN: "+prn);
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        Constructor obj = new Constructor();
        obj.print();
        Constructor obj1 = new Constructor(250701218,"vishrut");
        obj1.print();
        Constructor obj2 = new Constructor("vishrut");
        obj2.print();
        Constructor obj3 = new Constructor(obj1);
        obj3.print();

        
    }
    
}
