package cn.curlykale.leetcode.search;

import org.junit.Test;

import java.util.HashMap;
import java.util.logging.Logger;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author maxp
 * @date 2020/06/07
 */
public class StrLongestTest {
    private Logger logger = Logger.getLogger("StrLongestTest");


    @Test
    public void testSearch() {
        String nums = "abcdccd";
        int td = lengthOfLongestSubstring(nums);
        String val = String.valueOf(td);
        logger.info(val);
    }

    /**
     * 思路：
     * 滑动窗口
     * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
     * 我们定义不重复子串的开始位置为 start，结束位置为 end
     * 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
     * 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
     * 时间复杂度：O(n)
     *
     * @param s 字符串
     * @return 最长子串数量
     */
    private int lengthOfLongestSubstring(String s) {
        int size = s.length();
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>(size);
        int start = 0;
        for (int end = 0; end < size; end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(ch, end + 1);
        }
        return ans;

    }
}
