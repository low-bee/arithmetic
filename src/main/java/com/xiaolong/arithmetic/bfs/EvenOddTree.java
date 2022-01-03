package com.xiaolong.arithmetic.bfs;

import com.xiaolong.arithmetic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 * <p>
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/even-odd-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/12/25 5:20 下午
 */
public class EvenOddTree {

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isOdd = false;

        while (!queue.isEmpty()) {
            int size = queue.size();

            int prev = isOdd ? Integer.MAX_VALUE : 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);

                if (isOdd) {
                    if (curr.val % 2 != 0 || curr.val >= prev) {
                        return false;
                    }
                } else {
                    if (curr.val % 2 == 0 || curr.val <= prev) {

                        return false;
                    }
                }
                prev = curr.val;
            }
            isOdd = !isOdd;
        }
        return true;
    }
}
