import java.awt.event.*;
import java.io.FileNotFoundException;

import javax.swing.*;

public class MainMenu extends JPanel implements ActionListener {
	private JLabel title = new JLabel("Due Process");
	private JLabel footer = new JLabel("Gregory Karastergios 2019");
	
	// Buttons
	private JButton newGameButton = new JButton("New game");
	private JButton continueButton = new JButton("Continue game");
	private JButton howToPlayButton = new JButton("How to play");
	
	private GameWindow window;
	
	public MainMenu(GameWindow window) {
		
		// TODO: Make this look better
		this.window = window;
		setLayout(null);
		
		// Title
		title.setBounds(350, 40, 100, 20);
		add(title);
		
		// New game
		newGameButton.setBounds(150, 200, 150, 100);
		newGameButton.addActionListener(this);
		add(newGameButton);
		
		// Continue
		continueButton.setBounds(450, 200, 150, 100);
		continueButton.addActionListener(this);
		add(continueButton);
		
		// How to play
		howToPlayButton.setBounds(310, 400, 150, 100);
		howToPlayButton.addActionListener(this);
		add(howToPlayButton);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		// New game
		if (evt.getSource() == newGameButton) {
			
			
			// Check for save file
			if (SaveFile.checkSaveFile()) {
				
				// Confirm overwritting the current save file
				int confirm = JOptionPane.showConfirmDialog(this, "A save file already exists, overwrite?", "Warning", JOptionPane.YES_NO_OPTION);
				
				// The user cancels
				if (confirm == JOptionPane.NO_OPTION)
					return;
			}
			
			try {
				window.loadCase();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			//window.switchScreen("EnterName");
			window.switchScreen("Intro");
		}
		
		// Continue
		if (evt.getSource() == continueButton) {
			
			if (SaveFile.checkSaveFile())
				JOptionPane.showMessageDialog(this, "No save file exists", "Error", JOptionPane.INFORMATION_MESSAGE);
			
			// Load save
			try {
				SaveFile.load(window);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			
		}
		
		// How to play
		if (evt.getSource() == howToPlayButton) {
			window.switchScreen("HowToPlayM");
		}
	}
}
