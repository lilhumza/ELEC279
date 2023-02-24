
public class Student extends Person {
	
	private int courseNum = 0; //Private integer instance variable to keep track of the number of courses taken
	private static int courseMax = 20; //Private static integer instance variable to store the maximum number of courses a student can take
	private int courseGrade [] = new int [courseMax]; //Private integer array to store the grades
	private String courseCode [] = new String [courseMax]; //Private string array to store the course codes
	
	public Student(String name, String address, int idNum) { //Constructor
		super(name, address, idNum);
		
	}
	
	@Override 
    public String toString() { //Override toString with return of original superclass toString
        return "Student: " + super.toString();
    }
	
	public void addGrade(String courseCode, int courseGrade) { //Add to arrays
		this.courseNum += 1; //Add 1 to number of courses 
		
		if (checkNum(this.courseNum, courseMax)) {
			//Add to array at -1 index because count starts at 1 but array index starts at 0
			this.courseGrade[courseNum-1] = courseGrade; //Add courseGrade to array at corresponding index
			this.courseCode[courseNum-1] = courseCode; //Add courseNum to array at corresponding index
		} else {
			System.out.println("MAX NUMBER OF COURSES REACHED // ERROR ADDING OTHERS");
			this.courseNum = courseMax; //Manually define number of courses to maximum and no more
		}
		
	}
	
	public void printGrades() { //Loop to print all courses and grades
		for (int i = 0; i < this.courseNum; i++) {
			System.out.println(this.courseCode[i]+": "+this.courseGrade[i]);
		}
	}
	
	boolean checkNum(int counter, int compareTo) { //Check to see if number of courses is within boundaries
		if(counter <= compareTo) {
			return true;
		} else {
			return false;
		}
		
	}

	

}
