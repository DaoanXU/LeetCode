package scramble_string;

public class SolutionRecursive {
    String s1;
    String s2;

    public boolean isScramble(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        return scrambleHelper(0,0,s1.length());
    }

    boolean scrambleHelper(int is, int js, int l) {

        if (!setMatch(is, js, l))
            return false;

        if (l == 1)
            return true;

        for (int cut = 1; cut < l; cut++) {
            boolean valid;
            valid = scrambleHelper(is, js, cut)
                    && scrambleHelper(is + cut, js + cut, l - cut);

            valid = valid ||
                    (scrambleHelper(is, js + l - cut, cut)
                    && scrambleHelper(is + cut, js, l - cut));

            if (valid)
                return true;
        }

        return false;
    }

    boolean setMatch(int is, int js, int l) {
        int[] a = new int[26];

        for (int i = 0; i < l; i++) {
            a[s1.charAt(is + i) - 'a']++;
            a[s2.charAt(js + i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (a[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
