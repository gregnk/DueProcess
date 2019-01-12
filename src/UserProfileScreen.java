import javax.swing.*;
import java.awt.event.*;

public class UserProfileScreen extends JPanel implements ActionListener {

	private UserProfile profile;
	private JLabel name;
	private JLabel level;
	private JLabel trials;
	
	public UserProfileScreen(UserProfile profile) {
		this.profile = profile;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}
	
}
