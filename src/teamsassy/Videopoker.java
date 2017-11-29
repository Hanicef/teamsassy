
package teamsassy;

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

	private void hold() {
		player++;
	}

	public void start() {
		deck.reset();
		for (int i = 0; i < hands.length; ++i) {
			hands[i].clear();
		}

		for (int i = 0; i < hands.length; ++i) {
			for (int j = 0; j < 5; ++j) {
				hands[i].addCard(deck.drawCard());
			}
		}

		player = 0;
	}

	public void swapCards(boolean[] cardMask) {
		for (int i = 0; i < 5; ++i) {
			if (cardMask[i]) {
				hands[player].getCards()[i] = deck.drawCard();
			}
		}

		hold(); // Next player.
	}

	public Hand getHand(int index) {
		return hands[index];
	}

	public int score(Hand hand) {
		int[] values = new int[14];
		int sameSuit = 0;
		int s = 0;
		int sameCard = 0;
		boolean flush = false;
		
		for(int m = 1; m <= 13; m++) {
			values[m] = 0;
		}
		for (int x=0; x<=4; x++)
		{
			values[hand.getCards()[x].getValue()]++;
			for(int i = 0; i < 5; i++) {
				
			if(hand.getCards()[x].getSuit() == hand.getCards()[i].getSuit() && i != x)
			sameSuit++;
			if(sameSuit == 5) {
				flush = true;
				s = 10;
			}
			}
		}
		for(int m = 0; m < 13; m++) {
//			par
			System.out.println(values[m]);
			if(values[m] == 2) {
				s = 1;
			}
//			triss
			else if(values[m] == 3) {
				s = 3;
			}
//			fyrtal
			else if(values[m] == 4) {
				s = 7;
			}
			for(int i = 0; i < 13; i++) {
//				tvåpar
				if(values[m] == 2 && values[i] == 2 && i != m) {
					s = 2;
				}
//				kåk
				if(values[m] == 3 && values[i] == 2 && i != m || values[i] == 3 && values[m] == 2 && i != m ) {
					s = 6;
					
				}
				
			}
		}
		System.out.println();
		return s;
	}
}

