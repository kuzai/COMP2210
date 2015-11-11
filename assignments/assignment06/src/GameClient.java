import java.util.TreeSet;

public class GameClient {

	public static void main(String[] args) {
		WordSearchGame game = WordSearchGameFactory.createGame();
		System.out.println(game.getBoard());
		game.loadLexicon("words.txt");
		TreeSet<String> list = new TreeSet<String>(game.getAllValidWords(3));
		System.out.println(list.size() + "");
	}

}
