package mikecoleman.collections;


import java.util.Collections;
import java.util.TreeMap;

/**
 * Created by Mike on 10/12/2015.
 * This will map the user with the # of steps they have and display them in descending order for a friendly competition.
 * TreeMap works like a HashMap but will sort the keys in ascending order naturally
 */
public class StepsTreeMap {
    public static void main(String[] args) {

        // Creates the TreeMap but uses Collections.reverseOrder() to sort in descending order for purposes of the challenge
        TreeMap<Integer, String> challenge = new TreeMap<Integer, String>(Collections.reverseOrder());
        challenge.put(4000, "Mike");
        challenge.put(6000, "Lisa");
        challenge.put(2000, "Sara");
        challenge.put(3000, "Denise");
        challenge.put(10000, "Diane");

        // *****************The following are some HAPPY paths*********************

        // Prints the mappings in descending (reverse order) for purposes of the challenge
        System.out.println(challenge);

        // Prints the number of mappings found, in this case the number of people in the challenge
        System.out.println(challenge.size());

        // Finds the highest and lowest mappings(winner and loser in step counts)
        System.out.println(challenge.firstEntry());
        System.out.println(challenge.lastEntry());

        // Check if a value is in the map--in this case if a person is in the challenge
        if(challenge.containsValue("Denise")){
            System.out.println("Denise is entered in the challenge");
        }
        else {
            System.out.println("Denise is not participating in this challenge");
        }



        // *****************The following are some NASTY paths*********************

        // Creates new empty TreeMap, attempts to get lowest key, throws NoSuchElementException
        TreeMap<String, Integer> aTree = new TreeMap<>();

        try {
            aTree.firstKey();
        } catch(Exception e){
            System.out.println("There is no key ound in the TreeMap");
        }


        }
    }

