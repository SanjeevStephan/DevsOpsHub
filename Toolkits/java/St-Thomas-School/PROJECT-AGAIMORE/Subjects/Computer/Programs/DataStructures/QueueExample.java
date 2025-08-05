package Subjects.Computer.Programs.DataStructures;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Write a description of class QueueExample here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class QueueExample
{

    /**
     * Constructor for objects of class QueueExample
     */
    public QueueExample()
    {
         Queue<String> queue = new LinkedList<>();
         queue.add("Apple");
         queue.add("Facebook");
         queue.add("Tesla");
         queue.add("Instagram");
         queue.add("Twitter");
         System.out.println("Total Items in Queue : " + queue);
         System.out.println("Removed Item : " + queue.poll());
         System.out.println("Queue Size : " + queue.size());
         System.out.println("Total Items in Queue : " + queue);    
    }

}
