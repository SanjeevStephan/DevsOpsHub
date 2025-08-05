package Subjects.Computer.Programs.Patterns;


/**
 * Write a description of class PyramidPattern here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PyramidPattern {
    public static void main(String[] args) {
        int rows = 5;
        for (int i = 0; i < rows; i++) {
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

