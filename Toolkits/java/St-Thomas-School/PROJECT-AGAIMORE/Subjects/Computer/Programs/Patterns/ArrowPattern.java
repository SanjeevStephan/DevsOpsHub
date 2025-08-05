package Subjects.Computer.Programs.Patterns;
import java.util.Scanner;

/**
 * Write a description of class f here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrowPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the arrow pattern: ");
        int size = scanner.nextInt();
        // Upper part of the arrow pattern
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // Lower part of the arrow pattern
        for (int i = size - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
