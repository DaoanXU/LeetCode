package permutations;

import java.util.ArrayList;

public class SolutionSwapArray {
    private ArrayList<ArrayList<Integer>> result;
    
    public ArrayList<ArrayList<Integer>> permute(int[] num){
        result = new ArrayList<ArrayList<Integer>>();
        permuteHelper(num, 0);
        return result;
    }
    
    private void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    
    private void permuteHelper(int[] num, int left){
        if(left == num.length -1){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<num.length; i++){
                list.add(num[i]);
            }
            result.add(list);
            return;
        }
        
        for(int right=left; right<num.length; right++){
            swap(num, left, right);
            permuteHelper(num, left+1);
            swap(num, left, right);
        }
    }
}