//Humza Khokhar - 20HAK10 - 20290176
public abstract class Entity {
	private String name;
	private Date born;
	private double difficulty;
	
	public Entity(String name, Date birthDate, double difficulty) {
		this.name = name;
		this.born = new Date(birthDate); //no privacy leak
		this.difficulty = difficulty;
	}
	
	public Entity(Entity entity) {
		this.name = entity.name;
		this.born = new Date(entity.born); //no privacy leak
		this.difficulty = entity.difficulty;
	}

	public String getName() { //Get name
		return name;
	}

	public Date getBorn() { //Get date of birth
		return new Date(born);
	}
	
	public String toString() { //Preliminary toString statement
		return "Name: "+name+"\n"+"Born at: "+born.toString()+"\n";
	}
	
    public boolean equals(Entity otherEntity){ //Comparison between entities
        return (name.equals(otherEntity.name) && born.equals(otherEntity.born));
    }
    
    public int getAwardedTicketNumber() { //Method to calculate ticket numbers
    	return (int)(this.difficulty * 100); //Cast double to int after multiplication
    }
    
    public abstract String entityType(); //Abstract method return type of String
    
    public abstract Entity clone(); //Abstract method return type of Entity
    
    public String welcomeMessage() { //Welcome Message Prompt
    	return "\nWelcome! Let's start the game! This entity is a "+entityType()+"!";
    }
    
    public String closingMessage() { //User wins guess Prompt
    	return "Congratudations! The detailed information of the entity you guessed is:\n"+toString();
    }
    
}
