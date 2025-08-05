package Subjects.Computer.Programs;


/**
 * Write a description of class ProgramMenuList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProgramMenuList
{
    public String[] basic_program_list = 
    {
        "Hello World Program: Basic Java program to print 'Hello, World!'.",
        "Add Two Numbers: Program to add two numbers.",
        "Check Even/Odd Number: Program to check if a number is even or odd.",
        "Convert Celsius to Fahrenheit: Program to convert temperature from Celsius to Fahrenheit.",
        "Guessing Game: Simple game where the user has to guess a number.",
        "Rock, Paper, Scissors: Game to play Rock, Paper, Scissors.",
        "Reverse a Number: Program to reverse a given number",
        "Find Maximum of Three Numbers: Program to find the maximum of three numbers.",
        "Check Leap Year: Program to check if a year is a leap year.",
        "Calculate Area and Perimeter of Rectangle: Program to calculate the area and perimeter of a rectangle."
    };
    public String[] control_flow_programs = 
    {
        "If-Else Statement: Program using if-else to check conditions.",
        "Switch Statement: Program using switch to handle different cases.",
        "For Loop: Program using for loop to iterate over an array.",
        "While Loop: Program using while loop to iterate until a condition is met.",
        "Do-While Loop: Program using do-while loop to ensure at least one iteration.",
        "Nested Loops: Program using nested loops to print patterns.",
        "Break and Continue Statements: Program demonstrating break and continue statements."
    };
    public String[] array_lists_programs = 
    {
        "Find Maximum in an Array: Program to find the maximum element in an array.",
        "Sort an Array: Program to sort an array in ascending order.",
        "Search for an Element in an Array: Program to search for an element in an array.",
        "ArrayList Operations: Program demonstrating basic operations on ArrayList.",
        "Array to ArrayList Conversion: Program to convert an array to an ArrayList.",
        "Find Duplicate Elements in an Array: Program to find duplicate elements in an array."
        
    };
    public String[] strings_programs = 
    {
        "String Concatenation: Program to concatenate two strings.",
        "String Comparison: Program to compare two strings.",
        "String to Char Array: Program to convert a string to a char array.",
        "Char to String: Program to convert a char to a string.",
        "Palindrome Check: Program to check if a string is a palindrome.",
        "Remove White Spaces: Program to remove white spaces from a string.",
        "Find Substring: Program to find a substring within a string."
    };
    public String[] oop_based_programs = 
    {
        "Class and Object Basics: Program demonstrating basic class and object concepts.",
        "Constructors: Program using constructors to initialize objects.",
        "Inheritance: Program demonstrating inheritance between classes.",
        "Polymorphism: Program demonstrating method overriding and overloading.",
        "Encapsulation: Program demonstrating encapsulation using access modifiers.",
        "Abstraction: Program demonstrating abstraction using abstract classes.",
        "Interface: Program using interfaces to define contracts."
        
    };
    public String[] file_handling_programs = 
    {   
        "Read from a File: Program to read content from a file.",
        "Write to a File: Program to write content to a file.",
        "Append to a File: Program to append content to a file."
    };
    public String[] user_defined_programs = 
    {
        "Simple Method: Program defining and calling a simple method.",
        "Method with Parameters: Program defining and calling a method with parameters.",
        "Method Returning a Value: Program defining and calling a method that returns a value.",
        "Recursive Method: Program demonstrating recursion using a method."
        
    };
    public String[] library_classes_programs =
    {
        "Math Library: Program using mathematical library methods.",
        "String Library: Program using string library methods.",
        "Array Library: Program using array library methods."
    };
    public String[] database_programs = 
    {
        "Connect to SQLite Database: Program to connect to a SQLite database.",
        "Insert Data into Database: Program to insert data into a database table.",
        "Retrieve Data from Database: Program to retrieve data from a database table.",
        "Update Data in Database: Program to update data in a database table.",
        "Delete Data from Database: Program to delete data from a database table."
    };
    
    public void DisplayProgramList(String title,String[] list)
    {
        System.out.println("=======================||    " + title + "   ||============================");
        for(int i=0; i < list.length ; i++)
        {   int num = i + 1;
            System.out.print("[" + num + "] ");
            System.out.println(list[i]);
        }
    }

    
    public ProgramMenuList()
    {
        
        DisplayProgramList("Basic Programs", array_lists_programs);

    }
}
