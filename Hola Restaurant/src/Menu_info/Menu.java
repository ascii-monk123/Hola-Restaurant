package Menu_info;

public class Menu {
    String menu[]=new String[5];
    double rate[]=new double[5];
    int quant[]=new int[5];
    int totQuant=0;
    public Menu(){
        menu[0]="Apple Pie";
        rate[0]=20.75;
        quant[0]=10;
        menu[1]="Strawberry Cake";
        rate[1]=19.20;
        quant[1]=10;
        menu[2]="Fantasy bean waffle";
        rate[2]=50.87;
        quant[2]=10;
        menu[3]="Belgian choco pancake";
        rate[3]=100.75;
        quant[3]=10;
        menu[4]="American-delight sundae";
        rate[4]=15.88;
        quant[4]=10;
    }
    public void getMenu(){
        System.out.println("\nWelcome to the restaurant customer\n");
        System.out.println("1>Menu Item  2>Rate        3>Quantity");
        for(int i=0;i<5;i++){
            System.out.println( menu[i]+"  "+rate[i]+" "+quant[i]);
            totQuant+=quant[i];
        }
    }
}
