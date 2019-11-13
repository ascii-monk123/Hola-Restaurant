package customers;
import java.util.Scanner;

public class Customer {
    Scanner s=new Scanner(System.in);
    public String name;
 public void getData(){
     System.out.println("\nEnter your name\n");

     this.name=s.nextLine();
 }

}
