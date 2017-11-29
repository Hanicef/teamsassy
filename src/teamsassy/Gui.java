package teamsassy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Gui extends JFrame implements ActionListener {

	// Skapa massa variabler som behövs
	public int nrOfSwaps = 1;
	public int swapCount = 0;

	private JPanel buttonPanel = new JPanel();

	private JButton swap = new JButton("Swap");
	private JButton start = new JButton("Start");
	private JButton hold = new JButton("Hold");

	// Försökt göra detta till en array men blev krångel med actionListener´n,
	// nån får gärna försöka
	private JRadioButton[] radiobuttons = new JRadioButton[] { new JRadioButton("1 swap", true),
			new JRadioButton("2 swap", false) };
	// private JRadioButton radio1 = new JRadioButton("1 swap", true);
	// private JRadioButton radio2 = new JRadioButton("2 swap", false);

	private ButtonGroup group = new ButtonGroup();

	private JPanel checkboxPanel = new JPanel();

	private JCheckBox[] c = new JCheckBox[5];

	private JPanel textMessagePanel = new JPanel();
	private static JTextArea textArea = new JTextArea(3, 35);

	private JPanel cardPanel = new JPanel();

	private static JLabel[] cards = new JLabel[] { new JLabel(), new JLabel(), new JLabel(), new JLabel(),
			new JLabel() };

	private ImageIcon back = new ImageIcon("src/images/back.png");

	private static ImageIcon[] spadeCards = new ImageIcon[] { new ImageIcon("src/images/ace_of_spades.png"),
			new ImageIcon("src/images/2_of_spades.png"), new ImageIcon("src/images/3_of_spades.png"),
			new ImageIcon("src/images/4_of_spades.png"), new ImageIcon("src/images/5_of_spades.png"),
			new ImageIcon("src/images/6_of_spades.png"), new ImageIcon("src/images/7_of_spades.png"),
			new ImageIcon("src/images/8_of_spades.png"), new ImageIcon("src/images/9_of_spades.png"),
			new ImageIcon("src/images/10_of_spades.png"), new ImageIcon("src/images/knight_of_spades.png"),
			new ImageIcon("src/images/queen_of_spades.png"), new ImageIcon("src/images/king_of_spades.png") };

	private ImageIcon[] clubCards = new ImageIcon[] { new ImageIcon("src/images/ace_of_clubs.png"),
			new ImageIcon("src/images/2_of_clubs.png"), new ImageIcon("src/images/3_of_clubs.png"),
			new ImageIcon("src/images/4_of_clubs.png"), new ImageIcon("src/images/5_of_clubs.png"),
			new ImageIcon("src/images/6_of_clubs.png"), new ImageIcon("src/images/7_of_clubs.png"),
			new ImageIcon("src/images/8_of_clubs.png"), new ImageIcon("src/images/9_of_clubs.png"),
			new ImageIcon("src/images/10_of_clubs.png"), new ImageIcon("src/images/knight_of_clubs.png"),
			new ImageIcon("src/images/queen_of_clubs.png"), new ImageIcon("src/images/king_of_clubs.png") };

	private ImageIcon[] diamondCards = new ImageIcon[] { new ImageIcon("src/images/ace_of_diamonds.png"),
			new ImageIcon("src/images/2_of_diamonds.png"), new ImageIcon("src/images/3_of_diamonds.png"),
			new ImageIcon("src/images/4_of_diamonds.png"), new ImageIcon("src/images/5_of_diamonds.png"),
			new ImageIcon("src/images/6_of_diamonds.png"), new ImageIcon("src/images/7_of_diamonds.png"),
			new ImageIcon("src/images/8_of_diamonds.png"), new ImageIcon("src/images/9_of_diamonds.png"),
			new ImageIcon("src/images/10_of_diamonds.png"), new ImageIcon("src/images/knight_of_diamonds.png"),
			new ImageIcon("src/images/queen_of_diamonds.png"), new ImageIcon("src/images/king_of_diamonds.png") };

	private ImageIcon[] heartCard = new ImageIcon[] { new ImageIcon("src/images/ace_of_hearts.png"),
			new ImageIcon("src/images/2_of_hearts.png"), new ImageIcon("src/images/3_of_hearts.png"),
			new ImageIcon("src/images/4_of_hearts.png"), new ImageIcon("src/images/5_of_hearts.png"),
			new ImageIcon("src/images/6_of_hearts.png"), new ImageIcon("src/images/7_of_hearts.png"),
			new ImageIcon("src/images/8_of_hearts.png"), new ImageIcon("src/images/9_of_hearts.png"),
			new ImageIcon("src/images/10_of_hearts.png"), new ImageIcon("src/images/knight_of_hearts.png"),
			new ImageIcon("src/images/queen_of_hearts.png"), new ImageIcon("src/images/ace_of_king.png") };

	public Gui() {
		super("VideoPoker");

		// Ställa in och adda knapparna
		Font buttonFont = new Font("Helvetica", Font.BOLD, 24);
		Dimension buttonDim = new Dimension(120, 55);
		start.setFont(buttonFont);
		start.setPreferredSize(buttonDim);
		start.addActionListener(this);
		start.setEnabled(true);
		swap.setFont(buttonFont);
		swap.setPreferredSize(buttonDim);
		swap.addActionListener(this);
		swap.setEnabled(false);
		hold.setFont(buttonFont);
		hold.setPreferredSize(buttonDim);
		hold.addActionListener(this);
		hold.setEnabled(false);
		buttonPanel.setLayout(new GridBagLayout());
		GridBagConstraints buttonPanelGBC = new GridBagConstraints();
		buttonPanelGBC.insets = new Insets(0, 15, 0, 15);
		buttonPanelGBC.gridx = 1;
		buttonPanelGBC.gridheight = 2;
		buttonPanel.add(start, buttonPanelGBC);
		buttonPanelGBC.gridx = 2;
		buttonPanel.add(swap, buttonPanelGBC);
		buttonPanelGBC.gridx = 3;
		buttonPanel.add(hold, buttonPanelGBC);
		buttonPanelGBC.gridheight = 1;
		buttonPanelGBC.gridx = 4;
		buttonPanel.add(radiobuttons[0], buttonPanelGBC);
		buttonPanelGBC.gridy = 1;
		buttonPanel.add(radiobuttons[1], buttonPanelGBC);
		group.add(radiobuttons[0]);
		group.add(radiobuttons[1]);
		radiobuttons[0].addActionListener(this);
		radiobuttons[1].addActionListener(this);

		// Ställa in och adda checkboxes
		checkboxPanel.setLayout(new GridBagLayout());
		GridBagConstraints checkboxPanelGBC = new GridBagConstraints();
		checkboxPanelGBC.insets = new Insets(0, 40, 0, 40);
		c = new JCheckBox[5];
		for (int i = 0; i < c.length; ++i) {
			c[i] = new JCheckBox();
			checkboxPanelGBC.gridx = i + 1;
			checkboxPanel.add(c[i], checkboxPanelGBC);
			c[i].addActionListener(this);
			c[i].setEnabled(false);
		}

		// Lägg till textArea
		textArea.setOpaque(false);
		textArea.setFont(new Font("Helvetica", Font.BOLD, 18));
		// textArea.setText("Du fick kåk, 1000 poäng till dig!");
		textMessagePanel.add(textArea);

		// Adda ImageIcons till korten, default är baksidan av kortet
		for (int i = 0; i < cards.length; i++) {
			cards[i].setIcon(back);
		}

		// Adda korten i kortpanelen
		cardPanel.setLayout(new GridBagLayout());
		cardPanel.setPreferredSize(new Dimension(550, 150));
		GridBagConstraints cardPanelGBC = new GridBagConstraints();
		cardPanelGBC.insets = new Insets(5, 5, 5, 5);
		cardPanelGBC.gridy = 1;
		for (int i = 0; i < 5; i++) {
			cardPanelGBC.gridx = i + 1;
			cardPanel.add(cards[i], cardPanelGBC);
		}

		// set layout för frame
		setLayout(new GridBagLayout());
		GridBagConstraints frameGBC = new GridBagConstraints();
		frameGBC.insets = new Insets(10, 0, 10, 0);
		// Adda text i framen
		frameGBC.gridx = 1;
		frameGBC.gridy = 1;
		frameGBC.gridwidth = 5;
		frameGBC.gridheight = 1;
		add(textArea, frameGBC);
		// Adda cardPanel i framen
		frameGBC.gridx = 1;
		frameGBC.gridy = 2;
		frameGBC.gridwidth = 5;
		frameGBC.gridheight = 3;
		add(cardPanel, frameGBC);
		// Adda checkboxPanel i framen
		frameGBC.gridx = 1;
		frameGBC.gridy = 6;
		frameGBC.gridwidth = 5;
		frameGBC.gridheight = 1;
		add(checkboxPanel, frameGBC);
		// Adda buttonPanel i framen
		frameGBC.gridx = 1;
		frameGBC.gridy = 7;
		frameGBC.gridwidth = 5;
		frameGBC.gridheight = 1;
		add(buttonPanel, frameGBC);

		// inställningar för Framen
		// getContentPane().setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

	// Actionlistener
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == start) {
			// TODO: lägg in anrop till startmetoden här
			textArea.setText("START");
			start.setEnabled(false);
			swap.setEnabled(true);
			hold.setEnabled(true);
			//hand = new Hand();
			//setIconsForHand(hand);
			enableCheckboxes();
			disableRadiobuttons();
		}
		if (e.getSource() == swap) {
			// TODO: lägg in anrop till swapmetoden här
			textArea.setText("SWAP");
			setIcon(new Card(6, Suit.HEARTS), 2);
			resetCheckboxes();

			swapCount++;
			if (nrOfSwaps == swapCount) {
				swap.setEnabled(false);
			}

		}
			// Eventuellt bode denna heta "CALL" istället, engelska för syna
		if (e.getSource() == hold) {
			// TODO: lägg in anrop till holdmetoden här
			textArea.setText("HOLD");
			start.setEnabled(true);
			hold.setEnabled(false);
			disableCheckboxes();
			swapCount = 0;
			enableRadiobuttons();
		}
		for (int i = 0; i < 5; ++i) {
			if (c[i].isSelected()) {
				// TODO: Mark card i.
				String s = "c " + i + " is selected";
				textArea.setText(s);
			} else {
				// TODO: Unmark card i.
			}
		}
		// Här väljer vi hur många swaps man får göra
		for (int i = 0; i < 2; i++) {
			if (radiobuttons[i].isSelected())
				nrOfSwaps = i + 1;
			String s = "" + nrOfSwaps;
			textArea.setText(s);
		}
	}

	public static void setText(String text) {
		textArea.setText(text);
	}

	public static void setIconsForHand(Hand hand) {
		Card[] tempCards = hand.getCards();

		for (int index = 0; index < tempCards.length; index++) {
			setIcon(tempCards[index], index);
		}
	}

	public static void setIcon(Card card, int index) {
		if (card.getSuit() == Suit.SPADES) {
			switch (card.getValue()) {
			case 1:
				cards[index].setIcon(spadeCards[0]);
				break;
			case 2:
				cards[index].setIcon(spadeCards[1]);
				break;
			case 3:
				cards[index].setIcon(spadeCards[2]);
				break;
			case 4:
				cards[index].setIcon(spadeCards[3]);
				break;
			case 5:
				cards[index].setIcon(spadeCards[4]);
				break;
			case 6:
				cards[index].setIcon(spadeCards[5]);
				break;
			case 7:
				cards[index].setIcon(spadeCards[6]);
				break;
			case 8:
				cards[index].setIcon(spadeCards[7]);
				break;
			case 9:
				cards[index].setIcon(spadeCards[8]);
				break;
			case 10:
				cards[index].setIcon(spadeCards[9]);
				break;
			case 11:
				cards[index].setIcon(spadeCards[10]);
				break;
			case 12:
				cards[index].setIcon(spadeCards[11]);
				break;
			case 13:
				cards[index].setIcon(spadeCards[12]);
				break;
			}
		} else if (card.getSuit() == Suit.CLUBS) {
			switch (card.getValue()) {
			case 1:
				cards[index].setIcon(spadeCards[0]);
				break;
			case 2:
				cards[index].setIcon(spadeCards[1]);
				break;
			case 3:
				cards[index].setIcon(spadeCards[2]);
				break;
			case 4:
				cards[index].setIcon(spadeCards[3]);
				break;
			case 5:
				cards[index].setIcon(spadeCards[4]);
				break;
			case 6:
				cards[index].setIcon(spadeCards[5]);
				break;
			case 7:
				cards[index].setIcon(spadeCards[6]);
				break;
			case 8:
				cards[index].setIcon(spadeCards[7]);
				break;
			case 9:
				cards[index].setIcon(spadeCards[8]);
				break;
			case 10:
				cards[index].setIcon(spadeCards[9]);
				break;
			case 11:
				cards[index].setIcon(spadeCards[10]);
				break;
			case 12:
				cards[index].setIcon(spadeCards[11]);
				break;
			case 13:
				cards[index].setIcon(spadeCards[12]);
				break;
			}
		} else if (card.getSuit() == Suit.DIAMONDS) {
			switch (card.getValue()) {
			case 1:
				cards[index].setIcon(spadeCards[0]);
				break;
			case 2:
				cards[index].setIcon(spadeCards[1]);
				break;
			case 3:
				cards[index].setIcon(spadeCards[2]);
				break;
			case 4:
				cards[index].setIcon(spadeCards[3]);
				break;
			case 5:
				cards[index].setIcon(spadeCards[4]);
				break;
			case 6:
				cards[index].setIcon(spadeCards[5]);
				break;
			case 7:
				cards[index].setIcon(spadeCards[6]);
				break;
			case 8:
				cards[index].setIcon(spadeCards[7]);
				break;
			case 9:
				cards[index].setIcon(spadeCards[8]);
				break;
			case 10:
				cards[index].setIcon(spadeCards[9]);
				break;
			case 11:
				cards[index].setIcon(spadeCards[10]);
				break;
			case 12:
				cards[index].setIcon(spadeCards[11]);
				break;
			case 13:
				cards[index].setIcon(spadeCards[12]);
				break;
			}
		} else if (card.getSuit() == Suit.HEARTS) {
			switch (card.getValue()) {
			case 1:
				cards[index].setIcon(spadeCards[0]);
				break;
			case 2:
				cards[index].setIcon(spadeCards[1]);
				break;
			case 3:
				cards[index].setIcon(spadeCards[2]);
				break;
			case 4:
				cards[index].setIcon(spadeCards[3]);
				break;
			case 5:
				cards[index].setIcon(spadeCards[4]);
				break;
			case 6:
				cards[index].setIcon(spadeCards[5]);
				break;
			case 7:
				cards[index].setIcon(spadeCards[6]);
				break;
			case 8:
				cards[index].setIcon(spadeCards[7]);
				break;
			case 9:
				cards[index].setIcon(spadeCards[8]);
				break;
			case 10:
				cards[index].setIcon(spadeCards[9]);
				break;
			case 11:
				cards[index].setIcon(spadeCards[10]);
				break;
			case 12:
				cards[index].setIcon(spadeCards[11]);
				break;
			case 13:
				cards[index].setIcon(spadeCards[12]);
				break;
			}
		}
	}

	private void resetCheckboxes() {
		for (int i = 0; i < c.length; i++) {
			if (c[i].isSelected()) {
				c[i].doClick();
			}
		}
	}

	private void enableCheckboxes() {
		for (int i = 0; i < c.length; ++i) {
			c[i].setEnabled(true);
		}
	}

	private void disableCheckboxes() {
		for (int i = 0; i < c.length; ++i) {
			c[i].setEnabled(false);
		}
	}

	private void enableRadiobuttons() {
		for (int i = 0; i < 2; i++) {
			radiobuttons[i].setEnabled(true);
		}
	}
	
	private void disableRadiobuttons() {
		for (int i = 0; i < 2; i++) {
			radiobuttons[i].setEnabled(false);
		}
	}
}
