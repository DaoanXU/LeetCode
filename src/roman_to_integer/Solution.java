package roman_to_integer;

import java.util.HashMap;

public class Solution {
    
    final HashMap<Character,Integer> numbers;
    {
        numbers = new HashMap<Character,Integer>();
        numbers.put('I', 1);
        numbers.put('V', 5);
        numbers.put('X', 10);
        numbers.put('L', 50);
        numbers.put('C', 100);
        numbers.put('D', 500);
        numbers.put('M', 1000);
    }
    
    public int romanToInt(String s) {
        int size = s.length() - 1;
        int result = 0;
        
        int previous = numbers.get(s.charAt(size));
        result = result + previous;
        size --;
        
        while(size > -1){
            int current = numbers.get(s.charAt(size));
            if(current < previous)
                result = result - current;
            else
                result = result + current;
            previous = current;
            size --;
        }        
        
        return result;
    }
}