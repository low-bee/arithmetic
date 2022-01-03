package com.xiaolong.arithmetic.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * https://leetcode-cn.com/problems/permutations-ii/
 * @Author xiaolong
 * @Date 2022/1/2 11:43 下午
 */
public class PermuteUnique {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();


    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int step) {

        if (step == nums.length){
            res.add(new ArrayList<>(path));
        }

        for (int i = step; i < nums.length; i++) {
            if (path.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            dfs(nums, step + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(new PermuteUnique().permuteUnique(a));
    }


}
