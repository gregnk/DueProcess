import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class EvidenceScreen extends JPanel implements ActionListener {
	private ArrayList<Evidence> evidence;
	private JLabel evidenceList = new JLabel("<html><body style='width: 755px;'>Name&#09;&#09;Description<br><br>");
	private JLabel header = new JLabel("Evidence");

	public EvidenceScreen(ArrayList<Evidence> evidence) {
		this.evidence = evidence;

		setLayout(null);

		// Add header
		header.setBounds(10, 10, 755, 20);
		add(header);

		// Add witness list JLabel
		evidenceList.setVerticalAlignment(SwingConstants.TOP);
		evidenceList.setBackground(Color.WHITE);
		evidenceList.setFont(new Font("Courier New", Font.PLAIN, 12));
		evidenceList.setOpaque(true);
		evidenceList.setBounds(10, 40, 755, 600);
		add(evidenceList);

		// Display all the witnesses in the file
		for (Evidence evidenceItem : evidence) {
			evidenceList.setText(evidenceList.getText() + evidenceItem.getName() + "&#09;&#09;" + evidenceItem.getDesc() + "<br>");;
		}

		evidenceList.setText(evidenceList.getText() + "</body></html>");
		repaint();
	}

	public void addEvedence(Evidence evidence) {

	}

	@Override
	public void actionPerformed(ActionEvent evt) {

	}

}
