package ActionItem1;

import java.util.ArrayList;

public class ArrayData {
    public static void main(String[] args) {

        String[] colors = new String[]{"red", "blue", "white", "purple", "green"};
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        for(int i = 0; i < colors.length; i++) {
            System.out.println("The color " + colors[i] + " is option number " + numbers.get(i));
        } //end of for loop

    } //end of main
} //end of class
