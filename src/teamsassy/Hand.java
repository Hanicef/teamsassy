
package teamsassy;

import java.util.ArrayList;
import java.util.List;

public class Hand {

   private List<Card> cards;


   public Hand() {

	   cards = new ArrayList<Card>();
   }

   public void addCard(Card card) {
	   cards.add(card);
   }

   public Card[] getCards() {
      return cards.toArray(new Card[0]);
   }

   public void clear() {
	   cards.clear();
   }
   
}
