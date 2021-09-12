class Solution {
    public String reverseWords(String s) {
        String[] split = s.split("\\s");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (!split[i].isEmpty())
                sb.append(split[i]).append(" ");
        }
        return sb.toString().substring(0, sb.length()-1);
    }
}