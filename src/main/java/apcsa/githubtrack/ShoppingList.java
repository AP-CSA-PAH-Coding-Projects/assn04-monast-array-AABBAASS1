package apcsa.githubtrack;
import apcsa.githubtrack.ShoppingItem;


// Implement the ShoppingList class here

/*
## 📝 Class 2: `ShoppingList` (implements `MyList`)

### Purpose

A **custom ArrayList implementation** that stores `ShoppingItem` objects.

### Required Instance Variables

* `capacity` → `int`, initialized to `8`
* `size` → `int`, initialized to `0`
* `storage` → `ShoppingItem[]`, starting with length `8`

---

### Required Methods

#### `addToEnd(ShoppingItem item)`

* Appends `item` to the end
* If full, double capacity using the `makeCapacity` method you will implement

#### `insertAt(int index, ShoppingItem item)`

* Shifts items right to make space
* Prints `"Invalid index!"` if `index` < 0 or > `size`
* Increases capacity if needed

#### `removeAt(int index)`

* Removes item and shifts remaining items left
* Prints `"Invalid index!"` if `index` < 0 or > `size`

#### `getAt(int index)`

* Returns item at index
* Prints `"Invalid index!"` if `index` < 0 or > `size`

#### `getSize()`

* Returns number of stored items

---

### Capacity Management Methods

#### `makeCapacity(int minCapacity)`

* Does nothing if:

  * `minCapacity <= size`
  * `minCapacity == capacity`
* Otherwise:

  * The capacity of the list must be changed to either 8 or `minCapacity` (whichever is greater)
  * Create new array
  * Copy elements
  * Replace old storage

#### `trimExcess()`

* This method will remove any excess capacity by simply calling the `makeCapacity` method with an argument value that is equal to the current size of this list.


---

### Shopping-Specific Methods

#### `goShopping()`

* Buys **all items** in this list

#### `goShopping(ShoppingList toBuy)`

* Buys only items **common to both lists**

#### `totalPrice()`

* Returns total cost of all items in this list

#### `isIdentical(ShoppingList other)`

* Returns `true` only if:

  * This list is the same size as other
  * This list contains the same items as other (order does **not** matter)
#### Accessors
* All attributes must be accessible outside the class


---
*/ 
public class ShoppingList implements MyList {






    private int capacity;
    private int size;
    private ShoppingItem[] storage;

public void addToEnd(Object item) {
        
        for (int i = 0; i < this.storage.length; i++) {
            if (this.storage[i] == null) {
                this.storage[i] = (ShoppingItem)  item; 
                break;
            }
        }
        this.size++;
        if (this.size == this.capacity) {
            makeCapacity(this.capacity * 2);
            this.storage[this.storage.length] = (ShoppingItem) item;
        }
    
        this.size++;
        if (this.size == this.capacity) {
            makeCapacity(this.capacity * 2);
            this.storage[this.storage.length-1] = (ShoppingItem) item;
        }



    }
    public void insertAt(int index, Object item) {
        if (index < 0 || index > this.size) {
            System.out.println("Invalid index!");
            return;
        }
        if (this.size == this.capacity) {
            makeCapacity(this.capacity * 2);
        }
        for (int i = this.size; i > index; i--) {
            this.storage[i] = this.storage[i - 1];
        }
        this.storage[index] = (ShoppingItem) item;
        this.size++;
    }
public int getCapacity() {
    return this.capacity;
}

public ShoppingItem[] getStorage() {
    return this.storage;
}
    public ShoppingList() {
        this.capacity = 8;
        this.size = 0;
        this.storage = new ShoppingItem[this.capacity];
    }


    
    public void removeAt(int index) {
        if (index < 0 || index >= this.size) {
            System.out.println("Invalid index!");
            return; 
        }
        else {
            for (int i = index; i < this.size - 1; i++) {
                this.storage[i] = this.storage[i + 1];
            }
            this.storage[this.size - 1] = null;
            this.size--;
        }
}
public ShoppingItem getAt(int index){
if (index < 0 || index >= this.size){
System.out.println("Invalid index!");
return null;
}
else if (this.storage[index] == null){
    return null;
}
else{

    return this.storage[index];
}

}
public int getSize(){
    return this.size;
}
public void makeCapacity(int minCapacity){


    if (minCapacity <= this.size || minCapacity == this.capacity) {
        return;
    }
    int newCapacity = Math.max(8, minCapacity);
    ShoppingItem[] newStorage = new ShoppingItem[newCapacity];
    for (int i = 0; i < this.size; i++) {
        newStorage[i] = this.storage[i];
    }
    this.storage = newStorage;
    this.capacity = newCapacity;
}
public void trimExcess(){
    makeCapacity(this.size);
}
public void goShopping() {

    for (int i = 0; i < this.size; i++) {
        if (this.storage[i] != null)   {
            this.storage[i].buy();
        } 
        else {
            continue;
        }

    }
}
public void goShopping(ShoppingList toBuy) {
    for (int i = 0; i < this.size; i++) {
        for (int j = 0; j < toBuy.size; j++) {
            if (toBuy.storage[i] == null) {
                continue;
            }
            if (this.storage[i].equals(toBuy.storage[j])) {
                this.storage[i].buy();
            }
        }
    }
}
public double totalPrice() {
    double total = 0.0;
    for (int i = 0; i < this.size; i++) {
        total += this.storage[i].getPrice();
    }
    return total;
}
public boolean isIdentical(ShoppingList other) {
    if (this.size != other.size) {
        return false;
    }
    boolean[] matched = new boolean[other.size];
    for (int i = 0; i < this.size; i++) {
        boolean found = false;
        for (int j = 0; j < other.size; j++) {
            if (!matched[j] && this.storage[i].equals(other.storage[j])) {
                matched[j] = true;
                found = true;
                break;
            }
        }
        if (!found) {
            return false;
        }
    }
    return true;
}
}
