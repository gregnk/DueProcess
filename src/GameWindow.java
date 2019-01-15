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
	private JMenuItem notesItem = new JMenuItem("Notes");
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
		setResizable(false);
		
		// Build menu bar
		caseMenu.add(trialItem);
		caseMenu.add(caseInfoItem);
		caseMenu.add(notesItem);
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
		notesItem.addActionListener(this);
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

	public void switchScreen(String screenName) {
		switchScreen(screenName, false);
	}
	
	public void switchScreen(String screenName, boolean reset) {

		// Remove current screen
		remove(currentScreen);

		// Construct the next scene
		switch (screenName) {
		case "MainMenu":
			if (reset || mainMenuScreen == null) mainMenuScreen = new MainMenu(this);
			currentScreen = mainMenuScreen;
			break;
		case "EnterName":
			if (reset || enterNameScreen == null) enterNameScreen = new EnterName(this);
			currentScreen = enterNameScreen;
			break;
		case "Trial":
			if (reset || trialScreen == null) trialScreen = new Trial(currentCase, this);
			currentScreen = trialScreen;
			break;
		case "Intro":
			if (reset || introScreen == null) introScreen = new Intro(currentCase.getIntroText(), this);
			currentScreen = introScreen;
			break;
		case "GameEnd":
			break;
		case "CaseInfo":
			if (reset || caseInfoScreen == null) caseInfoScreen = new CaseInfo(currentCase.getCaseInfo(), this);
			currentScreen = caseInfoScreen;
			break;
		case "Witnesses":
			if (reset || witnessScreen == null) witnessScreen = new WitnessesScreen(currentCase.getWitnesses());
			currentScreen = witnessScreen;
			break;
		case "Evidence":
			if (reset || evidenceScreen == null) evidenceScreen = new EvidenceScreen(currentCase.getEvidence());
			currentScreen = evidenceScreen;
			break;
		case "Notes":
			ArrayList<String> testNotes = new ArrayList<String>();
			testNotes.add("12123123");
			testNotes.add("nadisfneawijj");
			
			if (reset || notesScreen == null) notesScreen = new Notes(testNotes, this);
			currentScreen = notesScreen;
			break;
		case "InputTest":
			inputTest = new InputTest();
			currentScreen = inputTest;
			break;
		default:
			System.err.printf("Invalid screen (%s)\n", screenName);
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

	public void loadNextCase() throws FileNotFoundException {
		caseNo++;
		loadCase();
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
		file.close();

		// Load witnesses
		file = new Scanner(new File("data/cases/" + currentCase.getCaseName() + "/Witnesses.csv"));
		file.useDelimiter(",");

		ArrayList<Witness> witnesses = new ArrayList<Witness>();

		while (file.hasNext()) {
			witnesses.add(new Witness(file.next(), file.next(), file.next()));
		}

		currentCase.setWitnesses(witnesses);
		file.close();

		// Load evidence
		file = new Scanner(new File("data/cases/" + currentCase.getCaseName() + "/Evidence.csv"));
		file.useDelimiter(",");

		ArrayList<Evidence> evidence = new ArrayList<Evidence>();

		while (file.hasNext()) {
			evidence.add(new Evidence(file.next(), file.next(), new ImageIcon("data/images/evidence/" + file.next())));
		}
		
		currentCase.setEvidence(evidence);
		file.close();

		System.out.println(currentCase.toString());
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
		
		else if (evt.getSource() == evidenceItem) {
			switchScreen("Evidence");
		}
		
		else if (evt.getSource() == notesItem) {
			switchScreen("Notes");
		}
		
		// Game menu
		if (evt.getSource() == quitItem) {
			int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit? You will lose all unsaved data.", "Warning", JOptionPane.YES_NO_OPTION);
			
			if (confirm == JOptionPane.YES_OPTION)
				switchScreen("MainMenu");
		}
	}
}
