package cardGame;

import java.util.ArrayList;

// This is to keep trak of a players cards.
public class Player {
    private static ArrayList<Card> playerCards;
    private static ArrayList<Card> deck; // link to the deck used in the game
    private int handValue = 0;

    public Player(ArrayList<Card> deck) {
        playerCards = new ArrayList<Card>();
        this.deck = deck;
    }

    /**
     * This way we enforce an abstraction barrier by preventing outside classes from accessing the player cards.
     * Will print the cards in the player's cards list.
     */
    public void showCards() {
		for(Card c: this.playerCards)
			System.out.println(c);
	}

    /**
     * This enforces an abstraction barrier so an outside program can't change the value of handValue
     * @return
     */
    public int getHandValue() {
        return handValue;
    }
    // "hit" (take another card) or "stand" (keep their current hand).

    /**
     * Player takes another card face down from the deck
     */
    public void hit() {
        Card pulledCard = deck.remove(0);
        System.out.println("\tCard pulled: " + pulledCard);
        playerCards.add(pulledCard); // Remove the first card from the deck and add to players hand
        handValue += pulledCard.rankNum;
    }

    /**
     * Player chooses not to draw a card (Does nothing)
     */
    public void stand(){
        return; // Do nothing
    }
}
