import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.color.*;

import javax.swing.*;

public class Trial extends JPanel implements ActionListener {
	
	// The image to be displayed representing the dialog
	private ImageIcon image;
	
	// List of previous game dialog
	private JLabel log;
	
	// User input
	private JTextField inputResponse;
	
	// List of possible outcomes
	private ArrayList<Outcome> outcomes = new ArrayList<Outcome>();
	
	// Proceed/Submit response button
	private JButton proceedButton;
	
	// Buttons
	private JButton evidenceButton;
	private JButton notesButton;
	
	private Case trialCase;
	
	private boolean canInput;
	
	private GameWindow window;
	
	public Trial(Case trialCase, GameWindow window) {
		this.trialCase = trialCase;
		this.window = window;
		
		setLayout(null);
		
		log = new JLabel("oapdsfmpoadsmfpomasdpofmopadsfmpomadspofm");
		log.setVerticalAlignment(SwingConstants.TOP);
		log.setBackground(Color.WHITE);
		log.setFont(new Font("Courier New", Font.PLAIN, 12));
		log.setOpaque(true);
		log.setBounds(10, 10, 755, 600);
		
		add(log);
	}
	
	public void loadDialog(String fileName) throws FileNotFoundException {
		
	}
	
	public double generateOutcomeScore(String[] response, String[] keywords, int pos, int words) {
		return 5;
	}
	
	public void submitResponse(String response) {
		
	}
	
	public void proceed() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		
	}
}
