package cn.curlykale.leetcode.tree;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 279. 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 *
 * @author maxp
 * @date 2020/05/27
 */
public class NumSquaresTest {
    private Logger logger = Logger.getLogger("NumSquaresTest");

    @Test
    public void testTrie() {
        int n = 14;
        int squares = numSquares(n);
        String b2 = String.format("%s", squares);
        logger.info(b2);
    }

    /**
     * 思路：
     * 动态规划
     * 初始化长度为n+1的数组dp，默认值0,用来存储0-n个数字的完全平方数
     * 遍历计算完全平方数，默认为最坏结果，比如i=4，最坏结果为4=1+1+1+1即为4个数字；然后循环遍历求i最小的dp
     *
     * @param n 原始数据
     * @return 最小平方数
     */
    private int numSquares(int n) {
        // 默认初始化值都为0
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 最坏的情况就是每次+1
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                // 动态转移方程
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
