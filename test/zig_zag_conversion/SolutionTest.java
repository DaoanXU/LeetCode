package zig_zag_conversion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import zig_zag_conversion.Solution.Generator;

public class SolutionTest {

    public Solution doit;

    @Before
    public void init() {
        doit = new Solution();
    }

    @Test
    public void test() {
        Generator index = doit.new Generator(1);
        for (int i = 0; i < 100; i++) {
            System.out.print(index.next());
        }
    }

}
