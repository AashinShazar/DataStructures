import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

/**
 *
 * @author Aashin Shazar
 * Assignment: Assignment 8
 * File name: MainPart3.java
 */

class stateSort implements Comparator<Users> { //custom sorting method for states

    @Override
    public int compare(Users a, Users b) {
        return b.state.compareTo(a.state);
    }
}

public class MainPart3 {
    /*
     * Question 3:
     * - In this question you will use the Data.users and Data.otherUsers array that includes
     * a list of users. Formatted as : firstname,lastname,age,email,gender,city,state
     * - Create a User class that should parse all the parameters for each user.
     * - The goal is to print out the users that are exist in both the Data.users and Data.otherUsers.
     * Two users are equal if all their attributes are equal.
     * - Print out the list of users which exist in both Data.users and Data.otherUsers.
     * */

    public static void main(String[] args) {

        //hashsets for each of the data collections
        HashSet<Users> mainUsers = new HashSet<>();
        HashSet<Users> otherUsers = new HashSet<>();

        for (String str : Data.users) {
            mainUsers.add(new Users(str)); //users go to mainUsers hashset
        }

        for (String str : Data.otherUsers) {
            otherUsers.add(new Users(str)); //otherUsers go to otherUsers hashset
        }

        HashSet<Users> commonUsers = new HashSet<>(mainUsers); //holds mainUsers
        
        commonUsers.retainAll(otherUsers); //retains only common users

        ArrayList<Users> convertedList = new ArrayList<>(commonUsers); //convert to arrayList for easy ordering

        Collections.sort(convertedList, new stateSort()); //order by state
        
        convertedList.stream().forEach((aUser) -> { //fancy forEach loop
            System.out.println(aUser);
        });

    }
}
