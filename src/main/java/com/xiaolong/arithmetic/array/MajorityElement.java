package com.xiaolong.arithmetic.array;

/**
 * @Description: 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * @Author xiaolong
 * @Date 2021/10/6 6:58 上午
 */
public class MajorityElement {
    // HashMap + 计数
    // 二分 + 归并
    // 排序
    // 去掉一对相同的元素，数组的众数不变
    public int majorityElement(int[] nums) {
        int count = 0, curr = 0;
        for (int num : nums) {
            if (count == 0){
                curr = num;
            }
            count += (num == curr) ? 1 : -1;
        }
        return curr;
    }
}
