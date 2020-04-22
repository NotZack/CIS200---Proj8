public class Student {
    private String name;
    private String userName;
    private double gpa;

    Student(String name, String userName, double gpa) {
        this.name = name;
        this.userName = userName;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public String getEmail() {
        return userName + "@ksu.edu";
    }

    @Override
    public String toString() {
        return name + "\n" + getEmail() + "\nGPA: " + gpa;
    }
}