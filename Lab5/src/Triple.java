
public class Triple <T, U, V> {
	private T firstItem;
	private U secondItem;
	private V thirdItem;
	
	public Triple (T firstItem, U secondItem, V thirdItem) {
		this.firstItem = firstItem;
		this.secondItem = secondItem;
		this.thirdItem = thirdItem;
		
	}
	
	@Override
	public boolean equals(Object otherTriple) {
		@SuppressWarnings("unchecked")
		Triple<T, U, V> triple = ((Triple<T, U, V>) otherTriple);
	
		if (triple.firstItem.equals(this.firstItem) && triple.secondItem.equals(this.secondItem) && triple.thirdItem.equals(this.thirdItem)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString () {
		return "Departure City: " +firstItem +"; Distance: "+secondItem+"; Arrival City: "+thirdItem;
	}

}
