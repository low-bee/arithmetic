package com.xiaolong.arithmetic.array;

/**
 * @Description:
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/10/10 7:02 上午
 */
public class Rotate {
    /**
     * [00 01 02]            [20 10 00]
     *             [10 11 12] => 变到位置 [21 11 01]
     *             [20 21 22]            [22 12 02]
     *             00 -> 02  10 -> 01  20 -> 00
     *             01 -> 12  11 -> 11  21 -> 10
     *             02 -> 22  12 -> 21  22 -> 20
     *
     *             由此可以推断出，旋转90的下标公式为 a[i][j] = a[j][a.length - i]
     *             因此对于任意一个下标我们都可以在找到它在矩阵中的位置
     *             如果可以引入一个新的数组，可以通过遍历的方式将数组赋值
     *
     *             但是现在要求原地旋转，那么我们可以引入一个变量temp保存当前的下标所对应的值
     *                 然后使用 j 表示当前的深度，使用i表示当前深度下需要循环多少次
     *                 也就是说
     *                 for(j = 0; j < n / 2 ; j++){
     *                     for(i = j; i < n - j*2 - 1; i ++){
     *                         do(i, j, nums);
     *                     }
     *                 }
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length-1;
        for (int j = 0; j <= n / 2; j++){
            for(int i = 0; i < n - j * 2 ; i++){
                doSwap(i, j, matrix);
            }
        }
    }

    private void doSwap(int i, int j, int[][] matrix){
        // i, j 表示第j层的第i个元素
        // 例如，第0层的第0个，00，第0层的第1个 01
        // 第1层的第0个 11，第1层的第1个 12
        // 第2层的第0个 22, 第2层的第1个 23
        // 因此 第j层的第i个为下标为j ,j + i, 这样就将i，j的含义转变成为下标了
        int t = i;
        i = j;
        j = j + t;
        int k = 4;
        int n = matrix.length - 1;
        int temp = matrix[i][j];
        while (k > 0){
            int t2 = matrix[j][n - i];
            matrix[j][n - i] = temp;
            temp = t2;
            int t1 = i;
            i = j;
            j = n - t1;
            k--;
        }
    }
}
