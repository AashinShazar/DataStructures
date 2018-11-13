/**
 * @author Aashin Shazar
 * File name: PrinterTest.java
 */
package linkednodesqueue;

import java.util.Scanner;

/**
 *
 * @author abeer
 */
public class PrinterTest {
    
     static void printQueue(CircularBuffer q) {
        CircularBuffer<PrinterJob> backup;
         backup = new CircularBuffer<>();
        System.out.println("Queue contents:");
        while (!q.isEmpty()) {
            PrinterJob t=(PrinterJob)q.getFront();
            backup.enqueue((PrinterJob)q.dequeue());
            System.out.println(t + " ");
        }
        System.out.println();
       
       while(!backup.isEmpty()){
            q.enqueue(backup.dequeue()) ;}
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CircularBuffer<PrinterJob> q = new CircularBuffer<>();

        int choice = -1;

        do {
            System.out.println("[1] To add a new printer job");
            System.out.println("[2] To print next job");
            System.out.println("[3] To view current buffer content");
            System.out.println("[4] To clear buffer");
            System.out.println("[5] To Exit");
            System.out.println("Enter your choice:");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter job text:");
                    String num = in.next();
                    if (!q.isFull())
                    {
                       q.enqueue(new PrinterJob(num)); 
                    }
                    else
                    {
                       System.out.println("Printer buffer is full now, try later."); 
                    }
                    break;
                case 2:
                    if (!q.isEmpty())
                    {
                      System.out.println("Printing:" + q.dequeue().getJobText());  
                    }
                    else 
                    {
                       System.out.println("Printer buffer is empty now, try later.");  
                    }
                    break;
                case 3:
                    printQueue(q);
                    break;
                case 4:
                    if (!q.isEmpty()) {
                        while (!q.isEmpty())
                        {
                          q.dequeue();  
                        }
                        System.out.println("Buffer is clear!");
                    }
                    break;
                case 5:
                    System.out.println("GoodBye!");
                    break;
                default:
                    System.out.println("Invalid choice! Enter a number in the range [1-6]");
                    break;
            }
        } while (choice != 5);
    }
    
}
