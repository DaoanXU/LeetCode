package restore_ip_addresses;

import java.util.ArrayList;

public class SolutionRecursive {
    ArrayList<String> result;
    int[] ip;
    String s;

    public ArrayList<String> restoreIpAddresses(String s) {
        result = new ArrayList<String>();
        ip = new int[4];
        this.s = s;
        restoreIP(0, 0);
        return result;
    }

    void restoreIP(int from, int count) {

        if (from >= s.length())
            return;

        if (count == 3) {
            if (from + 3 < s.length())
                return;
            if (s.charAt(from) == '0' && from + 1 < s.length())
                return;

            int last = Integer.parseInt(s.substring(from));
            if (last < 256) {
                ip[3] = last;
                install();
            }
            return;
        }

        if (s.charAt(from) == '0') {
            ip[count] = 0;
            restoreIP(from + 1, count + 1);
            return;
        }

        int current = s.charAt(from) - '0';
        ip[count] = current;
        restoreIP(from + 1, count + 1);
        from++;
        if (from >= s.length())
            return;

        current = current * 10 + s.charAt(from) - '0';
        ip[count] = current;
        restoreIP(from + 1, count + 1);
        from++;
        if (from >= s.length())
            return;

        current = current * 10 + s.charAt(from) - '0';
        if (current < 256) {
            ip[count] = current;
            restoreIP(from + 1, count + 1);
        }
    }

    void install() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(ip[i]);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        result.add(sb.toString());
    }
}