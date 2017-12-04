package teamsassy;

import java.io.Serializable;

public class Card implements Serializable {
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
