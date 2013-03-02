package zig_zag_conversion;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * <pre>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * </pre>
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"..
 * 
 * @author Daoan XU
 * 
 */
public class Solution {

    class Generator {
        private int current;
        private final int size;
        private int step;

        Generator(int size) {
            this.size = size - 1;
            this.current = 1;
            this.step = -1;
        }

        public int next() {
            if (size == 0)
                return 0;
            int next = current + step;
            if (next < 0 || next > size)
                step = 0 - step;
            current = current + step;
            return current;
        }
    }

    public String convert(String s, int nRows) {
        int rows = nRows;
        Generator indexGenerator = new Generator(rows);
        StringBuffer[] buffers = new StringBuffer[rows];
        for (int i = 0; i < rows; i++)
            buffers[i] = new StringBuffer();
        int stringSize = s.length();
        for (int i = 0; i < stringSize; i++)
            buffers[indexGenerator.next()].append(s.charAt(i));
        for (int i = 1; i < rows; i++)
            buffers[0].append(buffers[i]);
        return buffers[0].toString();
    }

}