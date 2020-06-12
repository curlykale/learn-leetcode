package cn.curlykale.leetcode.search;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 76. 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * @author maxp
 * @date 2020/06/11
 */
public class MinWindowTest {
    private Logger logger = Logger.getLogger("MinWindowTest");


    @Test
    public void testSearch() {
        String nums = "A";
        String nums1 = "A";
        String s = minWindow(nums, nums1);
        String val = String.valueOf(s);
        logger.info(val);
    }


    /**
     * 思路：滑动窗口
     *
     * @param s 源字符串
     * @param t 需要查找的字符串
     * @return 最小覆盖的字符串
     */
    private String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        // 统计t中每个字符串出现的次数
        int[] needs = new int[128];
        // 统计滑动窗口中每个字符串出现的次数
        int[] window = new int[128];

        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        String res = "";
        // 目前有多少个字符
        int count = 0;

        // 记录的最短字符串
        int minLen = s.length();

        // right右移
        while (right < s.length()) {
            char c = s.charAt(right);
            window[c]++;
            if (needs[c] > 0 && needs[c] >= window[c]) {
                count++;
            }

            // 判断窗口收缩，left右移
            while (count == t.length()) {
                c = s.charAt(left);
                if (needs[c] > 0 && needs[c] >= window[c]) {
                    count--;
                }

                if (right - left + 1 <= minLen) {
                    minLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                window[c]--;
                left++;
            }
            right++;
        }
        return res;
    }
}
