package Subjects.Computer.Programs.Patterns;


/**
 * Write a description of class RightTrianglePattern here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RightTrianglePattern {
    public static void main(String[] args) {
        int rows = 5;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}