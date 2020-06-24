package cn.curlykale.leetcode.search;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 560. 和为K的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * @author maxp
 * @date 2020/06/23
 */
public class SubarraySumTest {
    private Logger logger = Logger.getLogger("SubarraySumTest");

    @Test
    public void testSearch() {
        int[] nums = new int[]{3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        int sum = subarraySum(nums, k);
        String val = String.valueOf(sum);
        logger.info(val);
    }

    /**
     * 解题思路：
     * 建立map表用于存储每个连续子数组sum求和出现的次数，初始化为（0,1），表示和为0的连续子数组出现1次。
     * 每次遍历存储以sum为k，value为 1)map中已存在sum，则原值加1,2)不存在默认1
     * sum: 遍历nums数组，不断累加当前元素的值;
     * count: 查找map中是否已存在sum-k的元素，也就是在查找此前所有从0项开始累加的连续子项和中有没有sum-k。
     * 如果有的话，则说明从上一个sum-k出现的索引位置，到当前数组索引位置的连续子数组和必定为k，那么count = count + map.get(sum-k),可以获取最新的count值。
     *
     * @param nums int数组
     * @param k    要查找数字的和
     * @return 符合要求的数据个数
     */
    private int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            // 说明存在 【之前出现过的前缀和】，它的值满足 【当前前缀和】-【之前求出的前缀和】 === k,
            // 把 【之前出现过的前缀和】出现的次数，累加给 count
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
