class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedToAnagrams = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String str = new String(charArray);
            List<String> anagrams = sortedToAnagrams.getOrDefault(str, new ArrayList<>());
            anagrams.add(s);
            sortedToAnagrams.put(str, anagrams);
        }
        return new ArrayList<>(sortedToAnagrams.values());   
    }
}