import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class Intro extends JPanel implements ActionListener {
	
	private JButton continueButton = new JButton("Continue");
	
	private ArrayList<String> text;
	private JLabel textLabel;
	private int part = 0;
	
	private GameWindow window;

	public Intro(ArrayList<String> text, GameWindow window) {
		setLayout(null);

		this.text = text;
		this.window = window;
		
		// Intro text
		textLabel = new JLabel("<html><body style='width: 575px;text-align:center'>" + text.get(0) + "</body></html>");
		textLabel.setBounds(0, 40, 755, 20);
		add(textLabel);

		// Continue button
		continueButton.setBounds(326, 200, 100, 50);
		continueButton.addActionListener(this);
		add(continueButton);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource() == continueButton) {
			
			// Display the next part
			if (part < text.size() - 1) {
				textLabel.setText("<html><body style='width: 575px;text-align:center'>" + text.get(++part) + "</body></html>");
				
				if (part == text.size() - 1) {
					continueButton.setText("Go to trial");
				}
			}
			
			else {
				window.displayMenuBar();
				window.switchScreen("Trial");
			}
		}

	}
}
