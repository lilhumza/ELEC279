//Humza Khokhar - 20HAK10 - 20290176
public class Politician extends Person {
	private String party;
	
	public Politician(String name, Date birthDate, String gender, String party, double difficulty) { //Copy Constructor
		super(name, birthDate, gender, difficulty);
		this.setParty(party);
	}
	
	public String getParty() { //Get Party Name
		return party;
	}

	public void setParty(String party) { //Set Party Name
		this.party = party;
	}

	
	public Politician(Person person) { //Copy Constructor
		super(person);
	}
	
	public Singer clone() { //Clone method
		return new Singer(this);
	}
	
	@Override
	public String toString() { //toString with Override
		return super.toString() + "\nParty: "+this.party; 
	}

	@Override
	public String entityType() { //entityType with Override
		return "This entity is a singer!";
	}


}
