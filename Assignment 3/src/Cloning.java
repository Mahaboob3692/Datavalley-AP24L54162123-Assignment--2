import java.util.Scanner;
class Organization implements Cloneable {
    private int organizationCode;
    private String organizationName;
    private String organizationAddress;

    public Organization(int code, String name, String address) {
        this.organizationCode = code;
        this.organizationName = name;
        this.organizationAddress = address;
    }

    public int getOrganizationCode() {
        return organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void printDetails() {
        System.out.println("Organization Code: " + organizationCode);
        System.out.println("Organization Name: " + organizationName);
        System.out.println("Organization Address: " + organizationAddress);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Cloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter organization code: ");
        int code = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter organization name: ");
        String name = scanner.nextLine();
        System.out.print("Enter organization address: ");
        String address = scanner.nextLine();
        
        Organization org1 = new Organization(code,name,address);
        Organization org2 = (Organization) org1.clone();

        System.out.println("Original Organization:");
        org1.printDetails();

        System.out.println("\nCloned Organization:");
        org2.printDetails();
    }
}
