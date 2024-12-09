public class Bank {
    public double CalulateInterest(double amt, double interest ){
     return (amt +  (interest/100)*amt);
        
    }
    public double CalulateInterest(double amt, double interest, double time, double rate){
        return (amt*rate*interest)/100;
    }

public double CalculateInterest(double amt, double interest, double time, double rate1, double rate2){
    double amt1 = (amt*rate1*time)/100;
    double amt2 = (amt*rate2*time)/100;
    return ((amt1+amt2)/2);
}
public static void main(String args[]){
    Bank bank = new Bank();
    double amt1 = bank.CalulateInterest(69,9);
    double amt2 = bank.CalulateInterest(69,2,9,6);
    double amt3 = bank.CalculateInterest(69, 2, 7, 3, 4);
    System.out.println("The savings deposit is "+amt1);
    System.out.println("The Fixed deposit is "+amt2);
    System.out.println("The Recurring deposit is "+amt3);
   
}
}


