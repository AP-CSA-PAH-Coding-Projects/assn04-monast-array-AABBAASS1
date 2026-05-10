package apcsa.githubtrack;

public class Main {
    public static void main(String[] args) {
        ShoppingList breakfastEssentials = new ShoppingList();
        breakfastEssentials.addToEnd(new ShoppingItem("eggs", 350));
        breakfastEssentials.addToEnd(new ShoppingItem("zucchini", 275));
        breakfastEssentials.addToEnd(new ShoppingItem("frozen berries", 515));
        breakfastEssentials.addToEnd(new ShoppingItem("smoked salmon", 999));

        ShoppingList dormRun = new ShoppingList();
        dormRun.addToEnd(new ShoppingItem("eggs", 350));
        dormRun.addToEnd(new ShoppingItem("tissues", 100));
        dormRun.insertAt(1, new ShoppingItem("zucchini", 275));
        dormRun.addToEnd(new ShoppingItem("frozen berries", 515));
        dormRun.addToEnd(new ShoppingItem("smoked salmon", 999));

        System.out.println("Demonstrating addToEnd, insertAt, and removeAt:");
        System.out.println("dormRun list after insertAt: " + dormRun.getSize() + " items");

        dormRun.removeAt(1);
        System.out.println("dormRun after removeAt(1): " + dormRun.getSize() + " items");

        if (dormRun.isIdentical(breakfastEssentials)) {
            System.out.println("The shopping lists are identical.");
        } else {
            System.out.println("The shopping lists are not identical.");
        }

        dormRun.removeAt(1);
        dormRun.removeAt(dormRun.getSize() - 1);

        ShoppingList dormRun2 = new ShoppingList();
        dormRun2.addToEnd(new ShoppingItem("tissues", 100));
        dormRun2.addToEnd(new ShoppingItem("smoked salmon", 999));
        dormRun.goShopping(dormRun2);

        boolean allBought = true;
        for (int i = 0; i < dormRun.getSize(); i++) {
            if (dormRun.getAt(i) == null || !((ShoppingItem) dormRun.getAt(i)).isSold()) {
                allBought = false;
            }
        }

        if (allBought) {
            System.out.println("All items in dormRun have been bought.");
        } else {
            System.out.println("Not all items in dormRun have been bought.");
        }

        breakfastEssentials.goShopping();
        System.out.println("Total carts returned: " + ShoppingCart.getTotalCartsReturned());

        ShoppingCart cart1 = new ShoppingCart("Alice", breakfastEssentials);
        ShoppingCart cart2 = new ShoppingCart("Bob", dormRun);

        cart1.returnCart();
        cart2.returnCart();

        System.out.println("Total carts returned after attempts: " + ShoppingCart.getTotalCartsReturned());

        ShoppingItem first = (ShoppingItem) breakfastEssentials.getAt(0);
        ShoppingItem third = (ShoppingItem) dormRun.getAt(0);
        System.out.println("Comparison result: " + first.compareTo(third));

        String summary = "DormRun's cart includes the following items: ";
        for (int i = 0; i < dormRun.getSize(); i++) {
            if (i > 0) summary += ", ";
            summary += ((ShoppingItem) dormRun.getAt(i)).getName();
        }
        summary += " for a total of $" + String.format("%.2f", dormRun.totalPrice()) + ". ";
        summary += allBought ? "It is completed!" : "It is not completed.";
        System.out.println(summary);
    }
}
