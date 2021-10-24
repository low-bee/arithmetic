package com.xiaolong.arithmetic;

/**
 * @Description: 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/10/25 6:47 上午
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length; int col = matrix[0].length;
        int i = 0, j = matrix[0].length-1;

        while (i < row && j >= 0){
            if (target == matrix[i][j]){
                return true;
            } else if (target > matrix[i][j]){
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
