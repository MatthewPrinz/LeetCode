class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<Map<Character, Integer>> maps = new ArrayList<>();
        for (String s : strs) {
            maps.add(makeMap(s));
        }
        boolean[] processed = new boolean[strs.length];
        for (int i = 0; i < maps.size(); i++) {
            if (!processed[i]) {
                List<String> group = new ArrayList<>();
                group.add(strs[i]);
                Map<Character, Integer> map = maps.get(i);
                for (int j = i; j < maps.size(); j++) {
                    if (i == j || processed[j])
                        continue;
                    boolean isAnagram = true;
                    Set<Map.Entry<Character, Integer>> set = maps.get(j).entrySet();
                    // System.out.printf("Now processing: map: %s, set: %s\n", map, set);
                    if (!(map.isEmpty() && set.isEmpty())) {
                        if (map.size() == set.size()) {
                            for (Map.Entry<Character, Integer> me: set) {
                                if (map.containsKey(me.getKey())) {
                                    if (!map.get(me.getKey()).equals(me.getValue())) {
                                        // System.out.printf("val: Not anagrams: %s, %s\n", strs[i], strs[j]);
                                        isAnagram = false;
                                        break;
                                    }
                                } else {
                                    // System.out.printf("key: Not anagrams: %s, %s\n", strs[i], strs[j]);
                                    isAnagram = false;
                                    break;
                                }
                            }
                        } else {
                            isAnagram = false;
                        }
                    }
                    if (isAnagram) {
                        processed[j] = true;
                        // System.out.printf("strs[%d]=%s is processed, set is: %s, map is: %s\n",j, strs[j], set, map);
                        group.add(strs[j]);
                    }

                }
                result.add(group);
            }
        }
        return result;
    }
    public Map<Character, Integer> makeMap(String s) {
        Map<Character, Integer> charToFrequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charToFrequency.put(s.charAt(i), charToFrequency.getOrDefault(s.charAt(i), 0) + 1);
        }
        return charToFrequency;
    }
}