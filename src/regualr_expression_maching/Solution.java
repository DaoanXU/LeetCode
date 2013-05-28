package regualr_expression_maching;

public class Solution {

    String reformatExpression(String exp) {

        int i = 0;
        char it;
        int itCount;
        boolean haveStar;
        StringBuffer buff = new StringBuffer();
        int size = exp.length();

        while (i < size) {
            it = exp.charAt(i);
            itCount = 1;
            haveStar = false;
            char next;
            if (i < size - 1)
                next = exp.charAt(i + 1);
            else
                next = '\0';
            while ((next == it || next == '*') && (i < size - 1)) {
                if (next == it)
                    itCount++;
                else {
                    haveStar = true;
                    itCount--;
                }
                i++;
                if (i < size - 1)
                    next = exp.charAt(i + 1);
                else
                    next = '\0';
            }
            for (int j = 0; j < itCount; j++)
                buff.append(it);
            if (haveStar) {
                buff.append(it);
                buff.append('*');
            }
            ;
            i++;
        }

        return buff.toString();
    }

    public boolean isMatch(String s, String p) {
        return myIsMatch2(s, p);
        // return myIsMatch(s, reformatExpression(p));
    }

    public boolean myIsMatch2(String s, String p) {

        // System.out.println(s + "," + p);

        if (s.length() == 0) {
            if (p.length() == 0)
                return true;
            if (p.length() == 1)
                return false;
            if (p.length() > 1)
                if (p.charAt(1) == '*')
                    return myIsMatch2(s, p.substring(2));
                else
                    return false;
        }

        if (p.length() == 0)
            return false;

        char s0 = s.charAt(0);
        char p0 = p.charAt(0);
        char p1;
        if (p.length() > 1)
            p1 = p.charAt(1);
        else
            p1 = '\0';

        if (s0 == p0 || p0 == '.') {
            if (p1 == '*')
                return myIsMatch2(s.substring(1), p)
                        || myIsMatch2(s, p.substring(2));
            return myIsMatch2(s.substring(1), p.substring(1));
        }

        if (p1 == '*') {
            return myIsMatch2(s, p.substring(2));
        }

        return false;
    }

    public boolean myIsMatch(String s, String p) {

        // System.out.println(s + "," + p);

        if (s.length() == 0) {
            if (p.length() == 0)
                return true;
            if (p.length() == 1)
                return false;
            if (p.length() > 1)
                if (p.charAt(1) == '*')
                    return myIsMatch(s, p.substring(2));
                else
                    return false;
        }

        if (p.length() == 0)
            return false;

        char s0 = s.charAt(0);
        char p0 = p.charAt(0);
        char p1;
        if (p.length() > 1)
            p1 = p.charAt(1);
        else
            p1 = '\0';

        if (s0 == p0 || p0 == '.') {
            if (p1 == '*')
                return myIsMatch(s.substring(1), p)
                        || myIsMatch(s, p.substring(2));
            return myIsMatch(s.substring(1), p.substring(1));
        }

        if (p1 == '*') {
            return myIsMatch(s, p.substring(2));
        }

        return false;
    }

}
