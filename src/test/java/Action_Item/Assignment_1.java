package Action_Item;

public class Assignment_1 {
    public static void main(String[] args) {
        int grade = 90;

        if(grade >= 90 && grade <= 100){
            System.out.println("Grade is A");
        }else if(grade >= 80 && grade <= 89){
            System.out.println("Grade is B");
        }else if(grade >= 70 && grade <= 79){
            System.out.println("Grade is C");
        }else if(grade >= 60 && grade <= 69){
            System.out.println("Grade is D");
        }else if(grade >= 0 && grade <= 59) {
            System.out.println("Grade is F");
        }//End of if else statement

    }//end of main method
}//end of java class
