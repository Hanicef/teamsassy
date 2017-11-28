package teamsassy;

public class Card {
	private int value;
	private Suit suit;
	
	public Card(int value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}
	public int getValue() {
		return value;
	}
	public Suit getSuit() {
		return suit;
	}
	
	@Override
	public String toString() {
		return this.value + " " + this.suit;
	}

}
