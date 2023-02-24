
public class Stock extends Activity {
	private String name;
	private int[] values = new int[7];
	
	public Stock() {
		super();
		
		this.name = "";
		defaultValues();
	}
	
	public Stock(int dayIn, int monthIn, int yearIn, String nameIn, int[] valIn){
		super(dayIn, monthIn, yearIn);
		
		this.name = nameIn;
		if(this.values.length == valIn.length) {
			this.values = valIn.clone();
			
			for(int i = 0; i < values.length; i++) {
				if (values[i] < 0) {
					System.out.println("Error");
					defaultValues();
					break;
				}
			}
		}
		else {
			System.out.println("Error");
			defaultValues();
		}
	}
	
	private void defaultValues() {
		for (int i = 0; i < values.length; i++) {
			values[i] = 0;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getValue(int ind) {
		if(ind < this.values.length) {
			return this.values[ind];
		}
		else {
			System.out.println("Error");
			return -1;
		}
	}
	
	public void setName(String nameIn) {
		this.name = nameIn;
	}
	
	public void setValue(int val, int ind) {
		if(ind < this.values.length && val >= 0) {
			this.values[ind] = val;
		}
		else {
			System.out.println("Error");
		}
	}
	
	public void printStock() {
		String valToString = "";
		for (int val : values) {
			valToString += val + ", ";
		}
		System.out.println(name + ": " + super.getDay() + "." + super.getMonth() + "." + super.getYear() + " values:\n" + valToString);
	}
	
	public int getMean() {
		int mean = 0;
		for (int i : values) {
			mean += i;
		}
		return mean / values.length;
	}
	
}
