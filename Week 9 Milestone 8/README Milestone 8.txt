README for CST-135 
20 JAN 2018
Instructor: Dr. Bass 

Group Members:
Evan Wilson
Jake Babcock
Robert Nichols

ADMIN PASSWORD: admin

Milestone 8:
Created new AddNewProductDisplay class
Created admin user interface to manually add a new product using all variables required of it's type (i.e. drink, chips, candy, gum). This product is then added to inventory and visible from tableViews and selectable to purchase. Had to rewrite how the tableViews were populating their data and write several new methods in the Dispenser class to handle this.

Milestone 7:
Created a CSV file of customers and their requested products.
Created ProcessCustomerQueue class with methods to read the CSV file, and process each customer. If the item the customer wanted is not available (either never had it, or current inventory is 0) then the process determines what type of product the customer wanted (i.e. drink, chips, candy, or gum) and assigns them a random product of the same type.
Added new button to admin screen to access customer display GUI.
Created CustomerDisplay class that processes all customers in the queue with basic animations to show the queue being processed. Creates an event log as customers are processed
Complete project is now complete!

Milestone 6:
Cleaned up a lot of the interface actions where code was re-used a lot and formed several helper methods to achieve same result.
Products now are built with a productID for easy reference between lists and other functions
New Restock class
New CsvWriter class
New GLOBAL_INVENTORY_MANAGEMENT class

Program writes current inventory to a CSV file, and reads that file upon opening the program to keep inventory 
intact between program runs.

Created management GUI with password "admin" for the following functions:
View all inventory available, sorted by name
Force program to write current inventory file
Write purchase order for all products with 3 or less quantity
Restock inventory based on purchase order
Search inventory by name (This is a recursive search function that writes the Stack Trace to a text file)

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