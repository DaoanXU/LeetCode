package jump_game;

import java.util.Arrays;

public class Solution {
    public boolean canJump(int[] A) {
        int[] minJump = new int[A.length];
        Arrays.fill(minJump, Integer.MAX_VALUE);
        minJump[0] = 0;
        int currentMax = 0;
        for (int i = 0; i < A.length; i++) {
            if (minJump[i] == Integer.MAX_VALUE)
                continue;

            for (int j = currentMax + 1; j <= i + A[i]; j++) {
                if (j > A.length - 1)
                    break;
                minJump[j] = Math.min(minJump[j], minJump[i] + 1);
            }
            if (i + A[i] > currentMax)
                currentMax = i + A[i];
        }

        return minJump[A.length - 1] != Integer.MAX_VALUE;
    }
}