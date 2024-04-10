package studentdriver;

public class GraduateStudent extends StudentFees {

    //Declaring variables
    private int coursesEnrolled;
    private boolean isGraduateAssistant;
    private String graduateAssistantType;
    private final double ADDITIONAL_FEES = 654.45;

    //Methods
    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant,
            String graduateAssistantType, int coursesEnrolled) {
        super(studentName, studentID, isEnrolled);
        this.coursesEnrolled = coursesEnrolled;
        this.isGraduateAssistant = isGraduateAssistant;
        this.graduateAssistantType = graduateAssistantType;
    }

    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant,
            int coursesEnrolled) {
        super(studentName, studentID, isEnrolled);
        this.coursesEnrolled = coursesEnrolled;
        this.isGraduateAssistant = isGraduateAssistant;
    }

    public boolean isIsGraduateAssistant() {
        return isGraduateAssistant;
    }

    public String getGraduateAssistantType() {
        return graduateAssistantType;
    }

    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    @Override
    //Calculating payable amount
    public double getPayableAmount() {
        double totalFee = coursesEnrolled * getCREDITS_PER_COURSE() * getPER_CREDIT_FEE();

        if (!isGraduateAssistant) {
            totalFee += ADDITIONAL_FEES;
        } else {
            if (graduateAssistantType != null && graduateAssistantType.equals("full")) {
                totalFee = ADDITIONAL_FEES;
            } else if (graduateAssistantType != null && graduateAssistantType.equals("half")) {
                totalFee = 3100.20;
            }
        }

        return totalFee;
    }

    @Override
    //toString
    public String toString() {
        return "GraduateStudent{"
                + "coursesEnrolled=" + coursesEnrolled
                + ", isGraduateAssistant=" + isGraduateAssistant
                + ", graduateAssistantType='" + graduateAssistantType + '\''
                + ", payableAmount=" + getPayableAmount()
                + '}';
    }
}
