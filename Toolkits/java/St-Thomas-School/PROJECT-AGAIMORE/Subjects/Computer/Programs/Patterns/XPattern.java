package Subjects.Computer.Programs.Patterns;


/**
 * Write a description of class XPattern here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class XPattern {
    public static void main(String[] args) {
        int size = 5;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j || i + j == size - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
