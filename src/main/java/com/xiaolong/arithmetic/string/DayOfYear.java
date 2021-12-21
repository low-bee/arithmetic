package com.xiaolong.arithmetic.string;

import org.testng.annotations.Test;

/**
 * @Description:
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 *
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-year
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/12/21 8:46 上午
 */
public class DayOfYear {
    public int dayOfYear(String date) {
        int ret = 0;
        int[] dayOfMonth = new int[]{1,0,1,0,1,0,1,1,0,1,0,1};
        String[] dateArr = date.split("-");
        boolean flag = judgeLeap(Integer.parseInt(dateArr[0]));
        for (int i = 0; i < Integer.parseInt(dateArr[1]) - 1;i++) {
            ret += (dayOfMonth[i] == 1 ? 31 : 30);
        }
        ret += Integer.parseInt(dateArr[2]);
        if (Integer.parseInt(dateArr[1]) > 2){
            ret -= flag ? 1 : 2;
        }

        return ret;
    }

    private boolean judgeLeap(int year) {
        return year % 4 == 0 && (!(year % 100 == 0) || year % 400 == 0);
    }

    @Test
    public void testJudgeLeap(){
        System.out.println(judgeLeap(1));
        System.out.println(judgeLeap(4));
        System.out.println(judgeLeap(100));
        System.out.println(judgeLeap(200));
        System.out.println(judgeLeap(400));
        System.out.println(judgeLeap(800));

    }
}
