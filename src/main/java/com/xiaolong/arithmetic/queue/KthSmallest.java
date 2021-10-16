package com.xiaolong.arithmetic.queue;


import com.xiaolong.arithmetic.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description: 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * @Author xiaolong
 * @Date 2021/10/17 7:03 上午
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        // 广度优先 + 优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (que.size() != 0){

            int size = que.size();
            while (size > 0){
                TreeNode curr = que.poll();
                assert curr != null;
                if (curr.left != null){
                    que.add(curr.left);
                }
                if (curr.right != null){
                    que.add(curr.right);
                }
                if (queue.size() == k){
                    if (queue.peek() > curr.val){
                        queue.remove();
                        queue.add(curr.val);
                    }
                } else {
                    queue.add(curr.val);
                }
                size --;
            }
        }
        return queue.peek();
    }
}
