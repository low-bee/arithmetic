package com.xiaolong.arithmetic.bit;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * 给定正整数 N，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 *
 * 如果我们可以通过上述方式得到2 的幂，返回 true；否则，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reordered-power-of-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/10/28 7:01 上午
 */
public class ReorderedPowerOf2 {

    Set<String> set = new HashSet<>();

    public boolean reorderedPowerOf2(int n) {
        // 全排序 之后 x&x-1 == 0
        // 数位数，当位数相同这个数字一定可以排成一个2的幂
        init();
        return set.contains(count(n));
    }

    private void init() {
        for (int i = 1; i < 1e9; i<<=1) {
            set.add(count(i));
        }
    }

    private String count(int i) {
        char[] chars = new char[10];
        while (i > 0){
            ++chars[i % 10];
            i/=10;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        new ReorderedPowerOf2().reorderedPowerOf2(4);
    }
}
