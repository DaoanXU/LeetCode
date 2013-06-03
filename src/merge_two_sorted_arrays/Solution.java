package merge_two_sorted_arrays;

public class Solution {
    public void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB) {
        if (sizeB == 0)
            return;

        if (sizeA == 0)
            System.arraycopy(arrayB, 0, arrayA, 0, sizeB);

        int tailA = sizeA - 1;
        int tailB = sizeB - 1;

        int lastA = tailA + tailB + 1;
        while (tailA > -1 && tailB > -1) {
            if (arrayA[tailA] > arrayB[tailB]) {
                arrayA[lastA] = arrayA[tailA];
                lastA--;
                tailA--;
            } else {
                arrayA[lastA] = arrayB[tailB];
                lastA--;
                tailB--;
            }
        }

        if (tailA == -1) {
            System.arraycopy(arrayB, 0, arrayA, 0, tailB + 1);
        }
    }

}
