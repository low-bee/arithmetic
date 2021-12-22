package com.xiaolong.arithmetic.array;

/**
 * @Description:
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/12/22 12:29 下午
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int prev = 0, l = 0;
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < length; i++){
            prev += (nums[i]);
            while (prev >= target){
                ret = Math.min(ret, i - l + 1);
                prev -= nums[l++];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        new MinSubArrayLen().minSubArrayLen(7,new int[]{2,3,1,2,4,3});
    }

}
