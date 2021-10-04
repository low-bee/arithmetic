package com.xiaolong.arithmetic.math;

/**
 * @Description: 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用补码运算方法。
 *
 * 注意:
 *
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/10/5 6:40 上午
 */
public class IntegerToHex {

    public String toHex(int num) {
        // 位运算，对于每四位元素，都可以将其转变为 0-f中的一个
        // 一般的，我们可以将 0-9 不变 10-15 a,b,c,d,e,f
        if (num == 0){
            return "0";
        }
        StringBuilder ret = new StringBuilder();

        while (num != 0){
            short temp = 0;
            for (int i = 0; i < 4; i++) {
                temp += (num & 1) * Math.pow(2, i);
                num >>>= 1;
            }
            if (temp < 10) {
                ret.append(temp);
            } else {
                char c = (char)('a' + temp  - 10);
                ret.append(c);
            }
        }

        return ret.toString();
    }

}
