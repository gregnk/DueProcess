import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class CaseInfo extends JPanel implements ActionListener {
	private JLabel caseInfo;
	private JLabel header = new JLabel("Case Info");

	public CaseInfo(String text, GameWindow window) {
		setLayout(null);

		// Add header
		header.setBounds(10, 10, 755, 20);
		add(header);

		caseInfo = new JLabel("<html><body style='width: 575px;'>" + text + "</body></html>");
		caseInfo.setVerticalAlignment(SwingConstants.TOP);
		caseInfo.setBackground(Color.WHITE);
		caseInfo.setFont(new Font("Courier New", Font.PLAIN, 12));
		caseInfo.setOpaque(true);
		caseInfo.setBounds(10, 40, 755, 600);
		add(caseInfo);

	}

	@Override
	public void actionPerformed(ActionEvent evt) {

	}

}
