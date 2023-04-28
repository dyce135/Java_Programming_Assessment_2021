import java.util.*; // import for scanner

public class StudentRecordOrderedListTest {

    StudentRecordOrderedList Record = new StudentRecordOrderedList("Student Record"); // create the student record ordered list object of class StudentRecordOrderedList

    public static void main (String[] args) {

        Scanner input = new Scanner(System.in); // create new object instance of class Scanner
        StudentRecordOrderedListTest listAction = new StudentRecordOrderedListTest(); // create new object instance of class StudentRecordOrderedListTest
        int MainMenu; // create integer variable MainMenu to be used in the input switch

        while (true) { // loop while the program runs

            System.out.println("\nEnter 1, 2, 3, or 4 to declare action: ");
            System.out.println("1. Add to student record");
            System.out.println("2. Print student record");
            System.out.println("3. Remove student from record");
            System.out.println("4. End program");

            try {
                MainMenu = input.nextInt(); // Define MainMenu as the scanner input
                input.nextLine(); // ensures that the next input must be read in the next line
                if (MainMenu < 5 && MainMenu > 0) { // ensures input are 1 to 4
                    switch (MainMenu) {
                        case (1) -> listAction.getDetailsFromKeyboard(input); // call the getDetailsFromKeyboard method to obtain the desired action from the user
                        case (2) -> listAction.returnListToConsole(input); // call the returnListToConsole method to print out student record
                        case (3) -> listAction.removeFromList(input); // call the removeFromList method to remove an unwanted record from the Record ordered linked list
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

    public void getDetailsFromKeyboard (Scanner input) {

        int ListType; // create int variable for the input and switch

        while(true) { // runs as long as user does not exit loop
            try {
                System.out.println("\nPlease enter number to declare type of list");
                System.out.println("1. Add student to record");
                System.out.println("2. Add marks to an existing student");
                System.out.println("3. Back to main menu");
                ListType = input.nextInt(); // initialize ShapeType as the scanner input
                input.nextLine(); // ensures that the next input must be read in the next line
                if (ListType > 0 && ListType < 4) { // switch case only applicable if inputs are 1, 2, or 3
                    switch (ListType) {
                        case (1):
                            getStudentFromKeyboard(input); // calls method to add a student to record
                            continue; // continue looping
                        case (2):
                            getMarksFromKeyboard(input); // calls method to add marks to an existing student
                            continue; // continue looping
                        case (3):
                            break; // breaks from loop and exits method
                    }
                } else {
                    System.out.println("Input must be either one of 1, 2, or 3, try again"); // printed when an integer outside of 1 - 4 (inclusive) is entered
                    continue; // continue looping
                }
            } catch (InputMismatchException e) { // catches InputMismatchException when an integer is not entered
                System.out.println(e + ": Input must be either one of 1, 2, or 3, try again.\n");
                input.nextLine(); // scans input again in the next line
                continue; // continue looping
            }
            break; // break from loop
        }
    }

    public void getStudentFromKeyboard(Scanner input) {

        String name; // define a string type reference name
        String surname; // define a string type reference surname
        int studentNo; // define a reference int type studentNo


        while (true) {
            try {
                System.out.println("\nEnter the student's first name:");
                name = input.nextLine(); // scan name
                System.out.println("Enter the student's surname:");
                surname = input.nextLine(); // scan surname
                System.out.println("Enter the student's student no.:");
                studentNo = input.nextInt(); // scan student number
                input.nextLine();
                StudentRecord student = new StudentRecord(name, surname, studentNo); // create a new object instance of class StudentRecord
                if (!Record.insert(student)) { // if inserting the object to the list returns false
                    System.out.println("\"" + name + " " + surname + "\" already exists in the record.");
                } else {
                    System.out.println("\"" + name + " " + surname + "\" has been added to the record.");
                }
            } catch (InputMismatchException e) { // catches exception InputMismatchException if the input is not an integer
                System.out.println(e + ": Invalid input, try again.\n");
                input.nextLine(); // scans the input again in the following line
                continue; // continue looping
            }
            break; // we got it correctly, so break out of the loop
        } // loop until we get it correctly

    }

    public void getMarksFromKeyboard(Scanner input) {

        if (Record.firstNode == null) { // if list is empty
            System.out.println("\nRecord is empty.");
            return; // returns to main menu
        }

        String name; // define a  string type reference name
        String surname; // define a string type reference surname
        int studentNo; // define an int studentNo for the existing student's student no.
        float avgmark; // define a float avgmark to insert into a new object
        ListNode addMarks; // define a new ListNode object reference named addMarks
        StudentRecord student; // define a new StudentRecord object

        while (true) {
            try {
                System.out.println("\n========================================================================");
                System.out.println(Record.toString()); // print the student record list
                System.out.println("========================================================================");
                System.out.println("\nEnter the student's first name to add marks to:");
                name = input.nextLine(); // scan to the name reference
                System.out.println("Enter the student's surname to add marks to:");
                surname = input.nextLine(); // scan to the surname reference
                StudentRecord findStudent = new StudentRecord(name, surname); // create a new StudentRecord object used to find the student
                addMarks = Record.binaryFind(findStudent); // find the student using binaryFind
                if (addMarks == null) { // if binaryFind returns null (search doesnt find the student)
                    System.out.println("Student does not exist.");
                    return; // returns to menu
                }
                student = (StudentRecord) addMarks.data; // extract the StudentRecord object data to the student reference
                name = student.name; // redeclare name to the object variable name of the student object
                surname = student.surname; // redeclare surname to the object variable surname of the student object
                studentNo = student.studentNo; // redeclare studentNo to the object variable studentNo of the student object
                while (true) { // loop until we get it correct
                    System.out.println("Enter the student's marks:");
                    avgmark = input.nextFloat(); // initiate avgmark from the scanner input
                    input.nextLine(); // moves scanner to next line
                    if (avgmark < 0) { // checks if and ensures that avgmark is positive
                        System.out.println("Marks must be positive.");
                        continue; // continue looping
                    }
                    break; // got it correct, so break out of loop
                }
                Record.remove(addMarks.data); // removes the original node
                StudentRecord studentReplaced = new StudentRecord(name, surname, studentNo, avgmark); // replaces the original node with an identical object instance with the average mark variable included
                Record.insert(studentReplaced); // insert the new object into the list
            } catch (InputMismatchException e) { // catches exception InputMismatchException if the input is not an integer
                System.out.println(e + ": Invalid input, try again.\n");
                input.nextLine(); // scans the input again in the following line
                continue; // continue looping
            }
            break; // we got it correctly, so break out of the loop
        } // loop until we get it correctly
    }

    public void returnListToConsole(Scanner input) {

        String name; // define a  string type reference name
        String surname; // define a string type reference surname
        ListNode printStudent; // define a new ListNode object reference named printStudent
        int option; // create integer variable option to be used in the input switch

        while (true) { // keeps user in the method as long as the user does not exit
            try {
                System.out.println("\nEnter option:");
                System.out.println("1. Print all student records.");
                System.out.println("2. Print a specific student's record.");
                System.out.println("3. Back to main menu.");
                option = input.nextInt(); // scan the switch input
                input.nextLine();
                if (option > 0 && option < 4) { // ensures input is 1, 2, or 3
                    switch (option) {
                        case (1) -> {
                            System.out.println("\n========================================================================");
                            System.out.println(Record.toString()); // print the student record list
                            System.out.println("========================================================================");
                        }
                        case (2) -> {
                            System.out.println("Enter the first name of the student to remove:");
                            name = input.nextLine(); // scans the name to the reference
                            System.out.println("Enter the surname of the student to remove:");
                            surname = input.nextLine(); // scans the surname to the reference
                            StudentRecord findStudent = new StudentRecord(name, surname); // create a new object instance of class StudentRecord used to search the list
                            printStudent = Record.binaryFind(findStudent); // binary finds the list using the prior input
                            if (printStudent == null) { // if binaryFind returns null (list node not found)
                                System.out.println("Student does not exist.");
                            } else {
                                System.out.println("\n========================================================================\n");
                                System.out.println(printStudent.data.toString()); // print the student record of the specific student
                                System.out.println("========================================================================");
                            }
                        }
                        case (3) -> {
                            return; // returns to main menu
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println(e + ": Invalid input, try again.\n");
                input.nextLine(); // scans the input again in the next line
            }
        }
    }

    public void removeFromList(Scanner input) {

        if (Record.firstNode == null) { // if list is empty
            System.out.println("No students in record.");
            return; // back to main menu
        }

        String name; // define a  string type reference name
        String surname; // define a string type reference surname
        ListNode RemovedStudent; // define a new ListNode object reference named RemovedStudent
        int sure; // define int variable for the switch

        while(true) { // loop until we get it correct
            try {
                System.out.println("\nAre you sure?");
                System.out.println("1. Yes");
                System.out.println("2. No (back to main menu)");
                sure = input.nextInt(); // scan the switch input
                input.nextLine();
                if (sure > 0 && sure < 3) { // only runs if input is 1 or 2
                    switch (sure) {
                        case (1) -> { } // continues to line after switch
                        case (2) -> {
                            return; // returns to main menu
                        }
                    }
                } else {
                    System.out.println("Input must be 1 or 2, try again.\n");
                    continue; // continue looping
                }
                if (Record.firstNode == null) { // if list is empty
                    System.out.println("List is empty.");
                } else {
                    System.out.println("\n========================================================================");
                    System.out.println(Record.toString()); // print student record
                    System.out.println("========================================================================");
                    System.out.println("Enter the first name of the student to remove:");
                    name = input.nextLine(); // scans the input to the name reference
                    System.out.println("Enter the surname of the student to remove:");
                    surname = input.nextLine(); // scans the input to the surname reference
                    StudentRecord findStudent = new StudentRecord(name, surname); // create a new object instance of class StudentRecord used to search the list
                    RemovedStudent = Record.binaryFind(findStudent); // binary finds the list using the prior input
                    if (RemovedStudent == null) { // if the search fails find and return the node
                        System.out.println("Student does not exist.");
                    } else {
                        Record.remove(RemovedStudent.data); // removes the listnode using the provided listnode
                        System.out.println("\"" + name + " " + surname + "\" has been removed from the record.");
                    }
                    break;
                }
            } catch (InputMismatchException e) { // catches InputMismatchException if input is not an integer
                System.out.println(e + ": Invalid input, try again.\n");
                input.nextLine(); // scans the input again in the next line
                continue;
            }
        }

    }

}

class StudentRecord {

    public String surname;

    public String name;

    public int studentNo;

    public float averageMark = -1; // set default to -1 to signify that it is empty

    @Override
    public String toString () { // overrides toString of parent classes
        String s;
        s = "Full name: " + name + " " + surname; // concatenate the name
        s += "\nStudent Number: " + studentNo; // shows student number
        if (averageMark != -1) { // if an averageMark has been added
            s += "\nAverage Mark: " + averageMark; // shows average mark
        }
        s += "\n"; // next line
        return s; // returns string
    }

    public StudentRecord (String firstname, String lastname, int studentNum) { // constructor
        name = firstname;
        surname = lastname;
        studentNo = studentNum;
    }

    public StudentRecord (String firstname, String lastname, int studentNum, float avgmark) { // constructor
        name = firstname;
        surname = lastname;
        studentNo = studentNum;
        averageMark = avgmark;
    }

    public StudentRecord (String firstname, String lastname) { // constructor
        name = firstname;
        surname = lastname;
    }

}

class StudentRecordOrderedList extends OrderedList {

    public StudentRecordOrderedList(String listName) { // constructor
        firstNode = lastNode = null;
        name = listName;
    }

    @Override
    protected int compare (Object obj1, Object obj2) { // compare method which overrides a parent compare method

        StudentRecord name1 = (StudentRecord) obj1; // create a reference of object StudentRecord for obj1

        StudentRecord name2 = (StudentRecord) obj2; // create a reference of object StudentRecord for obj1

        String fullName1 = name1.name + name1.surname; // concatenate the name of obj1

        String fullName2 = name2.name + name2.surname;  // concatenate the name of obj2

        return fullName1.compareTo(fullName2);  // compare and returns the two strings

    }

    @Override
    public String toString () { // overrides toString methods of parent classes
        if (firstNode == null) { // if list is empty
            return  name + " is empty.";
        }
        String output;
        ListNode current = firstNode; // pointer to first node
        output = name + ":\n\n" + current.data; // first element in list
        current = current.next; // moves pointer on to next element
        while (current != null) { // we are implicitly calling the data object toString method
            output += "\n" + current.data; // concatenate the elements
            current = current.next; // moves pointer to next element
        }
        return output; // return the string
    }

}







