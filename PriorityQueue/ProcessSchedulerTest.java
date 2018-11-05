package processscheduler;

/**
 * @author Aashin Shazar
 * Assignment: Bonus Assignment #1
 * File name: ProcessSchedulerTest.java
 */
public class ProcessSchedulerTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Process newProcess = new Process();
        newProcess.GenerateProcesses();
        newProcess.ServerProcesses();
    }
    
}
