import java.util.*;

public class UserProfile {
	private String firstName;
	private String lastName;
	private int level = 0;
	private ArrayList<String> casesPlayed = new ArrayList<String>();
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public ArrayList<String> getCasesPlayed() {
		return casesPlayed;
	}
	public void setCasesPlayed(ArrayList<String> casesPlayed) {
		this.casesPlayed = casesPlayed;
	}
	
	@Override
	public String toString() {
		return "UserProfile [firstName=" + firstName + ", lastName=" + lastName + ", level=" + level + ", casesPlayed="
				+ casesPlayed + "]";
	}
	
	
}
