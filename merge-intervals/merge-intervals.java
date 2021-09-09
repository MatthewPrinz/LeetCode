class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, (e1, e2) -> Integer.compare(e1[0], e2[0]));
        List<Integer[]> result = new ArrayList<>();
        int newBegin = intervals[0][0];
        int newEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (newEnd >= intervals[i][0]) {
                newEnd = newEnd > intervals[i][1] ? newEnd : intervals[i][1];
            } else {
                result.add(new Integer[]{newBegin, newEnd});
                newBegin = intervals[i][0];
                newEnd = intervals[i][1];
            }
        }
        result.add(new Integer[]{newBegin, newEnd});
        int[][] resultArr = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i][0] = result.get(i)[0];
            resultArr[i][1] = result.get(i)[1];
        }
        return resultArr;
    }
}