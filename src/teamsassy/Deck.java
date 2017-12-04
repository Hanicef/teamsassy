package teamsassy;

import java.io.*;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck implements Serializable {
	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>();
		for (Suit cardSuit : Suit.values()) {
			for (int i = 1; i <= 13; ++i) {
				cards.add(new Card(i, cardSuit));
			}
		}
	}
	public Card drawCard() {
		Card temp = cards.get(0);
		cards.remove(0);
		return temp;
	}
	public void shuffle() {
//		Collections.shuffle(cards);
		int index;
		List<Card> temp = new ArrayList<Card>();
		
		Random rand = new Random();
		for(int i = cards.size() -1; i > 0;i--) {
			index = rand.nextInt(i+1);
			temp.add(cards.get(index));
			cards.remove(index);
		}
		cards = temp;
	}
	public String toString() {
		String s = "";
		for(int i = cards.size() -1; i >= 0; i--) {
			s=  cards.get(i).getValue() + " " + cards.get(i).getSuit();
			
		}
		return s;
		
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
