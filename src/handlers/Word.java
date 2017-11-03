package handlers;

import java.util.ArrayList;

public class Word {
	public static ArrayList<String> getWords(String sent) {
		ArrayList<String> words = new ArrayList<String>();
		Sign.delSign(sent);
		String[] words2 = sent.split("\\s+");
		for (String s : words2) {
			words.add(s);
		}
		return words;
	}

}
