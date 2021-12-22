class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        char[] permutationca = sb.toString().toCharArray();
        for (int j = 1; j < k; j++) {
            // i: beginning of the suffix
            // gtPivotIndex: index of the smallest element in the suffix that is greater than the pivot
            int begin = 0, pivot = -1, gtPivotIndex = -1;
            for (int i = permutationca.length - 1; i >= 0; i--) {
                if (permutationca[i - 1] < permutationca[i]) {
                    begin = i;
                    break;
                }
            }
            pivot = permutationca[begin - 1];
            gtPivotIndex = begin;
            for (int i = begin; i < permutationca.length; i++) {
                if (permutationca[i] <= permutationca[gtPivotIndex] && permutationca[i] > pivot) {
                    gtPivotIndex = i;
                }
            }
            char temp = permutationca[gtPivotIndex];
            permutationca[gtPivotIndex] = permutationca[begin - 1];
            permutationca[begin - 1] = temp;
            int end = permutationca.length - 1;
            while (begin < end) {
                temp = permutationca[begin];
                permutationca[begin++] = permutationca[end];
                permutationca[end--] = temp;
            }
        }
        return new String(permutationca);
    }
}
