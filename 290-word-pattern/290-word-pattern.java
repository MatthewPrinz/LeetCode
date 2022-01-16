class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternToS = new HashMap<>();
        Map<String, Character> sToPattern = new HashMap<>();
        String[] sSplit = s.split(" ");
        if (pattern.length() != sSplit.length) {
            return false;
        }
        for (int i = 0; i < sSplit.length; i++) {
            String check1 = patternToS.put(pattern.charAt(i), sSplit[i]);
            Character check2 = sToPattern.put(sSplit[i], pattern.charAt(i));
            if ((check1 != null && !check1.equals(sSplit[i])) || (check2 != null && !check2.equals(pattern.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}