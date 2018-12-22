
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author Aashin Shazar 
 * File name: MainPart1.java
 */

class ageSort implements Comparator<Users> { //custom sort by age

    @Override
    public int compare(Users a, Users b) {
        return b.age - a.age; //does a comparison
    }
}

public class MainPart1 {
    /*
     * Question 1:
     * - In this question you will use the Data.users array that includes
     * a list of users. Formatted as : firstname,lastname,age,email,gender,city,state
     * - Create a User class that should parse all the parameters for each user.
     * - Insert each of the users in a list.
     * - Print out the TOP 10 oldest users.
     * */

    public static void main(String[] args) {

        ArrayList<Users> userList = new ArrayList<>(); 

        for (String str : Data.users) {
            userList.add(new Users(str)); //add users to the userList ArrayList
        }

        Collections.sort(userList, new ageSort()); //sort by age

        System.out.println("Top 10 oldest users:");
        
        for (int i = 0; i < 10; i++) { //for loop to print out top 10 oldest users
            System.out.println(userList.get(i));
        }

    }
}
