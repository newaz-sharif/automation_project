package day2_09052020;

public class Dynamic_Array {
    public static void main(String[] args) {
        //dynamic array with String data example
        String[] zipCode = new String[5]; // defining and setting boundaries for array values
        zipCode[0] = "11218";
        zipCode[1] = "11219";
        zipCode[2] = "10001";
        zipCode[3] = "11201";
        zipCode[4] = "11217";

        System.out.println("My last zipcode is " + zipCode[0]);

        //dynamic array with int data example
        int[] checkAmount = new int[5];
        checkAmount[0] = 1000;
        checkAmount[1] = 2000;
        checkAmount[2] = 3000;
        checkAmount[3] = 4000;
        checkAmount[4] = 5000;

        System.out.println("My last checkAmount is " + checkAmount[0]);


    }//end of psvm


}//end of Java Class
