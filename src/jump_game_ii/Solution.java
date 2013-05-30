package jump_game_ii;

import java.util.Arrays;

public class Solution {
    public int jump(int[] A) {
        int[] minJump = new int[A.length];
        Arrays.fill(minJump, Integer.MAX_VALUE);
        minJump[0] = 0;
        int currentMax = 0;
        for (int i = 0; i < A.length; i++) {

            for (int j = currentMax + 1; j <= i + A[i]; j++) {
                if (j > A.length - 1)
                    break;
                minJump[j] = Math.min(minJump[j], minJump[i] + 1);
            }
            if (i + A[i] > currentMax)
                currentMax = i + A[i];
        }

        return minJump[A.length - 1];
    }
}
