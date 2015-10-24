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
        /*Happy paths*/
        HashSet<String> cards = new HashSet<>();
        cards.add("King of spades");
        cards.add("King of hearts");
        cards.add("King of diamonds ");
        cards.add("King of clubs");
        System.out.println(cards);

        /*Here are some nasty paths.*/
        /* Throws IllegalArgumentException when trying to set initial capacity below zero */
        try {
            HashSet<String> aSet = new HashSet<>(-2);
        } catch (Exception e) {
            System.out.println("You cannot start a collection with a negative value");
        }
        //I just wat to see what happens.
    }
}