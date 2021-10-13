package com.xiaolong.arithmetic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * @Author xiaolong
 * @Date 2021/10/11 6:42 上午
 */
public class PermuteUnique {
    boolean vis[];
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums){
        List<Integer> prem = new ArrayList<>();
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        back(nums, 0, prem);
        return ret;
    }

    private void back(int[] nums, int idx, List<Integer> prem) {
        if (idx == nums.length){
            ret.add(new ArrayList<>(prem));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && !vis[i - 1] && nums[i] == nums[i - 1])){
                continue;
            }
            prem.add(nums[i]);
            vis[i] = true;
            back(nums, idx + 1, prem);
            prem.remove(idx);
            vis[i] = false;
        }
    }
}
