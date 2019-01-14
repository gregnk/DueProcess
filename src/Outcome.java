import java.util.*;

public class Outcome implements Comparable {
	
	// Keywords (different lengths)
	private ArrayList<String> keywords1 = new ArrayList<String>();
	private ArrayList<String> keywords2 = new ArrayList<String>();
	private ArrayList<String> keywords3 = new ArrayList<String>();
	
	// Keyword scores
	private ArrayList<Double> keywords1Scores = new ArrayList<Double>();
	private ArrayList<Double> keywords2Scores = new ArrayList<Double>();
	private ArrayList<Double> keywords3Scores = new ArrayList<Double>();
	
	// Next dialog part to load
	private String nextDialog;
	
	// The outcomes score
	private double score = 0;
	
	public ArrayList<String> getKeywords1() {
		return keywords1;
	}

	public void setKeywords1(ArrayList<String> keywords1) {
		this.keywords1 = keywords1;
	}

	public ArrayList<String> getKeywords2() {
		return keywords2;
	}

	public void setKeywords2(ArrayList<String> keywords2) {
		this.keywords2 = keywords2;
	}

	public ArrayList<String> getKeywords3() {
		return keywords3;
	}

	public void setKeywords3(ArrayList<String> keywords3) {
		this.keywords3 = keywords3;
	}

	public ArrayList<Double> getKeywords1Scores() {
		return keywords1Scores;
	}

	public void setKeywords1Scores(ArrayList<Double> keywords1Scores) {
		this.keywords1Scores = keywords1Scores;
	}

	public ArrayList<Double> getKeywords2Scores() {
		return keywords2Scores;
	}

	public void setKeywords2Scores(ArrayList<Double> keywords2Scores) {
		this.keywords2Scores = keywords2Scores;
	}

	public ArrayList<Double> getKeywords3Scores() {
		return keywords3Scores;
	}

	public void setKeywords3Scores(ArrayList<Double> keywords3Scores) {
		this.keywords3Scores = keywords3Scores;
	}

	public String getNextDialog() {
		return nextDialog;
	}

	public void setNextDialog(String nextDialog) {
		this.nextDialog = nextDialog;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Outcome [keywords1=" + keywords1 + ", keywords2=" + keywords2 + ", keywords3=" + keywords3
				+ ", keywords1Scores=" + keywords1Scores + ", keywords2Scores=" + keywords2Scores + ", keywords3Scores="
				+ keywords3Scores + ", nextDialog=" + nextDialog + ", score=" + score + "]";
	}
	
	public Outcome(String nextDialog) {
		this.nextDialog = nextDialog;
	}

	public void addKeyword(String word, double score, int words) {
		switch (words) {
		case 1:
			keywords1.add(word);
			keywords1Scores.add(score);
			break;
		case 2:
			keywords2.add(word);
			keywords2Scores.add(score);
			break;
		case 3:
			keywords3.add(word);
			keywords3Scores.add(score);
			break;
		}
	}

	@Override
	public int compareTo(Object outcome) {
		double compareScore = ((Outcome)outcome).getScore();
		return (int) (compareScore - score);
	}
}
