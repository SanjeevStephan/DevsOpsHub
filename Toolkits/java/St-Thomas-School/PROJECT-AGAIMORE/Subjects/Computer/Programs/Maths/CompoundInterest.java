package Subjects.Computer.Programs.Maths;


/**
 * Write a description of class CompoundInterest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class CompoundInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter principal amount:");
        double principal = scanner.nextDouble();
        System.out.println("Enter rate of interest:");
        double rate = scanner.nextDouble();
        System.out.println("Enter time period:");
        double time = scanner.nextDouble();
        double amount = principal * Math.pow(1 + rate / 100, time);
        double interest = amount - principal;
        System.out.println("Compound Interest: " + interest);
    }
}
