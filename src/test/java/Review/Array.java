package Review;

public class Array {
    public static void main(String[]args){
        //declare String linear array for countries
        String[] countries = new String[]{"USA", "Canada", "Mexico"};

        //declare integer linear array for country zipcode
        int[] zipcodes = new int[]{11530, 10009, 11217};

        //print out country with zipcode
        System.out.println("The zipcode for " + countries[1] + " is " + zipcodes[1]);

    }//end of main
}//end of class
