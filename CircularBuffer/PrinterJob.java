/**
 * @author Aashin Shazar
 * File name: PrinterJob.java
 */
package linkednodesqueue;



/**
 *
 * @author abeer
 */
public class PrinterJob {
    
    static int jobID = 0;
    int counter = 0;
    String jobText;
    
    public PrinterJob(String jobText) {
        this.jobText = jobText;
        jobID++;
        counter = jobID;
    }
    
    public PrinterJob() {

    }

    public static int getJobID() {
        return jobID;
    }

    public static void setJobID(int jobID) {
        PrinterJob.jobID = jobID;
    }

    public String getJobText() {
        return jobText;
    }

    public void setJobText(String jobText) {
        this.jobText = jobText;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    
    @Override
    public String toString() {
        return "PrinterJob{" + "jobID=" + getCounter() + ",  text=" + jobText + '}';
    }
    
    
    

}
