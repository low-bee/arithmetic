package com.xiaolong.arithmetic.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。 任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/12/26 9:23 上午
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        int row = board.length, col = board[0].length;
        // 当board小于三，不会出现能替换的O
        if (row < 3) {
            return;
        }

        boolean[][] willNotReplace = new boolean[row][col];
        boolean[][] visited = new boolean[row][col];
        // 如果一个O不会被替换，那么它一定能在一个和边缘相连的的边中找到
        // 因此，我们遍历边，找到所有和边相连的元素O即可

        // 4 6
        Queue<int[]> temp = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') { // 右
                temp.add(new int[]{i, 0});
                willNotReplace[i][0] = true;
            }
            visited[i][0] = true;
        }
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') { // 上边界
                temp.add(new int[]{0, i});
                willNotReplace[0][i] = true;
            }
            visited[0][i] = true;
        }
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][row - 1] == 'O') { // 下边界
                temp.add(new int[]{i, row - 1});
                willNotReplace[i][row - 1] = true;
            }
            visited[i][row - 1] = true;
        }
        for (int i = col - 1; i >= 0; i--) {
            if (board[col - 1][i] == 'O') { // 下边界
                temp.add(new int[]{col - 1, i});
                willNotReplace[col - 1][i] = true;
            }
            visited[col - 1][i] = true;
        }
        int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!temp.isEmpty()) {
            int[] curr = temp.poll();
            for (int i = 0; i < 4 &&
                    curr[0] + direction[i][0] >= 0 && curr[0] + direction[i][0] < row
                    && curr[1] + direction[i][1] >= 0 && curr[1] + direction[i][1] < col
                    && !visited[curr[0] + direction[i][0]][curr[1] + direction[i][1]]; i++) {

                int nextRow = curr[0] + direction[i][0];
                int nextCol = curr[1] + direction[i][1];

                visited[nextRow][nextCol] = true;
                if (board[nextRow][nextCol] == 'O') {
                    temp.add(new int[]{nextRow, nextCol});
                    willNotReplace[nextRow][nextCol] = true;

                }

            }

        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!willNotReplace[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        new SurroundedRegions().solve(new char[][]{{'X', 'O', 'X'}, {'X', 'O', 'X'}, {'X', 'O', 'X'}});
    }
}
