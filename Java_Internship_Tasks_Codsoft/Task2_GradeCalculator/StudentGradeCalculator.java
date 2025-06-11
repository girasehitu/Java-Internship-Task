import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("🎓 Student Grade Calculator");
        System.out.println("===================================");

        System.out.print("Enter the number of subjects: ");
        int subjectCount = sc.nextInt();

        if (subjectCount <= 0) {
            System.out.println("❌ Invalid number of subjects!");
            return;
        }

        int totalMarks = 0;

        for (int i = 1; i <= subjectCount; i++) {
            System.out.print("Enter marks for Subject " + i + " (out of 100): ");
            int marks = sc.nextInt();

            // Validate marks
            if (marks < 0 || marks > 100) {
                System.out.println("⚠️ Invalid marks entered. Please enter marks between 0 and 100.");
                i--; // repeat the same subject input
                continue;
            }

            totalMarks += marks;
        }

        double average = (double) totalMarks / subjectCount;

        System.out.println("\nTotal Marks: " + totalMarks + "/" + (subjectCount * 100));
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + calculateGrade(average));

        sc.close();
    }

    // Method to calculate grade based on average
    private static String calculateGrade(double avg) {
        if (avg >= 90) {
            return "A+";
        } else if (avg >= 80) {
            return "A";
        } else if (avg >= 70) {
            return "B";
        } else if (avg >= 60) {
            return "C";
        } else if (avg >= 50) {
            return "D";
        } else {
            return "F (Fail)";
        }
    }
}
