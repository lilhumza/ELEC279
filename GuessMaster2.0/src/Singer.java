
public class Singer extends Person {
	private String debutAlbum;
	private Date debutAlbumReleaseDate;
	
	public Singer(String name, Date birthDate, String gender, String debutAlbum, Date debutAlbumReleaseDate, double difficulty) {
		super(name, birthDate, gender, difficulty);
		this.setDebutAlbum(debutAlbum);
		this.setDebutAlbumReleaseDate(debutAlbumReleaseDate);
	}
	
	public Singer(Person person) { //Copy Constructor
		super(person);
	}

	public String getDebutAlbum() {
		return debutAlbum;
	}

	public void setDebutAlbum(String debutAlbum) {
		this.debutAlbum = debutAlbum;
	}

	public Date getDebutAlbumReleaseDate() {
		return debutAlbumReleaseDate;
	}

	public void setDebutAlbumReleaseDate(Date debutAlbumReleaseDate) {
		this.debutAlbumReleaseDate = debutAlbumReleaseDate;
	}
	
	public Singer clone() { //Clone method
		return new Singer(this);
	}
	
	@Override
	public String toString() { //toString with Override
		return super.toString() + "\nDebut Album: "+this.debutAlbum+"\nRelease Date: "+this.debutAlbumReleaseDate; 
	}

	@Override
	public String entityType() { //entityType with Override
		return "This entity is a singer!";
	}
	

}
