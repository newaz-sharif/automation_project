package Action_Item;

public class Assignment_2 {
    public static void main(String[] args) {
        String[] borough = new String[5];
        borough[0] = "Brooklyn";
        borough[1] = "Bronx";
        borough[2] = "Manhattan";
        borough[3] = "Queens";
        borough[4] = "Staten Island";

        for (int i = 0; i < borough.length; i++){
            if(borough[i] == "Brooklyn"){
                System.out.println("My Borough is Brooklyn");
            }
            if(borough[i] == "Manhattan") {
                System.out.println("My Borough is Manhattan");
            }
        }//end of for loop to check borough

    }//end of main method
}//End of java class
