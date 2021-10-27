package com.xiaolong.arithmetic.back;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * @Author xiaolong
 * @Date 2021/10/27 7:04 上午
 */
public class GenerateParenthesis {

    List<String> ret;

    public List<String> generateParenthesis(int n) {
        ret = new ArrayList<>();
        doGenerate("", n, n);
        return ret;
    }

    private void doGenerate(String str, int left, int right) {
        if(0 == right && left == 0){
            ret.add(str);
            return;
        } else if (left == right){
            doGenerate(str+"(", left-1, right);
        } else if (left < right){
            if (left > 0){
                doGenerate(str+"(", left-1, right);
            }
            doGenerate(str+")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(3);
    }
}
