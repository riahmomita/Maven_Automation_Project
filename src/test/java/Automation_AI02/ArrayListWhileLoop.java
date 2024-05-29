package Automation_AI02;

import java.util.ArrayList;

public class ArrayListWhileLoop {
    public static void main(String[]args){
        //arraylist for countries
        ArrayList<String> countries = new ArrayList<>();

        //initialize i
        int i = 0;

        //declaring values for countries
        countries.add("USA");
        countries.add("India");
        countries.add("Bangladesh");
        countries.add("UK");
        countries.add("Egypt");

        //while loop to iterate through all the countries
        while(i<countries.size()){
            //if condition to print only when country is Bangladesh or USA
            if(countries.get(i).equals("Bangladesh") || countries.get(i).equals("USA")){
                System.out.println("Country is " + countries.get(i));
            }//end of if condition
            i++;
        }//end of while loop

    }//end of main
}//end of class