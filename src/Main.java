
import handlers.Text;
/**Во всех вопросительных предложениях текста найти и напечатать без по-
 вторений слова заданной длины.*/

public class Main {

	public static void main(String[] args) {
		Text t1 = new Text("src/files/test.txt");
		Text t2 = new Text("src/files/test2.txt");
		Text t3 = new Text("src/files/test3.txt");

		t1.getAskSentWords(5);
		t2.getAskSentWords(12);
		t3.getAskSentWords(15);

	}
}
