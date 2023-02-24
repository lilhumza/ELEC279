//Humza Khokhar - 20HAK10 - 20290176
public class Entity { 
	
	private String name;
	private Date born;
	
	public Entity (String name, Date date) { //Initial Constructor
		this.name = name;
		this.born = date;
	}
	
	public Entity (Entity entity) { //Copy Constructor
		this.name = entity.name;
		this.born = new Date(entity.born);
	}

	public String getName() { //Return Entity Name
        return name;
    }
	
	public Date getDate() { //Return Entity Date of birth
        return born;
    }
	
    public String toString(){ //toString for a final printable output
        return (name + ", born on " + born.toString( ));
    }
    
    public boolean equals(Entity otherEntity){ //Comparison between entities
        return (name.equals(otherEntity.name) && born.equals(otherEntity.born));
    }


}
