package Day3_09062020;

public class multiple_conditions {
    public static void main(String[] args) {
        //using multiple conditional statements
        int a = 1;
        int b = 2;
        int c = 3;

        if(a+b < c){
            System.out.println("sum of a and b is less than c");
        }else if(a+b > c){
            System.out.println("Sum of a and b is greater than c");
        }else{
            System.out.println("Sum of a and b is equal to c");
        }//end of conditional statements
    }
}
