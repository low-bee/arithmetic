package com.xiaolong.arithmetic.array;

/**
 * @Description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @Author xiaolong
 * @Date 2021/10/6 6:53 上午
 */
public class SingleNumber {
    // HashMap + 计数
    // 使用 位运算 ^ 即 如果两个数字相同就会抵消
    public int singleNumber(int[] nums){
        int ret = 0;
        for (int num : nums){
            ret ^= num;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
