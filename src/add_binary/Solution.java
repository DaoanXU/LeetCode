package add_binary;

public class Solution {
    public String addBinary(String a, String b) {
        int ia = a.length() - 1;
        int ib = b.length() - 1;

        if (ia < 0)
            return b;
        if (ib < 0)
            return a;

        char[] sb = new char[Math.max(ia, ib) + 1];
        int sbIndex = sb.length - 1;

        int carry = 0;
        while (ia >= 0 && ib >= 0) {
            int av = a.charAt(ia) - '0';
            int bv = b.charAt(ib) - '0';
            sb[sbIndex] = (char) (((av + bv + carry) & 1) + '0');
            sbIndex--;
            carry = (av + bv + carry) >>> 1;
            ia--;
            ib--;
        }

        if (ia < 0)
            carry = finish(sb, sbIndex, b, ib, carry);
        else
            carry = finish(sb, sbIndex, a, ia, carry);

        if (carry > 0)
            return 1 + new String(sb);
        return new String(sb);

    }

    int finish(char[] sb, int sbIndex, String a, int ia, int carry) {
        while (ia >= 0) {
            int av = a.charAt(ia) - '0';
            sb[sbIndex] = (char) (((av + carry) & 1) + '0');
            sbIndex--;
            carry = (av + carry) >>> 1;
            ia--;
        }
        return carry;
    }
}
