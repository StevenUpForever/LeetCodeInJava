package union_find;

import public_class.UnionFind;

public class NumberOfIslands {

    //Difficulty: medium
    //TAG: Google
    //TAG: Facebook
    //TAG: Microsoft
    //TAG: Amazon
    //TAG: Apple
    //TAG: DFS
    //TAG: BFS
    //TAG: union find

    /**
     * 200. Number of Islands
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.

     Example 1:

     11110
     11010
     11000
     00000
     Answer: 1

     Example 2:

     11000
     11000
     00100
     00011
     Answer: 3
     */

    /*
     * Solution 1:
     * DFS, when find a '1', try to set all adjacent '1' to '0' (including itself)
     *
     * Then when met another 1, it must be another island
     *
     * Time: O(2mn)
     * Space: O(1)
     */

    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }

    /*
     * Solution 2:
     * union find
     * always merge current 1 to nearest unit, see UnionFind class
     * due to merge from left top, so, at current 1, left and up could be the same unit
     *
     * Time: O(mn) initial unionFind + O(mn) search for 1 and do union found
     * Union fond takes essentially O(1) due yo update by rank
     * Space: O(mn)
     */
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        UnionFind union = new UnionFind(grid);
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    int curIndex = i * col + j;
                    //Only 1 and 1 could union
                    if (i > 0 && grid[i - 1][j] == '1') {
                        int up = (i - 1) * col + j;
                        union.union(curIndex, up);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        int left = i * col + j - 1;
                        union.union(curIndex, left);
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == '1') {
                        int down = (i + 1) * col + j;
                        union.union(curIndex, down);
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
                        int right = i * col + j + 1;
                        union.union(curIndex, right);
                    }
                }
            }
        }
        return union.getCount();
    }

}
