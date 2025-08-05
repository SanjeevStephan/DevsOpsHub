package Subjects.Computer.Programs.Patterns;


/**
 * Write a description of class HollowPyramidPattern here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HollowPyramidPattern {
    public static void main(String[] args) {
        int rows = 5;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                if (i == rows - 1 || j == 0 || j == i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}

