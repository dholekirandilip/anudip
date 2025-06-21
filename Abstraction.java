


abstract class Pet {
    //Abstract method
    abstract void sound();
    //Nonabstract method
    void eat(){
        System.out.println("pet eats");
    }
}
class Cat extends Pet {
    void sound(){
        System.out.println("Cat Mewoww");
    }
}
public class Abstraction {
    public static void main(String[] args) {
        Cat a = new Cat();
        a.sound();
        a.eat();

        
    }
    
}
