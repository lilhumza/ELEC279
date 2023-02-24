
public class GradStudent extends Student {

	private int numComitMembs = 0; //Private integer for the number of committee member
	private int numExams = 0; //Private integer to track the number of exams taken
	private static int maxAttempts = 6; //Private static integer for the maximum number of attempts 
	private String examGrade [] = new String [maxAttempts]; //Private string array that contains the results of these graduate exam
	private String examName [] = new String [maxAttempts]; //Private string array that contains the graduate exams’ names
	
	public GradStudent(String name, String address, int idNum) { //Constructor
		super(name, address, idNum);
		
	}
	
	public void setComitteeNum(int numComitMembs) { //Set number of committee members
		this.numComitMembs = numComitMembs;
	}
	
	
    public int getComitteeNum() { //Get number of committee members
        return numComitMembs;
        
    }
	
	public void addGrade(String examName, String examGrade) {
		this.numExams += 1; //Add 1 to number of exam attempts 
		
		if (checkNum(this.numExams, maxAttempts)) {
			//Add to array at -1 index because count starts at 1 but array index starts at 0
			this.examGrade[numExams-1] = examGrade; //Add examGrade to array at corresponding index
			this.examName[numExams-1] = examName; //Add examName to array at corresponding index
		} else {
			System.out.println("MAX NUMBER OF COURSES OR EXAMS REACHED // ERROR ADDING OTHERS");
			this.numExams = maxAttempts; //Manually define number of courses to maximum and no more
		}
	}
	
	@Override 
    public String toString() { //Override toString with return of original superclass toString
        return "Grad " + super.toString();
    }
	
	public void printExamGrades() {
		for (int i = 0; i < this.numExams; i++) {
			System.out.println(this.examName[i]+": "+this.examGrade[i]);
		}
	}
	

}
