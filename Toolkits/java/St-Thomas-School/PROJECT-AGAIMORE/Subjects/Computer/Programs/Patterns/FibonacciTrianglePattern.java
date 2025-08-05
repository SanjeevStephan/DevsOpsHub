package Subjects.Computer.Programs.Patterns;


/**
 * Write a description of class FibonacciTrianglePattern here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FibonacciTrianglePattern {
    public static void main(String[] args) {
        int n = 9;
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(a + " ");
                int sum = a + b;
                a = b;
                b = sum;
            }
            System.out.println();
        }
    }
}