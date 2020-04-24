/**
 * A Student represents a actual physical student at K-State with a name, username, gpa, and WID
 */
public class Student {

    private String name;
    private String userName;
    private double gpa;
    private String WID;

    /**
     * Creates a new, complete student
     * @param name The name of the student
     * @param userName The user name of the student
     * @param WID The WID of the student
     * @param gpa The cumulative gpa of the student
     */
    Student(String name, String userName, String WID, double gpa) {
        this.name = name;
        this.userName = userName;
        this.WID = WID;
        this.gpa = gpa;
    }

    /**
     * @return The email of this student
     */
    public String getEmail() {
        return userName + "@ksu.edu";
    }

    /**
     * @return The WID of this student
     */
    public String getWID() {
        return this.WID;
    }

    /**
     * A student is equal if their WIDs match.
     * @return If the students' WIDs matched
     */
    public boolean equals(Student otherStudent) {
        return otherStudent.getWID().equals(this.getWID());
    }

    /**
     * @return A string representation of all of this student's variables
     */
    @Override
    public String toString() {
        return name + "\nWID: " + WID + "\n" + getEmail() + "\nGPA: " + gpa;
    }
}