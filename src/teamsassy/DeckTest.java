package teamsassy;

public class DeckTest {
	public static void main(String[] args) {
		Deck deck = new Deck();
		
		System.out.println(deck);
		
		deck.shuffle();
		
		System.out.println(deck);
	}
}
