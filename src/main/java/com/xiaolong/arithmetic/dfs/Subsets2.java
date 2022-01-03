package com.xiaolong.arithmetic.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Description:
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author xiaolong
 * @Date 2022/1/2 11:25 下午
 */
public class Subsets2 {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    HashSet<List<Integer>> temp = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int step) {
        res.add(new ArrayList<>(path));

        for (int i = step; i < nums.length; i++) {
            if (!(i != step && nums[i] == nums[i-1])) {
                path.add(nums[i]);
                dfs(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] t = {1,2,2};

        System.out.println(new Subsets2().subsetsWithDup(t));
    }
}
