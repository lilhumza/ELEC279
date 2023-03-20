import java.util.ArrayList;
import java.util.Date;

public class Lab5 {
	//Generate numCap number of randomized elements in an arraylist
	public static ArrayList<Integer> numGen (ArrayList<Integer> intArray, int numCap) { 
		int randNum; //Placeholder variable - not necessary
		for (int i = 0; i < numCap; i++) { //Loop through for numCap number of times
			randNum = (int) (Math.random()*(99 - 0) + 0); //0-99 range of random number generator
			intArray.add(randNum);	//Add to arraylist
		}
		return intArray; //Return the arraylist with randomized items
	}
	
	//Reverse the order of elements in an arraylist
	public static ArrayList<Integer> numReverse (ArrayList<Integer> intArray) {
		ArrayList<Integer> revIntArray = new ArrayList<>(); //Create new arraylist instance to hold reversed elements
		for (int num : intArray) { //For Each Loop
			revIntArray.add(0, num); //Add elements at 0 index as the are looped through
		}
 		return revIntArray; //Return the arraylist with reversed items
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		ArrayList<Integer> intArray = new ArrayList<>(5); //Create int arraylist with capacity of 5
		int numCap = 10; //Define integer for number of elements being added into the arraylist
		intArray = numGen(intArray, numCap); //Call to generate 10 randomized items in the arraylist
		System.out.println("Randomimzed 10 elements in ArrayList:");
		System.out.println(intArray);
		
	
		ArrayList<Integer> revIntArray = new ArrayList<>(); //Create int arraylist to hold reversed order of elements from original arraylist
		revIntArray = numReverse(intArray); //Call to reverse the order of the previously randomized arraylist
		System.out.println("\nReversed elements in ArrayList:");
		System.out.println(revIntArray);
		
		
		ArrayList<HourlyEmployee> allPersons = new ArrayList<>(100); //Create arraylist of type HourlyEmployee with 100 capacity
		
		Date theDate = new Date(3891-1900,10,1); //Create a date instance for a person
		HourlyEmployee Tom = new HourlyEmployee("Tom", theDate, 14.0 , 8.0); //Call to create an hourly employee
		allPersons.add(Tom); //Add to arraylist
		
		theDate = new Date(3887-1900,4,18); //Redefine date instance
		HourlyEmployee Jessie = new HourlyEmployee("Jessie", theDate, 20.0 , 8.0); //Call to create an hourly employee
		allPersons.add(Jessie); //Add to arraylist
		
		theDate = new Date(3890-1900,5,12); //Redefine date instance
		HourlyEmployee Michael = new HourlyEmployee("Michael", theDate, 27.0 , 10.0); //Call to create an hourly employee
		allPersons.add(Michael); //Add to arraylist
		
		theDate = new Date(3885-1900,6,15); //Redefine date instance
		HourlyEmployee George = new HourlyEmployee("George", theDate, 35.0 , 8.0); //Call to create an hourly employee
		allPersons.add(George); //Add to arraylist
		
		System.out.println("\nEmployee Information:");
		System.out.println(allPersons);
		System.out.println("Size: "+allPersons.size());
		
		allPersons.remove(2); //Third element is actually at index 2 - remove the element
		allPersons.trimToSize(); //Set capcity to size of arraylist
		
		System.out.println("\nThird Element Removed:");
		System.out.println(allPersons);
		
		
		//Creating new Pair instances
		Pair coupleOne = new Pair ("Julia", "Tom");
		Pair coupleTwo = new Pair ("Julia", "Tom");
		Pair coupleThree = new Pair ("Judy", "Tom");
		
		System.out.println("\nFirst Pair ==> "+coupleOne.toString());
		System.out.println("Second Pair ==> "+coupleTwo.toString());
		System.out.println("Third Pair ==> "+coupleThree.toString());
		System.out.println("First and Second Pair are equal? " +coupleOne.equals(coupleTwo));
		System.out.println("First and Third Pair are equal? " +coupleOne.equals(coupleThree));
		
		//Creating new Triple instances
		Triple travelOne = new Triple ("Toronto", 547.0, "Montreal");
		Triple travelTwo = new Triple ("Toronto", 547.0, "Montreal");
		Triple travelThree = new Triple ("Toronto", 264.5, "Kingston");
		
		System.out.println("\nFirst Triple ==> "+travelOne.toString());
		System.out.println("Second Triple ==> "+travelTwo.toString());
		System.out.println("Third Triple ==> "+travelThree.toString());
		System.out.println("First and Second Triple are equal? " +travelOne.equals(travelTwo));
		System.out.println("First and Third Pair are equal? " +travelOne.equals(travelThree));
		
	}

}
