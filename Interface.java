interface fruits {
    public void eat();

}
class apple implements fruits {
public void eat() {
    System.out.println("man eating apple " );
}
}

public class Interface {
    public static void main(String[] args) {
        apple a=new apple();
        a.eat();
        
    }
    
}
