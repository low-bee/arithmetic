package com.xiaolong.arithmetic.stack;

import java.util.*;

/**
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/10/27 7:05 上午
 */
public class JudgeParenthesis {
    // 使用一个栈来判断当前的栈是够为空
    public boolean judgeParenthesis(String str){

        HashMap<String, String> parenthesis = new HashMap<>();
        parenthesis.put(")", "(");
        parenthesis.put("]", "[");
        parenthesis.put("}", "{");
        Deque<String> stack = new LinkedList<>();

        Set<String> left = parenthesis.keySet();
        for (int i = 0; i < str.length(); i++) {
            String curr = str.substring(i, i + 1);
            if (stack.isEmpty() && left.contains(curr)){
                return false;
            }else if (!stack.isEmpty() && parenthesis.getOrDefault(curr, "").equals(stack.peek())){
                stack.pop();
            } else {
                stack.push(curr);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new JudgeParenthesis().judgeParenthesis("((()))");
    }
}
