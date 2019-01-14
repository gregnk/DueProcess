import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.color.*;

import javax.swing.*;

public class Trial extends JPanel implements ActionListener {

	// List of previous game dialog
	private JLabel log = new JLabel("<html><body style='width: 755px;'>");
	private JScrollPane logPane = new JScrollPane(log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	// User input
	private JTextField inputResponse = new JTextField();

	// Trial dialog
	private ArrayList<String> dialog = new ArrayList<String>();
	private int part = 0;

	// List of possible outcomes
	private ArrayList<Outcome> outcomes = new ArrayList<Outcome>();

	// Proceed/Submit response button
	private JButton proceedButton = new JButton("Continue");

	private Case trialCase;

	private boolean canInput;

	private GameWindow window;

	public Trial(Case trialCase, GameWindow window) {
		this.trialCase = trialCase;
		this.window = window;

		setLayout(null);

		// Log
		log.setVerticalAlignment(SwingConstants.TOP);
		log.setBackground(Color.WHITE);
		log.setFont(new Font("Courier New", Font.PLAIN, 12));
		log.setOpaque(true);
		log.setBounds(0, 0, 755, 600);

		logPane.setBounds(10, 10, 755, 600);
		add(logPane);

		// User input
		inputResponse.setBounds(10, 620, 650, 30);
		inputResponse.setEnabled(false);
		add(inputResponse);

		// Proceed/Submit button
		proceedButton.setBounds(674, 620, 90, 30);
		proceedButton.addActionListener(this);
		add(proceedButton);

		try {
			loadDialog("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void loadDialog(String folder) throws FileNotFoundException {

		// Load dialog from file
		Scanner dialogFile;

		if (folder.equals(""))
			dialogFile = new Scanner(new File("data/cases/" + trialCase.getCaseName() + "/dialog/Dialog.csv"));
		else
			dialogFile = new Scanner(new File("data/cases/" + trialCase.getCaseName() + "/dialog/" + folder + "/Dialog.csv"));
		
		dialogFile.useDelimiter(",");

		// Reset dialog array
		dialog = new ArrayList<String>();
		part = 0;
		
		// Load dialog into the array
		while(dialogFile.hasNext())
			dialog.add(dialogFile.next());

		dialogFile.close();

		// Add the first part of the dialog to the JLabel
		log.setText(log.getText() + dialog.get(part) + "<br>");
		repaint();

		// Load outcomes
		Scanner outcomesFile;

		if (folder.equals(""))
			outcomesFile = new Scanner(new File("data/cases/" + trialCase.getCaseName() + "/dialog/Outcomes.csv"));
		else
			outcomesFile = new Scanner(new File("data/cases/" + trialCase.getCaseName() + "/dialog/" + folder + "/Outcomes.csv"));

		outcomesFile.useDelimiter(",");

		// Clear outcomes array
		outcomes = new ArrayList<Outcome>();

		// Get each outcome from the list
		while(outcomesFile.hasNext()) {
			outcomes.add(new Outcome(outcomesFile.next()));
		}

		// Load the keywords for each outcome
		for (Outcome outcome : outcomes) {
			System.out.println("data/cases/" + trialCase.getCaseName() + "/dialog/" + outcome.getNextDialog() + "/Keywords.csv");
			Scanner keywordsFile = new Scanner(new File("data/cases/" + trialCase.getCaseName() + "/dialog/" + outcome.getNextDialog() + "/Keywords.csv"));
			keywordsFile.useDelimiter(",");

			int words = 1;
			while (keywordsFile.hasNext()) {
				String keyword = keywordsFile.next();
				keyword = keyword.replace("\r", "");
				keyword = keyword.replace("\n", "");
				
				// Check if we are at the end of the line
				if (keyword.equals("__END")) {
					// End of line, increase words
					words++;
				}
				
				// If not, add the keyword
				else {
					double score = keywordsFile.nextDouble();
					outcome.addKeyword(keyword, score, words);
				}
			}
			
			keywordsFile.close();
		}

		outcomesFile.close();

	}

	public void submitResponse(String response) {
		
		// Generate the score for each outcome
		for (Outcome outcome : outcomes) {
			double score = 0;
			
			for (int words = 1; words <= 3; words++)
				score += (double) WordParser.generateOutcomeScore(response.split(" "), outcome, words);
			
			outcome.setScore(score);
		}
		
		// Sort the outcomes by score
		Collections.sort(outcomes, new Comparator<Outcome>() {
	        @Override
	        public int compare(Outcome outcome1, Outcome outcome2)
	        {
	        	Double score1 = outcome1.getScore();
	        	Double score2 = outcome2.getScore();
	        	
	            return score1.compareTo(score2);
	        }
	    });
		
		for  (Outcome outcome : outcomes) {
			System.out.println(outcome.toString());
		}
		
		// Load the outcome with the highest score
		try {
			loadDialog(outcomes.get(0).getNextDialog());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		canInput = false;
	}

	public void proceed() {
		// Display the next part of the dialog
		log.setText(log.getText() + dialog.get(++part) + "<br>");

		// Allow user input once done
		if (part == dialog.size() - 1) {
			canInput = true;
			inputResponse.setEnabled(true);
			proceedButton.setText("Submit");
		}

		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == proceedButton) {
			if (canInput)
				submitResponse(inputResponse.getText());
			else
				proceed();
		}
	}
}
