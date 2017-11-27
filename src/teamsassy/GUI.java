package teamsassy;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUI extends JFrame implements ActionListener {

	JPanel buttonPanel = new JPanel();

	JButton swap = new JButton("Swap");
	JButton start = new JButton("Start");
	JButton hold = new JButton("Hold");
	
	JPanel checkboxPanel = new JPanel();
	
	JCheckBox c1 = new JCheckBox();
	JCheckBox c2 = new JCheckBox();
	JCheckBox c3 = new JCheckBox();
	JCheckBox c4 = new JCheckBox();
	JCheckBox c5 = new JCheckBox();
	
	JPanel textMessagePanel = new JPanel();
	JTextArea textArea = new JTextArea(3, 35);
	
	JPanel cardPanel = new JPanel();
	
	JLabel card1 = new JLabel();
	JLabel card2 = new JLabel();
	JLabel card3 = new JLabel();
	JLabel card4 = new JLabel();
	JLabel card5 = new JLabel();
	
	ImageIcon spadesAce = new ImageIcon("src/images/Ace_of_spades.png");
	
	public GUI() {
		Font buttonFont = new Font("Helvetica", Font.BOLD, 24);
		Dimension buttonDim = new Dimension(120, 55);
		start.setFont(buttonFont);
		start.setPreferredSize(buttonDim);
		swap.setFont(buttonFont);
		swap.setPreferredSize(buttonDim);
		hold.setFont(buttonFont);
		hold.setPreferredSize(buttonDim);
		
		buttonPanel.setLayout(new GridBagLayout());
		GridBagConstraints buttonPanelGBC = new GridBagConstraints(); 
		buttonPanelGBC.insets = new Insets(0, 25, 0, 25);
		buttonPanelGBC.gridx = 1;
		buttonPanel.add(start, buttonPanelGBC);
		buttonPanelGBC.gridx = 2;
		buttonPanel.add(swap, buttonPanelGBC);
		buttonPanelGBC.gridx = 3;
		buttonPanel.add(hold, buttonPanelGBC);
		
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
		// TODO Auto-generated method stub
		
	}

}



