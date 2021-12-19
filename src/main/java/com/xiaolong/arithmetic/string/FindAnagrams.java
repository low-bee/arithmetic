package com.xiaolong.arithmetic.string;

import java.util.ArrayList;
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
    // 暴力搜索
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        char[] chars = p.toCharArray();
        HashMap<Character, Integer> pTemp = new HashMap<>();
        for (char aChar : chars) {
            pTemp.put(aChar, pTemp.getOrDefault(aChar, 0) + 1);
        }
        List<Integer> ret = new ArrayList<>();
        int i = 0;
        while (i < m){
            if (!pTemp.containsKey(s.charAt(i))){
                i++;
            } else {
                HashMap<Character, Integer> temp = new HashMap<>(pTemp);
                int j = 0;
                while (j < n) {
                    if (i+j < m && temp.containsKey(s.charAt(i + j)) && temp.get(s.charAt(i + j)) > 0) {
                        temp.put(s.charAt(i + j), temp.get(s.charAt(i + j)) - 1);
                        j++;
                    } else {
                        break;
                    }
                }
                if (j == n) {
                    ret.add(i);
                }
                i += 1;
            }
        }
        return ret;
    }

    // 滑动窗口
    public List<Integer> findAnagrams2(String s, String p) {
        int n = s.length();
        int m = p.length();

        int start = 0, window = 1;
        // 保存p
        HashMap<Character, Integer> temp = new HashMap<>();
        for (int i = 0; i < m; i++) {
            temp.put(p.charAt(i), temp.getOrDefault(p.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> curr = new HashMap<>();
        List<Integer> ret = new ArrayList<>();
        while (start + window < n){
            char c = s.charAt(start + window);
            if (!temp.containsKey(c)){
                start += window;
                window = 1;
            } else {
                if (curr.getOrDefault(c, 0) < temp.get(c)){
                    window ++;
                    curr.put(c, curr.getOrDefault(c, 0) + 1);
                } else {
                    start ++;
                    window --;
                    curr.put(c, curr.get(c) - 1);
                }
            }
            if (window == 4){
                ret.add(start);
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        new FindAnagrams().findAnagrams("abacbabc", "abc");
        new FindAnagrams().findAnagrams2("ddabcdcabcabc", "abcc");
    }
}

