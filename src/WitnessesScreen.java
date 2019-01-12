import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class WitnessesScreen extends JPanel implements ActionListener {
	
	private JLabel header = new JLabel("Witnesses");
	private ArrayList<Witness> witnesses;
	private JLabel witnessList = new JLabel("<html><body style='width: 755px;'>Name&#09;&#09;Side&#09;&#09;Description<br><br>");
	
	public WitnessesScreen(ArrayList<Witness> witnesses) {
		setLayout(null);
		
		this.witnesses = witnesses;
		
		// Add header
		header.setBounds(10, 10, 755, 20);
		add(header);
		
		// Add witness list JLabel
		witnessList.setVerticalAlignment(SwingConstants.TOP);
		witnessList.setBackground(Color.WHITE);
		witnessList.setFont(new Font("Courier New", Font.PLAIN, 12));
		witnessList.setOpaque(true);
		witnessList.setBounds(10, 40, 755, 600);
		add(witnessList);
		
		// Display all the witnesses in the file
		for (Witness witness : witnesses) {
			witnessList.setText(witnessList.getText() + witness.getName() + "&#09;&#09;" + witness.getSide() + "&#09;&#09;" + witness.getDesc() + "<br>");;
		}
		
		witnessList.setText(witnessList.getText() + "</body></html>");
		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		
	}
}
