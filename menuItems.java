// make a class for the menu_Items thats public so it can be accessed
public class menuItems{

// initalize and give each menu item a name and then a price but make them private so that they can't be changed our prices are our prices 
private String foodName; 
private double price; 

// make the menuitems a function/constructor with the name and price of the menu item to load its data 
public menuItems(String name, double price){

// this is this object bud, in this object the name and price will be obtained from the parameter 
    this.foodName = name;
    this.price = price;
    }

// now we need to make sure the other files can access the name and price 
public String getName() { return foodName; }
public double getPrice() { return price;}

// ^ ENCAPSULATION - this item is able to retrieve information and not change it even though the where its retirieving the information is locked

}


