package ActionItem1;
import java.util.ArrayList;

public class CountryCodes {
    public static void main(String[] args) {

        ArrayList<String> country = new ArrayList<>();
        ArrayList<Integer> countryCode = new ArrayList<>();

        //list of countries
        country.add("United States");
        country.add("France");
        country.add("Japan");
        country.add("Switzerland");

        //country codes
        countryCode.add(11247);
        countryCode.add(46335);
        countryCode.add(79444);
        countryCode.add(00434);

        for(int i = 0; i < country.size(); i++) {
            System.out.println("My country is " + country.get(i) + " and my country code is " + countryCode.get(i));
        } //end of for loop

    } //end of main
} //end of class
