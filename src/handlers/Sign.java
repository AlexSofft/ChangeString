package handlers;

public class Sign {

	public static void delSign(String sent) {
		sent.replaceAll("!|\\?|,|(\\.\\s)|;|:", "");
	}
}
