package com.xiaolong.arithmetic.dp;

import java.util.Map;

/**
 * @Description: 最大乘积子序列
 * @Author xiaolong
 * @Date 2021/10/29 6:49 上午
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        System.arraycopy(nums, 0, max, 0, n);
        System.arraycopy(nums, 0, min, 0, n);

        for(int i = 1; i < n; i++){
            max[i] = Math.max(max[i-1] * nums[i], Math.max(min[i-1] * nums[i], nums[i]));
            min[i] = Math.min(min[i-1] * nums[i], Math.min(max[i-1] * nums[i], nums[i]));
        }

        int ans = max[0];
        for (int i = 1; i < n; ++i) {
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        new MaxProduct().maxProduct(new int[]{2, 3, -2, 4,-2});
    }
}
