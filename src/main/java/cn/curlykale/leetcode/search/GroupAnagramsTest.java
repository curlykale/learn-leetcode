package cn.curlykale.leetcode.search;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;
import java.util.logging.Logger;

/**
 * 49. 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams
 *
 * @author maxp
 * @date 2020/06/09
 */
public class GroupAnagramsTest {
    private Logger logger = Logger.getLogger("StrLongestTest");


    @Test
    public void testSearch() {
        String[] nums = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(nums);
        String val = JSON.toJSONString(lists);
        logger.info(val);
    }

    /**
     * 思路：
     * 把字符串转成char[]排序，然后再转成字符串作为key，存入map。
     * 字符串是存在与map，存在加入list
     *
     * @param strs String数组
     * @return list
     */
    private List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, ArrayList<String>> ans = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String ca = String.valueOf(chars);
            if (!ans.containsKey(ca)) {
                ans.put(ca, new ArrayList<>());
            }
            ans.get(ca).add(str);
        }
        return new ArrayList<>(ans.values());
    }
}
