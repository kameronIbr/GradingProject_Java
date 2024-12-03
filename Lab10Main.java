// Lab10Main.java
// Kameron Ibraheem
// Lab 10: Lab10Main
//
//
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Lab10Main {
    public static void main(String[] args) {
        // Initialize required objects
        File inputFile = new File("Exam.txt");
        Scanner fileIn = null;
        PrintWriter fileOut = null;
        Scanner input = new Scanner(System.in);
        int totalQuestions = 0;
        int correctAnswers = 0;

        // Prompt the student for their name
        System.out.print("Enter your first and last name: ");
        String studentName = input.nextLine();

        try {
            // Initialize Scanner to read from the exam file
            fileIn = new Scanner(inputFile);
            
            // Initialize PrintWriter to write to GradeReport.txt
            fileOut = new PrintWriter("GradeReport.txt");

            // Write the student's name to the grade report
            fileOut.println("Grade Report for " + studentName);

            // Loop through each question in the exam file
            while (fileIn.hasNextLine()) {
                totalQuestions++;
                String question = fileIn.nextLine();
                String choice1 = fileIn.nextLine();
                String choice2 = fileIn.nextLine();
                String choice3 = fileIn.nextLine();
                String correctAnswer = fileIn.nextLine();

                // Display the question and choices to the student
                System.out.println("\n" + question);
                System.out.println("1. " + choice1);
                System.out.println("2. " + choice2);
                System.out.println("3. " + choice3);

                // Get the student's answer
                System.out.print("Your answer (1/2/3): ");
                String userAnswer = input.nextLine();

                // Check if the answer is correct and update the grade report
                if (userAnswer.equals(correctAnswer)) {
                    correctAnswers++;
                    fileOut.println("Question " + totalQuestions + ": Correct");
                } else {
                    fileOut.println("Question " + totalQuestions + ": Incorrect");
                }
            }

            // Write the student's score to the grade report
            fileOut.println("Score: " + correctAnswers + "/" + totalQuestions);

        } catch (FileNotFoundException e) {
            System.out.println("Cannot find the file.");
        } finally {
            // Close the file resources
            if (fileIn != null) {
                fileIn.close();
            }
            if (fileOut != null) {
                fileOut.close();
            }
        }

        // Display the student's results in the console
        System.out.println("\nQuiz complete!");
        System.out.println("You answered " + correctAnswers + " out of " + totalQuestions + " questions correctly.");
    }
}
