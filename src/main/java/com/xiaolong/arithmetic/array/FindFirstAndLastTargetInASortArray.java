package com.xiaolong.arithmetic.array;

/**
 * @Description:
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/11/21 12:35 下午
 */
public class FindFirstAndLastTargetInASortArray {
    int[] ret = { -1, -1};

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return ret;
        ret[0] = searchNum(nums, target, true);
        ret[1] = searchNum(nums, target, false);
        return ret;
    }

    private int searchNum(int[] nums, int target, boolean flag) {
        // flag 为 true 表示搜索前一个元素，否则表示搜索后一个元素
        int start = 0, end = nums.length;
        int n = nums.length;
        if (flag){
            while (end >= start){
                int mid = start + (end - start) / 2;
                if (mid >= n) return -1;
                if ((nums[mid] == target && mid == 0) || (nums[mid] == target && nums[mid-1] < nums[mid])){
                    return mid;
                } else if (nums[mid] >= target){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        } else {
            while (end >= start){
                int mid = start + (end - start) / 2;
                if (mid >= n) return -1;
                if ((nums[mid] == target && mid == n - 1) || (nums[mid] == target && nums[mid+1] > nums[mid])){
                    return mid;
                } else if (nums[mid] > target){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {2,2};
        new FindFirstAndLastTargetInASortArray().searchRange(ints, 8);
    }
}
