import java.util.*;

public class WordParser {
	
	// Starter function
	public static double generateOutcomeScore(String[] response, Outcome outcome, int words) {
		return generateOutcomeScore(response, outcome, 0, words, 0);
	}

	// Main function
	public static double generateOutcomeScore(String[] response, Outcome outcome, int pos, int words, double score) {
		
		// 1-word keywords
		if (words == 1) {
			if (pos < response.length) {
				
				// Check each keyword
				for (int keywordIndex = 0; keywordIndex < outcome.getKeywords1().size(); keywordIndex++) {
					if (outcome.getKeywords1().get(keywordIndex).equals(response[pos]))
						score += outcome.getKeywords1Scores().get(keywordIndex);
					
					keywordIndex++;
				}
				
				// Check next input word
				pos++;
				score = generateOutcomeScore(response, outcome, pos, words, score);
			}
		}
		
		// 2-word keywords
		else if (words == 2) {
			if (pos < response.length - 1) {
				
				// Check each keyword
				for (int keywordIndex = 0; keywordIndex < outcome.getKeywords2().size(); keywordIndex++) {
					
					// Combine words
					String inputString = response[pos] + " " + response[pos + 1];
					
					if (outcome.getKeywords2().get(keywordIndex).equals(inputString))
						score += outcome.getKeywords2Scores().get(keywordIndex);
					
					keywordIndex++;
				}
				
				// Check next input word
				pos++;
				score = generateOutcomeScore(response, outcome, pos, words, score);
			}
		}
		
		// 3-word keywords
		else if (words == 3) {
			if (pos < response.length - 2) {
				
				// Check each keyword
				for (int keywordIndex = 0; keywordIndex < outcome.getKeywords3().size(); keywordIndex++) {
					
					// Check each keyword
					String inputString = response[pos] + " " + response[pos + 1] + " " + response[pos + 2];

					if (outcome.getKeywords3().get(keywordIndex).equals(inputString))
						score += outcome.getKeywords3Scores().get(keywordIndex);
					
					keywordIndex++;
				}
				
				// Check next input word
				pos++;
				score = generateOutcomeScore(response, outcome, pos, words, score);
			}
		}

		return score;
	}
}
