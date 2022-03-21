public class RemoveDuplicateLetters {

    /*
    Given a string s, remove duplicate letters so that every letter appears once and only once.
    You must make sure your result is the smallest in lexicographical order among all possible results.

    Constraints:

    1 <= s.length <= 10^4
    s consists of lowercase English letters.
     */
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        int[] lastInd = new int[26];
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            lastInd[s.charAt(i) - 'a'] = i;
        }
        StringBuilder result = new StringBuilder();
        char curC = s.charAt(0);
        result.append(curC);
        visited[curC - 'a'] = true;
        char prevC;
        for (int j = 1; j < len; j++) {
            curC = s.charAt(j);
            prevC = result.charAt(result.length() - 1);
            if (visited[curC - 'a']) continue;
            while ((prevC > curC) && (lastInd[prevC - 'a'] > j)) {
                result.deleteCharAt(result.length() - 1);
                visited[prevC - 'a'] = false;
                if (result.length() == 0) break;
                prevC = result.charAt(result.length() - 1);
            }
            result.append(curC);
            visited[curC - 'a'] = true;
        }
        return result.toString();
    }
}
