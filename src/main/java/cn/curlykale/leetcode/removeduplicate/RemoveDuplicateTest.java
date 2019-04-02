package cn.curlykale.leetcode.removeduplicate;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author maxp
 * @since 2019-04-02
 */
public class RemoveDuplicateTest {
    private static Logger logger = Logger.getLogger("RemoveDuplicateTest");

    @Test
    public void removeDuplicateTest() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates(nums);
        if (logger.isLoggable(Level.INFO)) {
            logger.info("数量：" + i);
            logger.info("结果：" + JSON.toJSONString(nums));
        }
    }

    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 示例：
     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums int数组
     * @return 不重复字符数量
     */
    private int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index-1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
