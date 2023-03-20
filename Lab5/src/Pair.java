
public class Pair <T> { //Declaration of Triple with 2 data types
	private T firstItem;
	private T secondItem;
	
	public Pair (T firstItem, T secondItem) { //Setting the information of Pair
		this.firstItem = firstItem;
		this.secondItem = secondItem;
	}
	
	@Override
	public boolean equals(Object otherPair) { //Compare two different instances of Pair to see if equal
		@SuppressWarnings("unchecked")
		Pair<T> pair = ((Pair<T>) otherPair); //Declaration of Pair list with Object of other Pair
		
		if (pair.firstItem.equals(this.firstItem) && pair.secondItem.equals(this.secondItem)) { //If equal
			return true;
		} else {
			return false;
		}
	}
	
	public String toString () { //toString Output for final formatted output of Triple Data
		return "Wife's Name: " +firstItem +"; Husband's Name: "+secondItem;
	}
	
}
