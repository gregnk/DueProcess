import java.util.*;

public class Case {
	private String caseName;
	private ArrayList<String> introText = new ArrayList<String>();
	private String caseInfo;
	private ArrayList<Outcome> outcomes = new ArrayList<Outcome>();
	private ArrayList<Witness> witnesses = new ArrayList<Witness>();
	private ArrayList<String> notes = new ArrayList<String>();
	private ArrayList<Evidence> evidence = new ArrayList<Evidence>();
	
	public String getCaseName() {
		return caseName;
	}


	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}


	public ArrayList<String> getIntroText() {
		return introText;
	}


	public void setIntroText(ArrayList<String> introText) {
		this.introText = introText;
	}


	public String getCaseInfo() {
		return caseInfo;
	}


	public void setCaseInfo(String caseInfo) {
		this.caseInfo = caseInfo;
	}


	public ArrayList<Outcome> getOutcomes() {
		return outcomes;
	}


	public void setOutcomes(ArrayList<Outcome> outcomes) {
		this.outcomes = outcomes;
	}


	public ArrayList<Witness> getWitnesses() {
		return witnesses;
	}


	public void setWitnesses(ArrayList<Witness> witnesses) {
		this.witnesses = witnesses;
	}


	public ArrayList<String> getNotes() {
		return notes;
	}


	public void setNotes(ArrayList<String> notes) {
		this.notes = notes;
	}


	public ArrayList<Evidence> getEvidence() {
		return evidence;
	}


	public void setEvidence(ArrayList<Evidence> evidence) {
		this.evidence = evidence;
	}


	@Override
	public String toString() {
		return "Case [caseName=" + caseName + ", introText=" + introText + ", caseInfo=" + caseInfo + ", outcomes="
				+ outcomes + ", witnesses=" + witnesses + ", notes=" + notes + ", evidence=" + evidence + "]";
	}
}
