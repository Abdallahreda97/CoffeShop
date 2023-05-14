package javaapplication4;
import java.util.ArrayList;
import java.util.Scanner;

// MenuItem class to represent a menu item
class MenuItem {
    String item; // name of the item
    String type; // type of the item (drink or food)
    double price; // price of the item
    // constructor to initialize the MenuItem object
    public MenuItem(String item, String type, double price) {
        this.item = item;
        this.type = type;
        this.price = price;
    }
}
// CoffeeShop class to represent a coffee shop
class CoffeeShop {
    String name; // name of the coffee shop
    ArrayList<MenuItem> menu; // list of menu items
    ArrayList<String> orders; // list of orders
    // constructor to initialize the CoffeeShop object
    public CoffeeShop(String name, ArrayList<MenuItem> menu) {
        this.name = name;
        this.menu = menu;
        this.orders = new ArrayList<String>();
    }
    // method to add an order to the list of orders
    public String addOrder(String item) {
        for (MenuItem menuItem : menu) {
            if (menuItem.item.equalsIgnoreCase(item)) {
                orders.add(item);
                return "Order added!";
            }
        }
        return "This item is currently unavailable!";
    }
    // method to fulfill the first order in the list of orders
    public String fulfillOrder() {
        if (!orders.isEmpty()) {
            String item = orders.get(0);
            orders.remove(0);
            return "The " + item + " is ready!";
        } else {
            return "All orders have been fulfilled!";
        }
    }
    // method to get the list of orders
    public ArrayList<String> listOrders() {
        return orders;
    }
    // method to calculate the total due amount for all orders
    public double dueAmount() {
        double total = 0.0;
        for (String order : orders) {
            for (MenuItem menuItem : menu) {
                if (menuItem.item.equalsIgnoreCase(order)) {
                    total += menuItem.price;
                }
            }
        }
        return total;
    }
    // method to get the name of the cheapest item on the menu
    public String cheapestItem() {
        double minPrice = Double.MAX_VALUE;
        String cheapest = "";
        for (MenuItem menuItem : menu) {
            if (menuItem.price < minPrice) {
                minPrice = menuItem.price;
                cheapest = menuItem.item;
            }
        }
        return cheapest;
    }
    // method to get the list of drink items on the menu
    public ArrayList<String> drinksOnly() {
        ArrayList<String> drinkList = new ArrayList<String>();
        for (MenuItem menuItem : menu) {
            if (menuItem.type.equalsIgnoreCase("drink")) {
                drinkList.add(menuItem.item);
            }
        }
        return drinkList;
    }
    // method to get the list of food items on the menu
    public ArrayList<String> foodOnly() {
        ArrayList<String> foodList = new ArrayList<String>();
        for (MenuItem menuItem : menu) {
            if (menuItem.type.equalsIgnoreCase("food")) {
                foodList.add(menuItem.item);
            }
        }
        return foodList;
    }
}
// main class to run the coffee shop program
public class coffe {
    public static void main(String[] args) {
        // create a list of menu items
        ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
        menu.add(new MenuItem("Latte", "Drink", 3.50));
        menu.add(new MenuItem("Cappuccino", "Drink", 3.00));
        menu.add(new MenuItem("Espresso", "Drink", 2.50));
        menu.add(new MenuItem("Croissant", "Food", 2.00));
        menu.add(new MenuItem("Bagel", "Food", 2.50));
        // create a coffee shop object with the list of menu items
        CoffeeShop coffeeShop = new CoffeeShop("My Coffee Shop", menu);
        // create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // loop to take user orders until the user types "exit"
        while (true) {
            System.out.println("Enter your order (or 'exit' to quit): ");
            String order = scanner.nextLine();
            if (order.equalsIgnoreCase("exit")) {
                break;
            }
            String response = coffeeShop.addOrder(order);
            System.out.println(response);
        }
        // print the list of orders
        System.out.println(coffeeShop.listOrders());
        // print the total due amount for all orders
        System.out.println("Total due: " + coffeeShop.dueAmount());
        // print the name of the cheapest item on the menu
        System.out.println("Cheapest item: " + coffeeShop.cheapestItem());
    }
}
