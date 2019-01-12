import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class GameWindow extends JFrame implements ActionListener {

	// Game screens
	private MainMenu mainMenuScreen;
	private EnterName enterNameScreen;
	private SelectCase selectCaseScreen;
	private Trial trialScreen;
	private Intro introScreen;
	private GameEnd gameEndScreen;
	private Notes notesScreen;
	private EvidenceScreen evidenceScreen;
	private LawDatabase lawDBScreen;
	private CaseInfo caseInfoScreen;
	private UserProfileScreen profileScreen;
	private HowToPlay howToPlayScreen;
	private WitnessesScreen witnessScreen;

	// Test screens
	private InputTest inputTest;
	
	// Current screen
	private JPanel currentScreen;
	
	// Menu bar
	private JMenuBar menuBar = new JMenuBar();
	
	// Case menu
	private JMenu caseMenu = new JMenu("Case");
	private JMenuItem trialItem = new JMenuItem("Trial");
	private JMenuItem caseInfoItem = new JMenuItem("Case Info");
	private JMenuItem witnessesItem = new JMenuItem("Witnesses");
	private JMenuItem evidenceItem = new JMenuItem("Evidence");
	private JMenuItem lawDBItem = new JMenuItem("Law Database");
	
	// Game menu
	private JMenu gameMenu = new JMenu("Game");
	private JMenuItem saveItem = new JMenuItem("Save");
	private JMenuItem loadItem = new JMenuItem("Load");
	private JMenuItem quitItem = new JMenuItem("Quit to main menu");

	private ArrayList<Law> laws;
	private Case currentCase = new Case();
	private ArrayList<String> sceneText;
	private UserProfile userProfile = new UserProfile();

	private int caseNo = 0;
	
	public GameWindow() {

		// Window settings
		setSize(800, 750);
		setTitle("Due Process");
		setLocationRelativeTo(null); // Center on screen
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Build menu bar
		caseMenu.add(trialItem);
		caseMenu.add(caseInfoItem);
		caseMenu.add(witnessesItem);
		caseMenu.add(evidenceItem);
		caseMenu.add(lawDBItem);
		
		gameMenu.add(saveItem);
		gameMenu.add(loadItem);
		gameMenu.add(quitItem);
		
		menuBar.add(caseMenu);
		menuBar.add(gameMenu);
		
		// Add menu bar action listeners
		trialItem.addActionListener(this);
		caseInfoItem.addActionListener(this);
		witnessesItem.addActionListener(this);
		evidenceItem.addActionListener(this);
		lawDBItem.addActionListener(this);
		saveItem.addActionListener(this);
		loadItem.addActionListener(this);
		quitItem.addActionListener(this);
		
		// Add and then hide menu bar
		setJMenuBar(menuBar);
		getJMenuBar().setVisible(false);
		
		// Display main menu
		currentScreen = new JPanel();
		add(currentScreen);
		//switchScreen("MainMenu");
		
		try {
			SaveFile.load(this);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			loadCase();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		switchScreen("Intro");
		
		setVisible(true);
	}

	public void switchScreen(String switchToScreen) {
		
		// Remove current screen
		remove(currentScreen);
		
		// Construct the next scene
		switch (switchToScreen) {
		case "MainMenu":
			mainMenuScreen = new MainMenu(this);
			currentScreen = mainMenuScreen;
			break;
		case "EnterName":
			enterNameScreen = new EnterName(this);
			currentScreen = enterNameScreen;
			break;
		case "Trial":
			trialScreen = new Trial(currentCase, this);
			currentScreen = trialScreen;
			break;
		case "Intro":
			introScreen = new Intro(currentCase.getIntroText(), this);
			currentScreen = introScreen;
			break;
		case "GameEnd":
			break;
		case "CaseInfo":
			caseInfoScreen = new CaseInfo(currentCase.getCaseInfo(), this);
			currentScreen = caseInfoScreen;
			break;
		case "InputTest":
			inputTest = new InputTest();
			currentScreen = inputTest;
			break;
		default:
			System.err.println("Invalid screen");
			break;
		}
		
		// Add the scene to the fame
		currentScreen.setBounds(0, 0, 800, 750);
		add(currentScreen);
		repaint();
	}

	public void win() {

	}

	public void gameOver() {

	}

	public void loadCase() throws FileNotFoundException {
		// Reset current case class
		currentCase = new Case();
		
		// Scan the cases CSV file for the folder
		Scanner file = new Scanner(new File("data/cases/Cases.csv"));
		file.useDelimiter(",");
		
		for (int c = 0; file.hasNext() && c <= caseNo; c++) {
			if (c == caseNo) {
				currentCase.setCaseName(file.next());
			}
		}
		
		file.close();
		
		// Load intro
		file = new Scanner(new File("data/cases/" + currentCase.getCaseName() + "/Intro.csv"));
		file.useDelimiter(",");
		
		ArrayList<String> introText = new ArrayList<String>();
		
		while (file.hasNext()) 
			introText.add(file.next());
		
		currentCase.setIntroText(introText);
		
		file.close();
		
		// Load case info
		file = new Scanner(new File("data/cases/" + currentCase.getCaseName() + "/CaseInfo.csv"));
		
		String caseInfoText = "";
		
		while (file.hasNext()) {
			caseInfoText += file.next() + " ";
		}
		
		currentCase.setCaseInfo(caseInfoText);
		
		System.out.println(currentCase.toString());
		
		file.close();
	}	
	
	public void displayMenuBar() {
		getJMenuBar().setVisible(true);
	}
	
	public void hideMenuBar() {
		getJMenuBar().setVisible(false);
	}
	
	public Case getCurrentCase() {
		return currentCase;
	}

	public void setCurrentCase(Case currentCase) {
		this.currentCase = currentCase;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		// Menu bar actions

        // Case menu
        if (evt.getSource() == trialItem) {
            switchScreen("Trial");
        }
        
        else if (evt.getSource() == caseInfoItem) {
            switchScreen("CaseInfo");
        }
        
        else if (evt.getSource() == witnessesItem) {
            switchScreen("Witnesses");
        }
	}
}
