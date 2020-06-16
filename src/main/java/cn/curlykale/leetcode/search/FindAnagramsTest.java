package cn.curlykale.leetcode.search;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 *
 * @author maxp
 * @date 2020/06/16
 */
public class FindAnagramsTest {

    private Logger logger = Logger.getLogger("FindAnagramsTest");

    @Test
    public void testSearch() {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = findAnagrams(s, p);
        String val = JSON.toJSONString(anagrams);
        logger.info(val);
    }

    /**
     * 思路：
     * 滑动窗口
     * 先写框架，再补全更新代码
     *
     * @param s 源字符串
     * @param p 查找的字符串
     * @return list
     */
    private List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>(p.length());
        Map<Character, Integer> window = new HashMap<>(s.length());
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();

        // 判断右侧窗口是否需要扩张
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内的数据更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否需要收缩
            while (right - left >= p.length()) {
                // 当窗口符合条件，把起始索引加入res
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;

                // 进行窗口内数据更新
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }
}
