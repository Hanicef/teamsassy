
package teamsassy;

import java.util.Arrays;

public class Videopoker {
	private Deck deck;
	private Hand[] hands;
	private int player;

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
	}

	public void start() {
		deck = new Deck();
		for (int i = 0; i < hands.length; ++i) {
			hands[i].clear();
		}

		deck.shuffle();
		Card card1 = new Card(1, Suit.HEARTS);
		Card card2 = new Card(1, Suit.HEARTS);
		Card card3 = new Card(1, Suit.CLUBS);
		Card card4 = new Card(2, Suit.SPADES);
		Card card5 = new Card(2, Suit.CLUBS);
		
//		for (int i = 0; i < hands.length; ++i) {
//			for (int j = 0; j < 5; ++j) {
//				hands[i].addCard(deck.drawCard());
//			}
//		}
		hands[0].addCard(card1);
		hands[0].addCard(card2);
		hands[0].addCard(card3);
		hands[0].addCard(card4);
		hands[0].addCard(card5);


		player = 0;
	}

	public void swapCards(boolean[] cardMask) {
		for (int i = 0; i < 5; ++i) {
			if (cardMask[i]) {
				hands[player].getCards()[i] = deck.drawCard();
			}
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
			System.out.println(sameSuit);
			if (sameSuit == 5) {
				flush = true;
				s = 5;

			}
		}
		for (int m = 0; m < 13; m++) {
			// par
			System.out.println(values[m]);
			if (values[m] == 2) {
				s = 1;
				Gui.setTextMessage("Du fick par");
			}
			// triss
			else if (values[m] == 3) {
				s = 3;
				Gui.setTextMessage("Du fick triss");
			}
			// fyrtal
			else if (values[m] == 4) {
				s = 8;
				Gui.setTextMessage("Du fick fyrtal");
			}
			for (int i = 0; i < 13; i++) {
				// tvÃ¥par
				if (values[m] == 2 && values[i] == 2 && i != m) {
					s = 2;
					Gui.setTextMessage("Du fick Två par");
				}
				// kÃ¥k
				if (values[m] == 3 && values[i] == 2 && i != m || values[i] == 3 && values[m] == 2 && i != m) {
					s = 6;
					Gui.setTextMessage("Du fick Kåk");

				}

			}
		}
		Arrays.sort(handen);
		if (handen[0] == (handen[1] - 1) && (handen[2] - 2) == (handen[3] - 3) && (handen[3] - 3) == (handen[4] - 4)) {
			s = 4;
			// FÃ¤rgstege
			if (flush == true) {
				s = 11;
				System.out.println(handen[0] + " Hej");
				Gui.setTextMessage("Du fick Färgstege");

			}
		}
		// Royal Straight Flush
		if (handen[0] == 1 && handen[1] == 10 && handen[2] == 11 && handen[3] == 12 && handen[4] == 13
				&& flush == true) {
			s = 20;
			Gui.setTextMessage("Du fick RoyalFlush");
		}
		System.out.println();
		return s;
	}
}
