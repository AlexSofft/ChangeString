package handlers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {

	private ArrayList<String> sentsList = new ArrayList<String>();

	public Sentence(String text) {
		getSent(text);
	}

	public void getSent(String text) {
		Pattern pattern = Pattern.compile("(\\?|\\.|!)\\s");
		Matcher matcher = pattern.matcher(text);
		int startPos = 0;
		int endPos = 0;
		while (matcher.find()) {
			endPos = matcher.end();
			String foundSent = text.substring(startPos, endPos);
			sentsList.add(removeSymbols(foundSent));
			startPos = endPos;
		}
		if (endPos < text.length()) {
			String foundSent = text.substring(startPos);
			sentsList.add(removeSymbols(foundSent));
		}
	}

	public String removeSymbols(String sent) {
		return sent.replaceAll("( |\\t){1,}", " ").trim();
	}

	public ArrayList<String> getAsk() {
		ArrayList<String> askSentsList = new ArrayList<String>();
		for (String sent : sentsList) {
			if (isAsk(sent)) {
				askSentsList.add(sent);
			}
		}
		return askSentsList;
	}

	private Boolean isAsk(String sent) {
		return sent.charAt(sent.length() - 1) == '?';
	}

	public void getAskSentWords(int length) {
		for (String askSent : getAsk()) {
			printProblems(askSent, getProblems(Word.getWords(askSent), length));
		}

	}

	public ArrayList<String> getProblems(ArrayList<String> words, int length) {
		ArrayList<String> foundWords = new ArrayList<String>();
		for (String word : words) {
			if (word.length() == length && !foundWords.contains(word)) {
				foundWords.add(word);
			}
		}
		return foundWords;
	}

	public void printProblems(String askSent, ArrayList<String> askWords) {
		System.out.println(askSent + " : " + askWords);
	}

}
