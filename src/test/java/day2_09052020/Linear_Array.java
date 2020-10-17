package day2_09052020;

public class Linear_Array {
    public static void main(String[] args) {
        //Linear string array example
        String[] username = new String[] {"John", "Kenneth", "Millad", "Naim"};
        String[] lastname = new String[] {"Doe", "Johnson", "Smith", "Brown"};

        //print second value of string array
        System.out.println("second username is " + username[1] + " Last name is " + lastname[1]);

        //Linear int array example
        int[] numbers = new int[]{1,100,300,500};
        System.out.println("first int value is " + numbers[1]);

        //I want to get the sum of two ints
        System.out.println("Sum of the two ints is " + (numbers[0] + numbers[1]));



    }

}
