/**
 * @author Aashin Shazar
 * File name: ListElevatorTest.java
 */

package listelevator;

public class ListElevatorTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BuildingServe newBuilding = new BuildingServe(5);
        newBuilding.printBuildingStats();
        newBuilding.startElevator();

    }

}
