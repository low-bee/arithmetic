package com.xiaolong.arithmetic.bfs;

import com.sun.rowset.internal.Row;
import com.xiaolong.arithmetic.array.BinarySearchMounted;

import java.lang.reflect.WildcardType;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 * <p>
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 * <p>
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/12/26 7:23 上午
 */
public class BinaryMatrixShortestPath {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        int[][] temp = {{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}};

        // 广度优先层次遍历
        Queue<int[]> queue = new LinkedList<>();
        if (grid[0][0] == 0) {
            queue.add(new int[]{0, 0});
            visited[0][0] = true;
        } else {
            return -1;
        }
        int ret = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                // 增加到队列中并修改visited
                int[] curr = queue.poll();
                int currRow = curr[0];
                int currCol = curr[1];
                if (currRow == row - 1 && currCol == col - 1) {
                    return ret + 1;
                }
                for (int j = 0; j < 8; j++) {
                    int nextRow = currRow + temp[j][0];
                    int nextCol = currCol + temp[j][1];

                    if (nextRow >= 0 && nextRow < row
                            && nextCol >= 0 && nextCol < col
                            && !visited[nextRow][nextCol]  // 未拜访
                    ) {
                        visited[nextRow][nextCol] = true;
                        if (grid[nextRow][nextCol] == 0) { // 值为0
                            queue.add(new int[]{nextRow, nextCol});
                            flag = true;
                        }
                    }
                }
            }
            if (!flag) {
                return -1;
            } else {
                ret++;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        new BinaryMatrixShortestPath().shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}});
    }
}
