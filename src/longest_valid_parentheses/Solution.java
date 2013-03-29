package longest_valid_parentheses;

public class Solution {

    class Stack {
        int[] stack;
        int size;
        int currentMax;

        Stack(int size) {
            stack = new int[size];
            size = 0;
            currentMax = 0;
        }

        void put(char c) {
            if (size == 0) {
                if (c == '(') {
                    stack[size] = -1;
                    size++;
                }
                return;
            }

            if (c == '(') {
                stack[size] = -1;
                size++;
                return;
            }

            // when putting ')'
            int current = stack[size - 1];

            // the last one in stack is '('
            if (current == -1) {
                if (size > 1 && stack[size - 2] > 0) {
                    // the second last one is number
                    // and the last one is '('
                    // add the number by 2
                    stack[size - 2] += 2;
                    size--;
                } else {
                    // change '(' to 2
                    stack[size - 1] = 2;
                }
                return;
            }

            // the last one is ')'
            if (current == -2) {
                return;
            }

            // The current is number and putting ')'
            if (size > 1 && stack[size - 2] == -1) {
                // if the second to last is '('
                // and the last one is number
                if (size > 2 && stack[size - 3] > 0) {
                    // if the third to last is number
                    // e.g. 4 ( 2  <<< putting ')'
                    // >>>  6
                    stack[size - 3] += current + 2;
                    size = size - 2;
                } else {
                    // e.g. ( ( 2 <<< putting ')'
                    // >>>  ( 4
                    stack[size - 2] = current + 2;
                    size = size - 1;
                }
                return;
            }
            
            // no match
            // e.g. ) 4 <<< put ')'
            // >>>  ) 4 ) 
            stack[size] = -2;
            size++;
        }

        int getMax() {
            int max = 0;
            for (int i = 0; i < size; i++) {
                if (stack[i] > max)
                    max = stack[i];
            }
            return max;
        }

    }

    public int longestValidParentheses(String s) {

        Stack it = new Stack(s.length());

        for (int i = 0; i < s.length(); i++) {
            it.put(s.charAt(i));
        }

        return it.getMax();
    }
}
