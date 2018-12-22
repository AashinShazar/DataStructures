
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author Aashin Shazar 
 * Assignment: Assignment 8 
 * File name: MainPart2.java
 */
public class MainPart2 {

    /*
     * Question 2:
     * - In this question you will use the Data.users array that includes
     * a list of users. Formatted as : firstname,lastname,age,email,gender,city,state
     * - Create a User class that should parse all the parameters for each user.
     * - The goal is to count the number of users living each state.
     * - Print out the list of State, Count order in ascending order by count.
     * */
    public static void main(String[] args) {

        HashMap<String, ArrayList<Users>> hmapUsers = new HashMap<>(); //HashMap of type String (key), ArrayList type Users (value)

        for (String str : Data.users) {
            ArrayList<Users> userFieldList = new ArrayList<>();
            String[] userField = str.split(",");

            if (!hmapUsers.containsKey(userField[6])) { //check if key exists
                userFieldList.add(new Users(str)); //add new user to userFieldList ArrayList
                hmapUsers.put(userField[6], userFieldList); //place that ArrayList into the hashmap
            } else {
                userFieldList = hmapUsers.get(userField[6]); //retrieve that arrayList
                userFieldList.add(new Users(str)); //add to it
                hmapUsers.put(userField[6], userFieldList); //place it back into the hashmap
            }

        }

        //create an ArrayList for the hashmap of users from above
        ArrayList<HashMap.Entry<String, ArrayList<Users>>> userList
                = new ArrayList<HashMap.Entry<String, ArrayList<Users>>>(hmapUsers.entrySet());

        //referenced from https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
        Collections.sort(userList, new Comparator<HashMap.Entry<String, ArrayList<Users>>>() { //do a custom sort for the population size
            public int compare(HashMap.Entry<String, ArrayList<Users>> o1,
                    HashMap.Entry<String, ArrayList<Users>> o2) {
                return (o1.getValue().size() - o2.getValue().size());
            }
        });

        //for loop to retrive sorted values from userList
        for (HashMap.Entry<String, ArrayList<Users>> hmapEntry : userList) {
            System.out.println(hmapEntry.getKey()
                    + ": " + hmapEntry.getValue().size() + " users");
        }

    }

}
