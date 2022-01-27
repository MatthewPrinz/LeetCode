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
                for (int j = 0; j < word.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(j, c);
                        String s = sb.toString();
                        if (dictionary.contains(s) && !explored.contains(s)) {
                            if (s.equals(endWord)) {
                                return ++level;
                            }
                            explored.add(s);
                            queue.add(s);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}