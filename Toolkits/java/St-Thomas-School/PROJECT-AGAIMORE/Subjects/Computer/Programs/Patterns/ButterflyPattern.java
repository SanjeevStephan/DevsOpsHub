package Subjects.Computer.Programs.Patterns;


/**
 * Write a description of class fdf here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ButterflyPattern {
    public static void main(String[] args) {
        int n = 5;
        // Upper part of the butterfly
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 0; j < 2 * (n - i - 1); j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // Lower part of the butterfly
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 0; j < 2 * (n - i - 1); j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

