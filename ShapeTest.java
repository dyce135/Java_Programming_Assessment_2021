import java.util.*; // import for scanner and other classes

public class ShapeTest {

    private int k = 0; // declare and initiate integer counter k to indicate position in the array ShapeList

    private int size = 1; // declare and initiate integer size to indicate size of ShapeList

    public Shape[] ShapeList = new Shape[size]; // create new array object ShapeList of class Shape

    public void getShapeTypeFromKeyboard (Scanner input) {
        int ShapeType; // create int variable for the input and switch
        while(true) { // runs as long as user does not exit loop
            try {
                System.out.println("Please enter number to declare shape");
                System.out.println("1. Create point");
                System.out.println("2. Create circle");
                System.out.println("3. Create cylinder");
                System.out.println("4. Back to main menu");
                ShapeType = input.nextInt(); // initialize ShapeType as the scanner input
                input.nextLine(); // ensures that the next input must be read in the next line
                if (ShapeType > 0 && ShapeType < 5) { // switch case only applicable if inputs are 1, 2, 3, or 4
                    switch (ShapeType) {
                        case (1):
                            getPointFromKeyboard(input); // calls method for point creation
                            continue; // continue looping
                        case (2):
                            getCircleFromKeyboard(input); // calls method for circle creation
                            continue; // continue looping
                        case (3):
                            getCylinderFromKeyboard(input); // calls method for cylinder creation
                            continue; // continue looping
                        case (4):
                            break; // breaks from loop and exits method
                    }
                } else {
                    System.out.println("Input must be either one of 1, 2, 3, or 4, try again"); // printed when an integer outside of 1 - 4 (inclusive) is entered
                }
            } catch (InputMismatchException e) { // catches InputMismatchException when an integer is not entered
                System.out.println(e + ": Input must be either one of 1, 2, 3, or 4, try again.\n");
                input.nextLine(); // scans input again in the next line
                continue; // continue loop
            }
            break; // break from loop
        }
    }

    public void growSize() { // increases the size of the dynamic array ShapeList
        Shape[] temp = new Shape[size * 2]; // creates a new temporary array object instance temp of interface Shape which has double the size of ShapeList
        if (size >= 0) {
            System.arraycopy(ShapeList, 0, temp, 0, size); // copies the the elements of ShapeList to temp
        }
        ShapeList = temp; // redefine a new ShapeList same as temp
        size *= 2; // redefine the new size which is double the previous size
    }

    public void getPointFromKeyboard (Scanner input) {
        Point point = new Point(); // Create new object instance point of class Point
        while (true) { // loops until it gets it correctly
            try {
                System.out.println("\nEnter the parameters of the point:");
                System.out.println("Enter the x-value of the point:");
                point.setX(input.nextFloat()); // scans the x value
                input.nextLine(); // ensures that the next input must be read in the next line
                System.out.println("Enter the y-value of the point:");
                point.setY(input.nextFloat()); // scans the y value
                input.nextLine(); // ensures that the next input must be read in the next line
            } catch (InputMismatchException e) { // catches InputMismatchException if inputs are not numbers
                System.out.println(e + ": Input must be a number, try again");
                input.nextLine(); // scans the input again in the next line
                continue; // continue looping
            }
            ShapeList[k] = point; // define the k-th element in ShapeList as the point object
            k++; // increment of k by 1
            if (k == size) { // runs if k reaches the end of array
                growSize(); // calls the method growSize to increase the array size
            }
            break; // we got it correctly, so break out fo loop
        }
    }

    public void getCircleFromKeyboard (Scanner input) {
        Circle circle = new Circle(); // Create new object instance circle of class Circle
        double r;
        while (true) { // loops until it gets it correctly
            try {
                System.out.println("\nEnter the parameters of the circle:");
                System.out.println("Enter the x-value of the circle:");
                circle.setX(input.nextFloat()); // scans the x value
                input.nextLine(); // ensures that the next input must be read in the next line
                System.out.println("Enter the y-value of the circle:");
                circle.setY(input.nextFloat()); // scans the y value
                input.nextLine(); // ensures that the next input must be read in the next line
                System.out.println("Enter the radius of the circle:");
                circle.setRadius(r = input.nextDouble()); // scans the radius value
                if (r < 0) {
                    System.out.println("A negative value has been entered, default to 0.\n");
                }
                input.nextLine(); // ensures that the next input must be read in the next line
            } catch (InputMismatchException e) { // catches InputMismatchException if inputs are not numbers
                System.out.println(e + ": Input must be a number, try again");
                input.nextLine(); // scans input again in the next line
                continue; // continue looping
            }
            ShapeList[k] = circle; // define the k-th element in ShapeList as the circle object
            k++; // increment of k by 1
            if (k == size) { // runs if k reaches the end of array
                growSize(); // calls the method growSize to increase the array size
            }
            break; // we got it correctly, so break out fo loop
        }
    }

    public void getCylinderFromKeyboard (Scanner input) {
        Cylinder cylinder = new Cylinder(); // Create new object instance circle of class Cylinder
        double r, h;
        while (true) { // loops until it gets it correctly
            try {
                System.out.println("\nEnter the parameters of the cylinder:");
                System.out.println("Enter the x-value of the cylinder:");
                cylinder.setX(input.nextFloat()); // scans the x value
                input.nextLine(); // ensures that the next input must be read in the next line
                System.out.println("Enter the y-value of the cylinder:");
                cylinder.setY(input.nextFloat()); // scans the y value
                input.nextLine(); // ensures that the next input must be read in the next line
                System.out.println("Enter the radius of the cylinder:");
                cylinder.setRadius(r = input.nextDouble()); // scans the radius value
                if (r < 0) {
                    System.out.println("A negative value has been entered, default to 0.\n");
                }
                input.nextLine(); // ensures that the next input must be read in the next line
                System.out.println("Enter the height of the cylinder:");
                cylinder.setHeight(h = input.nextDouble()); // scans the height value
                if (h < 0) {
                    System.out.println("A negative value has been entered, default to 0.\n");
                }
                input.nextLine(); // ensures that the next input must be read in the next line
            } catch (InputMismatchException e) { // catches InputMismatchException if inputs are not numbers
                System.out.println(e + ": Input must be a number, try again");
                input.nextLine(); // scans the input again in the next line
                continue; // continue looping
            }
            ShapeList[k] = cylinder; // define the k-th element in ShapeList as the cylinder object
            k++; // increment of k by 1
            if (k == size) { // runs if k reaches the end of array
                growSize(); // calls the method growSize to increase the array size
            }
            break; // we got it correctly, so break out of loop
        }
    }

    public String returnShapesToConsole () {
        String s1; // creates a string s1
        if (k > 0) { // only runs if there are contents saved in ShapeList
            int i; // declare loop counter i
            s1 = "============================================================================================================================\n\nInformation of all created shapes:\n";
            for (i = 0; i < k; i++) { // loop until k (ShapeList counter) is reached
                s1 += "\n" + (i + 1) + ". " + ShapeList[i].getName() + " centred at " + ShapeList[i].toString() + "\n"; // concatenate s1 to indicate the name, position, and information of the shape
                if (ShapeList[i] instanceof Circle) { // only runs if object is of circle or subclass of circle (cylinder)
                    s1 += "Area: " + ShapeList[i].getArea() + "\n"; // obtains the total area of the shape
                    if (ShapeList[i] instanceof Cylinder) { // only runs if shape is an object of class Cylinder
                        s1 += "Volume: " + ShapeList[i].getVolume() + "\n"; // obtains volume of the cylinder
                    }
                }
            }
            s1 += "\n============================================================================================================================";
        } else {
            s1 = "No shapes have been created yet. Please create a shape before printing."; // prints if no shapes have been created
        }
        return s1; // returns the concatenated string
    }

    public void removeShapeFromList (Scanner input) {
        if (k > 0) { //only runs if there are shapes created
            int index;// declare index variable
            int ShapeNumber;
            int sure;
            while(true) { // loop until we get it correct
                try {
                    System.out.println("Are you sure?");
                    System.out.println("1. Yes");
                    System.out.println("2. No (Back to main menu)");
                    sure = input.nextInt();
                    input.nextLine();
                    if (sure > 0 && sure < 3) { // only runs if input is 1 or 2
                        switch (sure) {
                            case (1) -> {} // continue out of if else
                            case (2) -> {
                                return; // returns to main menu
                            }
                        }
                    } else {
                        System.out.println("Input must be 1 or 2, try again.\n");
                        continue; // back to beginning of while loop
                    }
                    System.out.println("Enter the shape number to remove:");
                    ShapeNumber = input.nextInt(); // declare and define the shape number to be deleted
                    if (ShapeNumber > 0 && ShapeNumber <= k) {
                        input.nextLine(); // ensures that the next input must be read in the next line
                        int i; // declare loop counter i
                        int j; // declare counter j
                        index = ShapeNumber - 1; // define index as ShapeNumber - 1, which is their position in the array
                        Shape[] temp = new Shape[size]; // creates a new temporary array object instance temp of interface Shape
                        for (i = 0, j = 0; i < k; i++) {
                            if (i == index) {
                                continue; // skips the loop sequence when i is equal to index which skips the copying of the unwanted object
                            }
                            temp[j++] = ShapeList[i]; // copies each element for ShapeList into temp except for index which is skipped
                        }
                        k -= 1; // decreases k by 1
                        ShapeList = temp; // define a new ShapeList object which is same as temp
                        return; // we got it correctly, so return to main menu
                    } else {
                        System.out.println("Input must be a number of belonging to a created shape (Between 1 to " + k + ")\n");
                        input.nextLine(); // scans the input again in the next line
                    }
                } catch (InputMismatchException e) { // catches InputMismatchException if input is not an integer
                    System.out.println(e + ": Input must be an integer, try again.\n");
                    input.nextLine(); // scans the input again in the next line
                }
            }
        } else {
            System.out.println("No shapes have been created yet."); // prints if no shapes have been created
        }
    }

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in); // create new object instance of class Scanner
        ShapeTest Shaper = new ShapeTest(); // create new object instance of class ShapeTest
        int MainMenu; // create integer variable MainMenu to be used in the input switch
        while (true) { // loop while the program runs
            System.out.println("\nEnter 1, 2, 3, or 4 to declare action: ");
            System.out.println("1. Create shape");
            System.out.println("2. Print details of all created shapes");
            System.out.println("3. Remove shape from list");
            System.out.println("4. End program");
            try {
                MainMenu = input.nextInt(); // Define MainMenu as the scanner input
                input.nextLine(); // ensures that the next input must be read in the next line
                if (MainMenu < 5 && MainMenu > 0) {
                    switch (MainMenu) {
                        case (1) -> Shaper.getShapeTypeFromKeyboard(input); // call the getShapeTypeFromKeyboard method to obtain the desired shape to create from the user
                        case (2) -> System.out.println(Shaper.returnShapesToConsole()); // call the returnShapesToConsole method to print out all created shapes
                        case (3) -> Shaper.removeShapeFromList(input); // call the removeShapeFromList method to remove an unwanted shape from the ShapeList array
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
} // end class