package com.xiaolong.arithmetic.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/11/28 9:08 上午
 */
public class FindAnagrams {
    // 滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> ret = new ArrayList<>();
        if (n < m) return ret;

        // 构建一个数组
        int[] charTemp = new int[26];
        int[] targetTemp = new int[26];
        for (int i = 0; i < m; i++) {
            charTemp[s.charAt(i) - 'a']++;
            targetTemp[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(charTemp, targetTemp)){
            ret.add(0);
        }

        for (int i = m; i < n; i++) {
            charTemp[s.charAt(i-m) - 'a']--;
            charTemp[s.charAt(i) - 'a']++;

            if (Arrays.equals(targetTemp, charTemp)){
                ret.add(i-m + 1);
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}

