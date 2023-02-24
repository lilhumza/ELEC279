//Humza Khokhar - 20HAK10 - 20290176
import java.util.*;
public class GuessMaster {
	
	private int numberOfCandidateEntities; 
	private Entity[] entities; 
	
	public GuessMaster () { //Constructor built based on reference main code included in assignment
		this.numberOfCandidateEntities = 0; //Initialize number of Candidate Entities to Zero
	}
	
	public void addEntity(Entity entity) {
		
        Entity[] tempEntity = new Entity[numberOfCandidateEntities]; //Create a tempEntity array that always has capacity numberOfEntities - 1 with each progressive call to the function
        for (int i = 0; i < numberOfCandidateEntities; i++) { //Loop through all indices
        	tempEntity[i] = entities[i]; //Set the tempEntity array to entities at each index
        }
        
        entities = new Entity[++numberOfCandidateEntities]; //Redeclare entities as a new Entity array with capacity 1 + numberOfEntities preincremented to accommodate the new entity entry
        for (int i = 0; i < numberOfCandidateEntities-1; i++) { //Loop through the indices of the new array and copy all elements from the tempEntity array
           entities[i] = tempEntity[i];
        }
        this.entities[numberOfCandidateEntities-1] = entity; //Assign the last index of the new array to be entity passed from function
		
	}
	public void playGame(){
		int entityIndex = (int)Math.floor(Math.random() * (numberOfCandidateEntities)); //This will grab randomized index for an entity to execute the game with
		playGame(entities[entityIndex]); //Call to play game with the specific entity
		
	}
	
	public void playGame(Entity entity) { //This code only implements the execution of code assuming a date input of MM/DD/YYYY
		Scanner input = new Scanner (System.in);
		System.out.println("Greeting User, today you will be guessing the birthday of: " +entity.getName());
		String dateGuess; //Declare variable for users inputted guess as a string
		Entity guessEnt = new Entity(entity); //A temporary placeholder value for guessEnt used for initialization
		
		do { //Keep Asking user to enter a guess
			System.out.print("\nEnter a guess for the birthday - type \"quit\" to terminate the game: ");
			dateGuess = input.next();
			
			if (dateGuess.equals("quit") || dateGuess.equals("Quit") || dateGuess.equals("QUIT")) { //Break sequence if user wishes to quit the game
				System.out.println("Game has been Terminated");
				break;
			}
			
			Date userGuess = new Date(dateGuess); //Create a Date for the user inputted guess
			guessEnt = new Entity(entity.getName(), userGuess); //Create a new entity of the user inputted guess
			
			//Comparison operands for the Dates
			if (entity.equals(guessEnt)) { 
				System.out.println("BINGO. You got it!!!\n");
				playGame(); //Call to play another round
			} else if ((entity.getDate()).precedes(userGuess)) {
				System.out.println("Incorrect. Try an earlier date.");
			} else {
				System.out.println("Incorrect. Try an later date.");
			}
			
			
		} while (!entity.equals(guessEnt)); //Break condition
		
		input.close(); //Close input
			
	}
	
	public static void main(String[] args){
		
		//Game Initialization Code
		Entity trudeau = new Entity("Justin Trudeau", new Date("December", 25, 1971));
		Entity dion = new Entity("Celine Dion", new Date("March", 30, 1968));
		Entity usa = new Entity("United States", new Date("July", 4, 1776));
		
        GuessMaster gm = new GuessMaster();
        gm.addEntity(trudeau);
        gm.addEntity(dion);
        gm.addEntity(usa);
        
        gm.playGame();
        
		
	}
	
}
