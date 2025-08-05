package Subjects.Computer.Programs.Basic;
import java.util.Scanner;

/**
 * Write a description of class Calculator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Calculator
{
    // instance variables - replace the example below with your own
 
    /**
     * Constructor for objects of class Calculator
     */
    public Calculator()
    {
        // initialise instance variables
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the First Number: ");
        double num1 = scanner.nextDouble();
        System.out.println("Enter Operator (+, -, *, /):");
        char op = scanner.next().charAt(0);
        System.out.println("Enter the Second Number:");
        double num2 = scanner.nextDouble();
        double result = 0;
        switch(op) 
        {
            case '+' : 
                result = num1 + num2 ;
                break;
            case '-' : 
                result = num1 - num2;
                break;
            case '*' : 
                result = num1 * num2;
                break;
            case '/' : 
                result = num1 / num2;
                break;
        }
        System.out.println("Result : " + result);
        
    }


}
