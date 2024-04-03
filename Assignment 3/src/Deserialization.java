import java.io.*;
import java.util.Scanner;
class Product implements Serializable {
    private int id;
    private String name;
    private String category;
    private double price;
    
    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

public class Deserialization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        System.out.println("Enter product category:");
        String category = scanner.nextLine();
        System.out.println("Enter product price:");
        double price = scanner.nextDouble();
        try {
            // Serialization
            Product product = new Product(id,name,category,price);
            FileOutputStream fileOut = new FileOutputStream("product.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(product);
            out.close();
            fileOut.close();
            System.out.println("Product serialized successfully.");

            // Deserialization
            FileInputStream fileIn = new FileInputStream("product.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Product deserializedProduct = (Product) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("\nProduct deserialized successfully.");
            System.out.println("Deserialized Product:");
            System.out.println("ID: " + deserializedProduct.getId());
            System.out.println("Name: " + deserializedProduct.getName());
            System.out.println("Category: " + deserializedProduct.getCategory());
            System.out.println("Price: $" + deserializedProduct.getPrice());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}