package day2_09052020;

public class While_loop {
    public static void main(String[] args) {
        //dynamic array with String data example
        String[] zipCode = new String[5]; // defining and setting boundaries for array values
        zipCode[0] = "11218";
        zipCode[1] = "11219";
        zipCode[2] = "10001";
        zipCode[3] = "11201";
        zipCode[4] = "11217";

        //First initialize the starting point before while loop
        int i = 0;
        //define the while loop with your end point execution
        while(i < zipCode.length){

            System.out.println("My zipcode is " + zipCode[i]);

            //increment goes here, same as i++
            i = i + 1;
        }

    }

}
