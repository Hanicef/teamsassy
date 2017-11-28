package teamsassy;

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

	public int nrOfSwaps = 0;

	private JPanel buttonPanel = new JPanel();

	private JButton swap = new JButton("Swap");
	private JButton start = new JButton("Start");
	private JButton hold = new JButton("Hold");
	private JRadioButton radio1 = new JRadioButton("1 swap", true);
	private JRadioButton radio2 = new JRadioButton("2 swap", false);
	private ButtonGroup group = new ButtonGroup();

	private JPanel checkboxPanel = new JPanel();

	private JCheckBox c1 = new JCheckBox();
	private JCheckBox c2 = new JCheckBox();
	private JCheckBox c3 = new JCheckBox();
	private JCheckBox c4 = new JCheckBox();
	private JCheckBox c5 = new JCheckBox();

	private JPanel textMessagePanel = new JPanel();
	private JTextArea textArea = new JTextArea(3, 35);

	private JPanel cardPanel = new JPanel();

	private JLabel card1 = new JLabel();
	private JLabel card2 = new JLabel();
	private JLabel card3 = new JLabel();
	private JLabel card4 = new JLabel();
	private JLabel card5 = new JLabel();

	private ImageIcon spadesAce = new ImageIcon("src/images/Ace_of_spades.png");

	public Gui() {
		super("VideoPoker");
		Font buttonFont = new Font("Helvetica", Font.BOLD, 24);
		Dimension buttonDim = new Dimension(120, 55);
		start.setFont(buttonFont);
		start.setPreferredSize(buttonDim);
		start.addActionListener(this);
		swap.setFont(buttonFont);
		swap.setPreferredSize(buttonDim);
		swap.addActionListener(this);
		hold.setFont(buttonFont);
		hold.setPreferredSize(buttonDim);
		hold.addActionListener(this);

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
		buttonPanel.add(radio1, buttonPanelGBC);
		buttonPanelGBC.gridy = 1;
		buttonPanel.add(radio2, buttonPanelGBC);
		group.add(radio1);
		group.add(radio2);
		radio1.addActionListener(this);
		radio2.addActionListener(this);

		checkboxPanel.setLayout(new GridBagLayout());
		GridBagConstraints checkboxPanelGBC = new GridBagConstraints();
		checkboxPanelGBC.insets = new Insets(0, 40, 0, 40);
		checkboxPanelGBC.gridx = 1;
		checkboxPanel.add(c1, checkboxPanelGBC);
		checkboxPanelGBC.gridx = 2;
		checkboxPanel.add(c2, checkboxPanelGBC);
		checkboxPanelGBC.gridx = 3;
		checkboxPanel.add(c3, checkboxPanelGBC);
		checkboxPanelGBC.gridx = 4;
		checkboxPanel.add(c4, checkboxPanelGBC);
		checkboxPanelGBC.gridx = 5;
		checkboxPanel.add(c5, checkboxPanelGBC);
		c1.addActionListener(this);
		c2.addActionListener(this);
		c3.addActionListener(this);
		c4.addActionListener(this);
		c5.addActionListener(this);

		textArea.setOpaque(false);
		textArea.setFont(new Font("Helvetica", Font.BOLD, 18));
		textArea.setText("Du fick kåk, 1000 poäng till dig!");
		textMessagePanel.add(textArea);

		card1.setIcon(spadesAce);
		card2.setIcon(spadesAce);
		card3.setIcon(spadesAce);
		card4.setIcon(spadesAce);
		card5.setIcon(spadesAce);

		cardPanel.setLayout(new GridBagLayout());
		GridBagConstraints cardPanelGBC = new GridBagConstraints();

		cardPanelGBC.insets = new Insets(5, 5, 5, 5);
		cardPanelGBC.gridx = 1;
		cardPanel.add(card1, cardPanelGBC);
		cardPanelGBC.gridx = 2;
		cardPanel.add(card2, cardPanelGBC);
		cardPanelGBC.gridx = 3;
		cardPanel.add(card3, cardPanelGBC);
		cardPanelGBC.gridx = 4;
		cardPanel.add(card4, cardPanelGBC);
		cardPanelGBC.gridx = 5;
		cardPanel.add(card5, cardPanelGBC);
		setLayout(new GridBagLayout());
		GridBagConstraints frameGBC = new GridBagConstraints();

		frameGBC.insets = new Insets(10, 0, 10, 0);

		frameGBC.gridx = 1;
		frameGBC.gridy = 1;
		frameGBC.gridwidth = 5;
		frameGBC.gridheight = 1;
		add(textArea, frameGBC);

		frameGBC.gridx = 1;
		frameGBC.gridy = 2;
		frameGBC.gridwidth = 5;
		frameGBC.gridheight = 3;
		add(cardPanel, frameGBC);

		frameGBC.gridx = 1;
		frameGBC.gridy = 6;
		frameGBC.gridwidth = 5;
		frameGBC.gridheight = 1;
		add(checkboxPanel, frameGBC);

		frameGBC.gridx = 1;
		frameGBC.gridy = 7;
		frameGBC.gridwidth = 5;
		frameGBC.gridheight = 1;
		add(buttonPanel, frameGBC);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == start) {
			// lägg in anrop till startmetoden här
			textArea.setText("START");
		}
		if (e.getSource() == swap) {
			// lägg in anrop till swapmetoden här
			textArea.setText("SWAP");
		}
		if (e.getSource() == hold) {
			// lägg in anrop till holdmetoden här
			textArea.setText("HOLD");
		}
		if (c1.isSelected()) {
			//Markera kort 1 för byte
		}
		if (!c1.isSelected()) {
			//Avmarkera kort 1 för byte
		}
		if (c2.isSelected()) {
			//Markera kort 2 för byte
		}
		if (!c2.isSelected()) {
			//Avmarkera kort 2 för byte
		}
		if (c3.isSelected()) {
			//Markera kort 3 för byte
		}
		if (!c3.isSelected()) {
			//Avmarkera kort 3 för byte
		}
		if (c4.isSelected()) {
			//Markera kort 4 för byte
		}
		if (!c4.isSelected()) {
			//Avmarkera kort 4 för byte
		}
		if (c5.isSelected()) {
			//Markera kort 5 för byte
		}
		if (!c5.isSelected()) {
			//Avmarkera kort 5för byte
		}
		if (radio1.isSelected()) {
			textArea.setText("radio1 is selected");
		}
		if(radio2.isSelected()) {
			textArea.setText("radio2 is selected");
		}
	}

}
