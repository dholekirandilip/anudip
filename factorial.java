

import java.util.Scanner;
public class Factorial{
    public static void main(String[]args){
    Scanner input=new Scanner(System.in);
        System.out.println("enter your number:");
        int num=input.nextInt();
    int factorial=1;
    for(int i=1;i<=num;i++){
    factorial=factorial*i;
    }
        System.out.println(" factorial of " + num + " is " + factorial );
    
    input.close();
}
}