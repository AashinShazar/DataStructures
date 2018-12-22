/*
    File Name: HashMapIntro.java
    Full Name: Aashin Shazar
 */
package HashMapIntro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 *
 * @author abeer
 */
public class HashMapIntro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HashMap<String, ArrayList<String>> hmap = new HashMap<>();

        String csvFile = "./src/inclass09/Countries-Continents.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                ArrayList<String> aList = new ArrayList<>();

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                System.out.println(country[0]+" => "+country[1]);
                
                if (!hmap.containsKey(country[0]))
                {
                    aList.add(country[1]);
                    hmap.put(country[0], aList);                   
                }
                
                else
                {
                    aList = hmap.get(country[0]);
                    aList.add(country[1]);
                    hmap.put(country[0], aList);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    /* Display content using Iterator*/
      Set set = hmap.entrySet();
      Iterator iterator = set.iterator();

      String largestCountry = "";
      int currentSize = 0;
      int largestSize = 0;
      
      while(iterator.hasNext()) {
         
         
         Map.Entry mentry = (Map.Entry)iterator.next();
         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
         System.out.println(mentry.getValue());         
         System.out.println("Total # of countries: " + ((ArrayList<String>)mentry.getValue()).size());   
         currentSize = ((ArrayList<String>)mentry.getValue()).size();
         


         if (currentSize > largestSize)
         {
             largestCountry =  (String) mentry.getKey();
             largestSize = ((ArrayList<String>)mentry.getValue()).size();
         }
         
      }
      
      System.out.println("Largest country is: " + largestCountry + " with " + largestSize + " countries");
      
      
        
    }
    
}
