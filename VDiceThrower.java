import java.util.*; // import java packages

public class VDiceThrower {

    public int[] results; // declare global array for throw results

    public int nsides; // declare global integer for number of sides

    public void getSideNoFromKeyboard (Scanner input) {
        nsides = 0; // initialize nsides to 0
        while (true) {
            try {
                System.out.println("Enter the number of sides of the dice:");
                nsides = input.nextInt();// scans the input using nextInt method in java scanner class
                input.nextLine(); // ensures that the next input must be read in the next line
                if (nsides < 1) { // ensures input is positive
                    System.out.println("Number of sides must be a positive integer\n");
                    continue; // continue looping
                }
            } catch (InputMismatchException e) { // catch InputMismatchException if input is not an int
                System.out.println(e + "Input must be integers, try again.\n");
                input.nextLine(); // scans the input again in the following line
                continue; // continue looping
            }
            break; // we got it correctly, so break out of the loop
        } // loop until we get it correctly
    }

    public void diceRNG (Scanner input) {
        int nthrow = getThrowNoFromKeyboard(input, nsides); // call the getThrowNoFromKeyboard method to obtain the number of throws to attempt
        Random randGen = new Random(); // create new randGen object instance of class Random to call random methods
        results = new int[nthrow]; // create a new instance array of length nthrow as the results array
        int i; // declare the loop counter i
        for (i = 0; i < nthrow; i++) { // loop for the length of the number of throws
            results[i] = randGen.nextInt(nsides) + 1; // randomly generates an integer up to nsides to each element of the array
        }
    }

    public static int getThrowNoFromKeyboard(Scanner input, int nsides) {
        int nthrow; // declare variable for the number of throws
        int k; // declare variable k to used to determine nthrows
        while (true) {
            try {
                System.out.println("Enter a factor multiplied to the number of sides to obtain the number of times to throw the dice:");
                k = input.nextInt(); // scan k using nextInt
                if (k < 1) { // ensures input is positive
                    System.out.println("Input must be a positive integer\n");
                    continue; // continue looping
                }
                nthrow = k*nsides; // calculate nthrow which is the product of k and nsides
                System.out.println("Number of times thrown: " + nthrow); // print nthrow
            } catch (InputMismatchException e) { // catches exception InputMismatchException if the input is not an integer
                System.out.println(e + "Input must be integers, try again.\n");
                input.nextLine(); // scans the input again in the following line
                continue; // continue looping
            }
            break; // we got it correctly, so break out of the loop
        } // loop until we get it correctly
        return nthrow; // returns nthrow
    }

    @Override // overrides Object toString - all Java classes inherit (ultimately) from Object
    public String toString () {
        String s1 = ""; // declare and initialize a string s1
        int i; // declare loop counter i
        int count; // declare counter for the amount of times a side is thrown and detected
        int j; // declare loop counter j
        int k; // declare loop counter k
        for (i = 0; i < results.length; i++) { // loop through the length of the number of throws
            s1 += results[i]; // concatenate each throw result into the string
            if (i < results.length - 1) {
                s1 += ", "; // adds a comma after each result
            } else {
                s1 += "\n\n"; // no comma in the final result
            }
        }
        s1 += "Results by dice sides: \n";
        for (j = 1; j < nsides + 1; j++) { // loop through the number of sides
            count = 0; // start the counter at 0
            for (k = 0; k < results.length; k++) { // loop through the length of the number of throws
                if (results[k] == j) {
                    count++; // counter goes up if the side number is detected in the array
                }
            }
            s1 += j + ": Thrown " + count + " times\n"; // concatenate into the string
        }
        return s1; // returns the concatenated string
    }

    public static void main (String[] args) {
        VDiceThrower dice = new VDiceThrower(); // create new VDiceThrower object instance to call methods
        Scanner input = new Scanner(System.in); // create new Scanner class object instance to call scanner methods
        dice.getSideNoFromKeyboard(input); // calls getSideNoFromKeyboard method which asks the user for the number of desired sides in their dice
        dice.diceRNG(input); // calls diceRNG method which asks the user for the number of throws and randomly simulates the results
        System.out.printf("\nThrow results: %s\n", dice.toString()); // prints the results using toString method
    }

} // end class
