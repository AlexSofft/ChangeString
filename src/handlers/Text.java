package handlers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Text {

	private String text;
	private Sentence sents;

	public Text(String path) {
		try {
			this.text = getFile(path);
			sents = new Sentence(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getFile(String filePath) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(filePath));
		return new String(encoded, StandardCharsets.UTF_8);
	}

	public void getAskSentWords(int length) {
		sents.getAskSentWords(length);

	}

}
