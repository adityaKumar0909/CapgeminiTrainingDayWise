import java.util.*;

public class shoppingCart {
    static Map<String, String> cartMap = new HashMap<>();
    static Set<String> uniquePhones = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("--- Shopping cart---");
        Menu();
    }

    private static void Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nMenu :");
        System.out.println("(1) Add phone ");
        System.out.println("(2) Remove data ");
        System.out.println("(3) Show all details");
        System.out.println("(4) Unique Phones List");
        System.out.println("(5) Cart size");
        System.out.println("(6) Quit");

        System.out.print("Enter option: ");
        String choice = sc.nextLine();

        switch(choice) {
            case "1": AddNewPhone(); Menu(); break;
            case "2": RemoveData(); Menu(); break;
            case "3": ShowAllDetail(); Menu(); break;
            case "4": ShowUniquePhones(); Menu(); break;
            case "5": System.out.println("Cart Size: " + cartMap.size()); Menu(); break;
            case "6": System.out.println("Bye!"); break;
            default: System.out.println("Invalid option"); Menu();
        }
    }

    private static void AddNewPhone() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone Model: ");
        String phone = sc.nextLine();

        cartMap.put(name, phone);
        uniquePhones.add(phone);
        System.out.println("Successfully added!");
    }

    private static void RemoveData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Customer Name to remove: ");
        String name = sc.nextLine();

        if (cartMap.containsKey(name)) {
            String phone = cartMap.remove(name);
            System.out.println("Removed " + name + "'s " + phone);

            if (!cartMap.containsValue(phone)) {
                uniquePhones.remove(phone);
            }
        } else {
            System.out.println("User not found!");
        }
    }

    private static void ShowAllDetail() {
        System.out.println("\n--- Current Cart Details ---");
        if (cartMap.isEmpty()) System.out.println("Cart is empty.");

        for (Map.Entry<String, String> entry : cartMap.entrySet()) {
            System.out.println("Owner: " + entry.getKey() + " | Phone: " + entry.getValue());
        }
    }

    private static void ShowUniquePhones() {
        System.out.println("Unique Models in Cart: " + uniquePhones);
    }
}