package Subjects.Computer.Programs.Patterns;


/**
 * Write a description of class ZigZagPattern here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ZigZagPattern {
    public static void main(String[] args) {
        int rows = 5;
        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("* ");
                }
            } else {
                for (int j = 0; j <= i; j++) {
                    System.out.print("  ");
                }
                for (int j = 0; j <= i; j++) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
