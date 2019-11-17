package main;
import java.sql.SQLOutput;
import java.util.Scanner;
import Menu_info.*;
import Rest_Main.*;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import display.Display;
import customers.Customer;
import static java.lang.System.exit;
import showDetails.show;
import java.io.*;

abstract public class Start implements show {
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nAuthentication started\n");
        String auth[]=new String[2];
         BufferedReader rs=new BufferedReader(new InputStreamReader(System.in));

         try {
             System.out.println("Enter your name\n");
             auth[0] = rs.readLine();
             System.out.println("Enter the password\n");
             auth[1]=rs.readLine();

         }
         catch(IOException e){
             System.out.println(e);
         }

        BufferedReader reader;
        try{
            InputStream is = Start.class.getResourceAsStream("authentic.txt");
            reader=new BufferedReader(new InputStreamReader(is));
            int ind=0;
            String line;
            while((line=reader.readLine())!=null){
                if(auth[ind].equals(line)){
                    System.out.println("\n"+line);
                    ind++;

                }
                else{
                    System.out.println("\nInvalid Details the programme is closing down");
                    return;
                }
            }
            reader.close();

        }
        catch(FileNotFoundException e){
            System.out.println("\nSorry the file cannot be found\n");

        }
        catch(IOException E){
            System.out.println("IO exception :"+E);
        }




        Restaurant r[]=new Restaurant[20];
        Customer c[]=new Customer[20];
        int index=-1;
        System.out.println("\nHello and Welcome to the restaurant\n");
       start: while(true){
            System.out.println("\nWhat would you like to do\n");
            System.out.println("\n 1> Customer's Order\n");
            System.out.println("\n 2> See the customer Database\n");
            System.out.println("\n 3>See the total budget \n");
            System.out.println("\n 4>Exit the programme\n");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    int ind=0;
                    String orders[]=new String[20];
                    double bills[]=new double[20];
                    int quantity[]=new int[20];
                    System.out.println("\nHere is the menu\n");
                    Dis d=new Dis();
                    d.DisData();
                    boolean cho=true;
                    System.out.println("\nEnter your name customer\n");
                    index++;
                    c[index]=new Customer();
                    c[index].getData();
                    sc.nextLine();
                    if(c[index].name.equals("")){
                        System.out.println("\nNo name entered\n");
                        continue start;
                    }
                    System.out.println("\nWhat would you like to eat\n??");
                    System.out.println("\nEnter F if you want to discontinue\n");
                 outer:   while(cho){
                        System.out.println("\nEnter the item name\n");
                        try {
                            sc.nextLine();
                            String ch = sc.nextLine();
                            if(ch=="F"){
                                cho=false;
                                break outer;
                            }
                            System.out.println("\nEnter the quantity of the item\n");
                            int quant=sc.nextInt();
                          sc.nextLine();
                            switch(ch){
                                case "Apple Pie":
                                    orders[ind]="Apple Pie";
                                    bills[ind]=20.75*quant;
                                    quantity[ind]=quant;
                                    ind++;
                                    break;
                                case "Strawberry Cake":
                                    orders[ind]="Strawberry Cake";
                                    bills[ind]=19.20*quant;
                                    quantity[ind]=quant;
                                    ind++;
                                    break;
                                case "Fantasy bean waffle":
                                    orders[ind]="Fantasy bean waffle";
                                    bills[ind]=50.87*quant;
                                    quantity[ind]=quant;
                                    ind++;
                                    break;
                                case "Belgian choco pancake":
                                    orders[ind]="Belgian choco pancake";
                                    bills[ind]=100.75*quant;
                                    ind++;
                                    break;
                                case "American-delight sundae":
                                    orders[ind]="American-delight sundae";
                                    bills[ind]=15.88*quant;
                                    quantity[ind]=quant;
                                    ind++;
                                    break;
                                case "F" :
                                    break outer;
                                default:
                                    System.out.println("\nInvalid choice please enter again\n");

                            }
                        }
                        catch(Exception e) {
                            System.out.println(e);
                            System.out.println("\nInvalid input please enter again\n");
                            continue;
                        }

                    }
                    try {
                        r[index] = new Restaurant();
                        r[index].setData(bills, orders, quantity);
                        System.out.println("\nCustomer name is \n" + " " + c[index].name);
                        System.out.println("\nYour bill amount is " + r[index].calculateBill());
                        System.out.println("\nDo you want to add a tip Y for yes and N for no");
                        String giveTip = sc.nextLine();
                        if (giveTip.equals("Y")) {
                            System.out.println("\nEnter the tip amount 5 ,10 0r 15 dollar only\n");
                            double tip = sc.nextInt();
                            if (tip == 5 || tip == 10 || tip == 15) {
                                r[index].tip(true, tip);
                                System.out.println("\nYour amount after giving the tip is" + " " + r[index].totalBill);
                            } else {
                                System.out.println("\nInvalid tip amount entered .Sorry as a caution tip will be cancelled imediatelly\n");
                            }
                        }
                        File file=new File("C:\\Users\\Aahan Singh Charak\\Desktop\\Restaurant Customer Data\\Hola Restaurant\\src\\main\\"+c[index].name+".txt");
                        if(file.createNewFile()) System.out.println("\nSuccess\n");
                        else System.out.println("\nFile already exists\n");
                        FileWriter f=new FileWriter(file);
                        PrintWriter p=new PrintWriter(f);
                        p.println("User Details File :");
                        p.println("**************************************************");
                        p.println("Name :"+c[index].name);
                        p.println("Order list:");
                       int i=0;
                       while(r[index].orders[i]!=null) {
                           p.println("Item : " + r[index].orders[i]);
                           p.println("quantity: " + r[index].quantity[i]);
                           p.println("bill: " + r[index].bills[i]);
                           p.println("Total bill: " + r[index].totalBill);
                           p.println();
                           p.println();
                           i++;
                       }

                        p.close();


                    }
                    catch(IOException e){
                        System.out.println("Exception occured_>"+" "+e);
                    }

                    break;
                case 2:
                    try {
                       if(index>=0){

                               for (int i = 0; i <= index; i++) {
                                  showData(r[i],c[i],index);
                               }


                       }

                    }
                    catch(Exception e){
                        System.out.println(e);
                    }

                    break;
                case 3:
                    System.out.println("\nThe total money for the restaurant is \n");
                    double totalMoney=0.0;
                    for(int i=0;i<=index;i++){
                        totalMoney+=r[index].totalBill;
                    }
                    if(totalMoney<=0){
                        System.out.println("\nThere is no total money currently\n");
                    }
                    else{
                        System.out.println("\nThe total Money with the restaurant is"+" "+totalMoney);
                    }
                    break;

                case 4:
                    exit(0);
                default:
                    System.out.println("\nInvalid choice please enter details again\n");

            }
        }

    }
 private static void showData(Restaurant r, Customer c, int index){

     System.out.println("\n\n");
                System.out.println("Customer name ->"+"  "+c.name);
                System.out.println("The orders and prices for the items customer ordered are\n");
                int j=0;
                 while(r.orders[j]!=null) {
                     System.out.println("Item name->" + " " + r.orders[j]);
                     System.out.println("Item quantity->" + " " + r.quantity[j]);
                     System.out.println("Item bill->" + " " + r.bills[j]);
                     j++;
                 }
                }




    }




class Dis extends Display {
    public void DisData() {

        Menu m = new Menu();
        m.getMenu();
    }
}




