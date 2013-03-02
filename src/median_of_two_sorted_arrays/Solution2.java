package median_of_two_sorted_arrays;

/**
 * http://www2.myoops.org/course_material/mit/NR/rdonlyres/Electrical-
 * Engineering
 * -and-Computer-Science/6-046JFall-2005/30C68118-E436-4FE3-8C79-6BAFBB07D935
 * /0/ps9sol.pdf
 * 
 * This is with O(logm + logn) time complexity
 * 
 */
public class Solution2 {
	public double findMedianSortedArrays(int A[], int B[]) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int l = A.length;
		int m = B.length;
		int n = l + m;

		return findMedianHelper(A, B, Math.max(0, n / 2 - m),
				Math.min(l - 1, n / 2));
	}

	private double findMedianHelper(int A[], int B[], int left, int right) {
		int l = A.length;
		int m = B.length;
		int n = l + m;
		if (left > right) {
			return findMedianHelper(B, A, Math.max(0, n / 2 - l),
					Math.min(m - 1, n / 2));
		}
		int i = (left + right) / 2;
		int j = n / 2 - i;
		if ((j < 1 || A[i] >= B[j - 1]) && (j > m - 1 || A[i] <= B[j])) { // hit
			if (n % 2 == 0) {
				if (i > 0 && j > 0) {
					return (double) (Math.max(A[i - 1], B[j - 1]) + A[i]) / 2;
				}
				if (i > 0) {
					return (double) (A[i] + A[i - 1]) / 2;
				}
				return (double) (A[i] + B[j - 1]) / 2;
			} else
				return (double) A[i];
		} else {
			if (j <= m - 1 && A[i] > B[j]) { // A[i] is larger than median
				return findMedianHelper(A, B, left, i - 1);
			} else { // A[i] is smaller than median
				return findMedianHelper(A, B, i + 1, right);
			}
		}
	}
}
