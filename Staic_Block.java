class Outer{
    static{
        System.out.println("static in progress");
    }
}
public class Staic_Block {
    public static void main(String[] args) {
        Outer O=new Outer();
        System.out.println("main class");

    }
    
}
