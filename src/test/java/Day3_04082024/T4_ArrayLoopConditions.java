package Day3_04082024;

public class T4_ArrayLoopConditions {
    public static void main(String[]args){
        String[] fruits = new String[]{"Apple", "Orange", "Strawberry", "Mango"};

        for(int i=0; i<fruits.length; i++){
            if(fruits[i].equals("Apple")){
                System.out.println("Fruit is " + fruits[i]);
            }else if(fruits[i].equals("Grape")){
                System.out.println("Fruit is " + fruits[i]);
            }//end of if else
        }//end of for loop

    }//end of main
}//end of class
