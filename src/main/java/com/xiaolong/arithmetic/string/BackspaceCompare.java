package com.xiaolong.arithmetic.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，请你判断二者是否相等。# 代表退格字符。
 *
 * 如果相等，返回 true ；否则，返回 false 。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/12/21 10:08 上午
 */
public class BackspaceCompare {

    public boolean backspaceCompare(String s, String t) {
        // 解法1 使用栈，将String s和String t push到栈中，遇到#执行pop 时间 On 空间 On
        // 解法2 使用双指针，逆序遍历String s和String t，遇到# 执行计数count个字母，跳过后比较两者是否相等 时间On 空间O1

        // 解法一
        Deque<Character> stack1 = new LinkedList<>();
        Deque<Character> stack2 = new LinkedList<>();
        push(stack1, s);
        push(stack2, t);

        if (stack1.size() != stack2.size()){
            return false;
        }
        int size = stack1.size();
        for (int i = 0; i < size; i++) {
            if (stack1.pop() != stack2.pop()){
                return false;
            }
        }
        return true;
    }

    private void push(Deque<Character> stack1, String s) {
        int index = s.length();

        for (int i = 0; i < index; i++) {
            char temp = s.charAt(i);
            if (!stack1.isEmpty() && temp == '#'){
                stack1.pop();
            } else if (temp != '#'){
                stack1.push(temp);
            }
        }
    }

    public static void main(String[] args) {
        new BackspaceCompare().backspaceCompare("abcd", "bbcd");
    }
}
