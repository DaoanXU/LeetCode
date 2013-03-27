package edit_distance;

public class Solution {
    public static int editDistance(String s1, String s2) {
        int[][] distance = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++)
            distance[i][0] = i;
        for (int i = 1; i < s2.length() + 1; i++)
            distance[0][i] = i;

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                int cost = s1.charAt(i) == s2.charAt(j) ? 0 : 1;
                distance[i + 1][j + 1] = min(distance[i][j + 1] + 1, 
                                             distance[i + 1][j] + 1,
                                             distance[i][j] + cost);
                /*Swap
                if (i > 1 && j > 1 && s1.charAt(i) == s2.charAt(j - 1)
                        && s1.charAt(i - 1) == s2.charAt(j)) {
                    distance[i + 1][j + 1] = Math.min(distance[i + 1][j + 1],
                                                      distance[i - 1][j - 1] + cost);
                }
                */
            }
        }

        return distance[s1.length()][s2.length()];
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
    
    public int minDistance(String word1, String word2){
        return editDistance(word1, word2);
    }
}
