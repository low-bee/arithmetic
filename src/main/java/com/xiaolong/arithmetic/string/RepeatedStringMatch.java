package com.xiaolong.arithmetic.string;

import java.util.HashSet;

/**
 * @Description:
 *
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 *
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author xiaolong
 * @Date 2021/12/22 9:17 上午
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        int n = b.length(), m = a.length();
        if (n <= m){
            if ( a.contains(b) ){
                return 1;
            } else if((a+a).contains(b)){
                return 2;
            } else {
                return -1;
            }
        }


        HashSet<String> temp = new HashSet<>();
        temp.add(a);
        for(int i=1; i < m; i++) {
            String front = a.substring(0, i);
            String tail = a.substring(i);
            temp.add(tail+front);
        }

        for (int i = 0; i <n; i += m) {
            if(i + m <= n){
                if (!temp.contains(b.substring(i, i + m))) {
                    return -1;
                }
            }
        }
        int last = n%m;
        int ret = n / m;
        if (last != 0){
            // 找到最后的几个, 计算尾部是否要加1
            if (b.substring(0, m).startsWith(b.substring(ret * m))){
                ret += 1;
            } else {
                return -1;
            }
        }
        // 计算是否要加1
        if (!a.equals(b.substring(0,m))){
            ret += 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        new RepeatedStringMatch().repeatedStringMatch("abccb"
                ,"cbabccb");
    }
}
