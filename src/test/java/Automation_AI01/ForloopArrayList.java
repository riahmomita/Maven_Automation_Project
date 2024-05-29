package Automation_AI01;

import java.util.ArrayList;

public class ForloopArrayList {
    public static void main(String[]args){
        //arraylist for string region and integer area code
        ArrayList<String> region = new ArrayList<>();
        ArrayList<Integer> areaCode = new ArrayList<>();

        //declare values for region
        region.add("New York City");
        region.add("Boston");
        region.add("Portland");
        region.add("Phoenix");

        //declare values for areaCode
        areaCode.add(10001);
        areaCode.add(22109);
        areaCode.add(73545);
        areaCode.add(92254);

        //for loop to iterate through region and areaCode and print to console
        for(int i=0; i<region.size(); i++){
            System.out.println("My region is " + region.get(i) + " and my area code is " + areaCode.get(i));
        }//end of for loop
    }//end of main
}//end of class
