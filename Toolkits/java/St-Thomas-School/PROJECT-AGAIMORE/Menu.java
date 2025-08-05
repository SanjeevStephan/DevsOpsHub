import java.util.Scanner;


/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Menu
{
    
     public String[] menu_list = {
                    "Show Teacher's Info",
                    "Show Student's Info"
     };
    
    
    
     public Menu()
     {
         Scanner scan = new Scanner(System.in);
         
         System.out.println("Enter Any Number");
         int num = scan.nextInt();
         System.out.println("You Have Entered : " + num);
         
         
         for(int i=0; i < menu_list.length; i++ )
         {
             System.out.println(menu_list[i]);
         }
     }
}
