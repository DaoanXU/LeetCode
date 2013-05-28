package median_of_two_sorted_arrays;

import java.util.Arrays;

public class Solution {

    public double findMedianSortedArrays(int A[], int B[]) {
        if (A.length <= B.length)
            return findMedian(A, 0, A.length - 1, B, 0, B.length - 1);
        return findMedian(B, 0, B.length - 1, A, 0, A.length - 1);

    }

    boolean isEven(int x) {
        return (x & 1) == 0;
    }

    double findMedian(int A[], int aStart, int aEnd) {
        if (isEven(aEnd - aStart))
            return A[(aStart + aEnd) >>> 1];
        return ((double) A[(aStart + aEnd) >>> 1]
        + (double) A[(aStart + aEnd >>> 1) + 1]) / 2.0;
    }

    double findMedianCombine(int A[], int aStart, int aEnd, int B[], int bStart, int bEnd) {

        int[] arr = new int[bEnd + aEnd - aStart - bStart + 2];
        int i = 0;
        while (aStart <= aEnd && bStart <= bEnd) {
            if (A[aStart] < B[bStart]) {
                arr[i] = A[aStart];
                aStart++;
                i++;
            } else {
                arr[i] = B[bStart];
                bStart++;
                i++;
            }
        }

        while (aStart <= aEnd) {
            arr[i] = A[aStart];
            aStart++;
            i++;
        }

        while (bStart <= bEnd) {
            arr[i] = B[bStart];
            bStart++;
            i++;
        }

        return findMedian(arr, 0, arr.length - 1);
    }

    double findMedian(int A[], int aStart, int aEnd, int B[], int bStart, int bEnd) {

        int allSize = A.length + B.length;
        int aHalf = aStart + aEnd >>> 1;
        int bCheck = (allSize + 1 >>> 1) - aHalf - 2;

        if (aStart > aEnd)
            return findMedian(B, bStart, bEnd);

        if (aEnd == aStart)
            return findMedianCombine(A, aStart, aEnd, B, bStart, bEnd);
        // When the size of A is cut to 1,
        // should be able to find the median in constant time

        if (aEnd == aStart + 1)
            return findMedianCombine(A, aStart, aEnd, B, bStart, bEnd);
        // When the size of A is cut to 2,
        // should be able to find the median in constant time

        if (isEven(allSize))
            if (A[aHalf] >= B[bCheck] && A[aHalf] <= B[bCheck + 1])
                return ((double) Math.min(A[aHalf + 1],
                        B[bCheck + 1]) + (double) A[aHalf]) / 2.0;
            else if (A[aHalf] >= B[bCheck + 1] && A[aHalf] <= B[bCheck + 2])
                return ((double) Math.max(A[aHalf - 1],
                        B[bCheck + 1]) + (double) A[aHalf]) / 2.0;
        if (A[aHalf] >= B[bCheck] && A[aHalf] <= B[bCheck + 1])
            return (double) A[aHalf];

        int cut = aEnd - aStart >>> 1;
        if (A[aHalf] < B[bCheck])
            return findMedian(A, aStart + cut, aEnd, B, bStart, bEnd - cut);
        return findMedian(A, aStart, aEnd - cut, B, bStart + cut, bEnd);

    }

}
