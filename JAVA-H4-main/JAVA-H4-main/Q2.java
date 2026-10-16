import java.util.HashSet;
import java.util.Scanner;

class Attendance {
    private HashSet<String> attendanceSet = new HashSet<>();

    public void markAttendance(String name) {
        if (attendanceSet.add(name)) {
            System.out.println("Attendance marked for " + name);
        } else {
            System.out.println(name + " is already marked present");
        }
    }

    public void displayAttendance() {
        System.out.println("Present Students: " + attendanceSet);
    }
}

public class Q2 {
    public static void main(String[] args) {
        Attendance attendance = new Attendance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter name to mark attendance (or 'exit' to quit): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            attendance.markAttendance(name);
        }

        attendance.displayAttendance();
        scanner.close();
    }
}