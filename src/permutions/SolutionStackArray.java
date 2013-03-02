package permutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;

public class SolutionStackArray {

    int cc = 0;

    boolean contains(int[] arr, int x) {
        for (int i : arr)
            if (x == i)
                return true;
        return false;
    }

    int compareto(int[] a, int[] b) {
        if (a.length > b.length)
            return 1;
        if (b.length > a.length)
            return -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i])
                return 1;
            if (b[i] > a[i])
                return -1;
        }
        return 0;
    }

    public LinkedList<int[]> search(int size) {
        int timecount = 0;

        LinkedList<int[]> mappers = new LinkedList<int[]>();

        LinkedList<int[]> s = new LinkedList<int[]>();
        s.push(new int[0]);
        int[] allNums = new int[size];
        for (int i = 0; i < size; i++)
            allNums[i] = i;

        int[] poped = new int[0];
        while (s.size() > 0) {
            int[] top = s.peek();
            boolean breakit = false;
            for (int i : allNums) {
                if (contains(top, i))
                    continue;
                cc++;
                int[] num = Arrays.copyOf(top, top.length + 1);
                num[num.length - 1] = i;
                if (compareto(num, poped) > 0) {
                    s.push(num);
                    if (num.length > size - 1) {
                        mappers.add(num);
                    }
                    breakit = true;
                    break;
                }
            }
            if (!breakit)
                poped = s.pop();
        }
        System.out.println("cc:" + cc);
        return mappers;
    }

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        LinkedList<int[]> mappers = search(num.length);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int[] mapper : mappers) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for (int i : mapper) {
                tmp.add(num[i]);
            }
            result.add(tmp);
        }

        return result;
    }
}