package Day3_043022;

public class Multiple_Conditional_Statements {

    public static void main(String[] args) {

        int a = 1;
        int b = 2;
        int c = 3;

        //if a+b is less c, than print the result
        //if a+b is greater than c, then print the result
        //finally print a+b is equal to c
        if(a+b < c){
            System.out.println("a & b is less than c");
        }else if(a+b > c){
            System.out.println("a & b is greater than c");
        }else{
            System.out.println("a & b is equal to c");
        } //end of conditions

        //declare additional variables
        int d = 4;
        int e = 5;
        int f = 6;
        //or operator with if statements
        // || is used for an or operator (only one of the conditions need to be true)
        // && is used for an and operator (both conditions must be true)

        if(d < e || f < e){
            System.out.println("d is less than e or f is less than e");
        }else{
            System.out.println("condition is not true");
        }

        if(d < e && f < e){
            System.out.println("di is less than e and f is less than e");
        }else{
            System.out.println("condition is not true");
        }

    } //end of main
} //end of class
