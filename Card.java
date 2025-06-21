package cardGame;

public class Card {
    String suit;
    String rank;
    int rankNum;
    String imgFileName;

    // Example of input file: heart, ace, 11,ah.gif
    public Card(String suit, String rank, int rankNum, String imgFileName) {
        this.suit = suit;
        this.rank = rank;
        this.rankNum = rankNum;
        this.imgFileName = imgFileName;
    }

    @Override
    public boolean equals(Card other) {
        if ((other.suit == this.suit) && (other.rank == this.rank)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return suit + " " + rank;
    }
}
