
package teamsassy;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Videopoker implements Serializable {
    // Game data.
	private Deck deck;
	private Hand[] hands;
	private int player;

    // Betting info.
	private int inmatning;
	private int points;
	private int newPot;
	public int nrOfSwaps = 1;
	public int swapCount = 0;
	public static int lastbet = 0;

	public Videopoker(int playercnt) {
		hands = new Hand[playercnt];
		deck = new Deck();

		for (int i = 0; i < playercnt; ++i) {
            // Initialize all hands.
			hands[i] = new Hand();
		}

		player = 0;
	}

	public Hand hold() {

		score(hands[player++]);
		if (player >= hands.length) {
            // All players have finished their turns: end the game.
            newPot();
            return null;
		}
		return hands[player];

	}

	public void start() {
		deck = new Deck();
		for (int i = 0; i < hands.length; ++i) {
            // Clear out all hands; new cards will be given later.
			hands[i].clear();
		}

		deck.shuffle();

		for (int i = 0; i < hands.length; ++i) {
			for (int j = 0; j < 5; ++j) {
                // Assign 5 cards to each hand.
				hands[i].addCard(deck.drawCard());
			}
		}
		setBet();

		player = 0;
	}

	public void swapCards(boolean[] cardMask) {
		Card[] tempCards = hands[player].getCards();
		for (int i = 0; i < 5; i++) {
			if (cardMask[i]) {
                // Check mask; if n'th boolean is true, swap that card.
				tempCards[i] = deck.drawCard();
			}
		}

        // Reset the hand.
		hands[player].clear();
		for (int i = 0; i < 5; i++) {
            // Assign cards to the new hand.
			hands[player].addCard(tempCards[i]);
		}
	}

	public Hand getHand(int index) {
		return hands[index];
	}

	public int score(Hand hand) {
		String pH = "inget";
		int[] values = new int[14];
		int sameSuit = 0;
		int s = 0;
		boolean flush = false;
		int[] handen = new int[5];
		Suit[] suits = new Suit[5];
//		Values[] har 14 hållare som börjar som alla har en int med värdet 0
		for (int m = 1; m <= 13; m++) {
			values[m] = 0;
		}
//		handens värdes motsvarande plats i values[] arrayen ökar med 1 för 
//		varje gång kortet finns i handen
		for (int x = 0; x <= 4; x++) {
			handen[x] = hand.getCards()[x].getValue();
			values[hand.getCards()[x].getValue()]++;

			// Färg
			if (hand.getCards()[0].getSuit() == hand.getCards()[x].getSuit())
				sameSuit++;
			if (sameSuit == 5) {
				flush = true;
				s = 5;
				pH = "färg";

			}
		}
//		kollar hur många kort av varje värde som finns
		for (int m = 0; m <= 13; m++) {
			// par
			if (values[m] == 2) {
				s = 1;
				pH = "par";

			}
			// triss
			else if (values[m] == 3) {
				s = 3;
				pH = "triss";

			}
			// fyrtal
			else if (values[m] == 4) {
				s = 8;
				pH = "fyrtal";

			}
			for (int i = 0; i < 13; i++) {
				// tvåpar
				if (values[m] == 2 && values[i] == 2 && i != m) {
					s = 2;
					pH = "två par";
				}
				// kåk
				if (values[m] == 3 && values[i] == 2 && i != m || values[i] == 3 && values[m] == 2 && i != m) {
					s = 6;
					pH = "kåk";
				}

			}
		}
		Arrays.sort(handen);
		// stege
		if (handen[0] == (handen[1] - 1) && (handen[2] - 2) == (handen[3] - 3) && (handen[3] - 3) == (handen[4] - 4)) {
			s = 4;
			pH = "stege";
			// Färgstege
			if (flush == true) {
				s = 11;
				pH = "färgstege";
			}
		}

		// Royal Straight Flush och Royal Straight
		if (handen[0] == 1 && handen[1] == 10 && handen[2] == 11 && handen[3] == 12 && handen[4] == 13) {
			s = (flush == true ? 20 : 4);
			pH = (flush == true ? "royal straight flush" : "royal straight");
		}
//		ingen hand
		if (s == 0) {
			s = -5;
			pH = "ingen hand";
		}
		System.out.println(s * 2);
		Gui.setTextMessage((s * 2) + " points! Du fick " + pH);
		return s * 2;
	}

	public void setBet() {
		inmatning += Gui.getBet();
		Gui.setMoneyLeft(inmatning);
	}

	public int newPot() {
		// inmatning = Gui.getBet();
		// Gui.setMoneyLeft(inmatning);
		// H�mta in po�ngen
		points = score(hands[0]);
		newPot = inmatning + points;
		Gui.setMoneyLeft(newPot);
		return newPot;
	}
}
