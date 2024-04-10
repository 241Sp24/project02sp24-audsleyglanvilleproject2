package studentdriver;

public class OnlineStudent extends StudentFees {

    //Declaring Variables
    public static double MONTHLY_FEE = 1245.25;
    private String StudentName;
    private int ID;
    private boolean IsEnrolled;
    private int NumOfMonths;

    //Setting them
    public OnlineStudent(String studentName, int ID, boolean isEnrolled, int NumOfMonths) {
        super(studentName, ID, isEnrolled);
        this.NumOfMonths = NumOfMonths;
    }

    public int getNumOfMonths() {
        return NumOfMonths;
    }

    //calculating the payable amount
    @Override
    public double getPayableAmount() {
        return MONTHLY_FEE * NumOfMonths;
    }

    //ToString to print
    public String toString() {
        return "Student Name: " + StudentName + "Student ID: " + ID + "Enrolled: " + IsEnrolled
                + "No of Months" + NumOfMonths + "Payable amount" + getPayableAmount();
    }
}
