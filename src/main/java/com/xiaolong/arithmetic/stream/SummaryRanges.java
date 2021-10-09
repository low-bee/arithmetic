package com.xiaolong.arithmetic.stream;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description:
 * 给你一个由非负整数a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。
 *
 * 实现 SummaryRanges 类：
 *
 * SummaryRanges() 使用一个空数据流初始化对象。
 * void addNum(int val) 向数据流中加入整数 val 。
 * int[][] getIntervals() 以不相交区间[starti, endi] 的列表形式返回对数据流中整数的总结。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author xiaolong
 * @Date 2021/10/9 6:58 上午
 */
public class SummaryRanges { // ❎
    HashMap<Integer, int[]> curr ;

    public SummaryRanges() {
        curr = new HashMap<>();
    }

    public void addNum(int val) {
        if (curr.get(val - 1) != null){

            if (curr.get(val + 1) != null){
                int[] temp = new int[]{val-1, val + 1};
                curr.put(val - 1, temp);
                curr.put(val + 1, temp);
                curr.put(val, temp);
            } else {
                int[] temp = new int[]{val - 1, val};
                curr.put(val - 1, temp);
                curr.put(val , temp);
            }

        } else {
            if (curr.get(val + 1) != null){
                int[] temp = new int[] {val, val + 1};
                if (!curr.containsKey(val + 2)) {
                    curr.put(val, temp);
                    curr.put(val + 1, temp);
                }
            } else {
                curr.put(val, new int[]{val, val});
            }
        }

    }

    public int[][] getIntervals() {
        HashSet<int[]> hashSet = new HashSet<>(curr.values());

        return hashSet.toArray(new int[0][0]);
    }
}
