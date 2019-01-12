import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class LawDatabase extends JPanel implements ActionListener {
	
	private ArrayList<Law> laws;
	private ArrayList<JLabel> lawList;
	
	public LawDatabase(ArrayList<Law> laws) {
		this.laws = laws;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		
	}
	
}
