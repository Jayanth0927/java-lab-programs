import java.util.Scanner;


class WrongAge extends Exception {
 
    public WrongAge() {
        super("Age Error");
    }


    public WrongAge(String message) {
        super(message);
        System.out.println(message);
    }
}


class Father {
    protected int fatherAge;

    
    public Father(Scanner s) throws WrongAge {
        System.out.print("Enter Father's age: ");
        fatherAge = s.nextInt();

        if (fatherAge < 0) {
            throw new WrongAge("Age cannot be negative.");
        }
    }

 
    public void display() {
        System.out.println("Father's age: " + fatherAge);
    }
}


class Son extends Father {
    private int sonAge;


    public Son(Scanner s) throws WrongAge {
        super(s); 
        System.out.print("Enter Son's age: ");
        sonAge = s.nextInt();

        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age cannot be greater than or equal to Father's age.");
        } else if (sonAge < 0) {
            throw new WrongAge("Age cannot be negative.");
        }
    }

   
    public void display() {
        super.display(); 
        System.out.println("Son's age: " + sonAge);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        try {
            Son son = new Son(scanner); 
            son.display();           
        } catch (WrongAge e) {
           
        } finally {
            scanner.close(); 
    }
}}
