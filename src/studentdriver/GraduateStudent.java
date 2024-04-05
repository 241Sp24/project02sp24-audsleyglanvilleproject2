package studentdriver;

import java.util.*;

public class GraduateStudent {

    private int coursesEnrolled;
    private boolean isGraduateAssistant;
    private String graduateAssistantType;
    private final double ADDITIONAL_FEES = 654.45;

    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant,
            String graduateAssistantType, int coursesEnrolled) {
        this.coursesEnrolled = coursesEnrolled;
        this.isGraduateAssistant = isGraduateAssistant;
        this.graduateAssistantType = graduateAssistantType;
    }

    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant,
            int coursesEnrolled) {
        this.coursesEnrolled = coursesEnrolled;
        this.isGraduateAssistant = isGraduateAssistant;
    }

    public boolean isIsGraduateAssistant() {
        return isGraduateAssistant;
    }

    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    @Override
    public double getPayableAmount() {
        double totalFee = coursesEnrolled * CREDITS_PER_COURSE * PER_CREDIT_FEE + ADDITIONAL_FEES;

        if (isGraduateAssistant) {
            if (graduateAssistantType.equals("full")) {
                totalFee = 0;
            } else if (graduateAssistantType.equals("half")) {
                totalFee /= 2;
            }
        }

        return totalFee;
    }

    @Override
    public String toString() {
        return "GraduateStudent{"
                + "coursesEnrolled=" + coursesEnrolled
                + ", isGraduateAssistant=" + isGraduateAssistant
                + ", graduateAssistantType='" + graduateAssistantType + "}";
    }
}
