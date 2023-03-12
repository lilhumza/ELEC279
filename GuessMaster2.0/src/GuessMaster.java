//Humza Khokhar - 20HAK10 - 20290176
import java.util.Random;
import java.util.Scanner;

public class GuessMaster{
	private int numOfEntities;
	private Entity[] entities; 
	private int ticketNum = 0;

	
	public GuessMaster() {
		numOfEntities = 0;
		entities = new Entity[100]; 
	}

	public void addEntity(Entity entity) {
		Entity[] tempEntity = new Entity[numOfEntities]; //Create a tempEntity array that always has capacity numberOfEntities - 1 with each progressive call to the function
        for (int i = 0; i < numOfEntities; i++) { //Loop through all indices
        	tempEntity[i] = entities[i]; //Set the tempEntity array to entities at each index
        }
        
        entities = new Entity[++numOfEntities]; //Redeclare entities as a new Entity array with capacity 1 + numberOfEntities preincremented to accommodate the new entity entry
        for (int i = 0; i < numOfEntities-1; i++) { //Loop through the indices of the new array and copy all elements from the tempEntity array
           entities[i] = tempEntity[i];
        }
        this.entities[numOfEntities-1] = entity; //Assign the last index of the new array to be entity passed from function
	}
	
	public void playGame(int entityId) {
		Entity entity = entities[entityId];
		System.out.println(entity.welcomeMessage());
		playGame(entity);
	}
	
	public void playGame(Entity entity) {
		System.out.printf("\nGuess %s's birthday\n", entity.getName());
		System.out.println("(mm/dd/yyyy)");
		
		Scanner scanner = new Scanner(System.in);

		while (true) {
			String answer = scanner.nextLine();
			answer = answer.replace("\n", "").replace("\r", "");

			if (answer.equals("quit")) {
				System.exit(0);
			}

			Date date = new Date(answer);

			if (date.precedes(entity.getBorn())) {
				System.out.println("Incorrect. Try a later date.");
			} else if (entity.getBorn().precedes(date)) {
				System.out.println("Incorrect. Try an earlier date.");
			} else {
				
				
//				Random random = new Random();
				ticketNum += entity.getAwardedTicketNumber();
//				for(int i=0; i<=50*100; i++)
//					System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
				System.out.println("*************Bingo!***************\n");
				System.out.println("You won "+entity.getAwardedTicketNumber()+" tickets in this round.");
				System.out.println("The total number of your tickets is " +ticketNum+".");
				System.out.println("**********************************\n");
				System.out.println(entity.closingMessage());
				
				playGame();
				//break;
			}
		}
	}
	
	public void playGame() {
		while (true) {
			int entityId = genRandomEntityId();
			playGame(entityId);
		}
	}

	public int genRandomEntityId() {
		Random randomNumber = new Random();
		return randomNumber.nextInt(numOfEntities);
	}

	public static void main(String[] args) {
		System.out.println("=========================\n");
		System.out.println("     GuessMaster 2.0 \n");
		System.out.println("=========================");
		Politician trudeau = new Politician("Justin Trudeau", new Date("December", 25, 1971), "Male", "Liberal", 0.25);
		Singer dion = new Singer("Celine Dion", new Date("March", 30, 1961), "Female", "La voix du bon Dieu", new Date("November", 6, 1981), 0.5);
		Person myCreator = new Person("myCreator", new Date("September", 1, 2000), "Female", 1);
		Country usa = new Country("United States", new Date("July", 4, 1776), "Washinton D.C.", 0.1);
		

		GuessMaster gm = new GuessMaster();
		gm.addEntity(trudeau);
		gm.addEntity(dion);
		gm.addEntity(myCreator);
		gm.addEntity(usa);

		gm.playGame();
	}
}
