package three_sum_closest;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        int[] arr = new int[]{1,1,1,0};
        int target = 100;
        System.out.println(new Solution().threeSumClosest(arr, target));
    }

}
