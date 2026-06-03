import java.util.ArrayList;
// remember to keep adding the import if your gonna use the arraylist and depending on the data structure

public class deliveryOrder extends order{

// make variable for the address 
private String address;

// make the constructor like you had in the last 2 classes maine to get the information from the tableNumbers
public deliveryOrder(ArrayList<menuItems> items, String resturauntName, int orderId, Customer customer, String address) {

// use super to call the parent class constructor 
    super(items, resturauntName, orderId, customer);

// you use this to grab the tableNumbers from this object
    this.address = address;
}

// calculate total with 3.99 delivery fee 
public double calculatePrice() {
    // init result as a double for the decimals as cents 
    double result = 0;
   
    // run thru for loop get the items using the getter, 
    for (int i = 0; i < getItems().size(); i++) {

        // grab the item, get menu item at position i, get the price 
        result += getItems().get(i).getPrice();
        }
        // return the result plus the 3.99
        return result + 3.99;
    }

    // use getters for the address
    public String getAddress() { return address; }

    // print the order summary for the dine in order
    public void printSummary() {

    // print the header
    System.out.println("============================================");
    System.out.println(" Order Confirmed! Here is your summary:");
    System.out.println("============================================");

    // print the customer info using the getters from the customer class
    System.out.println("Customer: " + getCustomer().getCustoName() + " | " + getCustomer().getEmail());

    // print the restaurant name using the getter from the order class
    System.out.println("Restaurant: " + getResturauntName());

    // print the items ordered
    System.out.println("Items Ordered:");

    // loop through the items arraylist and print each item with its price
    for (int i = 0; i < getItems().size(); i++) {
        System.out.println(" - " + getItems().get(i).getName() + "  $" + getItems().get(i).getPrice());
        }

    System.out.println("--------------------------------------------");

    // calculate the item total by looping through the items
    double itemTotal = 0;
    for (int i = 0; i < getItems().size(); i++) {
        itemTotal += getItems().get(i).getPrice();

        }

    // print the item total, service charge, and order total
    System.out.println("Item Total: $" + itemTotal);
    System.out.println("Service Charge (10%): $" + (itemTotal * 0.10));
    System.out.println("--------------------------------------------");
    System.out.println("Order Total: $" + calculatePrice());

    // print the delivery address 
    System.out.println("Delivery Address: " + address);
    System.out.println("============================================");
    }

}