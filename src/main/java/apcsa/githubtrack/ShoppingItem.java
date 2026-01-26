package apcsa.githubtrack;

// Implement your ShoppingItem class here
/*## 🧺 Class 1: `ShoppingItem`

### Purpose

Represents a single item in a store.

### Required Attributes

* Item name
* Item price (stored **in pennies**)
* Whether or not the item is sold

### Required Behaviors

#### `buy()`

* Marks the item as sold
* If already sold, nothing changes
* Once sold, **cannot be “unbought”**

#### `equals(ShoppingItem other)`

* Returns `true` **if and only if**:

  * The item's `name` is the same as `other`'s
  * The item's `price` is the same as `other`'s 

#### `compareTo(ShoppingItem other)`

* If names are different:

  * Print: `"Error: Different items!"`
* If names are the same:

  * Return `0` if prices are equal
  * Return a **positive difference** (magnitude equal to the price difference) if this item is more expensive 
  * Return a **negative difference** (magnitude equal to the price difference) if this item is cheaper

#### Accessor Methods

* All attributes must be able to be accessed outside the class
* The **price getter must return a `double` in dollars**
*/
public class ShoppingItem {
    private String name;
    private int pennies;
    private boolean sold;
    public ShoppingItem(String name, int pennies) {
        this.name = name;
        this.pennies = pennies;
        this.sold = false;
    }
    public void buy() {
        this.sold = true;
    }
    public boolean equals(ShoppingItem other) {
        if (other == null) {
            return false;
        }
        return this.name.equals(other.name) && this.pennies == other.pennies;   
    }
    public int compareTo(ShoppingItem other) {
        if (!this.name.equals(other.name)) {
            System.out.println("Error: Different items!");
        
        } 
        if (this.name.equals(other.name)){
            if (this.pennies == other.pennies) {
                return 0;
            } else if (this.pennies > other.pennies) {
                return other.pennies - this.pennies;
            } else {
                return this.pennies - other.pennies;
            }



        }
        return 0;
    }
    public String getName() {
        if (this.name == null) {
            return "";
        }
        return this.name;
    }
    public double getPrice() {
        return this.pennies / 100.0;
    }
    public boolean isSold() {
        return this.sold;
    }
}
