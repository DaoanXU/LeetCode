package permutations;

import java.util.Stack;

public class SolutionStackIntegerRepresents {

    void permute(int size) {
        int M = size;
        int poped = 0;
        Stack<Integer> s = new Stack<Integer>();
        s.push(0);
        while (!s.empty()) {
            int top = s.peek();
            int i = 0;
            for (i = 1; i <= M; ++i) {
                if (find(top, i))
                    continue;
                int no = top * 10 + i;
                if (no > poped) {
                    s.push(no);
                    if(no > Math.pow(10, M-1)){
                        
                    }
                    break;
                }
            }
            if (i == M + 1) {
                poped = s.pop();
            }
        }

    }

    private boolean find(int n, int k) {
        boolean result = false;
        while (n > 0) {
            if (n % 10 == k) {
                result = true;
                break;
            } else
                n = n / 10;
        }
        return result;
    }

}
