package studentdriver;

public class UGStudent {

    private String studentName;
    private int studentID;
    private boolean isEnrolled;
    private boolean hasScholarship;
    private double scholarshipAmount;
    private int coursesEnrolled;
    private double additionalFee;
    private static final double ADDITIONAL_FEE = 820.70;
    //Im using 3 credits because of what it says in thre StudentFees class
    private static final int CREDITS_PER_COURSE = 3;
    private double perCreditFee;

    public UGStudent(String studentName, int studentID, boolean isEnrolled, boolean hasScholarship, double scholarshipAmount, int coursesEnrolled, double additionalFee) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.isEnrolled = isEnrolled;
        this.hasScholarship = hasScholarship;
        this.scholarshipAmount = scholarshipAmount;
        this.coursesEnrolled = coursesEnrolled;
        this.additionalFee = additionalFee;
    }

    /**
     * @return the hasScholarship
     */
    public boolean isHasScholarship() {
        return hasScholarship;
    }

    /**
     * @return the scholarshipAmount
     */
    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    /**
     * @return the coursesEnrolled
     */
    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    public double getPayableAmount() {
        int totalCredits = coursesEnrolled * CREDITS_PER_COURSE;
        double tuitionFee = totalCredits * perCreditFee;
        double totalFee = tuitionFee + ADDITIONAL_FEE;
        if (hasScholarship) {
            totalFee -= scholarshipAmount;
        }
        return totalFee;
    }

    public String toString() {
        return "Student Name: " + studentName + "\nStudent ID: " + studentID + "\nEnrolled: " + isEnrolled
                + "\nScholarship: " + hasScholarship + "\nScholaship Amount: " + scholarshipAmount
                + "\nCourses Enrolled: " + coursesEnrolled + "\nPayable Amount: " + +getPayableAmount();
    }
}
