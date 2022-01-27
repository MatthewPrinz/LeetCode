We're essentially doing a BFS on a graph G with nodes being the beginWord and the wordList with edges connecting nodes which have 1 character distance.
​
An interesting note is that this can be optimized for large wordLists. The traditional manner would look for words which are 1 character away in the wordList - resulting in an O(size of word list) look up time. For large wordLists, this is can be very expensive. Instead, one can iterate through the lowercase ASCII alphabet and change every character of the word to every other character in the alphabet and check if it is inside the wordList. This results in a O(size of word), as 26 is a constant.
​
It is worth nothing that if the words in this problem weren't constricted to lowercase ASCII characters, this methodology could be worse than iterating through the word list (consider every word having UTF-32 characters - you'd have to check 2^32 characters for every letter of the word!).
​
For that case, the following solution would be better.
```
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> explored = new HashSet<>();
        Set<String> dictionary = new HashSet<>(wordList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> check = oneLetterDifference(wordList, word);
                for (String s : check) {
                    if (!explored.contains(s)) {
                        if (s.equals(endWord)) {
                            return ++level;
                        }
                        explored.add(s);
                        queue.add(s);
                    }
                }
            }
            level++;
        }
        return 0;
    }
    List<String> oneLetterDifference(List<String> words, String word) {
        List<String> result = new ArrayList<>();
        for (String s : words) {
            int numDifferences = 0;
            for (int i = 0; i < word.length() && numDifferences <= 1; i++) {
                if (s.charAt(i) != word.charAt(i)) {
                    numDifferences++;
                }
            }
            if (numDifferences == 1)
                result.add(s);
        }
        return result;
    }
}
