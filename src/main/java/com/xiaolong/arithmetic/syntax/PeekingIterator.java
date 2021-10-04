package com.xiaolong.arithmetic.syntax;

import java.util.Iterator;

/**
 * @Description: 请你设计一个迭代器，除了支持 hasNext 和 next 操作外，还支持 peek 操作。
 *
 * 实现 PeekingIterator 类：
 *
 * PeekingIterator(int[] nums) 使用指定整数数组 nums 初始化迭代器。
 * int next() 返回数组中的下一个元素，并将指针移动到下个元素处。
 * bool hasNext() 如果数组中存在下一个元素，返回 true ；否则，返回 false 。
 * int peek() 返回数组中的下一个元素，但 不 移动指针。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peeking-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author xiaolong
 * @Date 2021/10/5 7:05 上午
 */

public class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private Integer nextEle;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        nextEle = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextEle;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ret = nextEle;
        nextEle = iterator.hasNext() ? iterator.next() : null;
        return ret;
    }

    @Override
    public boolean hasNext() {
        return nextEle != null;
    }
}