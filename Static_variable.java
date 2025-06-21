class candidate {
    static String college="Dyp";
    String name;
    int age;
    
    candidate(String name, int age){      
        this.name=name;
        this.age=age;
    }
}
public class Static_variable {
    public static void main(String[] args) {
        candidate s1=new candidate("kiran",45);
        candidate s2=new candidate("vushali",56);

        System.out.println(s1.name +" " +s1.college);
        System.out.println(s2.name + " "+ s2.college);
    }
    
}
