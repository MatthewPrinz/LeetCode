class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        String str = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        char[] result = s.toCharArray();
        while (i < j) {
            if (!vowels.contains(str.charAt(i))) {
                i++;
            }
            if (!vowels.contains(str.charAt(j))) {
                j--;
            }
            if (vowels.contains(str.charAt(i)) && vowels.contains(str.charAt(j))) {
                swap(result, i, j);
                i++;
                j--;
            }
        }
        return new String(result);
    }
    void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}