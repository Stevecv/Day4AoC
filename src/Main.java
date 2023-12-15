import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static ArrayList<String> cards = new ArrayList<>(List.of(PuzzleInput.puzzleInput.split("\n")));
    public static void main(String[] args) {
        int total = 0;
        for (int i = 0; i < cards.size(); i++) {
            Card card = new Card(cards.get(i));
            total += card.score;
        }
        System.out.println(total);
    }
}