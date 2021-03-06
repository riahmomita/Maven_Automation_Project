package Day3_043022;

import java.util.ArrayList;

public class loop_with_conditions {

    public static void main(String[] args) {

        //create an array with fruits and print only when fruit is apple or orange
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Grape");
        fruits.add("Strawberry");

        for(int i = 0; i < fruits.size(); i++){
            //with if condition
            if(fruits.get(i) == "Apple"){
                System.out.println("My fruit is " + fruits.get(i));
            }else if(fruits.get(i) == "Grape"){
                System.out.println("My fruit is " + fruits.get(i));
            }

 //           //with or operator
//            if(fruits.get(i) == "Apple" || fruits.get(i) == "Grape"){
//                System.out.println("My fruit is " + fruits.get(i));
//            }
//
//            //or operator ignoring case sensitive spelling. you will not be using it
//            if(fruits.get(i).equalsIgnoreCase("apple") || fruits.get(i) == "Grape"){
//                System.out.println("My fruit is " + fruits.get(i));
//            }
//
        } //end of loop

    } //end of main
} //end of class
