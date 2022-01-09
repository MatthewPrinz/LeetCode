class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        char[] permutation = sb.toString().toCharArray();
        for (int j = 1; j < k; j++) {
            // i: beginning of the suffix
            // gtPivotIndex: index of the smallest element in the suffix that is greater than the pivot
            int begin = 0, pivot = -1, gtPivotIndex = -1;
            for (int i = permutation.length - 1; i >= 0; i--) {
                if (permutation[i - 1] < permutation[i]) {
                    begin = i;
                    break;
                }
            }
            pivot = permutation[begin - 1];
            gtPivotIndex = begin;
            for (int i = begin; i < permutation.length; i++) {
                if (permutation[i] <= permutation[gtPivotIndex] && permutation[i] > pivot) {
                    gtPivotIndex = i;
                }
            }
            char temp = permutation[gtPivotIndex];
            permutation[gtPivotIndex] = permutation[begin - 1];
            permutation[begin - 1] = temp;
            int end = permutation.length - 1;
            while (begin < end) {
                temp = permutation[begin];
                permutation[begin++] = permutation[end];
                permutation[end--] = temp;
            }
        }
        return new String(permutation);
    }
}
