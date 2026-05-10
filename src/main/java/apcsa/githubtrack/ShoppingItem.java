package apcsa.githubtrack;

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
            return 0;
        } 
        if (this.pennies == other.pennies) {
            return 0;
        } else if (this.pennies > other.pennies) {
            return this.pennies - other.pennies;
        } else {
            return this.pennies - other.pennies;
        }
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
