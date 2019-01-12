import java.io.*;
import java.util.*;

public class SaveFile {
	private final static String SAVE_PATH = "data/save/";
	private final static String GAME_SAVE_FILE = "Game.csv";
	private final static String LOGS_SAVE_FILE = "Logs.csv";
	private final static String EVIDENCE_SAVE_FILE = "Evedence.csv";
	private final static String PROFILE_SAVE_FILE = "Profile.csv";
	
	public static void save(GameWindow game) throws FileNotFoundException {
		Formatter saveFile;
		
		// Profile
		saveFile = new Formatter(new File(SAVE_PATH + PROFILE_SAVE_FILE));
		saveFile.format("%s,", game.getUserProfile().getFirstName());
		saveFile.format("%s,", game.getUserProfile().getLastName());
		
		
		saveFile.close();
	}
	
	public static void load(GameWindow game) throws FileNotFoundException {
		Scanner saveFile;
		
		// Profile
		saveFile = new Scanner(new File(SAVE_PATH + PROFILE_SAVE_FILE));
		saveFile.useDelimiter(",");
		
		game.getUserProfile().setFirstName(saveFile.next());
		game.getUserProfile().setLastName(saveFile.next());
		
		saveFile.close();
	}
	
	public static boolean checkSaveFile() {
		File saveFile = new File(SAVE_PATH + PROFILE_SAVE_FILE);
		
		if (saveFile.exists())
			return true;
		else
			return false;
	}
}
