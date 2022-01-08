class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int level = 0;
        Queue<String> bfs = new LinkedList<>();
        Set<String> bnk = new HashSet<>(Arrays.asList(bank));
        Set<String> explored = new HashSet<>();
        bfs.offer(start);
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                String gene = bfs.poll();
                List<String> mutations = findMutations(bank, gene);
                for (String s : mutations) {
                    if (!explored.contains(s)) {
                        if (s.equals(end))
                            return ++level;
                        bfs.offer(s);
                        explored.add(s);
                    }
                }
            }
            level++;
        }
        return -1;
    }
    
    List<String> findMutations(String[] bank, String gene) {
        List<String> mutations = new ArrayList<>();
        for (String s : bank) { 
            int numDifferences = 0;
            for (int i = 0; i < gene.length() && numDifferences <= 1; i++) {
                if (gene.charAt(i) != s.charAt(i))
                    numDifferences++;
            }
            if (numDifferences == 1)
                mutations.add(s);
        }
        return mutations;
    }
}