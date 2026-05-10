package apcsa.githubtrack;

public class ShoppingCart {
    private ShoppingList shoppingList;
    private String customerName;
    private boolean isReturned;
    private static int totalReturnedCarts = 0;

    public ShoppingCart(String customerName) {
        this.shoppingList = new ShoppingList(); 
        this.customerName = customerName;
        this.isReturned = false;
    }

    public ShoppingCart(String customerName, ShoppingList shoppingList) {
        this.customerName = customerName;
        this.shoppingList = shoppingList;
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

    public static int getTotalCartsReturned() {
        return totalReturnedCarts;
    }
}
