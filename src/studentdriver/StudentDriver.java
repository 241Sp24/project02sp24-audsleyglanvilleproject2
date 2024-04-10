package studentdriver;

import java.io.File;
import java.util.*;

public class StudentDriver {

    public static void main(String[] args) {
        //Asking the user to input amount of students
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the no of UG students: ");
        int numUGStudents = inputScanner.nextInt();
        System.out.print("Enter the no of Graduate students: ");
        int numGraduateStudents = inputScanner.nextInt();
        System.out.print("Enter the no of online students: ");
        int numOnlineStudents = inputScanner.nextInt();

        StudentFees[] students = new StudentFees[numUGStudents + numGraduateStudents + numOnlineStudents];

        try {
            //pulling info from the input file
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

                    students[index] = new UGStudent(studentName, studentID, isEnrolled, isScholarship, scholarshipAmount, coursesEnrolled, 0);
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
        System.out.println();
        System.out.println("**********Undergraduate students list**********");
        for (StudentFees student : students) {
            if (student instanceof UGStudent) {
                UGStudent ugStudent = (UGStudent) student;
                System.out.println("Student name: " + ugStudent.getStudentName());
                System.out.println("Student id: " + ugStudent.getStudentID());
                System.out.println("Enrolled: " + ugStudent.isEnrolled());
                System.out.println("Scholarship: " + ugStudent.hasScholarship());
                System.out.println("Scholarship Amount: " + ugStudent.getScholarshipAmount());
                System.out.println("Courses enrolled: " + ugStudent.getCoursesEnrolled());
                System.out.println("Payable amount: " + ugStudent.getPayableAmount());
                System.out.println();
            }
        }

        System.out.println("**********Graduate students list**********");
        for (StudentFees student : students) {
            if (student instanceof GraduateStudent) {
                GraduateStudent graduateStudent = (GraduateStudent) student;
                System.out.println("Student name: " + graduateStudent.getStudentName());
                System.out.println("Student id: " + graduateStudent.getStudentID());
                System.out.println("Enrolled: " + graduateStudent.isEnrolled());
                System.out.println("Graduate Assistant: " + graduateStudent.isIsGraduateAssistant());
                System.out.println("Graduate Assistant Type: " + graduateStudent.getGraduateAssistantType());
                System.out.println("Courses enrolled: " + graduateStudent.getCoursesEnrolled());
                System.out.println("Payable amount: $" + String.format("%.2f", graduateStudent.getPayableAmount())); // Print payable amount
                System.out.println();
            }
        }
        System.out.println("**********Online students list**********");
        for (StudentFees student : students) {
            if (student instanceof OnlineStudent) {
                OnlineStudent onlineStudent = (OnlineStudent) student;

                System.out.println("Student name: " + onlineStudent.getStudentName());
                System.out.println("Student id: " + onlineStudent.getStudentID());
                System.out.println("Enrolled: " + onlineStudent.isEnrolled());
                System.out.println("Number of Months: " + onlineStudent.getNumOfMonths());
                System.out.println("Payable amount: " + onlineStudent.getPayableAmount());
                System.out.println();
            }
        }

        // Calculation for UG students
        double totalUGFee = 0;
        int scholarshipCount = 0;
        int totalUGCourses = 0;
        int ugStudentCount = 0;

        for (StudentFees student : students) {
            if (student instanceof UGStudent && student.isEnrolled()) {
                UGStudent ugStudent = (UGStudent) student;
                totalUGFee += ugStudent.getPayableAmount();
                if (ugStudent.hasScholarship()) {
                    scholarshipCount++;
                }
                totalUGCourses += ugStudent.getCoursesEnrolled();
                ugStudentCount++;
            }
        }

        double averageUGFee = (ugStudentCount != 0) ? totalUGFee / ugStudentCount : 0;
        System.out.println("**********Undergraduate Students details**********");
        System.out.println("Average Students fee: " + String.format("%.1f", averageUGFee)); // Update output format
        System.out.println("Scholarship count: " + scholarshipCount);
        System.out.println("Total number of courses: " + totalUGCourses);

        System.out.println();

        // Calculation for Graduate Students
        double totalGraduateFee = 0;
        int graduateAssistantCount = 0;
        int totalGraduateCourses = 0;
        int graduateStudentCount = 0;

        for (StudentFees student : students) {
            if (student instanceof GraduateStudent && student != null) {
                GraduateStudent graduateStudent = (GraduateStudent) student;
                totalGraduateFee += graduateStudent.getPayableAmount();
                if (graduateStudent.isIsGraduateAssistant()) {
                    graduateAssistantCount++;
                }
                totalGraduateCourses += graduateStudent.getCoursesEnrolled();
                graduateStudentCount++;
            }
        }
        double averageGraduateFee = (graduateStudentCount != 0) ? totalGraduateFee / graduateStudentCount : 0;
        System.out.println("**********Graduate Students details**********");
        System.out.println("Average Grad student fee: $" + String.format("%.2f", averageGraduateFee));
        System.out.println("Number of students who got graduate assistantship: " + graduateAssistantCount);
        System.out.println("Total courses enrolled by all grad students: " + totalGraduateCourses);
        System.out.println();

        // Calculation for online students
        double totalOnlineFee = 0;
        int onlineStudentCount = 0;
        for (StudentFees student : students) {
            if (student instanceof OnlineStudent && student != null) {
                OnlineStudent onlineStudent = (OnlineStudent) student;
                totalOnlineFee += onlineStudent.getPayableAmount();
                onlineStudentCount++;
            }
        }
        double averageOnlineFee = (onlineStudentCount != 0) ? totalOnlineFee / onlineStudentCount : 0;
        System.out.println("**********Online Students details**********");
        System.out.println("Average Online Student fee: $" + String.format("%.2f", averageOnlineFee));

    }
}
