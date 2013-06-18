package scramble_string;

public class SolutionMisunderstanding {
    public boolean isScramble(String s1, String s2) {
        return represent(s1).equals(represent(s2));
    }

    String represent(String s) {
        if (s.length() == 1)
            return s;

        String s1 = represent(s.substring(0, s.length() / 2));
        String s2 = represent(s.substring(s.length() / 2 + 1));

        if (s1.compareTo(s2) > 0)
            return s2 + s1;
        return s1 + s2;
    }
}
