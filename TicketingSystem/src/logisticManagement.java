import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class logisticManagement{

    static List<Customer> customerData = new ArrayList<>();
    static Scanner sc = new Scanner(System.in); // Shared scanner to avoid multiple instances

    static class Product {
        long productID;
        String productName;
        double price;
        DeliveryDetails orderDetails = new DeliveryDetails(); // Initialize nested object
    }

    static class Customer {
        String name;
        String address;
        long phoneNumber;
        Product order = new Product(); // Initialize nested object
    }

    static class DeliveryDetails {
        String deliveryAddress;
        boolean isPrepaid;
        String status;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Logistics Manager 2026");
        boolean isRunning = true;
        while (isRunning) {
            int option = Menu();
            switch (option) {
                case 1: NewOrder(); break;
                case 2: SearchOrderByID(); break;
                case 3: CheckAllOrderStatus(); break;
                case 4: UpdateOrderStatus(); break;
                case 5: isRunning = false; break;
                default: System.out.println("Invalid option. Try again.");
            }
        }
    }

    static int Menu() {
        System.out.println("\n------- Menu ------");
        System.out.println("(1) Create new order");
        System.out.println("(2) Search order status");
        System.out.println("(3) Check all orders status");
        System.out.println("(4) Update order status");
        System.out.println("(5) Quit");
        System.out.print("Select: ");
        int opt = sc.nextInt();
        sc.nextLine(); // Consume newline
        return opt;
    }

    private static void NewOrder() {
        Customer cs = new Customer();
        System.out.print("Enter customer name: ");
        cs.name = sc.nextLine();
        System.out.print("Enter customer address: ");
        cs.address = sc.nextLine();
        System.out.print("Enter customer phone number: ");
        cs.phoneNumber = sc.nextLong();

        System.out.print("Enter product ID: ");
        cs.order.productID = sc.nextLong();
        sc.nextLine(); // Clear buffer

        System.out.print("Enter product name: ");
        cs.order.productName = sc.nextLine();
        System.out.print("Enter product price: ");
        cs.order.price = sc.nextDouble();

        System.out.print("Is order prepaid? (true/false): ");
        cs.order.orderDetails.isPrepaid = sc.nextBoolean();
        sc.nextLine(); // Clear buffer

        cs.order.orderDetails.status = "Ready to dispatch";
        System.out.print("Enter delivery address: ");
        cs.order.orderDetails.deliveryAddress = sc.nextLine();

        customerData.add(cs);
        System.out.println("Order created successfully!");
    }

    private static void SearchOrderByID() {
        System.out.print("Enter Product ID to search: ");
        long id = sc.nextLong();
        boolean found = false;
        for (Customer c : customerData) {
            if (c.order.productID == id) {
                System.out.println("Order Found: " + c.order.productName + " | Status: " + c.order.orderDetails.status);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Order ID not found.");
    }

    private static void CheckAllOrderStatus() {
        if (customerData.isEmpty()) {
            System.out.println("No orders in the system.");
            return;
        }
        System.out.println("\n--- All Orders ---");
        for (Customer c : customerData) {
            System.out.println("ID: " + c.order.productID + " | Customer: " + c.name + " | Status: " + c.order.orderDetails.status);
        }
    }

    private static void UpdateOrderStatus() {
        System.out.print("Enter product ID to update: ");
        long productID = sc.nextLong();
        sc.nextLine(); // Clear buffer

        for (Customer x : customerData) {
            if (x.order.productID == productID) {
                System.out.print("Enter new status: ");
                x.order.orderDetails.status = sc.nextLine();
                System.out.println("Status updated!");
                return;
            }
        }
        System.out.println("Order ID not found.");
    }
}