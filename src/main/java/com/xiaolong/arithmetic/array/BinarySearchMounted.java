package com.xiaolong.arithmetic.array;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
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
