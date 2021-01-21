class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
​
        for (int j = 0; j < boxTypes.length; j++)
        {
            int maxUnits = -1;
            int maxIndex = -1;
            for (int i = 0; i < boxTypes.length; i++)
            {
                if (boxTypes[i][1] > maxUnits && boxTypes[i][0] > 0)
                {
                    maxUnits = boxTypes[i][1];
                    maxIndex = i;
                }
            }
            System.out.println("maxIndex = " + maxIndex);
            if (truckSize > boxTypes[maxIndex][0])
            {
                truckSize -= boxTypes[maxIndex][0];
                result += boxTypes[maxIndex][1] * boxTypes[maxIndex][0];
                boxTypes[maxIndex][0] = 0;
                System.out.println("boxTypes[maxIndex][0]: " + boxTypes[maxIndex][0]);
            }
            else
            {
                result += truckSize * boxTypes[maxIndex][1];
                break;
            }
            System.out.println("truckSize: " + truckSize + " result: " + result);
        }
        return result;
    }
}
