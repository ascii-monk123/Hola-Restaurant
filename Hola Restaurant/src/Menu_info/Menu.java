package Menu_info;

public class Menu {
    String menu[]=new String[5];
    double rate[]=new double[5];
    public Menu(){
        menu[0]="Apple Pie";
        rate[0]=20.75;
        menu[1]="Strawberry Cake";
        rate[1]=19.20;
        menu[2]="Fantasy bean waffle";
        rate[2]=50.87;
        menu[3]="Belgian choco pancake";
        rate[3]=100.75;
        menu[4]="American-delight sundae";
        rate[4]=15.88;
    }
    public void getMenu(){
        System.out.println("\nWelcome to the restaurant customer\n");
        System.out.println("1>Menu Item  2>Rate");
        for(int i=0;i<5;i++){
            System.out.println( menu[i]+"  "+rate[i]);
        }
    }
}
