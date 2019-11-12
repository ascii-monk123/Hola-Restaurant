package main;
import java.sql.SQLOutput;
import java.util.Scanner;
import Menu_info.*;
import Rest_Main.*;
import display.Display;

import static java.lang.System.exit;

public class Start {
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);

        Restaurant r[]=new Restaurant[20];
        int index=0;
        System.out.println("\nHello and Welcome to the restaurant\n");
        while(true){
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
                    System.out.println("\nHere is the menu\n");
                    Dis d=new Dis();
                    d.DisData();
                    boolean cho=true;
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
                                    orders[ind]="Apple pie";
                                    bills[ind]=20.75*quant;
                                    ind++;
                                    break;
                                case "Strawberry Cake":
                                    orders[ind]="Strawberry Cake";
                                    bills[ind]=19.20*quant;
                                    ind++;
                                    break;
                                case "Fantasy bean waffle":
                                    orders[ind]="Fantasy bean waffle";
                                    bills[ind]=50.87*quant;
                                    ind++;
                                case "Belgian choco pancake":
                                    orders[ind]="Belgian choco pancake";
                                    bills[ind]=100.75*quant;
                                    ind++;
                                case "American-delight sundae":
                                    orders[ind]="American-delight sundae";
                                    bills[ind]=15.88*quant;
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
                    r[index]=new Restaurant();
                    r[index].setData(bills,orders);
                    System.out.println("\nYour bill amount is "+r[index].calculateBill());
                    System.out.println("\nDo you want to add a tip Y for yes and N for no\n");
                    String giveTip=sc.nextLine();
                    if(giveTip=="Y"){
                        System.out.println("\nEnter the tip amount 5 ,10 0r 15 dollar only\n");
                        double tip=sc.nextInt();
                        r[index].tip(true,tip);
                    }
                    index++;

                    break;
                case 2:
                    break;
                case 3:
                    break;

                case 4:
                    exit(0);
                default:
                    System.out.println("\nInvalid choice please enter details again\n");

            }
        }

    }
}


class Dis extends Display {
    public void DisData() {

        Menu m = new Menu();
        m.getMenu();
    }
}
