package permutation_sequence;

import java.util.LinkedList;

public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> left = new LinkedList<Integer>();
        int sum = 1;
        for (int i = 1; i < n + 1; i++) {
            left.offer(i);
            sum = sum * i;
        }
        k--;
        while (n > 0) {
            sum = sum / n;
            n--;
            int index = k / sum;
            k = k % sum;
            sb.append(left.get(index));
            left.remove(index);
        }
        return sb.toString();
    }
}