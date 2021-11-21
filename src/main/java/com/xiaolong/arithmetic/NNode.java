package com.xiaolong.arithmetic;

import java.util.List;

/**
 * @Description: N叉树Node
 * @Author xiaolong
 * @Date 2021/11/21 12:09 下午
 */
public class NNode {
    public int val;
    public List<NNode> children;

    public NNode() {}

    public NNode(int _val) {
        val = _val;
    }

    public NNode(int _val, List<NNode> _children) {
        val = _val;
        children = _children;
    }
}
