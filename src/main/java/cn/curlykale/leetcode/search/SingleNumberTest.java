package cn.curlykale.leetcode.search;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 136. 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 *
 * @author maxp
 * @date 2020/06/05
 */
public class SingleNumberTest {
    private Logger logger = Logger.getLogger("SingleNumberTest");


    @Test
    public void testSearch() {
        int[] nums = new int[]{4, 4, 6, 6};
        int td = singleNumber(nums);
        String val = String.valueOf(td);
        logger.info(val);
    }

    /**
     * 思路：
     * 交换律：a ^ b ^ c <=> a ^ c ^ b
     * 任何数于0异或为任何数 0 ^ n => n
     * 相同的数异或为0: n ^ n => 0
     *
     * @param nums int数组
     * @return num
     */
    private int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single = single ^ num;
        }
        return single;
    }

}
