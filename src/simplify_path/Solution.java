package simplify_path;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/+");
        Deque<String> deque = new LinkedList<String>();
        for (String dir : paths) {
            if (dir.equals(".") || dir.equals("")) {
                continue;
            }
            else if (dir.equals("..")) {
                if (deque.size() > 0)
                    deque.pop();
            }
            else {
                deque.push(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append('/');
            sb.append(deque.removeLast());
        }
        if (sb.length() == 0)
            return "/";
        return sb.toString();
    }
}
