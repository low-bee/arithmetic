package com.xiaolong.arithmetic.bfs;


import com.xiaolong.arithmetic.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
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
