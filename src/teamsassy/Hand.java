
package teamsassy;

public class Hand {

   private Card[] cards;
   private int cardCount;


   public Hand() {
	   cardCount = 0;
	   cards = new Card[5];
   }

   public void addCard(Card card) {
	   cards[cardCount++] = card;
   }

   public Card[] getCards() {
      return cards;
   }

   public void clear() {
   }
}
