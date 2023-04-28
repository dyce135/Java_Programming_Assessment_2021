import java.util.*; // needed for the Scanner class in the enhanced version

public class MeanAndVariance {

    float[] data; // the float array instance variable

    public float mean () {
        float sum = 0; // initiate a variable for the sum of numbers
        int i; // declare loop counter i
        for (i = 0; i < data.length; i++) { // loop through the whole length of the data array
            sum += data[i]; // for loop to sum the numbers
        }
        return sum / data.length; // return the mean by dividing the sum by the length of data vector (arithmetic expression for mean)
    }

    public float variance () {
        float sum = 0; // initiate a variable for the sum of numbers
        float varsum = 0; // initiate a variable for the variance sum
        int i; // initiate a for loop counter i
        for (i = 0; i < data.length; i++) {
            sum += data[i]; // for loop to sum the numbers
        }
        float avg = sum / data.length; // obtain the average by dividing the sum by the population number
        for (i = 0; i < data.length; i++) { // loop through the whole length of the data array
            varsum += Math.pow((data[i] - avg), 2); // for loop to sum the variance
        }
        return varsum / data.length; // obtain and return the variance
    }

    @Override // overrides Object toString - all Java classes inherit (ultimately) from Object
    public String toString () {
        String s1 = ""; // initiate string s1
        int i; // initiate a loop counter
        for (i = 0; i < data.length; i++) { // loop through the whole length of the data array
            s1 += data[i]; // concatenate the inputs to the array
            if (i < data.length - 1) {
                s1 += ", "; // add a comma following the number
            } else {
                s1 += ""; // no comma is added following the final input
            }
        }
        return s1; // return the string
    }

    private static int getDataNoFromKeyboard (Scanner input) {
        int ndata; // initialize integer ndata for the number of data
        while (true) {
            try {
                System.out.println("Enter the number of data set elements:"); // ask the user to enter the desired number of data
                ndata = input.nextInt(); // call nextint method from scanner class to scan the next token as ndata
                input.nextLine(); // ensures that the next input must be read in the next line
                if (ndata < 2) {
                    System.out.println("The number of data should be >=2, please try again"); // printed when the input is less than 2
                    continue; // continue looping
                }
            } catch (InputMismatchException e) { // catches InputMismatchException (i.e. when input is not an integer)
                System.out.println(e + ": Input must be integers, try again\n"); // printed when the input is not an integer
                input.nextLine(); // call the nextline method to advance the scanner and scan the input again
                continue; // continue looping
            }
            break; // we got it correctly, so break out of the loop
        } // loop until we get it correctly
        return ndata; // returns the ndata integer
    }

    public void getDataSetFromKeyboard (Scanner input) {
        int ndata = getDataNoFromKeyboard(input); // call the method getDataNoFromKeyboard to determine ndata
        data = new float[ndata]; // we create the array instance variable
        int i; // initiates loop counter i
        while (true) { // loop until we get it correctly
            try {
                System.out.println("Enter your data"); // asks the user enter the dataset
                for (i = 0; i < ndata; i++) { // loop for ndata amount of times
                    data[i] = input.nextFloat(); // loops through the data array as
                    input.nextLine(); // ensures that the next input must be read in the next line
                }
            }
            catch (InputMismatchException e) { // catches InputMismatchException (when input is not a float)
                System.out.println(e + "Input must be integers, try again\n");
                input.nextLine(); // call the nextLine method to advance the scanner and scan the input again
                continue; // continue looping
            }
            break; // we got it correctly, so break out of the loop
        }
    }

    public void getRandomDataSet (int ndata, int upperBound) {
        Random randGen = new Random(); // create a new randGen object instance to generate random floats
        data = new float[ndata]; // we create the array instance variable
        for (int i = 0; i < ndata; i++) { // loop for the length of ndata
            data[i] = randGen.nextFloat() * upperBound; // generate random floats for the whole length the data array
        }
    }

    public static void main (String[] args) {
        MeanAndVariance mv = new MeanAndVariance(); // we create a MeanAndVariance object instance
        try {
            if (args.length == 0) { // no arguments, so we get user data from the keyboard
                Scanner input = new Scanner(System.in); // create scanner that reads stdin
                mv.getDataSetFromKeyboard(input); // get user data from keyboard
            }
            else if (args.length == 2) { // two arguments, produce random data set
                int ndata = Integer.parseInt(args[0]); // parses the string in the first argument and returns an integer to ndata
                int upperBound = Integer.parseInt(args[1]); // parses the string in the second argument and returns an integer to upperBound
                if (ndata <= 0 || upperBound == 0) { // incorrect values of ndata or upperBound
                    System.out.println("ndata and/or upperBound has wrong value, try again");
                    System.exit(0); // terminate program
                }
                mv.getRandomDataSet(ndata, upperBound); // produce random data set
            }
            else { // any other number of arguments
                System.out.println("Number of arguments must be either 2 or 0, try again");
                System.exit(0); // terminate program
            }
            System.out.println("The mean and variance of the following numbers are:");
            System.out.printf("Numbers: %s\n", mv.toString()); // uses toString method to print all the data set
            System.out.printf("Mean: %f Variance: %f\n", mv.mean(), mv.variance()); // obtains and prints the mean and variance using the mean and variance methods
        } catch (NumberFormatException e) {
            System.out.println(e + ": Input arguments must be integers, try again"); // catches NumberFormatException if arguments are not integers
        }
    }

} // end class