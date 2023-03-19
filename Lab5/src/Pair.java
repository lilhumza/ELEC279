
public class Pair <T> {
	private T firstItem;
	private T secondItem;
	
	public Pair (T firstItem, T secondItem) {
		this.firstItem = firstItem;
		this.secondItem = secondItem;
	}
	@Override
	public boolean equals(Object otherPair) {
		@SuppressWarnings("unchecked")
		Pair<T> pair = ((Pair<T>) otherPair);
		
		if (pair.firstItem.equals(this.firstItem) && pair.secondItem.equals(this.secondItem)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString () {
		return "Wife's Name: " +firstItem +"; Husband's Name: "+secondItem;
	}
	
}
