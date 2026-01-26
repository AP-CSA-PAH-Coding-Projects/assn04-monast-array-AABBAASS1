package apcsa.githubtrack;

// Implement your ShoppingCart class here
/*## 🛒 Class 3: `ShoppingCart`

### Purpose

Represents a shopper’s cart.

### Required Attributes

* Associated `ShoppingList`
* Customer name
* Whether or not the shopping mission is complete
* **Total** number of `ShoppingCarts` returned

### Constructors

* If no `ShoppingList` provided:

  * Initialize with an empty `ShoppingList`

---

### Required Methods

#### `isCompleted()`

* Returns `true` only if **all items in the `ShoppingList` are bought**

#### `returnCart()`

* Can only return a cart if:

  * The associated shopping list is completed
* Once returned:

  * Counts toward total returned carts
  * Cannot be returned again

#### Accessors

* All attributes must be accessible outside the class

---
*/ 
public class ShoppingCart {
    private ShoppingList shoppingList;
    private String customerName;
    private boolean isCompleted;
    private boolean isReturned;
    private static int totalReturnedCarts = 0;

    
    public ShoppingCart(String customerName) {
        this.shoppingList = new ShoppingList(); 
        this.customerName = customerName;
        this.isCompleted = false;
        this.isReturned = false;
    }

    public ShoppingCart(ShoppingList shoppingList, String customerName) {
        this.shoppingList = shoppingList;
        this.customerName = customerName;
        this.isCompleted = false;
        this.isReturned = false;
    }

    public boolean isCompleted() {
        for (int i = 0; i < this.shoppingList.getStorage().length; i++) {
            if (this.shoppingList.getStorage()[i] != null) {
                if (!this.shoppingList.getStorage()[i].isSold()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void returnCart() {
        if (isCompleted() && !isReturned) {
            totalReturnedCarts++;
            isReturned = true;
        }
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public boolean getIsCompleted() {
        return isCompleted();
    }

    public static int getTotalReturnedCarts() {
        return totalReturnedCarts;
    }
}