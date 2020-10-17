package Day4_09122020;

public class Split_Command {
    public static void main(String[] args) {
        //declare and define a string variable
        String message = "My name is john";
        //print out only the word john from the string message using split command

        String[] result = message.split(" ");//must include space in quotations to find words

        //now print the index for john
        System.out.println("My result is " + result[3]);

    }//end of main method
}//end of java class
