package com.example.guessmaster; //Humza Khokhar - 20HAK10 - 20290176
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class GuessMaster extends AppCompatActivity {
	//Define Android view components
	private TextView entityName;
	private TextView ticketsum;
	private Button guessButton;
	private EditText userIn;
	private Button btnclearContent;
	private String user_input;
	private ImageView entityImage;
	String answer;

	//Define instances and variables
	private int numOfEntities;
	private Entity[] entities; 
	private int ticketNum = 0;
	Entity initEntity; //Declaration of an initial entity instance for the Entity that loads upon start

	Politician trudeau = new Politician("Justin Trudeau", new Date("December", 25, 1971), "Male", "Liberal", 0.25);
	Singer dion = new Singer("Celine Dion", new Date("March", 30, 1961), "Female", "La voix du bon Dieu", new Date("November", 6, 1981), 0.5);
	Person myCreator = new Person("myCreator", new Date("September", 1, 2000), "Female", 1);
	Country usa = new Country("United States", new Date("July", 4, 1776), "Washington D.C.", 0.1);

	Person hamidouDiallo = new Person("Hamidou Diallo", new Date("July", 31, 1998), "Male", 0.73); //Additional Entity for the fun of it 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guess_activity);

		//UI Components
		entityName = (TextView) findViewById(R.id.entityName);
		ticketsum = (TextView) findViewById(R.id.ticket);
		guessButton = (Button) findViewById(R.id.btnGuess);
		userIn = (EditText) findViewById(R.id.guessinput);
		btnclearContent = (Button) findViewById(R.id.btnClear);
		entityImage = (ImageView) findViewById(R.id.entityImage);

		//Add All Entity to GuessMaster
		addEntity(trudeau);
		addEntity(dion);
		addEntity(myCreator);
		addEntity(usa);
		addEntity(hamidouDiallo);

		initEntity = entities[genRandomEntityId()]; //Grab a random entity for the first run of the game
		entityName.setText(initEntity.getName()); //Set name of entity in UI
		ImageSetter(initEntity); //Set image of entity in UI

		//OnClick Listener for Submit Guess Button
		guessButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v){playGame(initEntity);} //Call to playGame upon clicking with the initEntity for continuation of the same entity
		});

		//OnClick Listener for Change Entity Button
		btnclearContent.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v){changeEntity();} //Call to changeEntity upon clicking the button
		});

	}

	public GuessMaster() { //Legacied in from 2.0, not relevant
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

	public void ImageSetter(Entity entity) { //Set image of entity for each entity selected
		if(entity.getName() == "Justin Trudeau"){
			entityImage.setImageResource(R.drawable.justint);
		} else if (entity.getName() == "Celine Dion") {
			entityImage.setImageResource(R.drawable.celidion);
		} else if (entity.getName() == "myCreator") {
			entityImage.setImageResource(R.drawable.creator);
		} else if (entity.getName() == "United States") {
			entityImage.setImageResource(R.drawable.usaflag);
		} else if (entity.getName() == "Hamidou Diallo") {
			entityImage.setImageResource(R.drawable.hamidou);
		}
	}
	
	public void playGame(int entityId) {
		Entity entity = entities[entityId];
		playGame(entity);
	}

	public void welcomeToGame(Entity entity) {
		AlertDialog.Builder welcomeAlert = new AlertDialog.Builder(GuessMaster.this); //Create and AlertDialog instance
		welcomeAlert.setTitle("GuessMaster Game V3"); //Set the title for the welcome message
		welcomeAlert.setMessage(entity.welcomeMessage()); //Set the welcome message
		welcomeAlert.setCancelable(false); //Disable cancel button

		welcomeAlert.setNegativeButton("START GAME", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getBaseContext(), "Game is Starting... Enjoy", Toast.LENGTH_SHORT).show();
			}
		});
		AlertDialog dialog = welcomeAlert.create();
		dialog.show();

	}

	
	public void playGame(Entity entity) {
		entityName.setText(entity.getName()); //Set name of entity in UI
		answer = userIn.getText().toString(); //Get the user input from the text field in UI
		answer = answer.replace("\n", "").replace("\r", ""); //Filter the inputted string to a viable date format

		Date date = new Date(answer); //Create a date instance with the filtered string

		if (date.precedes(entity.getBorn())) { //Guessed date precedes the actual date
			AlertDialog.Builder laterGuess = new AlertDialog.Builder(GuessMaster.this);
			laterGuess.setTitle("Incorrect");
			laterGuess.setMessage("Try a later date.");
			laterGuess.setCancelable(false);
			laterGuess.setNegativeButton("OK",new DialogInterface.OnClickListener() { //OK button to close the false alert
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
			AlertDialog dialog = laterGuess.create();
			dialog.show();

		} else if (entity.getBorn().precedes(date)) { //Guessed date exceeds the actual date
			AlertDialog.Builder earlyGuess = new AlertDialog.Builder(GuessMaster.this);
			earlyGuess.setTitle("Incorrect");
			earlyGuess.setMessage("Try an earlier date.");
			earlyGuess.setCancelable(false);
			earlyGuess.setNegativeButton("OK",new DialogInterface.OnClickListener() { //OK button to close the false alert
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
			AlertDialog dialog = earlyGuess.create();
			dialog.show();
		} else { //Guessed date matches the actual date

			ticketNum += entity.getAwardedTicketNumber(); //Add to the ticket count
			AlertDialog.Builder winningGuess = new AlertDialog.Builder(GuessMaster.this);
			winningGuess.setTitle("You Won!");
			winningGuess.setMessage("BINGO! "+entity.closingMessage());
			winningGuess.setNegativeButton("Continue", new DialogInterface.OnClickListener() { //Continue button to close the Winner alert
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getBaseContext(), "You Won " + ticketNum + " Tickets!", Toast.LENGTH_SHORT).show();} //Feedback message
			});

			ticketsum.setText("Ticket: " + Integer.toString(ticketNum));
			AlertDialog dialog = winningGuess.create();
			dialog.show();

			continueGame(); //Continue the game
		}
	}

	public void changeEntity() {
		userIn.setText(""); //Clear UI Field with Generic Input Baseline
		int randEntIndex = genRandomEntityId(); //Get random entity index
		Entity changeEnt = entities[randEntIndex]; //Create new Entity instance
		entityName.setText(changeEnt.getName()); //Set UI to new Entity Name
		ImageSetter(changeEnt); //Set UI to new Entity Image

		//OnClick Listener for Submit Guess Button
		guessButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v){playGame(changeEnt);} //playGame with new Entity
		});

	}
	public void continueGame() { //This function is redundant with the way this game has been coded, the function of importance is ChangeEntity
		changeEntity();
	}

	public void playGame() { //This is legacied in from previous renditions of the game and is not actually used. The first instance of playGame is called with a parameter
		while (true) {
			int entityId = genRandomEntityId();
			playGame(entityId);
		}
	}

	public int genRandomEntityId() { //Random number generator based off of the total number of entities in the game
		Random randomNumber = new Random();
		return randomNumber.nextInt(numOfEntities);
	}

}
