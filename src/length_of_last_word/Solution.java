package length_of_last_word;

public class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        if (i < 0)
            return 0;

        for (; i > -1; i--) {
            if (s.charAt(i) != ' ')
                break;
        }

        if (i < 0)
            return 0;
        int mark = i;
        for (; i > -1; i--) {
            if (s.charAt(i) == ' ')
                break;
        }
        return mark - i;
    }
}
