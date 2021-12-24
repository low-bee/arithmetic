package com.xiaolong.arithmetic.dfs;

/**
 * @Description:
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author xiaolong
 * @Date 2021/12/23 9:15 上午
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        // row col > 0
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int ret = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j]-'1' == 0 ){
                    ret += 1;
                    changeVisited(visited, i, j, grid);
                }
            }
        }
        return ret;
    }

    private void changeVisited(boolean[][] visited, int i, int j, char[][] grid) {
        if (grid[i][j] - '1' == 0){
            visited[i][j] = true;
            if (i + 1 < grid.length && !visited[i+1][j] && grid[i+1][j] == '1'){
                changeVisited(visited, i + 1, j, grid);
            }
            if (j + 1 < grid[0].length && !visited[i][j+1] && grid[i][j+1]== '1'){
                changeVisited(visited, i, j+ 1, grid);
            }
            if (i - 1 >= 0 && !visited[i-1][j] &&  grid[i-1][j ]== '1'){
                changeVisited(visited, i-1, j, grid);
            }
            if (j - 1 >= 0 && !visited[i][j-1] &&  grid[i][j-1]== '1'){
                changeVisited(visited, i, j - 1, grid);
            }
        }
    }

    public static void main(String[] args) {
        char[][] a = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        new NumIslands().numIslands(a);
    }
}
