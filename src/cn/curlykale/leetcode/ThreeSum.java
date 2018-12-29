package cn.curlykale.leetcode;

import java.util.*;
import java.util.logging.Logger;

/**
 * @author kale
 * @since 2018-12-29
 */
public class ThreeSum {
    private static Logger logger = Logger.getLogger("cn.curlykale.leetcode.ThreeSum");

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        logger.info(lists.toString());
    }


    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     * @param nums int数组
     * @return list
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length-1; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        List<Integer> templist = new ArrayList();
                        templist.add(nums[i]);
                        templist.add(nums[j]);
                        templist.add(nums[k]);
                        Collections.sort(templist);
                        set.add(templist);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

}
