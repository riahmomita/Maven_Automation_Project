package ActionItem1;

public class RegionAreaCodes {
    public static void main(String[] args) {

        String[] region = new String[]{"Manhattan", "Brooklyn", "Queens", "Staten Island", "Bronx"};
        int[] areaCode = new int[]{10001, 11220, 11414, 10315, 10462};

        //initializing while loop
        int i = 0;
        while (i < region.length){
            System.out.println("My region is " + region[i] + " and my area code is " + areaCode[i]);
            i++;
        } //end of while loop

    } //end of main
} //end of class
