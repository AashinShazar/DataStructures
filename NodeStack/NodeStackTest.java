/*
    File Name: NodeStackTest.java
    Full Name: Aashin Shazar
 */
package nodestack;

import java.util.Scanner;

/**
 *
 * @author abeer
 */
public class NodeStackTest {

     static void printStack(NodeStack s) {
        NodeStack<Integer> backup = new NodeStack<>();
        System.out.println("Stack contents:");
        while (!s.isEmpty()) {
            int t = (Integer)s.pop();
            backup.push(t);
            System.out.print(t + " ");
        }
        System.out.println();
         
        while(!backup.isEmpty())
            s.push(backup.pop());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int choice = -1;
        NodeStack<Integer> stk = new NodeStack<>();
        do {
            System.out.println("[1] To push an item into the stack");
            System.out.println("[2] To pop an item from the stack");
            System.out.println("[3] To print the top of stack");
            System.out.println("[4] To check of stack is empty");
            System.out.println("[5] To print bag contents");
            System.out.println("[6] To check occurences of an item");
            System.out.println("[7] To Exit");
            System.out.println("Enter your choice:");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter an item");
                    int num = in.nextInt();
                    stk.push(num);
                    break;
                case 2:
                    if (!stk.isEmpty()) {
                        stk.pop();
                    }
                    break;
                case 3:
                    if (!stk.isEmpty()) {
                        System.out.println("Top of the stack is " + stk.peek());
                    } else {
                        System.out.println("Stack is empy ");
                    }
                    break;
                case 4:
                    if (stk.isEmpty()) {
                        System.out.println("Stack is empty");
                    } else {
                        System.out.println("Stack is not empty");
                    }
                    break;
                case 5:
                    printStack(stk);
                    break;
                case 6:
                    System.out.println("Enter an item to look for:");
                    num = in.nextInt();
                    System.out.println("This item is found " + stk.countOccurrence(num) + " times!");
                    break;
                case 7:
                    System.out.println("GoodBye!");
                    break;
                default:
                    System.out.println("Invalid choice! Enter a number in the range [1-8]");
                    break;
            }
        } while (choice != 7);
    }

}
