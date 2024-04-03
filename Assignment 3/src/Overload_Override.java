import java.util.Scanner;
class Parent {
    // Method overloading
    public void display() {
        System.out.println("Parent class display method");
    }

    public void display(String message) {
        System.out.println("Parent class display method with message: " + message);
    }

    // Method overriding
    public void show() {
        System.out.println("Parent class show method");
    }
}

class Child extends Parent {
    // Method overriding
    @Override
    public void show() {
        System.out.println("Child class show method");
    }
}

public class Overload_Override {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();

        // Method overloading
        parent.display();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the message: ");
        String str = sc.nextLine();
        parent.display(str);

        // Method overriding
        parent.show(); 
        child.show(); 
    }
}
