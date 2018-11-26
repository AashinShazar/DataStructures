/**
 * Modifed by: Aashin Shazar
 * File name: DoubleLinkedQueueTest.java
 */
package linkednodesqueue;

import java.util.Scanner;

/**
 *
 * @author abeer
 */
public class DoubleLinkedQueueTest {

     static void printQueue(DoubleLinkedQueue q) {
        DoubleLinkedQueue<Integer> backup;
         backup = new DoubleLinkedQueue<>();
        System.out.println("Queue contents:");
        while (!q.isEmpty()) {
            int t=(Integer)q.getFront();
            backup.enqueue((Integer)q.dequeue());
            System.out.print(t + " ");
        }
        System.out.println();
       
       while(!backup.isEmpty()){
            q.enqueue(backup.dequeue()) ;}
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    DoubleLinkedQueue<Integer> q = new DoubleLinkedQueue<>();
       // q.
        int choice = -1;

        do {
            System.out.println("[1] To add an item into the queue");
            System.out.println("[2] To remove an item from the queue");
            System.out.println("[3] To print the front of queue");
            System.out.println("[4] To check of queue is empty");
            System.out.println("[5] To print queue contents");
            System.out.println("[6] To Exit");
            System.out.println("Enter your choice:");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter an item");
                    int num = in.nextInt();
                    q.enqueue(num);
                    break;
                case 2:
                    if (!q.isEmpty()) {
                        q.dequeue();
                    }
                    break;
                case 3:
                    if(!q.isEmpty())
                    System.out.println("Front of the queue is " + q.getFront());
                    else
                        System.out.println("Queue is empty ");
                    break;
                case 4:
                   if(q.isEmpty()) {
                        System.out.println("Queue is empty");
                    } else {
                        System.out.println("Queue is not empty");
                    }
                    break;
                case 5:
                    printQueue(q);
                    break;
                case 6:
                    System.out.println("GoodBye!");
                    break;
                default:
                    System.out.println("Invalid choice! Enter a number in the range [1-6]");
                    break;
            }
        } while (choice != 6);
    }
    
}
