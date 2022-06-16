package Day3_043022;

import ReusableLibraries.ReusableMethods;

public class TestingMethods {
    public static void main(String[] args) {

        //call the addTwoNumbers method and execute it
        ReusableMethods.addTwoNumbers(20,30);
        ReusableMethods.addTwoNumbers(50,50);

        //call the return method and store it in a variable to perform something else
        int finalResult = ReusableMethods.subtractTwoNumbers(20,10);
        System.out.println("New result is " + (finalResult+10));

    } //end of main

} //end of class
