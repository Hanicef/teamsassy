
package teamsassy;

import java.util.Arrays;
import java.util.List;

public class Videopoker {
	private Deck deck;
	private Hand[] hands;
	private int player;
//	private int bet = 100;
//	private BetMoney bet;
	private int inmatning;
	private int points;
	private int newPot;

	public Videopoker(int playercnt) {
		hands = new Hand[playercnt];
		deck = new Deck();

		for (int i = 0; i < playercnt; ++i) {
			hands[i] = new Hand();
		}

		player = 0;
	}

	public void hold() {
		Hand dealer;
		player++;

		if (player >= hands.length) {
			dealer = new Hand();

			for (int i = 0; i < 5; ++i) {
				dealer.addCard(deck.drawCard());
			}
		}
		score(hands[0]);
		newPot();
	}

	public void start() {
		deck = new Deck();
		for (int i = 0; i < hands.length; ++i) {
			hands[i].clear();
		}

		deck.shuffle();

		for (int i = 0; i < hands.length; ++i) {
			for (int j = 0; j < 5; ++j) {
				hands[i].addCard(deck.drawCard());
			}
		}
//		bet  = new BetMoney();
		setBet();
		
		
		player = 0;
	}

	public void swapCards(boolean[] cardMask) {
		Card[] tempCards = hands[player].getCards();
		for (int i = 0; i < 5; i++) {
			if (cardMask[i]) {
				tempCards[i] = deck.drawCard();
			}
		}
		hands[player].clear();
		for (int i = 0; i < 5; i++) {
			hands[player].addCard(tempCards[i]);
		}
	}

	public Hand getHand(int index) {
		return hands[index];
	}

	public int score(Hand hand) {
		int[] values = new int[14];
		int sameSuit = 0;
		int s = 0;
		boolean flush = false;
		int[] handen = new int[5];
		Suit[] suits = new Suit[5];

		for (int m = 1; m <= 13; m++) {
			values[m] = 0;
		}
		for (int x = 0; x <= 4; x++) {
			suits[x] = hand.getCards()[x].getSuit();
			handen[x] = hand.getCards()[x].getValue();
			values[hand.getCards()[x].getValue()]++;

			if (suits[0] == hand.getCards()[x].getSuit())
				sameSuit++;
			if (sameSuit == 5) {
				flush = true;
				s = 5;

			}
		}
		for (int m = 0; m <= 13; m++) {
			// par
			if (values[m] == 2) {
				s = 1;
				Gui.setTextMessage("Du fick par");
				Gui.setTextMessage("2 points!");
				
			}
			// triss
			else if (values[m] == 3) {
				s = 3;
				Gui.setTextMessage("Du fick triss");
				Gui.setTextMessage("6 points!");
				
			}
			// fyrtal
			else if (values[m] == 4) {
				s = 8;
				Gui.setTextMessage("Du fick fyrtal");
				Gui.setTextMessage("10 points!");
				
			}
			for (int i = 0; i < 13; i++) {
				// tvåpar
				if (values[m] == 2 && values[i] == 2 && i != m) {
					s = 2;
					Gui.setTextMessage("Du fick Tv� par");
					Gui.setTextMessage("10 points!");
					
				}
				// kåk
				if (values[m] == 3 && values[i] == 2 && i != m || values[i] == 3 && values[m] == 2 && i != m) {
					s = 6;
					Gui.setTextMessage("Du fick K�k");
					Gui.setTextMessage("15 points!");
					

				}

			}
		}
		Arrays.sort(handen);
		if (handen[0] == (handen[1] - 1) && (handen[2] - 2) == (handen[3] - 3) && (handen[3] - 3) == (handen[4] - 4)) {
			s = 4;
			// Färgstege
			if (flush == true) {
				s = 11;
				System.out.println(handen[0] + " Hej");
				Gui.setTextMessage("Du fick F�rgstege");
				Gui.setTextMessage("25 points!");
				

			}
		}
		// Royal Straight Flush
		if (handen[0] == 1 && handen[1] == 10 && handen[2] == 11 && handen[3] == 12 && handen[4] == 13
				&& flush == true) {
			s = 20;
			Gui.setTextMessage("Du fick RoyalFlush");
			Gui.setTextMessage("30 points!");
			
		}
		System.out.println("Hejdå!");
		if(s == 0) {
			s = -10;
			Gui.setTextMessage("Noll poäng");
			Gui.setTextMessage("-10 points!");
			
		}
		return s;
	}
	public void setBet() {
		inmatning = Gui.getBet();
		Gui.setMoneyLeft(inmatning);
	}
	public int newPot() {
//		inmatning = Gui.getBet();
//		Gui.setMoneyLeft(inmatning);
//		H�mta in po�ngen
		points = score(hands[0]);
		newPot = inmatning + points;
		Gui.setMoneyLeft(newPot);
		return newPot;
	}
}
