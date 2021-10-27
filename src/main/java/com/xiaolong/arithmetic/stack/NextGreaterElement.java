package com.xiaolong.arithmetic.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Description: 给你两个 没有重复元素 的数组nums1 和nums2，其中nums1是nums2的子集。
 *
 * 请你找出 nums1中每个元素在nums2中的下一个比其大的值。
 *
 * nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/10/26 7:29 上午
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 排序+二分查找O(nlogn)
        // 单调栈 + HashMap
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();

        for (int i = nums2.length - 1; i >= 0 ; i--) {

            while (!stack.isEmpty() && nums2[i] > stack.peek()){
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ret[i] = map.get(nums1[i]);
        }
        return ret;
    }
}
