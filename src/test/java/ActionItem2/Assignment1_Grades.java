package ActionItem2;

public class Assignment1_Grades {
    public static void main(String[] args) {
        //grade assigned
        int grade = 87;

        // condition to print alphabetical grade according to the numeric grade assigned
        if(grade >= 90 && grade <= 100) {
            System.out.println("Grade is A");
        }else if(grade >= 80 && grade < 90){
            System.out.println("Grade is B");
        }else if(grade >= 70 && grade < 80){
            System.out.println("Grade is C");
        }else if(grade >= 60 && grade < 70){
            System.out.println("Grade is D");
        }else{
            System.out.println("Grade is F");
        }

    } // end of main
} //end of class
