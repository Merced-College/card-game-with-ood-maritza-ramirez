package cardGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {

	public int numPlayers;
	private static ArrayList<Card> deckOfCards = new ArrayList<Card>();
	private static ArrayList<Player> players = new ArrayList<>();

	public static void main(String[] args) {

		// Populate and shuffle deck
		Scanner input = null;
		try {
			input = new Scanner(new File("cards.txt"));
		} catch (FileNotFoundException e) {
			// error
			System.out.println("error");
			e.printStackTrace();
		}

		while(input.hasNext()) {
			String[] fields  = input.nextLine().split(",");
			//	public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
			Card newCard = new Card(fields[0], fields[1].trim(),
					Integer.parseInt(fields[2].trim()), fields[3]);
			// Example of input file: heart, ace, 11,ah.gif
			deckOfCards.add(newCard);	
		}

		shuffle();

		//for(Card c: deckOfCards)
			//System.out.println(c);

		Scanner userInput = new Scanner(System.in);
		int numPlayers;
		while(true) {
			System.out.print("Number of players: ");
			try {
				numPlayers = userInput.nextInt();
				break;
			} catch (Error e) {
				System.out.println("Input must be an integer.");
			}
		}

		//deal each the player 2 cards
		for(int i = 0; i < numPlayers; i++) {
			Player newPlayer = new Player(deckOfCards);
			newPlayer.hit();
			newPlayer.hit();


			players.add(newPlayer);
		}

		System.out.println("pairs is " + checkFor2Kind());


		// Game loop
		while (true) {

		}
	}//end main

	private static void showPlayerCard(int index) {
		System.out.println("player " + index + " cards");
		// This way we enforce an abstraction barrier by preventing outside classes from accessing the player cards.
		players.get(index).showCards();
	}

	public static void shuffle() {

		//shuffling the cards by deleting and reinserting
		for (int i = 0; i < deckOfCards.size(); i++) {
			int index = (int) (Math.random()*deckOfCards.size());
			Card c = deckOfCards.remove(index);
			//System.out.println("c is " + c + ", index is " + index);
			deckOfCards.add(c);
		}
	}

	//check for 2 of a kind in the players hand
	public static boolean checkFor2Kind() {

		int count = 0;
		for(int i = 0; i < playerCards.size() - 1; i++) {
			Card current = playerCards.get(i);
			Card next = playerCards.get(i+1);
			
			for(int j = i+1; j < playerCards.size(); j++) {
				next = playerCards.get(j);
				//System.out.println(" comparing " + current);
				//System.out.println(" to " + next);
				if(current.equals(next)) // Need to make .equals function
					count++;
			}//end of inner for
			if(count == 1)
				return true;

		}//end outer for
		return false;
	}
}//end class
