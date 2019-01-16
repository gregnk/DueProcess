import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class HowToPlay extends JPanel implements ActionListener {
	private JLabel header = new JLabel("How To Play");
	private ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
	private JLabel imagesLabel = new JLabel();
	private JButton backButton = new JButton("Previous page");
	private JButton nextButton = new JButton("Next page");
	private JButton backToMainMenuButton = new JButton("Back to main menu");
	private int part = 0;

	private GameWindow window;
	
	public HowToPlay(GameWindow window, boolean showBackToMainMenu) {
		this.window = window;
		
		// Header
		header.setBounds(30, 10, 755, 20);
		add(header);

		// Images
		images.add(new ImageIcon("data/images/PlaceholderWhite.png"));
		images.add(new ImageIcon("data/images/PlaceholderBlack.png"));
		images.add(new ImageIcon("data/images/PlaceholderWhite.png"));

		// Images panel
		imagesLabel.setBounds(340, 10, 755, 600);
		imagesLabel.setIcon(images.get(0));
		add(imagesLabel);

		// Back button
		backButton.setBounds(40, 620, 120, 30);
		backButton.addActionListener(this);
		backButton.setEnabled(false);
		add(backButton);

		// Next button
		nextButton.setBounds(620, 620, 120, 30);
		nextButton.addActionListener(this);
		add(nextButton);

		// Back to main menu button
		if (showBackToMainMenu) {
			backToMainMenuButton.setBounds(40, 660, 150, 30);
			backToMainMenuButton.addActionListener(this);
			add(backToMainMenuButton);
		}
	}

	private void backPage() {
		if (part - 1 >= 0) {
			if (part - 1 == 0) {
				backButton.setEnabled(false);
			}

			if (part - 1 < images.size()) {
				nextButton.setEnabled(true);
			}

			imagesLabel.setIcon(images.get(--part));
			repaint();
		}
	}

	private void nextPage() {
		if (part + 1 < images.size()) {
			if (part + 1 == images.size() - 1) {
				nextButton.setEnabled(false);
			}

			if (part + 1 > 0) {
				backButton.setEnabled(true);
			}

			imagesLabel.setIcon(images.get(++part));
			repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource() == backButton)
			backPage();

		else if (evt.getSource() == nextButton)
			nextPage();
		
		else if (evt.getSource() == backToMainMenuButton)
			window.switchScreen("MainMenu");
	}
}
