abstract class payment{
    abstract void process_payment(double amount);
    }
class credit_card extends payment{
    @Override
    void process_payment(double amount){
    System.out.println("credit_card in process " +amount);

    }
}
class UPI extends payment{
    @Override
    void process_payment(double amount){
    System.out.println("UPI in process " +amount);

    }
}   

public class ExampleAbstraction {
    public static void main(String[] args) {
        payment p1=new credit_card();
        p1.process_payment(123.356);
        payment p2=new UPI();
        p2.process_payment(5342.635);
    }

    
}
