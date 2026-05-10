package apcsa.githubtrack;
import apcsa.githubtrack.ShoppingItem;

public class ShoppingList implements MyList {
    private int capacity;
    private int size;
    private ShoppingItem[] storage;

    public ShoppingList() {
        this.capacity = 8;
        this.size = 0;
        this.storage = new ShoppingItem[this.capacity];
    }

    public void addToEnd(Object item) {
        if (this.size == this.capacity) {
            makeCapacity(this.capacity * 2);
        }
        this.storage[this.size] = (ShoppingItem) item;
        this.size++;
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

    public void removeAt(int index) {
        if (index < 0 || index >= this.size) {
            System.out.println("Invalid index!");
            return; 
        }
        for (int i = index; i < this.size - 1; i++) {
            this.storage[i] = this.storage[i + 1];
        }
        this.storage[this.size - 1] = null;
        this.size--;
    }

    public Object getAt(int index) {
        if (index < 0 || index >= this.size) {
            System.out.println("Invalid index!");
            return null;
        }
        return this.storage[index];
    }

    public int getSize() {
        return this.size;
    }

    public void makeCapacity(int minCapacity) {
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

    public void trimExcess() {
        makeCapacity(this.size);
    }

    public void goShopping() {
        for (int i = 0; i < this.size; i++) {
            if (this.storage[i] != null) {
                this.storage[i].buy();
            }
        }
    }

    public void goShopping(ShoppingList toBuy) {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < toBuy.size; j++) {
                if (toBuy.storage[j] == null) {
                    continue;
                }
                if (this.storage[i] != null && this.storage[i].equals(toBuy.storage[j])) {
                    this.storage[i].buy();
                }
            }
        }
    }

    public double totalPrice() {
        double total = 0.0;
        for (int i = 0; i < this.size; i++) {
            if (this.storage[i] != null) {
                total += this.storage[i].getPrice();
            }
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
                if (!matched[j] && this.storage[i] != null && other.storage[j] != null &&
                    this.storage[i].equals(other.storage[j])) {
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

    public int getCapacity() {
        return this.capacity;
    }

    public ShoppingItem[] getStorage() {
        return this.storage;
    }
}
