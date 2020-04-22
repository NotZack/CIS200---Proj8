import java.util.*;

/*******************************************************************
 * Proj8.java* <Zackary Nichol / Friday/3:30>
 *******************************************************************/

public class Proj8 {
    public static void main(String[] args) {

        Scanner s = new Scanner (System.in);
        ArrayList<Student> studentsList = new ArrayList<>();

        String reply;

        do {
            reply = "Y";

            System.out.print("Enter the student's name: ");
            String name = s.nextLine();
            try {
                if (name.equals("")) throw new Error("Name is required (Please re-enter)");
            }
            catch (Error e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.print("Enter student's user name: ");
            String userName = s.nextLine();
            try {
                if (userName.equals("")) throw new Error("User name is required (Please re-enter name and user name)");
            }
            catch (Error e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.print("Enter student's GPA: ");
            double gpa = 0;
            try {
                gpa = Double.parseDouble(s.nextLine());
                while (gpa < 0.0 || gpa > 4.0) {
                    System.out.print("GPA must be between 0.0-4.0 (inclusive). Please re-enter: ");
                    gpa = Double.parseDouble(s.nextLine());
                }
            }
            catch (NumberFormatException e) {
                System.out.println("No characters allowed for GPA...Please re-enter all information");
                continue;
            }

            studentsList.add(new Student(name, userName, gpa));

            System.out.println("Student added to the arraylist...");
            System.out.print("\nAdd another student? ('Y' or 'N'): ");
            reply = s.nextLine();
        }
        while (reply.equalsIgnoreCase("Y"));

        for (Student student : studentsList) {
            System.out.println(student.toString() + "\n");
        }

        System.out.println("Students on the Dean's list");
        for (Student student : studentsList) {
            if (student.getGpa() > 3.0) System.out.println(student.getName() + " - " + student.getGpa());
        }
    }
}