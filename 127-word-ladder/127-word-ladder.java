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
                for (int j = 0; j < endWord.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(j, c);
                        if (!explored.contains(sb.toString()) && dictionary.contains(sb.toString())) {
                            if (sb.toString().equals(endWord)) {
                                return ++level;
                            }
                            explored.add(sb.toString());
                            queue.add(sb.toString());

                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}