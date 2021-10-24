package com.xiaolong.arithmetic.dp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * 在 LeetCode 商店中， 有 n 件在售的物品。每件物品都有对应的价格。然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 *
 * 给你一个整数数组 price 表示物品价格，其中 price[i] 是第 i 件物品的价格。另有一个整数数组 needs 表示购物清单，其中 needs[i] 是需要购买第 i 件物品的数量。
 *
 * 还有一个数组 special 表示大礼包，special[i] 的长度为 n + 1 ，其中 special[i][j] 表示第 i 个大礼包中内含第 j 件物品的数量，且 special[i][n] （也就是数组中的最后一个整数）为第 i 个大礼包的价格。
 *
 * 返回 确切 满足购物清单所需花费的最低价格，你可以充分利用大礼包的优惠活动。你不能购买超出购物清单指定数量的物品，即使那样会降低整体价格。任意大礼包可无限次购买。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shopping-offers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author xiaolong
 * @Date 2021/10/24 8:06 上午
 *
 */
public class ShoppingOffers {
    Map<List<Integer>, Integer> memo = new HashMap<>();
    int n ;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        n = price.size();
        // 先剪枝，去除不可能的部分
        List<List<Integer>> filterList = special.stream().filter(sp -> {
            int totalCount = 0, totalPrice = 0;
            for (int i = 0; i < n; ++i) {
                totalCount += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
            }
            return totalCount > 0 && totalPrice > sp.get(n);
        }).collect(Collectors.toList());

        return dfs(price, needs, filterList);
    }

    private int dfs(List<Integer> price, List<Integer> currNeeds, List<List<Integer>> filterList) {
        if (!memo.containsKey(currNeeds)){
            int[] minPrice = {0};
            // 计算不使用大礼包的价格
            for (int i = 0; i < n; i++) {
                minPrice[0] += price.get(i) * currNeeds.get(i);
            }
            // 计算使用礼包的价格
            filterList.forEach(curr -> {
                // 大礼包的价格， 当前的大礼包只要选入，必定可以减少总支付价格
                int currPrice = curr.get(n);
                // 选入当前礼包后，下一个需要的礼包
                List<Integer> nextNeeds = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (curr.get(i) > currNeeds.get(i)){
                        break;
                    }
                    // 减除对应位置的数量
                    nextNeeds.add(currNeeds.get(i) - curr.get(i));
                    if (nextNeeds.size() == n){
                        // 进到这里说明礼包可以买,总价格为剩余部分的价格 + 加上当前大礼包的价格
                        minPrice[0] = Math.min(minPrice[0], dfs(price, nextNeeds, filterList) + currPrice);
                    }
                }
            });
            memo.put(currNeeds, minPrice[0]);
        }

        return memo.get(currNeeds);
    }

}
