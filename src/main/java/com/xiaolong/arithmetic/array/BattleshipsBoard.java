package com.xiaolong.arithmetic.array;

/**
 * @Description:
 * 给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的 战舰 的数量。
 *
 * 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/battleships-in-a-board
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/12/18 7:21 上午
 */
public class BattleshipsBoard {

    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]){
                    continue;
                }
                if (board[i][j] == '.'){
                    visited[i][j] = true;
                } else {
                    ret ++;
                    int k = 1;
                    while (i+k<m && board[i+k][j] == 'X'){
                        visited[i+k][j] = true;
                        k++;
                    }
                    if (k > 1){
                        continue;
                    }
                    while (j+k <n && board[i][j+k] == 'X'){
                        visited[i][j+k] = true;
                        k++;
                    }
                }
            }
        }
        return ret;
    }
}
