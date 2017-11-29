package teamsassy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VideopokerTest {
	
	private Videopoker p = new Videopoker(1);
	Hand h;
	
	@BeforeEach
	void nyHand() {
		h = new Hand();
		
	}

	@Test
	void testPar() {
		h.clear();
		  h.addCard(new Card(2, Suit.HEARTS));
		  h.addCard(new Card(4, Suit.SPADES));
		  h.addCard(new Card(1, Suit.HEARTS));
		  h.addCard(new Card(4, Suit.HEARTS));
		  h.addCard(new Card(3, Suit.HEARTS));
		  
		   assertEquals(1, p.score(h));
		   
	}
	@Test
	void testTvåPar() {
		h.clear();
		h.addCard(new Card(2, Suit.HEARTS));
		h.addCard(new Card(4, Suit.SPADES));
		h.addCard(new Card(2, Suit.HEARTS));
		h.addCard(new Card(3, Suit.HEARTS));
		h.addCard(new Card(4, Suit.HEARTS));
		
		assertEquals(2, p.score(h));
		
	}
	@Test
	void testTriss() {
		h.clear();
		h.addCard(new Card(2, Suit.HEARTS));
		h.addCard(new Card(4, Suit.SPADES));
		h.addCard(new Card(1, Suit.HEARTS));
		h.addCard(new Card(1, Suit.HEARTS));
		h.addCard(new Card(1, Suit.HEARTS));
		
		assertEquals(3, p.score(h));
		
	}
	@Test
	void testFyrtal() {
		h.clear();
		h.addCard(new Card(1, Suit.HEARTS));
		h.addCard(new Card(2, Suit.SPADES));
		h.addCard(new Card(1, Suit.HEARTS));
		h.addCard(new Card(1, Suit.HEARTS));
		h.addCard(new Card(1, Suit.HEARTS));
		
		assertEquals(8, p.score(h));
		
	}
	@Test
	void testKåk() {
		h.clear();
		h.addCard(new Card(1, Suit.HEARTS));
		h.addCard(new Card(5, Suit.SPADES));
		h.addCard(new Card(1, Suit.HEARTS));
		h.addCard(new Card(5, Suit.HEARTS));
		h.addCard(new Card(1, Suit.HEARTS));
		
		assertEquals(6, p.score(h));
		
	}
	@Test
	void testFärg() {
		h.clear();
		h.addCard(new Card(1, Suit.HEARTS));
		h.addCard(new Card(2, Suit.HEARTS));
		h.addCard(new Card(6, Suit.HEARTS));
		h.addCard(new Card(5, Suit.HEARTS));
		h.addCard(new Card(3, Suit.HEARTS));
		
		assertEquals(5, p.score(h));
		
	}
	@Test
	void testStege() {
		h.clear();
		h.addCard(new Card(6, Suit.HEARTS));
		h.addCard(new Card(2, Suit.SPADES));
		h.addCard(new Card(3, Suit.HEARTS));
		h.addCard(new Card(5, Suit.HEARTS));
		h.addCard(new Card(4, Suit.HEARTS));
		
		assertEquals(4, p.score(h));
		
	}
	@Test
	void testFärgStege() {
		h.clear();
		h.addCard(new Card(6, Suit.HEARTS));
		h.addCard(new Card(2, Suit.HEARTS));
		h.addCard(new Card(3, Suit.HEARTS));
		h.addCard(new Card(5, Suit.HEARTS));
		h.addCard(new Card(4, Suit.HEARTS));
		
		assertEquals(11, p.score(h));
		
	}
	@Test
	void testRoyalStraightFlush() {
		h.clear();
		h.addCard(new Card(10, Suit.HEARTS));
		h.addCard(new Card(11, Suit.HEARTS));
		h.addCard(new Card(12, Suit.HEARTS));
		h.addCard(new Card(13, Suit.HEARTS));
		h.addCard(new Card(1, Suit.HEARTS));
		
		assertEquals(20, p.score(h));
		
	}

}
