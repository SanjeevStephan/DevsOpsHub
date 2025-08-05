package Subjects.Computer.Programs.Basic;


/**
 * Write a description of class PowerOfNumber here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class PowerOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter base:");
        int base = scanner.nextInt();
        System.out.println("Enter exponent:");
        int exponent = scanner.nextInt();
        long result = 1;
        while (exponent != 0) {
            result *= base;
            exponent--;
        }
        System.out.println("Result: " + result);
    }
}
