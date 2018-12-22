/**
 * @author Aashin Shazar 
 * File name: BuildingServe.java
 */
package listelevator;

import java.util.Random;

public class BuildingServe {

    int numFloors;
    int numPassengers;
    static int passengerID = 0; //to increment our passenger ID
    int currentFloor;
    int destinationFloor;
    int passengerCount = 0;
    int floorNum;
    ArrayList<BuildingServe> floorList = new ArrayList<>(); //arrayList for each floor 
    ArrayList<ArrayList<BuildingServe>> allFloorLists = new ArrayList<>(); //arrayList containing all the floor arrayLists
    ArrayList<BuildingServe> elevatorList = new ArrayList<>(); //arrayList for the elevator containing passengers

    public BuildingServe() {

    }

    //to initializie the building with a custom floor count
    public BuildingServe(int numFloors) {
        this.numFloors = numFloors;
        Random rand = new Random();

        for (int x = 1; x <= numFloors; x++) {
            floorList = new ArrayList<>(); //initialize new arrayList for each new floor
            int randPassengerCount = rand.nextInt(6) - 1;

            for (int z = 0; z <= randPassengerCount; z++) {
                int destFloor = rand.nextInt(numFloors) + 1; //dependent on the number of floors available

                while (destFloor == x) {
                    destFloor = rand.nextInt(numFloors) + 1;
                }

                floorList.add(new BuildingServe(x, destFloor));
            }
            allFloorLists.add(floorList); //add our floor to a collection of arrayLists
        }

    }

    //to initialize passengers with their current and destination floors
    public BuildingServe(int currentFloor, int destinationFloor) {
        passengerID++;
        passengerCount = passengerID;
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
    }

    //getters and setters below
    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloors) {
        this.numFloors = numFloors;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public int getFloors() {
        return numFloors;
    }

    public void setFloors(int floors) {
        this.numFloors = floors;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public void printBuildingStats() {
        System.out.println("Building has " + getNumFloors() + " floors");
        System.out.println("=============================");

        for (int x = 1; x <= getNumFloors(); x++) {
            System.out.println("Floor " + x + " (" + allFloorLists.getEntry(x).getLength() + ")" + " passengers waiting:");
            for (int z = 1; z <= allFloorLists.getEntry(x).getLength(); z++) {
                if (allFloorLists.getEntry(x) != null) {
                    System.out.println(allFloorLists.getEntry(x).getEntry(z));
                }
            }

            System.out.println("=============================");
        }
    }

    //controls elevator up direction
    public void moveUp() {
        int passengersServed = 0;

        for (int x = 1; x <= getNumFloors(); x++) {

            for (int z = 1; z <= allFloorLists.getEntry(x).getLength(); z++) {
                elevatorList.add(allFloorLists.getEntry(x).getEntry(z));
            }

            for (int y = 1; y <= elevatorList.getLength(); y++) {
                while (elevatorList.getEntry(y).getDestinationFloor() == x) {
                    elevatorList.remove(y);
                    passengersServed++;
                    if ((elevatorList.getEntry(y) == null)) {
                        break;
                    }
                }
            }
            
            if (x == 1) {
                System.out.println("At floor " + x + ", elevator picked "
                        + allFloorLists.getEntry(x).getLength() + " passengers");
            } else {
                if (allFloorLists.getEntry(x).getLength() != 0 || passengersServed > 0) {
                    System.out.println("Stopped at floor " + x + ", elevator picked "
                            + allFloorLists.getEntry(x).getLength()
                            + " passengers," + " # of passengers now " + elevatorList.getLength());
                }
            }

            if (passengersServed > 0) {
                System.out.println("Elevator served " + passengersServed + " passengers, # of passengers now " + elevatorList.getLength());
                passengersServed = 0;
            }
            if (x != getNumFloors()) {
                System.out.println("Going up");
            } else {
                System.out.println("Going down");
            }

            System.out.println("=============================");

        }
    }

    //controls elevator down direction
    public void moveDown() {
        int passengersServed = 0;

        for (int x = getNumFloors() - 1; x >= 1; x--) {

            for (int y = 1; y <= elevatorList.getLength(); y++) {
                while (elevatorList.getEntry(y).getDestinationFloor() == x) {
                    elevatorList.remove(y);
                    passengersServed++;
                    if ((elevatorList.getEntry(y) == null)) {
                        break;
                    }
                }
            }

            if (passengersServed != 0) { //if no passengers need to get off at this floor, skip prompt
                System.out.println("Stopped at floor " + x);
            }
            if (passengersServed > 0) {
                System.out.println("Elevator served " + passengersServed + " passengers, # of passengers now " + elevatorList.getLength());
                passengersServed = 0;
                if (x != 1) {
                    System.out.println("Going down");
                }
                System.out.println("=============================");
            }

        }
    }

    //how the elevator operates, simple up and down direction
    public void startElevator() {
        System.out.println("");
        System.out.println("Elevator started");
        moveUp();
        moveDown();

    }

    @Override
    public String toString() {
        return "Passenger{passengerID=" + getPassengerCount() + ", floor" + getCurrentFloor() + ", destinationFloor=" + getDestinationFloor() + '}';
    }

}
