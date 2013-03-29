package count_and_say;

public class Solution {

    public String count(String s) {
        StringBuffer sb = new StringBuffer();

        char previous = s.charAt(0);
        int i = 1;
        int count = 1;

        while (i < s.length()) {
            char current = s.charAt(i);
            if (current == previous) {
                count++;
            } else {
                sb.append(count);
                sb.append(previous);
                count = 1;
                previous = current;
            }
            i++;
        }
        sb.append(count);
        sb.append(previous);
        return sb.toString();
    }

    public String countAndSay(int n) {
        if (n == 0)
            return null;

        String s = "1";

        for (int i = 1; i < n; i++) {
            s = count(s);
        }

        return s;

    }
}
