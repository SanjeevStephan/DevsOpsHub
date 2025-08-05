package Subjects.Computer.Programs.DataStructures;


/**
 * Write a description of class ArrayOperations here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayOperations
{
    /**
     * Constructor for objects of class ArrayOperations
     */
    public ArrayOperations()
    {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(" Array Elements : ");
        for (int i : numbers) { System.out.print( i + " " ); }
        System.out.println("\n Array Length : " + numbers.length );
    }


}
