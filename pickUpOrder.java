import java.util.ArrayList;

public class pickUpOrder extends order {

// make variable for the pickuptime 
private String pickUpTime;

// make the constructor like you had in the last 2 classes maine to get the information from the tableNumbers
public pickUpOrder(ArrayList<menuItems> items, String resturauntName, int orderId, Customer customer, String pickUpTime) {

        // use super to call the parent class constructor 
        super(items, resturauntName, orderId, customer);

        // you use this to grab the pickuptime from this object
        this.pickUpTime =  pickUpTime;
    }

// calculate total with no extra rate besides the total for the order  
    public double calculatePrice() {
        double result = 0;
        // init result as a double for the decimals as cents 
        // run thru for loop get the items using the getter, 
        for (int i = 0; i < getItems().size(); i++) {
            // grab the item, get menu item at position i, get the price 
            result += getItems().get(i).getPrice();
        }
        // return the flat result rate
        return result;
    }

    // use getters for the address
    public String getPickUpTime() {
        return pickUpTime;
    }

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

    // print the table number unique to dine in
    System.out.println("Pickup Time: " + pickUpTime);
    System.out.println("============================================");
    }
}

