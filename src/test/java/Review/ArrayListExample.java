package Review;
//Example of arrayList and for loops

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[]args){
        //declare arraylist string for countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Canada");
        countries.add("Greece");
        countries.add("India");

        //print out canada
        System.out.println("The country is " + countries.get(1));

        //print out the countries using a for loop
        for(int i=0; i<countries.size(); i++){
            System.out.println("The country is " + countries.get(i));
        }//end of loop

    }//end of main
}//end of class
