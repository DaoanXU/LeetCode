package string_to_integer;

import org.junit.Before;
import org.junit.Test;


public class SolutioTest {
    public Solution doit;

    @Before
    public void init() {
        doit = new Solution();
        
    }
    
    @Test
    public void test(){
        doit.atoi("1");
    }
}
