# MonastArray - How It All Works

## What I Built

I created my own version of ArrayList from scratch using a regular Java array. The main idea is that when you keep adding items to an array that's full, you need to create a bigger array and copy everything over. That's basically what ArrayList does behind the scenes.

## The Main Classes

**ShoppingItem** stores a product with its name, price in pennies, and whether it's been bought. Pretty straightforward.

**ShoppingList** is where the real work happens. It holds ShoppingItems in an array and manages the whole growing/shrinking process.

**ShoppingCart** just tracks a customer's list and whether they've bought everything. It also keeps a running count of how many carts have been successfully returned.

**Main** sets up two shopping lists with different items and demonstrates that add, insert, and remove all work correctly.

## How the Array Resizing Works

When the storage array gets full, `makeCapacity()` creates a new array that's twice as big, copies all the old items into it, then switches over to using the new one. The minimum size is always 8, so even an empty list takes up some space. This strategy means you don't have to resize after every single add, which keeps things efficient.

## Inserting and Removing Items

When you insert at a specific position, everything from that position onward shifts to the right to make space. When you remove something, everything after it shifts left to fill the gap. Both operations take O(n) time in the worst case because of the shifting, but that's just how it has to work with arrays.

## The Shopping Features

I implemented three main shopping operations:
- Buy everything in a list at once with `goShopping()`
- Buy only items that appear in both lists using `goShopping(ShoppingList)`
- Check if two lists contain the same items regardless of order with `isIdentical()`

## What I Learned

Building this from scratch really shows why ArrayList is useful. Managing the array size manually is tedious, but understanding what's happening under the hood makes you appreciate the abstraction. The trickiest part was making sure the resizing logic didn't have any off-by-one errors, and getting all the null checks in the right places so nothing breaks unexpectedly.
