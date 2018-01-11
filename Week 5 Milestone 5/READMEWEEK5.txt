README for CST-135 
24 DEC 2017
Instructor: Dr. Bass 

Group Members:
Evan Wilson
Jake Babcock
Robert Nichols

Milestone 5:
Reworked a lot of the code. Eliminated Stack implementation of products. Assigned quantity value to each product, creating just one of each type of product with a quantity of 20. 

GUI now shows an animation sequence when adding items to cart. 

When adding items to cart, it lowers inventory of that item by 1. When removing from cart it increases inventory of that item by 1. 

Added a scene that displays all current inventory for management purposes

Updated checkout scene to display TableView instead of ListView as originally intended after working out the bugs

Milestone 4: 
17 DEC 2017

Interface class incorporated within program for the product dispenser module. Used JavaFX to create GUI necessary for program compilation. User can choose category from vending machine, view and add products to cart, and view transaction information.

Description, price, and properties of product shown on each categories TableView. Classes created in previous weeks integrated within Interface class. 

Milestone 3:
10 DEC 2017
Added comparable interface to Drink and Snack subclasses. Sorts by name of product first, if names are equal, will sort by price. If name and price are equal, the product is considered to be equal. 

Updated dispenser class to add additional products to better show sorting capabilities of the compareTo method. Added ArrayLists for each class of products to have the stack.peek added to the ArrayList, as well as the stack.size. Updated System.out.print commands to show contents of ArrayList for sorting purposes instead of the stack lists.


Milestone 2:
03 DEC 2017
Includes UML diagram showing the relationship amongst the included classes. Program includes seven classes:

Dispenser Class - Used to instantiate the other classes. Creates products of various types and stores them in a stack.

Product Class - Super class to all types of product classes. Contains basic variables found in all products.

Drink Class - Subclass of Product Class. Contains variables associated with drinks.

Snack Class - Subclass of Product Class. Contains variables associated with generic snacks.

Chips Class - Subclass of Snack Class. Contains variables associated with chips.

Gum Class - Subclass of Snack Class. Contains variables associated with gum.

Candy Class - Subclass of Snack Class. Contains variables associated with candy.