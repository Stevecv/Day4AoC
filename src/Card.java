import java.util.*;

public class Card {
    public int cardNum;
    public int[] winningNumbers;
    public int[] numbers;
    public int score;
    public Card(String card) {
        String cleanedCard = card.replace("Card ", "")
                .replace(" | ", "|")
                .replace(": ", "|");
        String[] cardPieces = cleanedCard.split("\\|");

        cardNum = Integer.parseInt(cardPieces[0].trim());

        ArrayList<Integer> winningNums = new ArrayList<>();
        for (String winningNum: cardPieces[1].split(" ")) {
            if (!winningNum.isEmpty()) {
                winningNums.add(Integer.valueOf(winningNum.trim()));
            }
        }
        ArrayList<Integer> nums = new ArrayList<>();
        for (String num: cardPieces[2].split(" ")) {
            if (!num.isEmpty()) {
                nums.add(Integer.valueOf(num.trim()));
            }
        }
        winningNumbers = winningNums.stream().mapToInt(i -> i).toArray();
        numbers = nums.stream().mapToInt(i -> i).toArray();
        calculateScore();
    }

    private void calculateScore() {
        int totalledScore = 0;
        for (int num: numbers) {
            for (int winningNum: winningNumbers) {
                if (num == winningNum) {
                    if (totalledScore == 0) {
                        totalledScore = 1;
                    } else {
                        totalledScore *= 2;
                    }
                    break;
                }
            }
        }
        score = totalledScore;
    }
}
