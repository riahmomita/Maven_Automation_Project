package Day2_04022024;

import java.util.ArrayList;

public class T2_ArrayList {
    public static void main(String[] args) {

        //declare an arraylist variable
        ArrayList<String> countries = new ArrayList<>();

        //add some values to the countries arraylist
        countries.add("USA");
        countries.add("INDIA");
        countries.add("PAKISTAN");
        countries.add("BANGLADESH");

        //print out USA
        System.out.println("The first country is " + countries.get(0));

        //print out the total size of countries
        System.out.println("The total size of countries arraylist is " + countries.size());

        //arraylist is resizable
        countries.add("CANADA");
        //print out the new size
        System.out.println("The total size of countries arraylist is " + countries.size());

    }//end of main
}//end of class
