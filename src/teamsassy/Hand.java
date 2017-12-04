
package teamsassy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Hand implements Serializable {

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

        public void writeData(DataOutputStream s) throws IOException {
                s.writeInt(cards.size());
                for (int i = 0; i < cards.size(); ++i) {
                        s.writeInt(cards.get(i).getValue());
                        s.writeInt(cards.get(i).getSuit().ordinal());
                }
        }

        public void readData(DataInputStream s) throws IOException {
                cards = new ArrayList<Card>();
                int len = s.readInt();
                for (int i = 0; i < len; ++i) {
                        Card card = new Card(s.readInt(), Suit.values()[s.readInt()]);
                        cards.add(card);
                }
        }
   
}
