package studentdriver;

public class OnlineStudent {

    //Declaring Variables
    public static double MONTHLY_FEE = 1245.25;
    private String StudentName;
    private int ID;
    private boolean IsEnrolled;
    private int NumOfMonths;

    //Setting them
    public OnlineStudent(String studentName, int ID, boolean isEnrolled, int NumOfMonths) {
        this.StudentName = StudentName;
        this.ID = ID;
        this.IsEnrolled = IsEnrolled;
        this.NumOfMonths = NumOfMonths;
    }

    //calculating the payable amount
    public double GetPayableAmount() {
        return MONTHLY_FEE * NumOfMonths;
    }

    //ToString to print
    public String toString() {
        return "Student Name: " + StudentName + "Student ID: " + ID + "Enrolled: " + IsEnrolled
                + "No of Months" + NumOfMonths + "Payable amount" + GetPayableAmount();
    }
}
