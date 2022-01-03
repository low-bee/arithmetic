package com.xiaolong.arithmetic.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Description:
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author xiaolong
 * @Date 2022/1/3 7:22 上午
 */
public class CombinationSum2 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    HashSet<List<Integer>> temp = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int step, int curr) {
        if (curr == target && !temp.contains(path)) {
            res.add(new ArrayList<>(path));
            temp.add(new ArrayList<>(path));
            return;
        }
        if (curr > target) {
            return ;
        }

        for (int i = step; i < candidates.length; i++) {
            if(!path.isEmpty() && (candidates[i] < path.get(path.size() - 1) || target < candidates[i])){
                continue;
            }
            curr += candidates[i];
            path.add(candidates[i]);
            dfs(candidates, target, i + 1, curr);
            curr -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        System.out.println(new CombinationSum2().combinationSum2(a, 4));
    }
}
