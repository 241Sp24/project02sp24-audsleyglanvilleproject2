package studentdriver;

public class UGStudent extends StudentFees {

    //Declaring the vartiables
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

    //Setting the variables to themselves
    public UGStudent(String studentName, int studentID, boolean isEnrolled, boolean hasScholarship,
            double scholarshipAmount, int coursesEnrolled, double additionalFee) {
        super(studentName, studentID, isEnrolled);
        this.hasScholarship = hasScholarship;
        this.scholarshipAmount = scholarshipAmount;
        this.coursesEnrolled = coursesEnrolled;
        this.isEnrolled = isEnrolled;
    }

    /**
     * @param hasScholarship the hasScholarship to set
     */
    public void setHasScholarship(boolean hasScholarship) {
        this.hasScholarship = hasScholarship;
    }

    /**
     * @return the hasScholarship
     */
    public boolean HasScholarship() {
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

    @Override
    public double getPayableAmount() {
        if (!isEnrolled) {
            return 0;
        }
        int totalCredits = coursesEnrolled * getCREDITS_PER_COURSE();
        double tuitionFee = totalCredits * getPER_CREDIT_FEE();
        double totalFee = tuitionFee + ADDITIONAL_FEE;
        if (HasScholarship()) {
            totalFee -= getScholarshipAmount();
        }
        return totalFee;
    }

    /**
     * @return the studentName
     */
//    public String getStudentName() {
//        return studentName;
//    }
    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @param scholarshipAmount the scholarshipAmount to set
     */
    public void setScholarshipAmount(double scholarshipAmount) {
        this.scholarshipAmount = scholarshipAmount;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the isEnrolled
     */
    public boolean isEnrolled() {
        return isEnrolled;
    }

    /**
     * @param isEnrolled the isEnrolled to set
     */
    public void setisEnrolled(boolean isEnrolled) {
        this.isEnrolled = isEnrolled;
    }

    boolean hasScholarship() {
        return hasScholarship;
    }

    public String toString() {
        return String.format("Student Name: " + getStudentName() + "\nStudent ID: " + getStudentID() + "\nEnrolled: " + isEnrolled()
                + "\nScholarship: " + HasScholarship() + "\nScholaship Amount: " + getScholarshipAmount()
                + "\nCourses Enrolled: " + coursesEnrolled + "\nPayable Amount: " + +getPayableAmount());
    }
}
