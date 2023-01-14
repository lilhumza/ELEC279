import java.util.Scanner;
public class TaskInputOutput {

	public int num1, num2, prod, sum; //Declare variables for class
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in); //Create Scanner instance
		TaskInputOutput arithmObj = new TaskInputOutput(); //Create class instance
		
		System.out.println("Please enter an Integer: "); //Prompt user for an int
		arithmObj.num1 = input.nextInt(); //Assign value of int to var
		
		System.out.println("Please enter an Integer: "); //Prompt user for an int
		arithmObj.num2 = input.nextInt(); //Assign value of int to var
		
		input.close(); //Close the scanner
		
		arithmObj.prod = arithmObj.num1 * arithmObj.num2; //Calculate and assign value of product of ints
		arithmObj.sum = arithmObj.num1 + arithmObj.num2; //Calculate and assign value of sum of ints
		
		System.out.println("\nThe Sum is: "+arithmObj.sum +"\nThe Product is: "+arithmObj.prod); //Print sum and product of ints
	}

}
