package next_permutation;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] num) {
        int last = num.length - 1;
        
        for(int i = last; i > 0 ; i --){
            Arrays.sort(num,i,last+1);
            if(num[last] > num[i-1]){
                for(int j = i ; j < last + 1 ; j ++){
                    if(num[j] > num[i-1]){
                        num[j] = num[i-1] ^ num[j];
                        num[i-1] = num[i-1] ^ num[j];
                        num[j] = num[i-1] ^ num[j];
                        return;
                    }
                }                
            }
        }
        Arrays.sort(num,0,last+1);
    }
}
