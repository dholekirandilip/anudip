class animal {
    String name;
    int age;

    public void printInfo(String name) {
        System.out.println("Name: " + name);  // ✔ Corrected here
    }

    public void printInfo(int age) {
        System.out.println("Age: " + age);
    }

    public void printInfo(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class CompileTimePolymorphism {
    public static void main(String[] args) {
        animal s1 = new animal();

        s1.printInfo("Kiran");        
        s1.printInfo(20);                
        s1.printInfo("Kiran", 20);       
    }
} 
