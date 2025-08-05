package Subjects.Computer.Programs.Maths;


/**
 * Write a description of class SimpleInterest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter principal amount:");
        double principal = scanner.nextDouble();
        System.out.println("Enter rate of interest:");
        double rate = scanner.nextDouble();
        System.out.println("Enter time period:");
        double time = scanner.nextDouble();
        double interest = (principal * rate * time) / 100;
        System.out.println("Simple Interest: " + interest);
    }
}
