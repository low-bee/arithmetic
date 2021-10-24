package com.xiaolong.arithmetic.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * @Author xiaolong
 * @Date 2021/10/22 8:07 上午
 */
public class MajorityElement3 {

    public List<Integer> majorityElement(int[] nums) {
        // HashMap 时间 O(n) 空间 O(nlogk)
        // 抵消法 每三个数抵消一次，当剩余数字没有办法组成三个数字的时候，就超过了1/3 时间 O(n) 空间O(1)
        int first = 0, second = 0;
        int num1 = 0, num2 = 0;

        for(int num : nums){
            // 第一个数字
            if(num1 > 0 && first == num){
                num1 ++;
            } else if (num2 > 0 && second == num){
                num2 ++;
            } else if (num1 == 0){
                num1 = 1; first = num;
            } else if (num2 == 0){
                num2 = 1; second = num;
            } else {
                num1--; num2--;
            }
        }
        int count1 = 0, count2 = 0;
        for (int num: nums){
            if (num == first) count1++;
            if (num == second) count2++;
        }
        List<Integer> ret = new ArrayList<>();
        if (num1 > 0 && count1 > nums.length / 3){
            ret.add(first);
        }
        if (num2 > 0 && count2 > nums.length / 3){
            ret.add(second);
        }
        return ret;
    }

}
