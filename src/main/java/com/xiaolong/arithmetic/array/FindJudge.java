package com.xiaolong.arithmetic.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Description:
 * 在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。
 *
 * 如果小镇的法官真的存在，那么：
 *
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足条件 1 和条件 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示编号为 a 的人信任编号为 b 的人。
 *
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-town-judge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/12/19 10:14 上午
 */
public class FindJudge {
    public int findJudge(int n, int[][] trusts) {
        if (n == 0 && trusts.length == 0) return 1;
        Map<Integer, Integer> trustNum = new HashMap<>();
        Map<Integer, Integer> trustOther = new HashMap<>();
        for (int[] trust : trusts) {
            trustNum.put(trust[1], trustNum.getOrDefault(trust[1], 0) + 1);
            trustOther.put(trust[0], trustOther.getOrDefault(trust[0], 0 ) + 1);
        }
        for (Map.Entry<Integer, Integer> numTrust : trustNum.entrySet()) {
            if (numTrust.getValue() == n - 1 && trustOther.get(numTrust.getKey()) == 0){
                return numTrust.getKey();
            }
        }
        return -1;
    }

    public int findJudge1(int n, int[][] trusts){

        int[] trustNum = new int[n];
        HashSet<Integer> notJudge = new HashSet<>();
        int currIndex = 0, max = 0;
        for (int[] trust : trusts) {
            trustNum[trust[1] - 1] += 1;
            notJudge.add(trust[0] - 1);
            if (trustNum[trust[1] - 1] > max){
                currIndex = trust[1] - 1;
                max = trustNum[trust[1] - 1];
            }
        }
        if (trustNum[currIndex] == n-1 && !notJudge.contains(currIndex)){
            return currIndex + 1;
        }
        return -1;
    }
}
