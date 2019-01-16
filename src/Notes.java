import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

public class Notes extends JPanel implements ActionListener {
	private JLabel header = new JLabel("Notes");
	private ArrayList<JLabel> notesLabel = new ArrayList<JLabel>();
	private ArrayList<JButton> deleteNoteButtons = new ArrayList<JButton>();
	private ArrayList<String> notes;
	private JTextField noteInput = new JTextField();
	private JButton addNoteButton = new JButton("Add note");
	
	private GameWindow window;
	
	public Notes(ArrayList<String> notes, GameWindow window) {
		
		this.notes = notes;
		
		// Setup each note
		for (String note : notes) {
			notesLabel.add(new JLabel("<html><body style='width: 755px;'>" + note));
			deleteNoteButtons.add(new JButton("Delete note"));
		}
		
		// Add each note to the panel
		int x = 10;
		int y = 10;
		
		for(JLabel note : notesLabel) {
			note.setBounds(x, y, 755, 30);
			add(note);
			
			y += 20;
		}
		
		// Add delete buttons
		
		// Add user input
//		noteInput.setBounds(10, 620, 650, 30);
//		add(noteInput);
//		
//		addNoteButton.setBounds(674, 620, 90, 30);
//		addNoteButton.addActionListener(this);
//		add(addNoteButton);
	}
	
	public void addNote(String text) {
		
	}
	
	public void deleteNote(int id) {
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		
	}
}
