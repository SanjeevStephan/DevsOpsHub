package Subjects.Computer.Programs.Patterns;


/**
 * Write a description of class DiamondPattern here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DiamondPattern {
    public static void main(String[] args) {
        int rows = 5;
        // Upper half
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // Lower half
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

