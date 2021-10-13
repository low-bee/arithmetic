package com.xiaolong.arithmetic.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/10/12 7:14 上午
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits.length() == 0) {
            return ret;
        }
        String[] phone = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        back(ret, phone, digits, 0, new StringBuilder());
        return ret;
    }

    private void back(List<String> ret, String[] phone, String digits, int index, StringBuilder combination) {
        if (index == digits.length()) {
            ret.add(combination.toString());
        } else {
            int digit = digits.charAt(index) - '0';
            String curr = phone[digit - 2];
            int lettersCount = curr.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(curr.charAt(i));
                back(ret, phone, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
