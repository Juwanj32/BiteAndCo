// make the order class n import arraylist 
import java.util.ArrayList;

public abstract class order{

// make private variables for the arraylist so that this list with no fixed size to keep adding to only holds the menu items
private ArrayList<menuItems> items;
private String resturauntName; 
private int orderId;
private Customer customer;

// make the constructor to get the information from the custo, the menuitems, the orderID, and the resturauntName
public order(ArrayList<menuItems> items, String resturauntName, int orderId, Customer customer) {

// initialize the items into a new array list 
this.items = items;
this.resturauntName = resturauntName;
this.orderId = orderId;
this.customer = customer;
}

// use method to add to the arraylist 
public void addItems(menuItems item){
items.add(item);

}

// use abstract method for the price that turns into a double
public abstract double  calculatePrice();

// use getters 
public ArrayList<menuItems> getItems() { return items; }

public String getResturauntName() { return resturauntName; }

public int getOrderId() { return orderId; }

public Customer getCustomer() { return customer; }

// use abstract method to print the summary 
public abstract void printSummary();

}