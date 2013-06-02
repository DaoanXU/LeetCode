package word_search;

public class Solution {
    char[][] board;
    boolean[][] visited;
    char[] word;
    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.visited = new boolean[m][n];
        this.word = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (findLocation(i, j, 0))
                    return true;
            }
        }
        return false;
    }

    boolean findLocation(int x, int y, int wordIndex) {
        if (board[x][y] != word[wordIndex])
            return false;

        wordIndex++;
        if (wordIndex == word.length)
            return true;

        boolean result = false;
        visited[x][y] = true;

        int nx;
        int ny;

        nx = x + 1;
        ny = y;
        if (!result && valid(nx, ny) && !visited[nx][ny])
            result = result || findLocation(nx, ny, wordIndex);

        nx = x - 1;
        ny = y;
        if (!result && valid(nx, ny) && !visited[nx][ny])
            result = result || findLocation(nx, ny, wordIndex);

        nx = x;
        ny = y + 1;
        if (!result && valid(nx, ny) && !visited[nx][ny])
            result = result || findLocation(nx, ny, wordIndex);

        nx = x;
        ny = y - 1;
        if (!result && valid(nx, ny) && !visited[nx][ny])
            result = result || findLocation(nx, ny, wordIndex);

        visited[x][y] = false;
        return result;
    }

    boolean valid(int x, int y) {
        if (x < 0 || y < 0)
            return false;
        if (x >= m)
            return false;
        if (y >= n)
            return false;
        return true;
    }
}