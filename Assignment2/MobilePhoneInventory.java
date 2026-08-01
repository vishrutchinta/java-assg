package Assignment2;

public class MobilePhoneInventory {
    String m_name;
    int serialno;
    int ram;
    MobilePhoneInventory(String mn,int sn,int r){
        m_name = mn;
        serialno = sn;
        ram = r;
    }
    MobilePhoneInventory(MobilePhoneInventory p){
        m_name = p.m_name;
        serialno = p.serialno;
        ram = p.ram;
    }
    void print(){
        System.out.println("Phone Name: "+m_name);
        System.out.println("SerialNo.: "+serialno);
        System.out.println("RAM: "+ram);
    }
    public static void main(String args[]){
        MobilePhoneInventory m1 = new MobilePhoneInventory("Samsung",3310,8);
        m1.print();
        MobilePhoneInventory m2 = new MobilePhoneInventory(m1);
        m2.print();
        

    }
}
    

