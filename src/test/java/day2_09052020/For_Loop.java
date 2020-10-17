package day2_09052020;

public class For_Loop {
    public static void main(String[] args) {
        //dynamic array with String data example
        String[] zipCode = new String[5]; // defining and setting boundaries for array values
        zipCode[0] = "11218";
        zipCode[1] = "11219";
        zipCode[2] = "10001";
        zipCode[3] = "11201";
        zipCode[4] = "11217";

        //iterate through all of the zipcode data and print each one
        for(int i=0;i <=4; i++){
            // code goes here
            System.out.println("My zipcode is " + zipCode[i]);

            //(third part) i = i+2 for greater increments than one
            //(second part) i < zipCode.length to automatically set gate keeper


        }//end of for loop

    }//end of psvm

}//end of java class
