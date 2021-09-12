class Solution {
    public String toLowerCase(String s) {
        // Way 1:
        // return s.toLowerCase();
        // Assuming we're not allowed to use that method, as that would be rather trivial.
        char[] schar = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                schar[i] = (char)((int)s.charAt(i) + 0x20);
            else
                schar[i] = s.charAt(i);
        }
        return new String(schar);
    }
}