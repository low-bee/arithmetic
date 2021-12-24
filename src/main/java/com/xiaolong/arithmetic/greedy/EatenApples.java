package com.xiaolong.arithmetic.greedy;

import java.util.PriorityQueue;

/**
 * @Description:
 *
 * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后
 * （也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，
 * 此时用 apples[i] == 0 且 days[i] == 0 表示。
 *
 * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
 *
 * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-eaten-apples
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author xiaolong
 * @Date 2021/12/24 8:24 上午
 */
public class EatenApples {

    static class Pair implements Comparable<Pair>{
        public int key;
        public int value;

        public Pair() {
        }

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return this.key - o.key;
        }
    }

    public int eatenApples(int[] apples, int[] days) {
        // 优先队列，按照时间排序，每次将已经腐烂的苹果移出
        int num = days.length;
        int ret = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        int i = 0;
        do {
            if (i < num && days[i] > 0) {
                queue.add(new Pair(days[i] + i, apples[i]));
            }
            while (!queue.isEmpty() && queue.peek().key - i <= 0){
                queue.poll();
            }
            if (!queue.isEmpty()) {
                ret ++;
                Pair poll = queue.poll();
                poll.value -= 1;
                if (poll.value > 0) {
                    queue.add(poll);
                }

            }
            i++;
        } while (!queue.isEmpty() || i < num);
        return ret;
    }

    public static void main(String[] args) {
        new EatenApples().eatenApples(new int[]{1,2,3,5,2}, new int[]{3,2,1,4,2});
    }
}
