package com.xiaolong.arithmetic.array;

/**
 * @Description: 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/10/16 7:17 上午
 */
public class NextArray {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for ( ; i >= 0 && nums[i] > nums[i + 1]; i--){}

        if (i >=0 ){
            int j = nums.length - 1;
            for( ; j >=0 && nums[j] > nums[i]; j--){}
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }
    public void nextPermutation2(int[] nums) {
        int i = nums.length - 2;
        for (;i >= 0 && nums[i] >= nums[i + 1];i--){}

        if (i >= 0) {
            int j = nums.length - 1;
            for(;j >= 0 && nums[i] >= nums[j];j--){}
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i){
        int j = nums.length - 1;
        for ( ; i<j; i++, j--){
            swap(nums, i, j);
        }
    }

}
