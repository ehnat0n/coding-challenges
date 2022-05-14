import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinationsOfAPhoneNumber {

    private final String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private int phoneLength;

    public List<String> letterCombinations(String digits) {
        phoneLength = digits.length();
        if (phoneLength == 0) return new ArrayList<>();

        List<String> combinations = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        addCombinations(digits, 0, combinations, sb);

        return combinations;
    }

    private void addCombinations(String digits, int digitInd, List<String> combinations, StringBuilder sb) {
        if (sb.length() == phoneLength) {
            combinations.add(sb.toString());
            return;
        }

        String letterSet = letters[digits.charAt(digitInd) - '2'];
        for (int i = 0; i < letterSet.length(); i++) {
            sb.append(letterSet.charAt(i));
            addCombinations(digits, digitInd + 1, combinations, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations2(String digits) {
        if (digits.length() == 0) return new ArrayList<>();

        Queue<String> combinations = new LinkedList<>();
        String letterSet;
        String combination;
        int currentSize;

        combinations.offer("");
        for (char digit : digits.toCharArray()) {
            letterSet = letters[digit - '2'];
            currentSize = combinations.size();
            for (int i = 0; i < currentSize; i++) {
                combination = combinations.poll();
                for (char letter : letterSet.toCharArray()) {
                    combinations.offer(combination + letter);
                }
            }
        }
        return new ArrayList<>(combinations);
    }
}
