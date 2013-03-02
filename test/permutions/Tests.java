package permutions;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Tests {

    @Test
    public void test() {
        SolutionStackTailStack a = new SolutionStackTailStack();
        SolutionSwapArray b = new SolutionSwapArray();
        SolutionStackArray c = new SolutionStackArray();
        long startTime;
        long endTime;

        int[] num = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

//        startTime = System.currentTimeMillis();
//        System.out.println(a.permute(num).size());
//        endTime = System.currentTimeMillis();
//        System.out.println("Run Time: " + (endTime - startTime) + "ms");
//        System.out.println("=============");
        
        startTime = System.currentTimeMillis();
        System.out.println(b.permute(num).size());
        endTime = System.currentTimeMillis();
        System.out.println("Run Time: " + (endTime - startTime) + "ms");
        System.out.println("=============");
        
        startTime = System.currentTimeMillis();
        System.out.println(c.permute(num).size());
        endTime = System.currentTimeMillis();
        System.out.println("Run Time: " + (endTime - startTime) + "ms");
        System.out.println("=============");
        
    }

}
