package com.xiaolong.arithmetic.bfs;

import com.xiaolong.arithmetic.NNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/11/21 12:10 下午
 */
public class NTreeMaxDepth {

    public int maxDepth(NNode root) {
        if (root == null) return 0;

        Deque<NNode> nNodeDeque = new LinkedList<>();
        nNodeDeque.addLast(root);
        int ret = 0;
        while (nNodeDeque.size() != 0){
            int n = nNodeDeque.size();
            ret += 1;
            while (n > 0){
                List<NNode> next = nNodeDeque.poll().children;
                if (next.size() > 0){
                    next.forEach(nNodeDeque::addLast);
                }
                n--;
            }
        }
        return ret;
    }
}
