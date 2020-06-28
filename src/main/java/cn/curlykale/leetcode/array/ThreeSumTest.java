package cn.curlykale.leetcode.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
 *
 * @author kale
 * @since 2020/06/28
 */
public class ThreeSumTest {
    private static Logger logger = Logger.getLogger("ThreeSumTest");

    @Test
    public void threeSumTest() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Long start = System.currentTimeMillis();
        List<List<Integer>> lists = threeSum(nums);
        Long end = System.currentTimeMillis();
        long ret = end - start;
        if (logger.isLoggable(Level.INFO)) {
            logger.info("耗时：" + ret);
            logger.info("结果：" + JSON.toJSONString(lists));
        }
    }

    /**
     * @param nums int数组
     * @return list
     */
    private List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        // 第一层数据索引i
        for (int i = 0; i < n; i++) {
            // 判断是否重复数据
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 第三层数据索引k
            int k = n - 1;
            int target = -nums[i];
            // 第二层数据索引j
            for (int j = i + 1; j < n; j++) {
                // 判断是否重复数据
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 遍历符合条件的第三层数据索引
                while (j < k && nums[j] + nums[k] > target) {
                    k--;
                }

                // 判断终止条件：第二年层索引和第三层数据索引相等
                if (j == k) {
                    break;
                }
                // 存储匹配到的数据
                if (nums[j] + nums[k] == target) {
                    List<Integer> tList = new ArrayList<>();
                    tList.add(nums[i]);
                    tList.add(nums[j]);
                    tList.add(nums[k]);
                    ans.add(tList);
                }

            }
        }
        return ans;
    }
}
