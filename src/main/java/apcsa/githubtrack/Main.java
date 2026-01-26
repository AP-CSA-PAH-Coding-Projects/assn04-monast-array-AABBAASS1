package apcsa.githubtrack;




public class Main {
public static void main(String[] args) {
    ShoppingList breakfastEssentials = new ShoppingList();
    breakfastEssentials.addToEnd(new ShoppingItem("eggs", 350));  // $3.50 in pennies
    breakfastEssentials.addToEnd(new ShoppingItem("zucchini", 275));  // $2.75
    breakfastEssentials.addToEnd(new ShoppingItem("frozen berries", 515));  // $5.15
    breakfastEssentials.addToEnd(new ShoppingItem("smoked salmon", 999));  // $9.99

    ShoppingList dormRun = new ShoppingList();
    dormRun.addToEnd(new ShoppingItem("eggs", 350));
    dormRun.addToEnd(new ShoppingItem("tissues", 100));
    dormRun.addToEnd(new ShoppingItem("zucchini", 275));
    dormRun.addToEnd(new ShoppingItem("frozen berries", 515));
    dormRun.addToEnd(new ShoppingItem("smoked salmon", 999));
    dormRun.insertAt(1, new ShoppingItem("milk", 200));  // $2.00 in pennies

    dormRun.removeAt(1); 

    if (dormRun.equals(breakfastEssentials)) {
        System.out.println("The shopping lists are identical.");
    } else {
        System.out.println("The shopping lists are not identical.");
    }

    dormRun.removeAt(2); 
    dormRun.removeAt(dormRun.getSize() - 1); 
        ShoppingList dormRun2 = new ShoppingList();
         dormRun2.addToEnd(new ShoppingItem("tissues", 100));
    dormRun2.addToEnd(new ShoppingItem("smoked salmon", 999));
    dormRun.goShopping(dormRun2);


    
  
    int count = 0;
   for (int i = 0; i < dormRun.getSize(); i++) {
        if(   dormRun.getAt(i) == null || !dormRun.getAt(i).isSold()) {
            count = count;

        }
        else {
            count++;
    }
    if (count == dormRun.getSize()) {
        System.out.println("All items in dormRun have been bought.");
    } else {
        System.out.println("Not all items in dormRun have been bought.");
    }

    breakfastEssentials.goShopping();
    System.out.println("Total carts returned: " + ShoppingCart.getTotalReturnedCarts());

    ShoppingCart cart1 = new ShoppingCart(breakfastEssentials, "Alice");
    ShoppingCart cart2 = new ShoppingCart(dormRun, "Bob");

    cart1.returnCart();
    cart2.returnCart();

    System.out.println("Total carts returned after attempts: " + ShoppingCart.getTotalReturnedCarts());
}
System.out.println("Total carts returned after attempts: " + ShoppingCart.getTotalReturnedCarts());

    // Step 6: Final Summary Output
    String summary = "DormRun’s cart includes the following items: ";
    for (int i = 0; i < dormRun.getSize(); i++) {
        if (i > 0) summary += ", ";
        summary += dormRun.getAt(i).getName();
    }
    summary += " for a total of $" + String.format("%.2f", dormRun.totalPrice()) + ". ";
    summary += count == dormRun.getSize() ? "It is completed!" : "It is not completed.";
    System.out.println(summary);
}
}