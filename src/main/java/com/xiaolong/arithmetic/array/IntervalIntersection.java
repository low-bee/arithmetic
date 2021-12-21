package com.xiaolong.arithmetic.array;

import jdk.nashorn.internal.ir.IfNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 *
 * 返回这 两个区间列表的交集 。
 *
 * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
 *
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interval-list-intersections
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/12/21 10:38 上午
 */
public class IntervalIntersection {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // 双指针
        int first = 0;
        int second = 0;
        List<int[]> ret = new LinkedList<>();
        for (int i = 0; i < Math.min(firstList.length, secondList.length); i++) {
            int flag = judgeInterval(firstList[first], secondList[second]);
            if (flag != 0){  // 说明有交集
                if (flag == 1){  // 前面的大
                    second = getSecond(firstList, secondList, first, second, ret);
                } else {
                    first = getSecond(secondList, firstList, second, first, ret);
                }
            } else {
                // 无交集
                if (firstList[first][0] > secondList[second][0]) {
                    second ++;
                } else {
                    first ++;
                }
            }
        }
        return ret.toArray(new int[0][]);
    }

    private int getSecond(int[][] firstList, int[][] secondList, int first, int second, List<int[]> ret) {
        if (firstList[first][0] > secondList[second][0] || firstList[first][0] == secondList[second][1]){
            ret.add(new int[]{firstList[first][0], secondList[second][1]});
        } else {
            ret.add(new int[]{secondList[second][0], secondList[second][1]});
        }
        second ++;
        return second;
    }

    private int judgeInterval(int[] first, int[] last){
        // 0没有交集 1前面的大 2last大
        if (first[0] > last[1] && first[1] < last[0] || first[0] == last[1]) {
            return 1;
        } else if (first[0] < last[1] && first[1] > last[0] || last[0] == first[1]) {
            return 2;
        } else {
            return 0;
        }
    }

}
