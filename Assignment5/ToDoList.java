package Assignment5;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();
        Scanner st = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("Task "+(i+1)+": ");
            arr.add(st.nextLine());    
        }
        st.close();
        System.out.println("---------TO DO LIST---------");
        StringBuilder arr1 = new StringBuilder();
        for(int i =0;i<5;i++){
            arr1.append("Task "+(i+1)+": "+arr.get(i)+" ");
        }
        System.out.println(arr1);

    }
}
