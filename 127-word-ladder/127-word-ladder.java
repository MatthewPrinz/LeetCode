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