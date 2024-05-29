package Day4_04152024;

import java.util.HashMap;

public class T1_HashMap {
    public static void main(String[] args) {
        //create hashmap consisting of name and age of Triage Solutions
        HashMap<String, Integer> triageStudents = new HashMap<>();

        //add values for triage student hashmap
        triageStudents.put("Oyon", 25);
        triageStudents.put("Shakeb", 29);
        triageStudents.put("Tanvir", 27);
        triageStudents.put("Angie", 21);
//      triageStudents.put("Noyon", 23);

        //print out the size of the hashmap
        System.out.println("The size of the hashmap is " + triageStudents.size());

        //print out the content of the hashmap
        System.out.println(triageStudents);

        //print out Oyons age
        int oyonsAge = triageStudents.get("Oyon");
        System.out.println("Oyons age is " + oyonsAge);

        //another way of printing oyons age
        System.out.println("Oyons age is " + triageStudents.get("Oyon"));

        //you can change the value of the variable oyonsAge
        oyonsAge = oyonsAge+2;
        System.out.println("Oyons age is " + oyonsAge);
        System.out.println(triageStudents);

        //lets print out noyons age
        System.out.println("Noyons age is " + triageStudents.get("Noyon"));

        //print out Noyons age if it exist in the data set
        if(triageStudents.containsKey("Noyon")){
            System.out.println("Noyons age is " + triageStudents.get("Noyon"));
        }else{
            System.out.println("Noyon does not exist in the data set");
        }//end of if else


    }//end of main
}//end of class
