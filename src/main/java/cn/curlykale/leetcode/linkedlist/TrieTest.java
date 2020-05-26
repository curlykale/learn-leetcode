package cn.curlykale.leetcode.linkedlist;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 208. 实现 Trie (前缀树)
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 *
 * @author maxp
 * @date 2020/05/26
 */
public class TrieTest {
    private Logger logger = Logger.getLogger("TrieTest");

    @Test
    public void testTrie() {
        Trie obj = new Trie();
        String param = "word";
        obj.insert(param);
        boolean param2 = obj.search(param);
        String p = "wro";
        boolean param3 = obj.startsWith(p);
        String b2 = String.format("%s", param2);
        String b3 = String.format("%s", param3);
        logger.info(b2);
        logger.info(b3);
    }


}