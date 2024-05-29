package Day2_04022024;

public class T1_LinearArray {
    public static void main(String[] args) {

        //declare a string array variable
        String[] studentNames;
        //store some values in the string array
        studentNames = new String[]{"Abdul", "Ahmad", "Anderson", "Wahid"};

        //print out index 0 from studentNames array
        System.out.println("The value of index 0 is " + studentNames[0]);

        //print out Anderson from studentNames array
        System.out.println("The student name at index 2 is " + studentNames[2]);

        //print out Wahid from studentNames array
        System.out.println("The student name at index 3 is " + studentNames[3]);



        //declare and store student grades
        int[] studentGrades = new int[]{90, 93, 94, 99};
        //print out grade 95 from the array
        System.out.println("Student grade is " + studentGrades[1]);

        //the total size of the linear array
        System.out.println("The total number of grades are " + studentGrades.length);

    }//end of main
}//end of class
