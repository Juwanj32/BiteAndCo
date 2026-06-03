# Bite & Co. Food Hall

A Java CLI application that simulates a multi-restaurant food hall ordering system. Built from scratch to demonstrate core Object-Oriented Programming principles in a real, working program.

---

## What It Does

- Greets the customer and collects their name, email, and phone number
- Lets them choose from 3 restaurants, each with a unique 7-item menu
- Adds items to a cart with a running confirmation
- Supports 3 order types — Dine In, Delivery, and Pickup
- Prints a full order summary with itemized pricing, service charges, and order total

---

## OOP Concepts Demonstrated

**Abstract Classes** — `order` is an abstract class that defines shared structure for all order types. It cannot be instantiated directly — you must use one of its subclasses.

**Inheritance** — `dineInOrder`, `deliveryOrder`, and `pickUpOrder` all extend `order`, inheriting shared fields like customer info, restaurant name, and item list without rewriting them.

**Encapsulation** — All class fields are `private` and accessed through public getters, protecting the data from being modified directly.

**Polymorphism** — All three order types are stored in an `ArrayList<order>` and call `printSummary()` through the same loop. Java automatically runs the correct version for each order type at runtime.

**Constructors & `this` keyword** — Every class uses a constructor to initialize its fields, with `this` to distinguish between parameters and instance variables.

---

## Project Structure

```
BiteAndCo/
├── Main.java            # Entry point — CLI loop and user input
├── order.java           # Abstract parent class for all order types
├── dineInOrder.java     # Extends order — adds table number, 10% service charge
├── deliveryOrder.java   # Extends order — adds delivery address, $3.99 delivery fee
├── pickUpOrder.java     # Extends order — adds pickup time, no extra charge
├── Customer.java        # Holds customer name, email, and phone number
└── menuItems.java       # Holds menu item name and price
```

---

## How to Run

**Requirements:** Java 17 or higher

```bash
# Clone the repo
git clone https://github.com/Juwanj32/BiteAndCo.git
cd BiteAndCo

# Compile and run
javac *.java && java Main
```

> Note: If you're using VS Code, run from the terminal using the command above. The built-in Java extension may have caching issues with multi-file projects.

---

## Roadmap

- [ ] Add a JavaFX or Swing GUI
- [ ] Add input validation for menu selections
- [ ] Support ordering from multiple restaurants in one session

---

## Author

**Juwan Johnson Jr.**  
CS Student — Delaware State University  
[GitHub](https://github.com/Juwanj32)
