public class Activity {
	private int day;
	private int month;
	private int year;
	
	public Activity() {
		this.day = 1;
		this.month = 1;
		this.year = 1;
	}
	
	public Activity(int day, int month, int year) {
		this.day = 1;
		this.month = 1;
		this.year = 1;
		
		setDate(day, month, year);
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setDate(int day, int month, int year) {
		
		if(month > 0 && month < 13) {
			this.month = month;
		}
		else {
			System.out.println("Error");
			//this.month = 1;
		}
		if(checkDay(day)) {
		this.day = day;
		}
		else {
			System.out.println("Error");
			//this.day = 1;
		}
		if(year > 0) {
		this.year = year;
		}
		else {
			System.out.println("Error");
		}
	}
	
	public void printDate() {
		System.out.println(day + "." + month + "." + year);
	}
	
	private boolean checkDay(int day) {
		int[] dayLimit = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		return day <= dayLimit[this.month - 1] && day > 0;
	}
	
}
