import java.util.*;

/*******************************************************************
 * Proj8.java* <Zackary Nichol / Friday/3:30>
 * A student information entering program that allows the user to
 * input and validate each student's name, username, WID, and gpa.
 * Then allows the user to perform a search of the entered users
 * based on their WID.
 *******************************************************************/

public class Proj8 {

    /**
     * Performs all user input, input validation, and student WID search
     * functions.
     * @param args Unused command line arguments
     */
    public static void main(String[] args) {

        Scanner s = new Scanner (System.in);
        ArrayList<Student> studentsList = new ArrayList<>();

        String reply = "Y";
        while (reply.equalsIgnoreCase("Y")) {

            System.out.print("Enter the student's name: ");
            String name = s.nextLine();
            while (name.equals("")) {
                System.out.println("Name is required (Please re-enter)\n");
                System.out.print("Enter the student's name: ");
                name = s.nextLine();
            }

            System.out.print("Enter student's USER name: ");
            String userName = s.nextLine();
            while (userName.equals("")) {
                System.out.println("User name is required (Please re-enter)\n");
                System.out.print("Enter student's USER name: ");
                userName = s.nextLine();
            }

            String WID;
            while (true) {
                try {
                    System.out.print("Enter student's WID #: ");
                    WID = s.nextLine();
                    if (WID.equals("")) throw new Error();
                    Integer.parseInt(WID);
                    if (WID.length() != 9) throw new NumberFormatException();
                    break;
                }
                catch (Error e) {
                    System.out.println("WID is required (Please re-enter)\n");
                }
                catch (NumberFormatException e) {
                    System.out.println("WID must contain 9-digits - no characters (Please re-enter)\n");
                }
            }

            double gpa;
            System.out.print("Enter student's GPA: ");
            while (true) {
                try {
                    gpa = Double.parseDouble(s.nextLine());
                    if (gpa < 0.0 || gpa > 4.0) {
                        System.out.println("GPA must be between 0.0-4.0 (inclusive).");
                        System.out.print("Please re-enter: ");
                        continue;
                    }
                    break;
                }
                catch (NumberFormatException e) {
                    System.out.print("No characters allowed for GPA...\nPlease re-enter: ");
                }
            }
            Student newStudent = new Student(name, userName, WID, gpa);
            for (Student student : studentsList) {
                if (student.equals(newStudent)) {
                    System.out.println("Student already exists.");
                    newStudent = null;
                    break;
                }
            }
            if (newStudent != null) {
                studentsList.add(newStudent);
                System.out.println("Student added to the arraylist...");
            }
            System.out.print("\nAdd another student? ('Y' or 'N'): ");
            reply = s.nextLine();
        }

        HashMap<String, Student> studentMap = new HashMap<>();

        for (Student student : studentsList) {
            System.out.println("\n" + student.toString());
            studentMap.put(student.getWID(), student);
        }
        System.out.println("All students displayed.\n");

        System.out.println("Search for a Student by entering Student's WID number\n" +
                "(or enter \"exit\" to exit the program.)");
        while (true) {
            System.out.print("Input Student WID # (or \"exit\"): ");
            String searchInput = s.nextLine();
            if (searchInput.equals("")) {
               System.out.println("Nothing Entered");
               continue;
            }
            else if (searchInput.equalsIgnoreCase("exit")) {
                break;
            }

            boolean studentFound = false;
            for (String WID : studentMap.keySet()) {
                if (WID.equals(searchInput)) {
                    System.out.println("Student info:\n" + studentMap.get(WID).toString());
                    studentFound = true;
                    break;
                }
            }

            if (!studentFound) {
                System.out.println("Student not found");
            }
        }
    }
}