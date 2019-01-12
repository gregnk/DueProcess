import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class CaseInfo extends JPanel implements ActionListener {
	private JLabel caseInfo;
	private JLabel header;
	 
	public CaseInfo(String text, GameWindow window) {
		setLayout(null);
		
		caseInfo = new JLabel("<html><body style='text-align: center;'>" + text + "</body></html>");
		caseInfo.setBounds(150, 40, 1000, 200);
		add(caseInfo);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		
	}
	
}
