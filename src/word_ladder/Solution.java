package word_ladder;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    private static class Graph {
        HashMap<String, HashSet<String>> graph;

        Graph() {
            graph = new HashMap<String, HashSet<String>>();
        }

        public void add(String word) {
            char[] wordChars = word.toCharArray();
            for (int i = 0; i < wordChars.length; i++) {
                char before = wordChars[i];
                wordChars[i] = (char) 0;
                String key = String.valueOf(wordChars);

                HashSet<String> valueSet = graph.get(key);
                if (valueSet == null) {
                    valueSet = new HashSet<String>();
                    graph.put(key, valueSet);
                }
                valueSet.add(word);

                wordChars[i] = before;
            }
        }

        public HashSet<String> connectTo(String word) {
            char[] wordChars = word.toCharArray();
            HashSet<String> result = new HashSet<String>();
            for (int i = 0; i < wordChars.length; i++) {
                char before = wordChars[i];
                wordChars[i] = (char) 0;
                String key = String.valueOf(wordChars);

                HashSet<String> valueSet = graph.get(key);
                if (valueSet == null)
                    return null;

                result.addAll(valueSet);

                wordChars[i] = before;
            }
            return result;
        }
    }

    public int ladderLength(String start, String end, HashSet<String> dict) {
        Graph graph = new Graph();
        graph.add(start);
        graph.add(end);
        for (String word : dict)
            graph.add(word);

        return BFS(graph, start, end);
    }

    private int BFS(Graph graph, String start, String end) {
        int length = 1;
        if (start.equals(end))
            return 0;

        HashSet<String> visited = new HashSet<String>();
        HashSet<String> outGoing = new HashSet<String>();
        HashSet<String> reaching = new HashSet<String>();
        reaching.add(start);
        visited.add(start);

        while (!visited.contains(end) && reaching.size() > 0) {
            length++;
            HashSet<String> temp = outGoing;
            outGoing = reaching;
            reaching = temp;
            reaching.clear();

            for (String word : outGoing) {
                for (String toWord : graph.connectTo(word)) {
                    if (!visited.contains(toWord)) {
                        reaching.add(toWord);
                        visited.add(toWord);
                    }
                }
            }
        }

        return reaching.size() > 0 ? length : 0;
    }
}
