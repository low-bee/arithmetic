package com.xiaolong.arithmetic.array;

/**
 * @Description:
 *
 * 给定一个正整数数组 nums和整数 k 。
 *
 * 请找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 * @Author xiaolong
 * @Date 2021/12/22 10:47 上午
 */
public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // 滑动窗口
        int length = nums.length;
        int ret = 0;
        int prev = 1, start = 0;
        for (int end = 0; end < length; end++) {
            prev *= nums[end];
            while (prev >= k) {
                prev /= nums[start++];
            }
            ret += (end - start) + 1;
        }
        return ret;
    }
}
