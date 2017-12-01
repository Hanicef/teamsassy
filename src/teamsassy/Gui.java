package teamsassy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Gui extends JFrame implements ActionListener {

	// Skapa massa variabler som behövs
	Videopoker videopoker = new Videopoker(1);

	private int nrOfSwaps = 1;
	private int swapCount = 0;
	private static int lastbet = 0;

	private JPanel buttonPanel = new JPanel();
	private JButton swap = new JButton("Swap");
	private JButton start = new JButton("Start");
	private JButton hold = new JButton("Call");

	private JRadioButton[] radiobuttons = new JRadioButton[] { new JRadioButton(" 1 swap ", true),
			new JRadioButton(" 2 swaps", false) };
	private ButtonGroup group = new ButtonGroup();

	private JPanel checkboxPanel = new JPanel();
	private JCheckBox[] c = new JCheckBox[5];

	private JPanel textMessagePanel = new JPanel();
	private static JTextArea textMessageArea = new JTextArea(2, 20);
	private static JTextArea moneyLeft = new JTextArea("0", 1, 4);
	private JComponent[] textAreas = new JTextArea[] { new JTextArea("money left:", 1, 10),
			new JTextArea("bet:", 1, 4) };
	private static JTextField betField = new JTextField(4);

	private JPanel cardPanel = new JPanel();

	private static JLabel[] cards = new JLabel[] { new JLabel(), new JLabel(), new JLabel(), new JLabel(),
			new JLabel() };
	
	// sökvägar för kortikonerna
	private ImageIcon back = new ImageIcon("src/images/back.png");

	private static ImageIcon[] spadeCards = new ImageIcon[] { new ImageIcon("src/images/ace_of_spades.png"),
			new ImageIcon("src/images/2_of_spades.png"), new ImageIcon("src/images/3_of_spades.png"),
			new ImageIcon("src/images/4_of_spades.png"), new ImageIcon("src/images/5_of_spades.png"),
			new ImageIcon("src/images/6_of_spades.png"), new ImageIcon("src/images/7_of_spades.png"),
			new ImageIcon("src/images/8_of_spades.png"), new ImageIcon("src/images/9_of_spades.png"),
			new ImageIcon("src/images/10_of_spades.png"), new ImageIcon("src/images/knight_of_spades.png"),
			new ImageIcon("src/images/queen_of_spades.png"), new ImageIcon("src/images/King_of_spades.png") };

	private static ImageIcon[] clubCards = new ImageIcon[] { new ImageIcon("src/images/ace_of_clubs.png"),
			new ImageIcon("src/images/2_of_clubs.png"), new ImageIcon("src/images/3_of_clubs.png"),
			new ImageIcon("src/images/4_of_clubs.png"), new ImageIcon("src/images/5_of_clubs.png"),
			new ImageIcon("src/images/6_of_clubs.png"), new ImageIcon("src/images/7_of_clubs.png"),
			new ImageIcon("src/images/8_of_clubs.png"), new ImageIcon("src/images/9_of_clubs.png"),
			new ImageIcon("src/images/10_of_clubs.png"), new ImageIcon("src/images/knight_of_clubs.png"),
			new ImageIcon("src/images/queen_of_clubs.png"), new ImageIcon("src/images/king_of_clubs.png") };

	private static ImageIcon[] diamondCards = new ImageIcon[] { new ImageIcon("src/images/ace_of_diamonds.png"),
			new ImageIcon("src/images/2_of_diamonds.png"), new ImageIcon("src/images/3_of_diamonds.png"),
			new ImageIcon("src/images/4_of_diamonds.png"), new ImageIcon("src/images/5_of_diamonds.png"),
			new ImageIcon("src/images/6_of_diamonds.png"), new ImageIcon("src/images/7_of_diamonds.png"),
			new ImageIcon("src/images/8_of_diamonds.png"), new ImageIcon("src/images/9_of_diamonds.png"),
			new ImageIcon("src/images/10_of_diamonds.png"), new ImageIcon("src/images/knight_of_diamonds.png"),
			new ImageIcon("src/images/queen_of_diamonds.png"), new ImageIcon("src/images/king_of_diamonds.png") };

	private static ImageIcon[] heartCards = new ImageIcon[] { new ImageIcon("src/images/ace_of_Hearts.png"),
			new ImageIcon("src/images/2_of_hearts.png"), new ImageIcon("src/images/3_of_hearts.png"),
			new ImageIcon("src/images/4_of_hearts.png"), new ImageIcon("src/images/5_of_hearts.png"),
			new ImageIcon("src/images/6_of_hearts.png"), new ImageIcon("src/images/7_of_hearts.png"),
			new ImageIcon("src/images/8_of_hearts.png"), new ImageIcon("src/images/9_of_hearts.png"),
			new ImageIcon("src/images/10_of_hearts.png"), new ImageIcon("src/images/knight_of_hearts.png"),
			new ImageIcon("src/images/queen_of_hearts.png"), new ImageIcon("src/images/king_of_hearts.png") };

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

		// Ställ in och lägg till textAreas
		for (int i = 0; i < textAreas.length; i++) {
			textAreas[i].setOpaque(false);
			// textAreas[i].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			// textAreas[i].setFont(new Font("Helvetica", Font.BOLD, 12));
		}

		moneyLeft.setOpaque(false);
		textMessageArea.setOpaque(false);
		textMessageArea.setFont(new Font("Helvetica", Font.BOLD, 18));
		textMessageArea.setText("Starttext");
		betField.addActionListener(this);

		// Adda textfälten till textpanelen
		textMessagePanel.setPreferredSize(new Dimension(550, 100));
		textMessagePanel.setLayout(new GridBagLayout());
		GridBagConstraints textMessagePanelGBC = new GridBagConstraints();
		textMessagePanelGBC.gridx = 1;
		textMessagePanelGBC.gridy = 2;
		// textMessagePanelGBC.gridwidth = 2;
		// textMessagePanelGBC.gridheight = 2;
		textMessagePanel.add(textMessageArea, textMessagePanelGBC);

		textMessagePanelGBC.gridx = 3;
		textMessagePanelGBC.gridy = 1;
		textMessagePanelGBC.gridwidth = 1;
		textMessagePanelGBC.gridwidth = 1;
		textMessagePanel.add(textAreas[0], textMessagePanelGBC);

		textMessagePanelGBC.gridx = 4;
		textMessagePanel.add(moneyLeft, textMessagePanelGBC);

		textMessagePanelGBC.gridx = 3;
		textMessagePanelGBC.gridy = 2;
		textMessagePanel.add(textAreas[1], textMessagePanelGBC);

		textMessagePanelGBC.gridx = 4;
		textMessagePanel.add(betField, textMessagePanelGBC);

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

		// set layout för frame och adda komponenter
		setLayout(new GridBagLayout());
		GridBagConstraints frameGBC = new GridBagConstraints();
		frameGBC.insets = new Insets(10, 0, 10, 0);
		// Adda text i framen
		frameGBC.gridx = 1;
		frameGBC.gridy = 1;
		frameGBC.gridwidth = 5;
		frameGBC.gridheight = 1;
		add(textMessagePanel, frameGBC);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	// Actionlistener
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == start) {
			// TODO: lägg in anrop till startmetoden här
			start.setEnabled(false);
			swap.setEnabled(true);
			hold.setEnabled(true);
			betField.setEnabled(false);
			enableCheckboxes();
			disableRadiobuttons();
			videopoker.start();
			setIconsForHand(videopoker.getHand(0));
			setTextMessage("");

		} else if (e.getSource() == swap) {
			// TODO: lägg in anrop till swapmetoden här
			boolean[] mask = new boolean[] { c[0].isSelected(), c[1].isSelected(), c[2].isSelected(), c[3].isSelected(),
					c[4].isSelected(), };
			videopoker.swapCards(mask);
			setIconsForHand(videopoker.getHand(0));
			checkNrOfSwaps();

		} else if (e.getSource() == hold) {
			// TODO: lägg in anrop till holdmetoden här
			start.setEnabled(true);
			hold.setEnabled(false);
			swap.setEnabled(false);
			betField.setEnabled(true);
			resetCheckboxes();
			disableCheckboxes();
			swapCount = 0;
			enableRadiobuttons();
			videopoker.hold();
			resetCardIcons();
			betField.setText("");
		}
		// tar hand om inmatningarna i betfield
		else if (e.getSource() == betField) {
			String s = betField.getText();
			try {
				setTextMessage("Du bettar " + s);
			} catch (Exception e1) {
				setTextMessage("Ogiltig inmatning");
			}
		}

		// Här väljer vi hur många swaps man får göra
		for (int i = 0; i < 2; i++) {
			if (radiobuttons[i].isSelected())
				nrOfSwaps = i + 1;
		}

	}

	private void checkNrOfSwaps() {
		swapCount++;
		if (nrOfSwaps == swapCount) {
			resetCheckboxes();
			swap.setEnabled(false);
			for(int i = 0; i < c.length; i++) {
				c[i].setEnabled(false);
			}
		} else {
			resetCheckboxes();
		}
	}

	public static void setTextMessage(String text) {
		textMessageArea.setText(text);
	}

	// Sätter hur mycket pengar som finns efter att man spelar en runda
	public static void setMoneyLeft(int moneyLeft) {
		Gui.moneyLeft.setText(Integer.toString(moneyLeft));
		lastbet = moneyLeft;
	}

	// Hämtar ut vad användaren vill betta
	public static int getBet() {
		try {
			
		return Integer.parseInt(Gui.betField.getText());
		}catch(NumberFormatException e) {
			return lastbet;
		}
	}

	private void setIconsForHand(Hand hand) {
		Card[] tempCards = hand.getCards();

		for (int index = 0; index < tempCards.length; index++) {
			setIcon(tempCards[index], index);
		}
	}

	private void setIcon(Card card, int index) {
		if (card.getSuit() == Suit.SPADES) {
			cards[index].setIcon(spadeCards[card.getValue() - 1]);
		} else if (card.getSuit() == Suit.CLUBS) {
			cards[index].setIcon(clubCards[card.getValue() - 1]);
		} else if (card.getSuit() == Suit.DIAMONDS) {
			cards[index].setIcon(diamondCards[card.getValue() - 1]);
		} else if (card.getSuit() == Suit.HEARTS) {
			cards[index].setIcon(heartCards[card.getValue() - 1]);
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

	public void resetCardIcons() {
		for (int i = 0; i < cards.length; i++) {
			cards[i].setIcon(back);
		}
	}

        public void save() {
                File file = new File("save.game");
                try {
                    FileOutputStream fs = new FileOutputStream(file);
                    ObjectOutputStream os = new ObjectOutputStream(fs);
    
                    os.writeObject(videopoker);
                    os.close();
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        public void load() {
                File file = new File("save.game");
                try {
                FileInputStream fs = new FileInputStream(file);
                ObjectInputStream os = new ObjectInputStream(fs);

                videopoker = (Videopoker)os.readObject();
                os.close();
                fs.close();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
        }
}
