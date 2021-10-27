package com.xiaolong.arithmetic.back;

import com.xiaolong.arithmetic.bit.ReorderedPowerOf2;

import java.util.Arrays;

/**
 * @Description: 使用回溯完成
 * 给定正整数 N，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 *
 * 如果我们可以通过上述方式得到2 的幂，返回 true；否则，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reordered-power-of-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/10/28 7:09 上午
 */
public class ReorderedPowerOf2Back {

    boolean[] vis ;

    public boolean reorderedPowerOf2(int n) {
        // 首先将数字进行全排列
        // 然后在里面使用 x & x-1 == 0 来判断是否是2的幂次
        char[] chars = Integer.toString(n).toCharArray();
        Arrays.sort(chars);
        vis = new boolean[chars.length];
        return back(chars, 0, 0);
    }

    private boolean back(char[] chars, int i, int num) {
        if (i == chars.length){
            return (num & ( num - 1)) == 0;
        }
        for (int j = 0; j < chars.length; j++) {
            if ((num == 0 && chars[j]-'0' == 0) || vis[j] || (j > 0 && !vis[j - 1] && chars[j] == chars[j - 1])){
                continue;
            }
            vis[j] = true;
            if (back(chars, i + 1, num * 10 + chars[j] - '0')) {
                return true;
            }
            vis[j] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ReorderedPowerOf2Back().reorderedPowerOf2(46));
    }
}
