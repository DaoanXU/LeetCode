package zig_zag_conversion;

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