package com.xiaolong.arithmetic.array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @Description:
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符
 * @Author xiaolong
 * @Date 2021/10/7 6:42 上午
 */
public class CountSegments {
    public int countSegments(String s) {
        return (int) Arrays.stream(s.split(" ")).filter(a -> !("".equals(a))).filter( a -> !" ".equals(a)).count();
    }
}
