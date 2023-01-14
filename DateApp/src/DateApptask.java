import java.util.Date;
public class DateApptask {
	
	public static void main(String[] args) {
		
		Date todaysDate = new Date(); //Create date instance
		System.out.println(todaysDate); //Print out date through instance
		
		System.out.println(); //Blank Line for Formatting - can also be inserted as /n on start or end of print
		
		int min = 10, max = 20, avg = 5; //Declare and initialize variables
		String myRole = "Driver"; //Declare and initialize string var
		byte myFirstByte = 22; //Declare and initialize a byte var
		double pi = 3.14519; //Declare and initialize a double var
		char myChar = 'N'; //Declare and initialize a char var
		
		
		//Series of print statements for the variables
		System.out.println("I am now the "+myRole);
		System.out.println("Our minimum Score is " +min);
		System.out.println("Our maximum Score is " +max);
		System.out.println("Our average Score is " +avg);
		System.out.println("We have a byte " +myFirstByte);
		System.out.println("And double type is " +pi);
		System.out.println("A char looks like "+myChar);
		
		System.out.println(); //Blank Line for Formatting - can also be inserted as /n on start or end of print
		
		
		//While loop to print Date 10 times
		int count = 0; //Counter variable
		while (count < 10) {
			System.out.println(todaysDate);
			count++; //Increment counter
		}
		
		System.out.println(); //Blank Line for Formatting - can also be inserted as /n on start or end of print
		
		//For loop to print Date 25 times
		for (int i = 0; i < 25; i++) {
			System.out.println(todaysDate);
		}
		
		System.out.println(); //Blank Line for Formatting - can also be inserted as /n on start or end of print
		
		//Nested for loops to print a 5x10 table of 
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 10; col ++) {
				System.out.print(row*col +"\t"); //Print each row
			}
			System.out.println(); //New Row
		}
		
	}

}
