package com.xiaolong.arithmetic;

/**
 * @Description: 有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。
 *
 * 给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。
 *
 * 两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 *
 * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/license-key-formatting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author xiaolong
 * @Date 2021/10/4 6:59 上午
 */
public class FormatLicenseKey {

    public String licenseKeyFormatting(String s, int k) {
        // 创建一个StringBuilder用来存放String
        StringBuilder ret = new StringBuilder();
        int count = 0;
        // 遍历字符串
        for (int i = s.length() - 1; i >= 0; i--) {
            // 为 '-' 表示当前需要跳过
            if (s.charAt(i) != '-') {
                count++;
                ret.append(Character.toUpperCase(s.charAt(i)));
                if (count % k == 0) {
                    ret.append("-");
                }
            }
        }
        if (ret.length() > 0 && ret.charAt(ret.length() - 1) == '-') {
            ret.deleteCharAt(ret.length() - 1);
        }

        return ret.reverse().toString();
    }

}
