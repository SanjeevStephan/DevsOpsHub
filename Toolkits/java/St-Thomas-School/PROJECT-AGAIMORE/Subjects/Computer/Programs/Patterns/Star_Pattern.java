package Subjects.Computer.Programs.Patterns;


/**
 * Write a description of class Star_Pattern here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Star_Pattern
{
    public Star_Pattern()
    {
        int rows = 10;
        for(int i = 0; i < rows; i++) {
            //System.out.print("i : " + i);
            for( int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
