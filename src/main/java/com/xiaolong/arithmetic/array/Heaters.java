package com.xiaolong.arithmetic.array;

import java.util.Arrays;

/**
 * @Description: 冬季已经来临。你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * <p>
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * <p>
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * <p>
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/heaters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/12/20 1:45 下午
 */
public class Heaters {

    public int findRadius(int[] houses, int[] heaters) {
        // 排序heaters
        Arrays.sort(heaters);
        // 找到houses所处在heaters中的位置
        // 然后计算当前值和应该所在的空位和最近的一个供暖器的距离
        int ret = 0;
        for (int house : houses) {
            int index = binarySearchSlot(heaters, house);
            // 说明是第一个位置
            if (index == 0) {
                ret = Math.max(ret, heaters[index] - house);
            } else if (index == heaters.length) { // 说明是最后一个位置
                ret = Math.max(ret, house -heaters[index - 1]);
            } else { // 在中间
                int temp = Math.min(house - heaters[index - 1], heaters[index] - house);
                ret = Math.max(temp, ret);
            }
        }
        // 将首尾值和排序好的值做差值找到最大值
        return ret;
    }

    private int binarySearchSlot(int[] heaters, int house) {
        int low = 0, mid, high = heaters.length - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (heaters[mid] < house)
                low = mid + 1;
            else if (heaters[mid] > house)
                high = mid - 1;
            else
                return mid;
        }
        return low;
    }

    public static void main(String[] args) {
        new Heaters().findRadius(new int[]{1,2,3}, new int[]{2});
    }
}
