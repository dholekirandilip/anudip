import java.util.Scanner;
public class Even_Odd {
    public static void main(String [] args){
Scanner input=new Scanner(System.in);
    System.out.println("enter your number");
    int n=input.nextInt();
    if (n%2==0){
        System.out.println(  n  +  " number is even" );
    }
    else{
        System.out.println( n+ "number is odd");
    }
    input.close();

}
}