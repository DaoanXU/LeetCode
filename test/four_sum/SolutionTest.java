package four_sum;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        int [] arr = new int[]{5,10,5,-10,-4,0,2,-4,4,-6,2,-7,-2,10,-1,3,3};
        int target = -19;
        System.out.println(new SolutionOn4().fourSum(arr, target));        
    }

}
