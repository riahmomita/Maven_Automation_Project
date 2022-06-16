package ActionItem2;

public class Assignment2_Cities {
    public static void main(String[] args) {

        //list of cities
        String[] cities = new String[] {"Brooklyn", "Queens", "Manhattan", "Staten Island"};

        //for loop to print only if the city is Brooklyn or Manhattan
        for(int i = 0; i < cities.length; i++) {
            if(cities[i] == "Brooklyn" || cities[i] == "Manhattan"){
                System.out.println("The city is " + cities[i]);
            } //end of if statement
        } //end of for loop

    } //end of main
} //end of class
