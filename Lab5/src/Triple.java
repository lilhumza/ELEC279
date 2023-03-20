
public class Triple <T, U, V> { //Declaration of Triple with 3 data types
	//3 data instances
	//This could have been completed with 2 data types T, U as the locations are the same data type instead of 3; T, U, V
	private T firstItem;
	private U secondItem;
	private V thirdItem;
	
	public Triple (T firstItem, U secondItem, V thirdItem) { //Setting the information of Triple
		this.firstItem = firstItem;
		this.secondItem = secondItem;
		this.thirdItem = thirdItem;
		
	}
	
	@Override
	public boolean equals(Object otherTriple) { //Compare two different instances of Triple to see if equal
		@SuppressWarnings("unchecked")
		Triple<T, U, V> triple = ((Triple<T, U, V>) otherTriple); //Declaration of Triple list with Object of other Triple
	
		if (triple.firstItem.equals(this.firstItem) && triple.secondItem.equals(this.secondItem) && triple.thirdItem.equals(this.thirdItem)) { //If Equal
			return true;
		} else {
			return false;
		}
	}
	
	public String toString () { //toString Output for final formatted output of Triple Data
		return "Departure City: " +firstItem +"; Distance: "+secondItem+"; Arrival City: "+thirdItem;
	}

}
