import java.util.*;

public class WordLadder {

    /*
    A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence
    of words beginWord -> s1 -> s2 -> ... -> s_k such that:

    - Every adjacent pair of words differs by a single letter.
    - Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    - s_k == endWord

    Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest
    transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

    Constraints:

    1 <= beginWord.length <= 10
    endWord.length == beginWord.length
    1 <= wordList.length <= 5000
    wordList[i].length == beginWord.length
    beginWord, endWord, and wordList[i] consist of lowercase English letters.
    beginWord != endWord
    All the words in wordList are unique.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //quick fail checks on restrictions
        int len = beginWord.length();
        if ((len < 1) || (len > 10) ||
                (len != endWord.length()) ||
                (beginWord.equals(endWord)) ||
                ((wordList == null) || wordList.size() < 1)) return 0;

        //no endWord - no solution
        if (!wordList.contains(endWord)) return 0;

        /*
        Doing BFS on a tree that we build from beginWord.

        To build it we look up all possible children with 1 char difference in a wordList and:
        - add them to a queue for processing
        - remove them from original wordList

        To track the depth level we measure the queue size before processing of a new level and only cycle on that size.
        After that we keep going but with a new depth level in mind.

        If solution is found inside the cycle - we return right away.
        If we get to a point that we cannot find any more valid children and queue size becomes empty - no solution.
         */
        int curDepth = 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while (!q.isEmpty()) { //empty queue - no valid children left - no solution
            curDepth++;
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) { //length of a current depth level
                String curWord = q.poll(); //word to process from current depth level

                /*
                Place where we look up solution on the next level.
                If no solution, but valid child - add to queue and remove from original list
                 */
                ListIterator<String> iter = wordList.listIterator();
                String word;
                while (iter.hasNext()) {
                    word = iter.next();
                    if (isDirectChild(word, curWord)) {
                        if (word.equals(endWord)) return curDepth + 1;
                        iter.remove();
                        q.add(word);
                    }
                }
            }
        }
        return 0;
    }

    /*
    Direct child - only 1 different char in one position, not an anagram with 1 substitution!
     */
    private boolean isDirectChild(String word, String value) {
        int len = word.length();
        boolean diffByOne = false;
        for (int i = 0; i < len; i++) {
            if ((word.charAt(i) != value.charAt(i))) {
                if (diffByOne) return false;
                else diffByOne = true;
            }
        }
        return true;
    }

    /*
    Fast solution using HashSet() and checking all possible mutations with English alphabet and contains()
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        //quick fail checks on restrictions
        int len = beginWord.length();
        if ((len < 1) || (len > 10) ||
                (len != endWord.length()) ||
                (beginWord.equals(endWord)) ||
                ((wordList == null) || wordList.size() < 1))  return 0;

        //words supposed to be unique - moving to HashSet for faster contains() checks
        Set<String> wordSet = new HashSet<>(wordList);

        //no endWord - no solution
        if (!wordSet.contains(endWord)) return 0;

        /*
        Doing BFS on a tree that we build from beginWord.

        To build it we look up all possible children with 1 char difference in a wordList and:
        - add them to a queue for processing
        - remove them from original wordList

        To track the depth level we measure the queue size before processing of a new level and only cycle on that size.
        After that we keep going but with a new depth level in mind.

        If solution is found inside the cycle - we return right away.
        If we get to a point that we cannot find any more valid children and queue size becomes empty - no solution.
         */
        int curDepth = 0;
        Queue<String> q = new LinkedList<>();
        int layerSize;

        q.add(beginWord);
        while (!q.isEmpty()) { //empty queue - no valid children left - no solution
            curDepth++;
            layerSize = q.size();

            String currentWord;
            String mutatedWord;
            char[] wordChars;
            for (int i = 0; i < layerSize; i++) { //length of a current depth level
                currentWord = q.poll(); //word to process from current depth level

                for (int j = 0; j < len; j++) {
                    wordChars = currentWord.toCharArray(); //not null since queue size > 0

                    for (char k = 'a'; k <= 'z'; k++) {
                        wordChars[j] = k;
                        mutatedWord = new String(wordChars);
                        if (wordSet.contains(mutatedWord)) {
                            if (mutatedWord.equals(endWord)) return curDepth + 1;
                            q.add(mutatedWord);
                            wordSet.remove(mutatedWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
