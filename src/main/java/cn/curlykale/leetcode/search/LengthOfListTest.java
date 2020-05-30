package cn.curlykale.leetcode.search;

import org.junit.Test;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * 300. 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author maxp
 * @date 2020/05/30
 */
public class LengthOfListTest {

    private Logger logger = Logger.getLogger("LengthOfListTest");


    @Test
    public void testRob() {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int td = lengthOfLIS(nums);
        String val = String.valueOf(td);
        logger.info(val);
    }

    /**
     * 思路：动态规划
     * 1.初始化数组dp，默认每一个元素序列为1。
     * 2.双层遍历，外层遍历nums，index为i，内层遍历,index为j, j < i，然后比较nums[i]与nums[j]的值，如果nums[j] < nums[i]，更新dp[i]，否则跳过
     * 状态方程：dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
     *
     * @param nums int数组
     * @return 最长上升子序列
     */
    private int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
