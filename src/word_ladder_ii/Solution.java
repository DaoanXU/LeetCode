package word_ladder_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution {

    private Graph graph;
    private String startWord;
    private String endWord;
    private HashSet<String> dict;

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

    private void initMap() {
        graph = new Graph();
        graph.add(startWord);
        graph.add(endWord);
        for (String word : dict)
            graph.add(word);
    }

    private HashMap<String, HashSet<String>> BFS() {
        HashMap<String, HashSet<String>> reverseLinks = new HashMap<String, HashSet<String>>();
        if (startWord.equals(endWord))
            return reverseLinks;

        HashSet<String> visited = new HashSet<String>();
        HashSet<String> outGoing = new HashSet<String>();
        HashSet<String> reaching = new HashSet<String>();
        reaching.add(startWord);
        visited.add(startWord);

        while (!visited.contains(endWord) && reaching.size() > 0) {
            HashSet<String> temp = outGoing;
            outGoing = reaching;
            reaching = temp;
            reaching.clear();

            for (String fromWord : outGoing) {
                for (String toWord : graph.connectTo(fromWord)) {
                    if (!visited.contains(toWord)) {
                        reaching.add(toWord);

                        HashSet<String> from = reverseLinks.get(toWord);
                        if (from == null) {
                            from = new HashSet<String>();
                            reverseLinks.put(toWord, from);
                        }
                        from.add(fromWord);
                    }
                }
            }

            visited.addAll(reaching);
        }

        return reverseLinks;
    }

    private ArrayList<ArrayList<String>> getPath(HashMap<String, HashSet<String>> reverseLinks) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        if(startWord.endsWith(endWord)){
            ArrayList<String> tmp = new ArrayList<String>();
            tmp.add(endWord);
            result.add(tmp);
            return result;
        }
        
        if(!reverseLinks.containsKey(endWord))
            return result;       

        
        LinkedList<Object> stack = new LinkedList<Object>();
        LinkedList<String> path = new LinkedList<String>();
        path.add(endWord);
        stack.push(path);
        stack.push(endWord);

        while (!stack.isEmpty()) {
            String word = (String) stack.pop();
            LinkedList<String> currentPath = (LinkedList<String>) stack.pop();
            if (!reverseLinks.containsKey(word)) {
                result.add(new ArrayList<String>(currentPath));
            } else {
                for (String from : reverseLinks.get(word)) {
                    LinkedList<String> newPath = new LinkedList<String>(currentPath);
                    newPath.push(from);
                    stack.push(newPath);
                    stack.push(from);
                }
            }
        }

        return result;
    }

    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        this.startWord = start;
        this.endWord = end;
        this.dict = dict;
        initMap();
        HashMap<String, HashSet<String>> reverseLinks = BFS();
        return getPath(reverseLinks);
    }
}
