package studentdriver;

import java.io.File;
import java.util.*;

public class StudentDriver {

    public static void main(String[] args) {
        System.out.println("Project02");

        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the no of UG students: ");
        int numUGStudents = inputScanner.nextInt();
        System.out.print("Enter the no of Graduate students: ");
        int numGraduateStudents = inputScanner.nextInt();
        System.out.print("Enter the no of online students: ");
        int numOnlineStudents = inputScanner.nextInt();

        StudentFees[] students = new StudentFees[numUGStudents + numGraduateStudents + numOnlineStudents];

        try {
            File file = new File("input.csv");
            Scanner scanner = new Scanner(file);

            int index = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                int studentID = Integer.parseInt(data[0]);
                String studentName = data[1];
                boolean isEnrolled = Boolean.parseBoolean(data[2]);

                if (studentID >= 100 && studentID <= 199) {
                    int coursesEnrolled = Integer.parseInt(data[3]);
                    boolean isScholarship = Boolean.parseBoolean(data[4]);
                    double scholarshipAmount = Double.parseDouble(data[5]);

                    students[index] = new UGStudent(studentName, studentID, isEnrolled, isScholarship, coursesEnrolled);
                } else if (studentID >= 200 && studentID <= 299) {
                    int coursesEnrolled = Integer.parseInt(data[3]);
                    boolean isGraduateAssistant = Boolean.parseBoolean(data[4]);
                    String graduateAssistantType = (data.length > 5) ? data[5] : "";

                    students[index] = new GraduateStudent(studentName, studentID, isEnrolled, isGraduateAssistant, graduateAssistantType, coursesEnrolled);
                } else if (studentID >= 300 && studentID <= 399) {
                    int creditsEnrolled = Integer.parseInt(data[3]);
                    students[index] = new OnlineStudent(studentName, studentID, isEnrolled, creditsEnrolled);
                }

                index++;
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Print student information
        System.out.println("******* Undergraduate students list *******");
        for (StudentFees student : students) {
            if (student instanceof UGStudent && student != null) {
                UGStudent ugStudent = (UGStudent) student;

                System.out.println("Student name: " + ugStudent.getStudentName());
                System.out.println("Student id: " + ugStudent.getStudentID());
                System.out.println("Enrolled: " + ugStudent.isEnrolled());
                System.out.println("Scholarship: " + ugStudent.hasScholarship());
                System.out.println("Courses enrolled: " + ugStudent.getCoursesEnrolled());
                System.out.println("Payable amount: " + ugStudent.getPayableAmount());
                System.out.println();
            }
        }

        // Similar printing for Graduate and Online students
        // Calculation for UG students
        double totalUGFee = 0;
        int scholarshipCount = 0;
        int totalUGCourses = 0;
        int ugStudentCount = 0;

        for (StudentFees student : students) {
            if (student instanceof UGStudent && student != null) {
                UGStudent ugStudent = (UGStudent) student;
                totalUGFee += ugStudent.getPayableAmount();
                if (ugStudent.isScholarship()) {
                    scholarshipCount++;
                }
                totalUGCourses += ugStudent.getCoursesEnrolled();
                ugStudentCount++;
            }
        }

        double averageUGFee = (ugStudentCount != 0) ? totalUGFee / ugStudentCount : 0;
        System.out.println("Average UG student fee: $" + String.format("%.2f", averageUGFee));
        System.out.println("Number of students who got scholarship: " + scholarshipCount);
        System.out.println("Total courses enrolled by all UG students: " + totalUGCourses);
    }
}
