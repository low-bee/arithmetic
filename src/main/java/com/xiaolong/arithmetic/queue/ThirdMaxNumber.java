package com.xiaolong.arithmetic.queue;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @Description: 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * @Author xiaolong
 * @Date 2021/10/6 6:25 上午
 */
public class ThirdMaxNumber {
    public int thirdMax(int[] nums) {

        if (nums.length == 1){
            return nums[0];
        } else if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        HashSet<Integer> theNum = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (!theNum.contains(num)) {
                if (queue.size() < 3) {
                    queue.add(num);
                } else {
                    if (queue.peek() < num) {
                        queue.poll();
                        queue.add(num);
                    }
                }
            }
            theNum.add(num);
        }
        return queue.size() > 2 ? queue.peek() : (Integer) queue.toArray()[queue.size()-1];
    }
}
