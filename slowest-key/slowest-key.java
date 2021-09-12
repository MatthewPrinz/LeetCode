class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxValue = releaseTimes[0];
        char maxKey = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int duration = (releaseTimes[i] - releaseTimes[i-1]);
            if (duration > maxValue) {
                maxValue = duration;
                maxKey = keysPressed.charAt(i);
            } 
            else if (duration == maxValue && maxKey < keysPressed.charAt(i)) {
                maxKey = keysPressed.charAt(i);
            }
        }
        return maxKey;
    }
}