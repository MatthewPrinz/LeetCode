class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = -1;
        for (int start = 0; start < gas.length; start++) {
            int remaining = gas[start];
            if (gas[start] == 0)
                continue;
            int j;
            for (j = ((start + 1) % gas.length); j != start; j = ((j + 1) % gas.length)) {
                remaining -= cost[j - 1 == -1 ? gas.length - 1 : j - 1];
                if (remaining < 0)
                    break;
                remaining += gas[j];
            }
            remaining -= cost[j - 1 == -1 ? gas.length - 1 : j - 1];
            if (remaining >= 0) {
                result = start;
            }
        }            
        return result;
    }
}