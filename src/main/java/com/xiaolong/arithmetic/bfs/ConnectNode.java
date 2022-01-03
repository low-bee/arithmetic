package com.xiaolong.arithmetic.bfs;


import com.xiaolong.arithmetic.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 *
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/12/24 9:00 上午
 */
public class ConnectNode {

    public Node connect(Node root) {
        if(root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            Node prev = queue.poll();
            if (prev.left != null) queue.add(prev.left);
            if (prev.right != null) queue.add(prev.right);

            for (int i = 0; i < n - 1; i++) {
                Node curr = queue.poll();
                assert curr != null;
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                prev.next = curr;
                prev = prev.next;
            }
        }

        return root;
    }
}
