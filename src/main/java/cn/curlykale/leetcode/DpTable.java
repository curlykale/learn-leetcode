package cn.curlykale.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 动态规划
 *
 * @author maxp
 * @date 2020/04/28
 */
public class DpTable {
    private static Logger logger = Logger.getLogger("DpTable");

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int nOne = 100;
        fibOne(nOne);
        int nTwo = 10000;
        int fibTwo = fibTwo(nTwo);
        logger.info(String.valueOf(fibTwo));
        int[] coins = {3, 1, 5, 8};
        int amount = 115;
        coinchange(coins, amount);
        long endTime = System.currentTimeMillis();
        logger.info((endTime - startTime) + "");
    }

    private static int fibOne(int n) {
        int st = 1;
        int st2 = 2;
        if (n == st2 || n == st) {
            return 1;
        }
        return fibOne(n - 1) + fibOne(n - 2);
    }

    private static int fibTwo(int n) {
        int st = 1;
        int st2 = 2;
        if (n == st2 || n == st) {
            return 1;
        }
        int prev = 1;
        int curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    /**
     * def coinChange(coins: List[int], amount: int):
     * <p>
     * def dp(n):
     * # base case
     * if n == 0: return 0
     * if n < 0: return -1
     * # 求最小值，所以初始化为正无穷
     * res = float('INF')
     * for coin in coins:
     * subproblem = dp(n - coin)
     * # 子问题无解，跳过
     * if subproblem == -1: continue
     * res = min(res, 1 + subproblem)
     */

    private static void coinchange(int[] coins, int amount) {
        Map<Integer, Integer> dpMap = new HashMap<>(16);
        int count = dp(amount, coins, dpMap);
        logger.info(String.valueOf(count));
    }

    private static int dp(int n, int[] coins, Map<Integer, Integer> dpMap) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        int res = n + 1;
        for (int coin : coins) {
            int sub = dp(n - coin, coins, dpMap);
            if (sub == -1) {
                continue;
            }
            res = Math.min(res, 1 + sub);
        }
        dpMap.put(n, res);
        if (res != n + 1) {
            return res;
        } else {
            return -1;
        }
    }


}
