# Assignment 4: MonastArray - Student Reflection

## Program Overview

This program recreates the core functionality of Java's `ArrayList` using a plain Java array as the underlying storage mechanism. The assignment demonstrates fundamental data structure concepts including dynamic array resizing, element shifting, and efficient memory management.

## How It Works

### Key Components

1. **ShoppingItem** - Represents a product with name, price (in pennies), and sold status
2. **ShoppingList** - Custom ArrayList implementation storing ShoppingItem objects
3. **ShoppingCart** - Represents a customer's shopping cart with completion tracking
4. **Main** - Demonstrates all functionality with a realistic shopping scenario

### Array Resizing Logic

The `makeCapacity(int minCapacity)` method is the heart of this implementation:
- When the list is full and needs more space, we create a new array with double the capacity
- All existing elements are copied to the new array
- The old array is discarded (garbage collected)
- This ensures O(1) amortized time complexity for append operations

### Element Shifting

**insertAt()**: When inserting at an index, all elements from that index onwards are shifted right:
```
Before: [A, C] -> insert B at index 1
Shift:  [A, C, ?] -> shift C right
After:  [A, B, C]
```

**removeAt()**: When removing, all elements after the index shift left:
```
Before: [A, B, C] -> remove B at index 1
Shift:  [A, C, ?] -> shift C left
After:  [A, C]
```

### Shopping Logic

- **goShopping()**: Marks all items in the list as bought
- **goShopping(ShoppingList)**: Buys only items that appear in both lists (intersection)
- **isIdentical()**: Checks if two lists contain the same items (order-independent)

## Design Decisions

1. **Minimum Capacity**: Capacity never drops below 8, ensuring reasonable storage even for empty lists
2. **Null Safety**: Added null checks in shopping methods to handle edge cases
3. **Double Resizing**: Doubling capacity when full provides good balance between memory efficiency and performance
4. **Constructor Overloading**: ShoppingCart supports both empty and pre-populated initialization

## Challenges & Solutions

1. **Character Encoding**: Removed emoji characters from comments to ensure US-ASCII compatibility
2. **Array Index Management**: Carefully tracked size vs capacity to avoid off-by-one errors
3. **Method Signature Matching**: Ensured constructor parameters matched test expectations
4. **List Comparison**: Implemented order-independent comparison by tracking matched items

## Compliance with Rubric

- All required methods implemented per specification
- Proper error messages printed for invalid indices
- Array resizing demonstrated through capacity management
- Shopping scenario fully implemented in Main
- Clear separation of concerns among classes
