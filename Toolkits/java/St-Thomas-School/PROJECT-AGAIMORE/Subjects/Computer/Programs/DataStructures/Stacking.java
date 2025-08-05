package Subjects.Computer.Programs.DataStructures;

import java.util.Stack;
/**
 * Write a description of class Stacking here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Stacking
{

    /**
     * Constructor for objects of class Stacking
     */
    public Stacking()
    {
        Stack<String> stack = new Stack<>();
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Mango");
        stack.push("Graphes");
        System.out.println("Total Stack : " + stack);
        System.out.println("Total Stack Size : " + stack.size());
        System.out.println("Popped Item : " + stack.pop());
        System.out.println("Stack After Removing Last Item : "  + stack);
    }

  
}
