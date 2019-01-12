import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class InputTest extends JPanel implements ActionListener {
	
	private ArrayList<Outcome> outcomes = new ArrayList<Outcome>();
	private JTextField textInput = new JTextField();
	private JButton submitButton = new JButton("Submit");
	
	public InputTest() {
		setLayout(null);
		
		outcomes.add(new Outcome("asdnfikjn"));
		outcomes.get(0).addKeyword("Eggs", 5, 1);
		outcomes.get(0).addKeyword("Hi", 1, 1);
		outcomes.get(0).addKeyword("Balls", 1, 1);
		
		
		outcomes.get(0).addKeyword("Two words", 3, 2);
		outcomes.get(0).addKeyword("What the fuck", 7, 3);
		
		textInput.setBounds(340, 40, 100, 20);
		add(textInput);
		
		submitButton.setBounds(325, 140, 100, 50);
		submitButton.addActionListener(this);
		add(submitButton);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		if (evt.getSource() == submitButton) {
			String[] words = textInput.getText().split(" ");
			
			for (Outcome outcome : outcomes) {
				System.out.println(WordParser.generateOutcomeScore(words, outcome, 2));
			}
		}
		
	}
}
