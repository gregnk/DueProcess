import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class WitnessesScreen extends JPanel implements ActionListener {
	
	private ArrayList<Witness> witnesses;
	private ArrayList<JLabel> witnessList;
	
	public WitnessesScreen(ArrayList<Witness> witnesses) {
		this.witnesses = witnesses;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		
	}
}
