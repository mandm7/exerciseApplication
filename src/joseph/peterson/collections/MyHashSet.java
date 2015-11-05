package joseph.peterson.collections;

import java.util.HashSet;

/**
 * Created by Joseph on 10/19/2015.
 */
//difference of arrayList and hashset is that in a hashset, there can be no duplicate elements, prints in any random order. linked runs it in ;order you put it in
public class MyHashSet {
    public static void main(String[] args) {
        MyHashSet run = new MyHashSet();
        run.program();

    }
    public void program() {
        ///////////////////////////////////////////HAPPY PATHS////////////////////////////////////////////////////////
        HashSet<String> cards = new HashSet<>();
        cards.add("King of spades");
        cards.add("King of hearts");
        cards.add("King of diamonds ");
        cards.add("King of clubs");
        System.out.println(cards);
        System.out.println(cards.size());
        if (cards.contains("King of spades")){
            System.out.println(cards);
        }
//happy path remove
        cards.remove("King of hearts");
        if (cards.contains("King of spades")){
            System.out.println("it does contain the king of spades.");
        }
        System.out.println("now we have " + cards);
        ///////////////////////////////////Here are some nasty paths.////////////////////////////////////////////////
        /* Throws IllegalArgumentException when trying to set initial capacity below zero */
        try {
            HashSet<String> aSet = new HashSet<>(-2);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("You cannot start a collection with a negative value");
        }
        //adding a value that already exists
        cards.add("King of clubs");
        System.out.println(cards);
        //adding null
        cards.add(null);
        System.out.println(cards);
        //removing null
        cards.remove(null);
        System.out.println(cards);
        //look for some value that doesnt exist.
        if (cards.contains("jibber")){
            System.out.println("it contains jibber");
        }else {
            System.out.println("jibber dont exist yo.");
        }

    }
}