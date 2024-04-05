package studentdriver;

import java.util.*;

public class StudentDriver {

    public static void main(String[] args) {
        //Got most of the code done
        System.out.println("Project02");
        // read the number of each type of student
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the no of UG students: ");
        int numUGStudents = inputScanner.nextInt();
        System.out.print("Enter the no of Graduate students: ");
        int numGraduateStudents = inputScanner.nextInt();
        System.out.print("Enter the no of online students: ");
        int numOnlineStudents = inputScanner.nextInt();

        // instantiate an array of StudentFees to hold the data from the file
        Students[] students = new StudentFees[numUGStudents + numGraduateStudents + numOnlineStudents];

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
                String graduateAssistantType = "";
                if (data.length > 5) {
                    graduateAssistantType = data[5];
                }
                students[index] = new GraduateStudent(studentName, studentID, isEnrolled, isGraduateAssistant, graduateAssistantType, coursesEnrolled);
            } else if (studentID >= 300 && studentID <= 399) {
                int creditsEnrolled = Integer.parseInt(data[3]);
                students[index] = new OnlineStudent(studentName, studentID, isEnrolled, creditsEnrolled);
            }

            index++;
        }

        scanner.close();

        // print the list of student's data
        System.out.println("******* Undergraduate students list *******");
        for (StudentFees student : students) {
            if (student instanceof UGStudent) {
                UGStudent ugStudent = (UGStudent) student;

                System.out.println("Student name: " + ugStudent.getStudentName());
                System.out.println("Student id: " + ugStudent.getStudentID());
                System.out.println("Enrolled: " + ugStudent.isEnrolled());
                System.out.println("Scholarship: " + ugStudent.isScholarship());
                System.out.println("Scholarship amount: " + ugStudent.getScholarshipAmount());
                System.out.println("Courses enrolled: " + ugStudent.getCoursesEnrolled());
                System.out.println("Payable amount: " + ugStudent.getPayableAmount());
                System.out.println();
            }
        }

        System.out.println("******* Graduate students list *******");
        for (StudentFees student : students) {
            if (student instanceof GraduateStudent) {
                GraduateStudent graduateStudent = (GraduateStudent) student;

                System.out.println("Student name: " + graduateStudent.getStudentName());
                System.out.println("Student id: " + graduateStudent.getStudentID());
                System.out.println("Enrolled: " + graduateStudent.isEnrolled());
                System.out.println("Graduate Assistant: " + graduateStudent.isGraduateAssistant());
                System.out.println("Assistant Type: " + graduateStudent.getGraduateAssistantType());
                System.out.println("Courses enrolled: " + graduateStudent.getCoursesEnrolled());
                System.out.println("Payable amount: " + graduateStudent.getPayableAmount());
                System.out.println();
            }
        }

        System.out.println("******* Online students list *******");
        for (StudentFees student : students) {
            if (student instanceof OnlineStudent) {
                OnlineStudent onlineStudent = (OnlineStudent) student;

                System.out.println("Student name: " + onlineStudent.getStudentName());
                System.out.println("Student id: " + onlineStudent.getStudentID());
                System.out.println("Enrolled: " + onlineStudent.isEnrolled());
                System.out.println("Credits enrolled: " + onlineStudent.getCreditsEnrolled());
                System.out.println("Payable amount: " + onlineStudent.getPayableAmount());
                System.out.println();
            }
        }

        // calculate + display avg of UG students fee, number of students who got scholarship, total no of courses enrolled by all UG students
        double totalUGFee = 0;
        int scholarshipCount = 0;
        int totalUGCourses = 0;
        int ugStudentCount = 0;

        for (StudentFees student : students) {
            if (student instanceof UGStudent) {
                UGStudent ugStudent = (UGStudent) student;
                totalUGFee += ugStudent.getPayableAmount();
                if (ugStudent.isScholarship()) {
                    scholarshipCount++;
                }
                totalUGCourses += ugStudent.getCoursesEnrolled();
                ugStudentCount++;
            }
        }

        double averageUGFee = totalUGFee / ugStudentCount;
        System.out.println("Average UG student fee: $" + String.format("%.2f", averageUGFee));
        System.out.println("Number of students who got scholarship: " + scholarshipCount);
        System.out.println("Total courses enrolled by all UG students: " + totalUGCourses);
    }
}
