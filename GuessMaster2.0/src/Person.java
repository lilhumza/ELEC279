//Humza Khokhar - 20HAK10 - 20290176
public class Person extends Entity {
	private String gender;
	
	public Person(String name, Date birthDate, String gender, double difficulty) { //Copy Constructor
		super(name, birthDate, difficulty);
		this.gender = gender;
	}
	
	public Person (Entity entity) { //Copy Constructor
		super(entity);
	}

	public Person clone () { //Clone method
		return new Person(this);
	}
	
	public void setGender(String gender) { //Set gender 
		this.gender = gender;
	}
	
	public String getCapital() { //Get capital
		return this.gender;
	}
	
	@Override
	public String toString() { //toString with Override
		return super.toString() + "Gender: "+this.gender; 
	}

	@Override
	public String entityType() { //entityType with Override
		return "This entity is a person!";
	}
	
	
	
	

}
