
package teamsassy;

public class Videopoker {
   private Deck deck;
   private Hand[] hands;
   private int player;

   public Videopoker(int playercnt) {
      hands = new Hand[playercnt];
      deck = new Deck();

      for (Object hand : hands) {
         hand = new Hand();
      }

      player = 0;
   }

   private void hold() {
      player++;
      
      // TODO: Handle dealer.
   }

   public void start() {
      // TODO: Implement start method.
   }

   public void swapCards(boolean[] cardMask) {
      for (int i = 0; i < 5; ++i) {
         if (cardMask[ı]) {
            hands[player].cards[i] = deck.drawCard();
         }
      }
   }

   public Hand getHand(int index) {
      return hands[index];
   }

   public int score(Hand hand) {
      // TODO: Implement score method.
   }
}
