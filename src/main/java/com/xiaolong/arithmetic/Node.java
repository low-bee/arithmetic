package com.xiaolong.arithmetic;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author xiaolong
 * @Date 2021/12/24 9:01 上午
 */
public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public Node(int val) {
        this.val = val;
    }

    public Node() {
    }

    public Node(Node left, Node right, Node next) {
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
