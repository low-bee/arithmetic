package com.xiaolong.arithmetic.string;

/**
 * @Description: 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/10/15 7:04 上午
 */
public class CountAndSay {

    public String countAndSay(int n) {
        String ret = "1";
        if (n == 1){
            return "1";
        }
        for (int i = 1; i < n; i++) {
            ret = count(ret);
        }
        return ret;
    }

    private String count(String str){
        int n = str.length();
        if (n == 1){
            return "1"+str;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int temp = 1;
            while (i < n && str.charAt(i) == str.charAt(i-1)){
                temp++;
                i++;
            }
            builder.append(temp);
            builder.append(str.charAt(i-1));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(2));
    }
}
