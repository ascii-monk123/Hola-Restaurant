package Rest_Main;
public class Restaurant {
    public double bills[]=new double[20];
    public  String orders[]=new String[20];
    public double totalBill;

    public void setData(double bill[],String o[]) {
        if (bill.length > 0 && o.length > 0) {
            this.bills = bill;
            this.orders = o;
        }
        else{
            System.out.println("\nInvalid amount of bill and orders printed\n");
        }
    }
    public  double calculateBill(){
        this.totalBill=0;
        if(this.bills.length>0 &&this.orders.length>0){
            for(int i=0;i<this.bills.length;i++){
                this.totalBill+=this.bills[i];
            }

        }
        else{
            System.out.println("\nSorry this customer does not have the bills\n");
        }
        return this.totalBill;
    }
    public  void tip(boolean tip,double tAmount){
        if(tip){
            System.out.println("\nThe person decided to give a tip\n");
            this.totalBill+=tAmount;
            System.out.println("\nYour total bill after adding the tip is "+this.totalBill);
        }
        else{
            System.out.println("\nNo tip will be added\n");
        }

    }
}


