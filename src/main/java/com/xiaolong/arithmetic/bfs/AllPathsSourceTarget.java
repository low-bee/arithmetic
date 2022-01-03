package com.xiaolong.arithmetic.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 *
 * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/12/26 10:46 上午
 */
public class AllPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ret = new ArrayList<>();
        int target = graph.length;
        Queue<List<Integer>> temp = new LinkedList<>();
        //bfs
        List<Integer> first = new ArrayList<Integer>();
        first.add(0);
        temp.add(first);

        while (!temp.isEmpty()) {
            int size = temp.size();
            List<Integer> curr = temp.poll();
            int n = curr.get(curr.size() - 1);
            for (int i = 0; i < graph[n].length; i ++) {
                List<Integer> mayRet = new ArrayList<>(curr);

                mayRet.add(graph[n][i]);
                if (graph[n][i] == target - 1){
                    ret.add(mayRet);
                } else {
                    temp.add(mayRet);
                }

            }
        }
        return ret;
    }
}
