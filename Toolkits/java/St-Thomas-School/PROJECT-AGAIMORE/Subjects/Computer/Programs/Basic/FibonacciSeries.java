package Subjects.Computer.Programs.Basic;


/**
 * Write a description of class FibonacciSeries here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 10;
        int num1 = 0, num2 = 1;
        System.out.print("Fibonacci Series up to " + n + ": ");
        for (int i = 1; i <= n; i++) {
            System.out.print(num1 + " ");
            int sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
    }
}
