package com.xiaolong.arithmetic.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * @Author xiaolong
 * @Date 2022/1/2 10:15 下午
 */
public class Subsets {

    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ret;
    }

    private void dfs(int step, int[] nums){

        if (step == nums.length){
            ret.add(new ArrayList<>(temp));
        } else {
            temp.add(nums[step]);
            dfs(step + 1, nums);
            temp.remove(temp.size() - 1);
            dfs(step + 1, nums);
        }
    }


    public List<List<Integer>> subsets1(int[] nums) {
        dfs1(0, nums);
        return ret;
    }

    private void dfs1(int step, int[] nums){
        ret.add(new ArrayList<>(temp));

        for (int i = step; i < nums.length; i++){
            temp.add(nums[i]);
            dfs1(i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};

        System.out.println(new Subsets().subsets1(a));
    }

}
