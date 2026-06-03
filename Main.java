import java.util.ArrayList;
import java.util.Scanner;

public class Main{

public static void main(String[] arrStr){

    // use the scanner and arraylist for the orders since theres no fixed size 
    Scanner scanner = new Scanner(System.in); 
    ArrayList<order> orders = new ArrayList<>();


System.out.println("============================================");
System.out.println("   Welcome to Bite & Co. Food Hall!         ");
System.out.println("============================================");
// use the print to print these lines on the same line
System.out.print("Enter your name: ");
// just like the input() method in python| next line reads what the person typed and assigns it to the name
String name = scanner.nextLine();

System.out.print("Enter your email: ");
String email = scanner.nextLine();

System.out.print("Enter your phone number: ");
String PhoneNumber = scanner.nextLine();

// make a customer variable that makes a new instance for the new custmer object with a name, email and phone number 
Customer customer = new Customer(name, email, PhoneNumber);

System.out.println("                                            ");
System.out.println("============================================");
System.out.println("   Please select a restaurant:              ");
System.out.println("============================================");
System.out.println("1 - Smoky's BBQ");
System.out.println("2 - Sakura Bites");
System.out.println("3 - The Green Fork");
System.out.println("                                            ");
System.out.print("Enter your choice (1,2, or 3): ");

// next int is just the nextLine but for numbers 
int restaurantChoice = scanner.nextInt();

// then you have to clear the buffer because when you enter 1 for the restaurantChoice the scanner still leaves behind /n for the next line but we don't want that 
scanner.nextLine();

System.out.println("                                            ");
System.out.println("============================================");

// varible for the restaurants name 
String restaurantName = "";
menuItems [] menu = new menuItems[7];

// if else's for the choice of the resturaunts with the corresponding menuitem in the menu with its prie 
if (restaurantChoice == 1){
    // init rest name and print it
    restaurantName = "Smoky's BBQ";

    System.out.println(restaurantName);
    System.out.println("   Low and slow. Bold and smoky. ");

    menu[0] = new menuItems("Pulled Pork Sandwhich", 9.99);
    menu[1] = new menuItems("BBQ Ribs (Half Rack)", 14.99);
    menu[2] = new menuItems("Smoked Brisket Place", 13.49);
    menu[3] = new menuItems("Mac & Cheese", 4.99);
    menu[4] = new menuItems("Coleslaw", 2.99);
    menu[5] = new menuItems("Cornbread", 2.49);
    menu[6] = new menuItems("Sweet Tea", 2.49);

}

else if (restaurantChoice == 2){
    restaurantName = "Sakura Bites";

    System.out.println(restaurantName);
    System.out.println("Fresh, bold Japanese flavors. Fast casual done beautifully.");

    menu[0] = new menuItems("Tonkotsu Ramen", 12.99);
    menu[1] = new menuItems("Spicy Tuna Roll", 10.49);
    menu[2] = new menuItems("Gyoza (6 pieces)", 6.49);
    menu[3] = new menuItems("Edamame", 3.99);
    menu[4] = new menuItems("Miso Soup", 2.99);
    menu[5] = new menuItems("Matcha Lemonade", 3.49);
    menu[6] = new menuItems("Green Tea Ice Cream", 4.49);
}

else{
    restaurantName = "The Green Fork";

    System.out.println(restaurantName);
    System.out.println("Plant - powered.Feel good food that actually tastes good");
    

    menu[0] = new menuItems("Quinoa Power Bowl", 11.99);
    menu[1] = new menuItems("Avocado Toast", 8.99);
    menu[2] = new menuItems("Roasted Veggie Wrap", 9.49);
    menu[3] = new menuItems("Kale Caesar Salad", 8.49);
    menu[4] = new menuItems("Fresh Fruit Cup", 3.99);
    menu[5] = new menuItems("Mango Smoothie", 5.49);
    menu[6] = new menuItems("Sparkling Water", 1.99);}

// now print the menu 
System.out.println("============================================");
System.out.println(" " + restaurantName);
System.out.println("============================================");

// run a for loop runing through the menu 
for (int i = 0; i < menu.length; i++){
    // print the item number corresponding to the menu item, with the item and price using the getters 
    System.out.println((i + 1) + " - " + menu[i].getName() + " $" + menu[i].getPrice());

}

// add number 8 as a way to exit the menu
System.out.println("8 - Done adding items");

//make arraylist with the menu items and call it current items
ArrayList<menuItems> currentInCart = new ArrayList<>();
int itemChoice = 0; 

//run while loop as long as the customer hasn't selected item 8
while (itemChoice != 8){

System.out.println("Enter item number to add to your order: ");
//get the itemchoice using the scanner next int
itemChoice = scanner.nextInt();

// include buffer to take away \n
scanner.nextLine();

// if item 8 has not been selected then add it to the current items 
if (itemChoice != 8) {
    currentInCart.add(menu[itemChoice - 1]);
    System.out.println(menu[itemChoice - 1].getName() + " Added to your order!");
    }

}

    
System.out.println("============================================");
System.out.println(" How would you like to receive your order?");
System.out.println("============================================");
System.out.println("1 - Dine In");
System.out.println("2 - Delivery");
System.out.println("3 - Pickup");
System.out.print("Enter your choice (1, 2, or 3): ");

// use scanner to get the number and then remove the buffer 
int orderChoice = scanner.nextInt();
scanner.nextLine();

// order starts out as null
order orderss = null;

    // if the order choice is 1 then enter table number and give your dine in order 
    if (orderChoice == 1) {
        System.out.print("Enter your table number: ");
        int tableNumber = scanner.nextInt();
        scanner.nextLine();
        orderss = new dineInOrder(currentInCart, restaurantName, 1, customer, tableNumber);
    // if the order is delivery we need the address and
    } else if (orderChoice == 2) {
        System.out.print("Enter your delivery address: ");
        String address = scanner.nextLine();
        orderss = new deliveryOrder(currentInCart, restaurantName, 1, customer, address);
    } else {
    // if the order is pickup we need the pickup time 
        System.out.print("Enter your preferred pickup time: ");
        String pickupTime = scanner.nextLine();
        orderss = new pickUpOrder(currentInCart, restaurantName, 1, customer, pickupTime);
    }

// add the order to the orders 
orders.add(orderss);

// print the order summary
orderss.printSummary();

// loop through every order in the list and call printSummary
// no if statements needed - polymorphism handles which printSummary to call
System.out.println("============================================");    
System.out.println(" All Orders:");
System.out.println("============================================");
    
for (int i = 0; i < orders.size(); i++) {
    orders.get(i).printSummary();
    }

System.out.println("Thank you for ordering with Bite & Co.!");

}

}