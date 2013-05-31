package test_justification;

import java.util.ArrayList;

public class Solution {
    ArrayList<String> result;
    ArrayList<String> line;
    int L;
    int letterCount;

    public ArrayList<String> fullJustify(String[] words, int L) {
        this.result = new ArrayList<String>();
        this.L = L;
        this.line = new ArrayList<String>();
        this.letterCount = 0;
        int count = -1;
        for (String word : words) {
            count = count + 1 + word.length();
            if (count > L)
            {
                refresh();
                count = word.length();
                letterCount = word.length();
            }
            else {
                letterCount = letterCount + word.length();
            }
            line.add(word);
        }
        StringBuilder sb = new StringBuilder(L);
        int tmpIndex = 0;
        for (; tmpIndex < line.size() - 1; tmpIndex++) {
            sb.append(line.get(tmpIndex));
            sb.append(' ');
        }
        sb.append(line.get(tmpIndex));
        for (int i = L - sb.length(); i > 0; i--) {
            sb.append(' ');
        }
        result.add(sb.toString());
        line.clear();
        return result;
    }

    void refresh() {
        StringBuilder sb = new StringBuilder(L);

        int gapCount = line.size() - 1;
        if (gapCount == 0) {
            sb.append(line.get(0));
            for (int i = L - sb.length(); i > 0; i--) {
                sb.append(' ');
            }
            result.add(sb.toString());
            line.clear();
            return;
        }

        int spaceCount = L - letterCount;
        int space = spaceCount / gapCount;
        int longCount = spaceCount - space * gapCount;
        int i = 0;
        for (; i < line.size() - 1; i++) {
            sb.append(line.get(i));
            for (int j = space; j > 0; j--) {
                sb.append(' ');
            }
            if (longCount > 0) {
                sb.append(' ');
                longCount--;
            }
        }
        sb.append(line.get(i));
        result.add(sb.toString());
        line.clear();
    }
}
