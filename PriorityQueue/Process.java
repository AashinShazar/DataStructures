package processscheduler;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random; 

/**
 * @author Aashin Shazar
 * Assignment: Bonus Assignment #1
 * File name: Process.java
 */

public class Process implements Comparable<Process> {
    
    int ID; //our ID number
    int priorityNum; //our Priority Number
    private static final int PROCESS_CAPACITY = 10; //our set capacity of 10 processes
    Queue<Process> integerPriorityQueue = new PriorityQueue<>(PROCESS_CAPACITY, Collections.reverseOrder()); //our integerPriorityQueue built to capacity and order reversed
    
    //new process creation that takes in a key paired value of priority and ID
    public Process(int ID, int priorityNum) {
        this.ID = ID;
        this.priorityNum = priorityNum;
    }

    //for our test class
    public Process() {

    }
    
    //function that generates processes and randomly assigns priority
    public void GenerateProcesses()
    {
        Random rand = new Random(); //leverages random class
        
        for (int x = 1; x<= PROCESS_CAPACITY; x++) 
        {
            int randomPriorityNum = rand.nextInt(100); //random priority up to 100
            System.out.println("Currently adding process ID: " + x + " with priority " + randomPriorityNum);
            integerPriorityQueue.add(new Process(randomPriorityNum, x)); //stores in priorityQueue as key pair value
        }
    }
   
    //function that serves processes based on the highest priority
    public void ServerProcesses()
    {
        for(int i=1; i<=PROCESS_CAPACITY; i++){
            Process serverdProcess = integerPriorityQueue.remove(); //removes from priorityQueue
            System.out.println("Currently processing process ID: " + serverdProcess.getPriority() + " with priority " + serverdProcess.getID());
            } 
    }

    //getters and setters 
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPriority() {
        return priorityNum;
    }

    public void setPriority(int Priority) {
        this.priorityNum = Priority;
    }

    //overriden compareTo
    @Override
    public int compareTo(Process o) {
        return this.getID() - o.getID();
       }
    
    
        
}
