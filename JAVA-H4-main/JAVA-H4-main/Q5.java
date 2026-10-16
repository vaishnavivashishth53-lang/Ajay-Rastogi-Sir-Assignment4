import java.util.LinkedHashSet;
import java.util.Scanner;

class CourseEnrollment {
    private LinkedHashSet<String> students = new LinkedHashSet<>();

    public void enrollStudent(String name) {
        if (students.add(name)) {
            System.out.println("Enrolled: " + name);
        } else {
            System.out.println(name + " is already enrolled");
        }
    }

    public void displayEnrolledStudents() {
        System.out.println("Enrolled Students: " + students);
    }
}

public class Q5 {
    public static void main(String[] args) {
        CourseEnrollment enrollment = new CourseEnrollment();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enroll (or type 'exit' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            enrollment.enrollStudent(name);
        }

        enrollment.displayEnrolledStudents();
        scanner.close();
    }
}