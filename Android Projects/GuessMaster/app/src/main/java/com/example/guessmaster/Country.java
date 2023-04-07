//Humza Khokhar - 20HAK10 - 20290176
package com.example.guessmaster;


public class Country extends Entity {
	private String capital; //Instance String variable for capital
	
	public Country(String name, Date birthDate, String capital, double difficulty) { //Copy Constructor
		super(name, birthDate, difficulty);
		this.capital = capital;
	}

	public Country(Entity entity) { //Copy Constructor
		super(entity);
	}

	public Country clone () { //Clone method
		return new Country(this);
	}
	
	public void setCapital(String capital) { //Set capital 
		this.capital = capital;
	}
	
	public String getCapital() { //Get capital
		return this.capital;
	}
	
	@Override
	public String toString() { //toString with Override
		return super.toString() + "\nCapital: "+this.capital; 
	}

	@Override
	public String entityType() { //entityType with Override
		return "This entity is a country!";
	}
	

}
