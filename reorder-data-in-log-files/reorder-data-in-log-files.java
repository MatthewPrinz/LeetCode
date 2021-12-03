class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                int posFirst1 = s1.indexOf(' ');
                int posFirst2 = s2.indexOf(' ');
                if (Character.isDigit(s1.charAt(posFirst1 + 1))) {
                    if (Character.isDigit(s2.charAt(posFirst2 + 1))) 
                        return 0;
                    else 
                        return 1;
                }
                if (Character.isDigit(s2.charAt(posFirst2 + 1)))
                    return -1;
                int compareLogs = s1.substring(posFirst1 + 1).compareTo(s2.substring(posFirst2 + 1));
                if (compareLogs == 0)
                    return s1.substring(0, posFirst1 + 1).compareTo(s2.substring(0, posFirst2 + 1));
                else
                    return compareLogs;
                
            }
        };
        Arrays.sort(logs, comparator);
        return logs;
    }
}