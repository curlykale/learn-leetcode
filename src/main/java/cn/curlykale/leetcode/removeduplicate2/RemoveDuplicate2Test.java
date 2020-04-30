package cn.curlykale.leetcode.removeduplicate2;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author maxp
 * @since 2019-04-02
 */
public class RemoveDuplicate2Test {
    private static Logger logger = Logger.getLogger("RemoveDuplicateTest");

    @Test
    public void removeDuplicateTest() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int i = removeDuplicates(nums);
        if (logger.isLoggable(Level.INFO)) {
            logger.info("数量：" + i);
            logger.info("结果：" + JSON.toJSONString(nums));
        }
    }

    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 示例：
     * 给定 nums = [1,1,1,2,2,3],
     * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums int数组
     * @return 不重复字符数量
     */

    private int removeDuplicates(int[] nums) {
        int index = 2;
        if (nums.length <= 2) {
            return nums.length;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

}
