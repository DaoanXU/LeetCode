package letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    private static HashMap<Character, ArrayList<Character>> mapper;
    static {
        mapper = new HashMap<Character, ArrayList<Character>>();
        mapper.put('0', new ArrayList<Character>(Arrays.asList(' ')));
        mapper.put('1', new ArrayList<Character>());
        mapper.put('2', new ArrayList<Character>(Arrays.asList('a', 'b', 'c')));
        mapper.put('3', new ArrayList<Character>(Arrays.asList('d', 'e', 'f')));
        mapper.put('4', new ArrayList<Character>(Arrays.asList('g', 'h', 'i')));
        mapper.put('5', new ArrayList<Character>(Arrays.asList('j', 'k', 'l')));
        mapper.put('6', new ArrayList<Character>(Arrays.asList('m', 'n', 'o')));
        mapper.put('7', new ArrayList<Character>(Arrays.asList('p', 'q', 'r', 's')));
        mapper.put('8', new ArrayList<Character>(Arrays.asList('t', 'u', 'v')));
        mapper.put('9', new ArrayList<Character>(Arrays.asList('w', 'x', 'y', 'z')));
        mapper.put('*', new ArrayList<Character>(Arrays.asList('+')));
        mapper.put('#', new ArrayList<Character>());
    }


    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        result.add("");
        char[] cDigits = digits.toCharArray();
        for(Character c : cDigits){
            ArrayList<String> previous = new ArrayList<String>();
            previous.addAll(result);
            result = new ArrayList<String>();
            for(Character mapTo : mapper.get(c)){
                for(String s : previous){
                    result.add(s + mapTo);
                }
            }
        }
        return result;
    }
}
