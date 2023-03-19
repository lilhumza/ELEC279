import java.util.ArrayList;
import java.util.Date;

public class Lab5 {
	
	public static ArrayList<Integer> numGen (ArrayList<Integer> intArray, int numCap) {
		int randNum;
		for (int i = 0; i < numCap; i++) {
			randNum = (int) (Math.random()*(99 - 0) + 0);
			intArray.add(randNum);	
		}
		return intArray;
	}
	
	public static ArrayList<Integer> numReverse (ArrayList<Integer> intArray) {
		ArrayList<Integer> revIntArray = new ArrayList<>();
		for (int num : intArray) {
			revIntArray.add(0, num);
		}
 		return revIntArray;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		ArrayList<Integer> intArray = new ArrayList<>(5);
		int numCap = 10;
		intArray = numGen(intArray, numCap);
		System.out.println(intArray);
		
		ArrayList<Integer> revIntArray = new ArrayList<>();
		revIntArray = numReverse(intArray);
		System.out.println(revIntArray);
		
		ArrayList<HourlyEmployee> allPersons = new ArrayList<>(100);
		Date theDate = new Date(3891-1900,10,1);
		HourlyEmployee Tom = new HourlyEmployee("Tom", theDate, 14.0 , 8.0);
		allPersons.add(Tom);
		
		theDate = new Date(3887-1900,4,18);
		HourlyEmployee Jessie = new HourlyEmployee("Jessie", theDate, 20.0 , 8.0);
		allPersons.add(Jessie);
		
		theDate = new Date(3890-1900,5,12);
		HourlyEmployee Michael = new HourlyEmployee("Michael", theDate, 27.0 , 10.0);
		allPersons.add(Michael);
		
		theDate = new Date(3885-1900,6,15);
		HourlyEmployee George = new HourlyEmployee("George", theDate, 35.0 , 8.0);
		allPersons.add(George);
		
		System.out.println(allPersons);
		System.out.println("Size: "+allPersons.size());
		
		allPersons.remove(2); //Third element is actually at index 2
		allPersons.trimToSize();
		
		System.out.println(allPersons); //Cut 3rd element
		
		

		Pair coupleOne = new Pair ("Julia", "Tom");
		Pair coupleTwo = new Pair ("Julia", "Tom");
		Pair coupleThree = new Pair ("Judy", "Tom");
		
		System.out.println("First Pair ==> "+coupleOne.toString());
		System.out.println("Second Pair ==> "+coupleTwo.toString());
		System.out.println("Third Pair ==> "+coupleThree.toString());
		System.out.println("First and Second Pair are equal? " +coupleOne.equals(coupleTwo));
		System.out.println("First and Third Pair are equal? " +coupleOne.equals(coupleThree));
		
		Triple travelOne = new Triple ("Toronto", 547.0, "Montreal");
		Triple travelTwo = new Triple ("Toronto", 547.0, "Montreal");
		Triple travelThree = new Triple ("Toronto", 264.5, "Kingston");
		
		System.out.println("First Triple ==> "+travelOne.toString());
		System.out.println("Second Triple ==> "+travelTwo.toString());
		System.out.println("Third Triple ==> "+travelThree.toString());
		System.out.println("First and Second Triple are equal? " +travelOne.equals(travelTwo));
		System.out.println("First and Third Pair are equal? " +travelOne.equals(travelThree));
		
	}

}
