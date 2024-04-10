package studentdriver;

public class StudentFees {

    //declaring the variables
    private String studentName;
    private int studentID;
    private boolean isEnrolled;
    private int CREDITS_PER_COURSE = 3;
    private double PER_CREDIT_FEE = 543.50;

    //setting the variables
    public StudentFees(String studentName, int studentID, boolean isEnrolled) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.isEnrolled = isEnrolled;
    }

    //Getter and Setter Methods
    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the studentID
     */
    public int getStudentID() {
        return studentID;
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
    public void setIsEnrolled(boolean isEnrolled) {
        this.isEnrolled = isEnrolled;
    }

    /**
     * @return the CREDITS_PER_COURSE
     */
    public int getCREDITS_PER_COURSE() {
        return CREDITS_PER_COURSE;
    }

    /**
     * @param CREDITS_PER_COURSE the CREDITS_PER_COURSE to set
     */
    public void setCREDITS_PER_COURSE(int CREDITS_PER_COURSE) {
        this.CREDITS_PER_COURSE = CREDITS_PER_COURSE;
    }

    /**
     * @return the PER_CREDIT_FEE
     */
    public double getPER_CREDIT_FEE() {
        return PER_CREDIT_FEE;
    }

    /**
     * @param PER_CREDIT_FEE the PER_CREDIT_FEE to set
     */
    public void setPER_CREDIT_FEE(double PER_CREDIT_FEE) {
        this.PER_CREDIT_FEE = PER_CREDIT_FEE;
    }

    //Calculates the payable amount for a student
    public double getPayableAmount() {
        if (isEnrolled) {
            return CREDITS_PER_COURSE * PER_CREDIT_FEE;
        } else {
            return 0;
        }
    }

    public String toString() {
        return "Student Name: " + studentName + "\n Student ID: " + studentID + "\n Enrolled: " + isEnrolled + "\n Payable amount: $" + getPayableAmount();
    }
}
