package com.xiaolong.arithmetic.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 *
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author xiaolong
 * @Date 2022/1/3 7:21 上午
 */
public class CombinationSum {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int step, int curr) {
        if (curr == target) {
            res.add(new ArrayList<>(path));
        }
        if (curr > target) {
            return ;
        }

        for (int candidate : candidates) {
            if (!path.isEmpty() && candidate < path.get(path.size() - 1)) {
                continue;
            }
            curr += candidate;
            path.add(candidate);
            dfs(candidates, target, step + 1, curr);
            curr -= candidate;
            path.remove(path.size() - 1);
        }
    }
}
