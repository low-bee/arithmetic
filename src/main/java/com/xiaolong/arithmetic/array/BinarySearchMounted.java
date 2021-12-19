package com.xiaolong.arithmetic.array;

/**
 * @Description: 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/12/19 11:22 上午
 */
public class BinarySearchMounted {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length-1;

        while (l < r) {
            int mid = (r-l)/2 + l;
            if (mid - 1 >= 0 && nums[mid] > nums[mid - 1]){
                if (mid + 1 < nums.length && nums[mid] < nums[mid + 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else if(mid + 1 < nums.length && nums[mid] < nums[mid + 1]) {
                if (mid - 1 >= 0 && nums[mid] > nums[mid - 1]){
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }else {
                r = mid ;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        new BinarySearchMounted().findPeakElement(new int[]{3,4});
    }
}
