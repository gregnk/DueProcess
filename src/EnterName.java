import javax.swing.*;

import java.awt.TrayIcon.MessageType;
import java.awt.event.*;
import java.io.FileNotFoundException;

public class EnterName extends JPanel implements ActionListener {
	private JLabel header = new JLabel("Enter your name");
	
	// User input
	private JLabel firstNameLabel = new JLabel("First name");
	private JTextField firstName = new JTextField();
	private JLabel lastNameLabel = new JLabel("Last name");
	private JTextField lastName = new JTextField();
	
	// Submit button
	private JButton submitButton = new JButton("Submit");
	
	private GameWindow window;
	
	public EnterName(GameWindow window) {
		this.window = window;
		
		header.setBounds(340, 40, 100, 20);
		add(header);
		
		firstName.setBounds(300, 80, 181, 20);
		add(firstName);
		lastName.setBounds(300, 110, 181, 20);
		add(lastName);
		
		firstNameLabel.setBounds(200, 80, 181, 20);
		add(firstNameLabel);
		lastNameLabel.setBounds(200, 110, 181, 20);
		add(lastNameLabel);
		
		submitButton.setBounds(325, 140, 100, 50);
		submitButton.addActionListener(this);
		add(submitButton);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		if (evt.getSource() == submitButton) {
			
			// Check if the name is empty
			if (firstName.getText() != "" && lastName.getText() != "") {
				
				// Set profile
				window.getUserProfile().setFirstName(firstName.getText());
				window.getUserProfile().setLastName(lastName.getText());
				
				
				// Save
				try {
					SaveFile.save(window);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				// Load trial intro
				
				try {
					window.loadCase();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				window.switchScreen("Intro");
			}
			
			else {
				JOptionPane.showMessageDialog(this, "Please enter both a first and last name", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
