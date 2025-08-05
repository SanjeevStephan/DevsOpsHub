package Subjects.Computer.Programs.Patterns;


/**
 * Write a description of class Number_Pattern here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Number_Pattern
{
    public Number_Pattern()
    {
        int rows = 5;
        for(int i = 0; i <= rows ; i++)
        {
            for(int j = 0; j <= i; j++)
            {
            System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}