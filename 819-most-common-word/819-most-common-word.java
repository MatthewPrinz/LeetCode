class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> wordsToFrequency = new HashMap<>();
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        StringBuilder sb = new StringBuilder();
        boolean seenChar = false;
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
                seenChar = true;
            } else if ((c == ' ' || c == ',') && seenChar) {
                wordsToFrequency.put(sb.toString(), wordsToFrequency.getOrDefault(sb.toString(), 0) + 1);
                sb = new StringBuilder();
                seenChar = false;
            }
        }
        if (sb.length() > 0) {
                wordsToFrequency.put(sb.toString(), wordsToFrequency.getOrDefault(sb.toString(), 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        String mostCommon = "";
        for (Map.Entry<String, Integer> me : wordsToFrequency.entrySet()) {
            if (max < me.getValue() && !ban.contains(me.getKey())) {
                max = me.getValue();
                mostCommon = me.getKey();
            }
        }
        return mostCommon;
    }
}