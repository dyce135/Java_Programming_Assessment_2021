import java.util.*; // import scanner

public class OrderedListTest {

    IntegerOrderedList iList = new IntegerOrderedList("Integer List"); // create new IntegerOrderedList object

    StringOrderedList sList = new StringOrderedList("String List"); // create new StringOrderedList object

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in); // create new object instance of class Scanner
        OrderedListTest listAction = new OrderedListTest(); // create new object instance of class listAction
        int MainMenu; // create integer variable MainMenu to be used in the input switch
        while (true) { // loop while the program runs
            System.out.println("\nEnter 1, 2, 3, or 4 to declare action: ");
            System.out.println("1. Insert element to lists");
            System.out.println("2. Print details of lists");
            System.out.println("3. Remove element from lists");
            System.out.println("4. End program");
            try {
                MainMenu = input.nextInt(); // Define MainMenu as the scanner input
                input.nextLine(); // ensures that the next input must be read in the next line
                if (MainMenu < 5 && MainMenu > 0) { // ensures that the input is 1, 2, 3,or 4
                    switch (MainMenu) {
                        case (1) -> listAction.getListTypeFromKeyboard(input); // call the getShapeTypeFromKeyboard method to obtain the desired shape to create from the user
                        case (2) -> System.out.println(listAction.returnListToConsole()); // call the returnShapesToConsole method to print out all created shapes
                        case (3) -> listAction.removeFromList(input); // call the removeShapeFromList method to remove an unwanted shape from the ShapeList array
                        case (4) -> {
                            System.out.println("Stopping program...");
                            System.exit(0); // terminates program
                        }
                    }
                } else {
                    System.out.println("Input must be either one of 1, 2, 3, or 4, try again."); //printed when an integer outside of 1,2,3, or 4 is entered
                }
            } catch (InputMismatchException e) { // catches input mismatch exception when input is not an integer
                System.out.println(e + ": Input must be either one of 1, 2, 3, or 4 try again.\n");
                input.nextLine(); // scans the input again in the next line
            }
        }
    }

    public void getListTypeFromKeyboard (Scanner input) {
        int ListType; // create int variable for the input and switch
        while(true) { // runs as long as user does not exit loop
            try {
                System.out.println("\nPlease enter number to declare type of list");
                System.out.println("1. Add element to integer list");
                System.out.println("2. Add element to string list");
                System.out.println("3. Back to main menu");
                ListType = input.nextInt(); // initialize ShapeType as the scanner input
                input.nextLine(); // ensures that the next input must be read in the next line
                if (ListType > 0 && ListType < 4) { // switch case only applicable if inputs are 1, 2, or 3
                    switch (ListType) {
                        case (1):
                            getIntegerListFromKeyboard(input); // calls method for point creation
                            continue; // continue looping
                        case (2):
                            getStringListFromKeyboard(input); // calls method for circle creation
                            continue; // continue looping
                        case (3):
                            return; // returns and exits method
                    }
                } else {
                    System.out.println("Input must be either one of 1, 2, or 3, try again"); // printed when an integer outside of 1 - 4 (inclusive) is entered
                }
            } catch (InputMismatchException e) { // catches InputMismatchException when an integer is not entered
                System.out.println(e + ": Input must be either one of 1, 2, or 3, try again.\n");
                input.nextLine(); // scans input again in the next line
                continue; // continue loop
            }
            break; // break from loop
        }
    }

    public void getIntegerListFromKeyboard(Scanner input) {

        int element; // create an int variable for the input

        while (true) {
            try {
                System.out.println("Enter an integer to add to the list:");
                element = input.nextInt(); // scan the input to element
                input.nextLine();
                if (!iList.insert(element)) { // if insert returns false
                    System.out.println(element + " already exists in the list.");
                } else { // if insert is successful
                    System.out.println(element + " has been added to the list.");
                }
            } catch (InputMismatchException e) { // catches exception InputMismatchException if the input is not an integer
                System.out.println(e + ": Input must be integers, try again.\n");
                input.nextLine(); // scans the input again in the following line
                continue; // continue looping
            }
            break; // we got it correctly, so break out of the loop
        } // loop until we get it correctly
    }

    public void getStringListFromKeyboard(Scanner input) {

        String element; // create a string reference for the input

        while (true) {
            try {
                System.out.println("Enter a string to add to the list:");
                element = input.nextLine(); // scan the input to the reference
                if (!sList.insert(element)) { // if insert returns false
                    System.out.println("\"" + element + "\"" + " already exists in the list.");
                } else { // if insert is successful
                    System.out.println("\"" + element + "\"" + " has been added to the list.");
                }
            } catch (InputMismatchException e) { // catches exception InputMismatchException if the input is not an integer
                System.out.println(e + ": Input must be strings, try again.\n");
                input.nextLine(); // scans the input again in the following line
                continue; // continue looping
            }
            break; // we got it correctly, so break out of the loop
        } // loop until we get it correctly
    }

    public String returnListToConsole() { // prints the two lists
        return "\n" + iList.toString() + "\n" + sList.toString();
    }

    public void removeFromList(Scanner input) {
        if (iList.firstNode == null && sList.firstNode == null) { // if both lists are empty
            System.out.println("No elements have been created yet."); // prints if no shapes have been created
            return; // back to main menu
        }

        Object removedNode; // create object for the data to remove
        int sure; // create int for switch

        while(true) { // loop until we get it correct
            try {
                System.out.println("\nWhich list would you like to remove an element from?");
                System.out.println("1. Integer List");
                System.out.println("2. String List");
                System.out.println("3. Back to main menu");
                sure = input.nextInt(); // scan the input
                input.nextLine();
                if (sure > 0 && sure < 4) { // only runs if input is 1, 2, or 3
                    switch (sure) {
                        case (1) -> {
                            if (iList.firstNode == null) { // if list is empty
                                System.out.println("Integer list is empty.");
                            } else {
                                System.out.println(iList.toString()); // prints the integer list
                                System.out.println("Enter the integer to remove:");
                                removedNode = input.nextInt(); // scan the data
                                input.nextLine();
                                if (iList.remove(removedNode) == null) { // returned null, integer not in list
                                    System.out.println("Integer does not exist in the list.");
                                } else {
                                    System.out.println(removedNode + " has been removed.");
                                }
                            }
                        }
                        case (2) -> {
                            if (sList.firstNode == null) { // if list is empty
                                System.out.println("String list is empty.");
                            } else {
                                System.out.println(sList.toString()); // prints the string list
                                System.out.println("Enter the string to remove:");
                                removedNode = input.next(); // scans the data
                                input.nextLine();
                                if (sList.remove(removedNode) == null) { // returned null, string not in list
                                    System.out.println("String does not exist in the list.");
                                } else {
                                    System.out.println("\"" + removedNode + "\" has been removed.");
                                }
                            }
                        }
                        case (3) -> {
                            return; // returns to main menu
                        }
                    }
                } else {
                    System.out.println("Input must be 1, 2, or 3, try again.\n");
                }
            } catch (InputMismatchException e) { // catches InputMismatchException if input is not an integer
                System.out.println(e + ": Invalid input, try again.\n");
                input.nextLine(); // scans the input again in the next line
            }

        }

    }

}

class IntegerOrderedList extends OrderedList {

    public IntegerOrderedList(String listName) { // constructor
        firstNode = lastNode = null;
        name = listName;
    }

    @Override
    protected int compare(Object obj1, Object obj2) { // override compare of OrderedList parent class

        Integer temp = (Integer) obj1; // create a string reference of object obj1

        Integer temp2 = (Integer) obj2; // create a string reference of object obj2

        return temp.compareTo(temp2); // compare the strings

    }

}

class StringOrderedList extends OrderedList {

    public StringOrderedList(String listName) { // constructor
        firstNode = lastNode = null;
        name = listName;
    }

    @Override
    protected int compare(Object obj1, Object obj2) {  // override compare of OrderedList parent class

        String temp = (String) obj1; // create a string reference of object obj1

        String temp2 = (String) obj2; // create a string reference of object obj2

        return temp.compareTo(temp2); // compare the strings

    }

}


