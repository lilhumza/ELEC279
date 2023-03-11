
public class Politician extends Person{
	private String party;
	
	public Politician(String name, Date birthDate, String gender, String party, double difficulty) {
		super(name, birthDate, gender, difficulty);
		this.setParty(party);
	}
	
	public String getParty() {
		return party;
	}

	public void setParty(String party) {
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
