package Subjects.Computer.Programs.Patterns;


/**
 * Write a description of class PrintSPattern here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PrintSPattern {
    public static void main(String[] args) {
        int rows = 5;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (i == 0 || i == rows - 1 || (i == rows / 2 && j >= rows / 2) || (j == 0 && i < rows / 2)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
