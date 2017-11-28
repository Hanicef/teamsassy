
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
      
      // TODO: Handle dealer.
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
         if (cardMask[ı]) {
            hands[player].cards[i] = deck.drawCard();
         }
      }

      hold(); // Next player.
   }

   public Hand getHand(int index) {
      return hands[index];
   }


	public int score(Hand hand) {
		int score;
		for (int i = 0; i < 5; i++) {

			if (hands[player].cards[i].getvalue == hands[player].cards[i + 1].getvalue) {
				score = 1;
			}
			if(hands[player].cards[i].getvalue == hands[player].cards[i + 1].getvalue) {
				for(int j = i;i < 4; i++) {
					if(hands[player].cards[i].getvalue == hands[player].cards[i + 1].getvalue) {
						
					}
					
				}
			}
		}

	}
}
