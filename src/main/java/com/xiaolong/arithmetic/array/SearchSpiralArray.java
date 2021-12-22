package com.xiaolong.arithmetic.array;

import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @Description: 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ...,
 * <p>
 * nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/12/21 3:37 下午
 */
public class SearchSpiralArray {
    public int search(int[] nums, int target) {
        // 二分搜索，一个旋转之后的数组，二分之后，必定有其中一边是有序的
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] > nums[r] && nums[mid] > l) { // 左边有序
                if (target <= nums[mid] && target >= nums[l]) { // 如果这个值恰好在左边，调用二分搜索，
                    return binarySearch(nums, l, mid, target);
                } else { // 否则应该在右边继续二分
                    l = mid + 1;
                }
            } else { // 右边有序
                if (target >= nums[mid] && target <= nums[r]) {
                    return binarySearch(nums, mid, r, target);
                } else {
                    r = mid;
                }
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        if (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return binarySearch(nums, l, mid - 1, target);
            } else {
                return binarySearch(nums, mid + 1, r, target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchSpiralArray().search(new int[]{1}, 1));
    }
}
