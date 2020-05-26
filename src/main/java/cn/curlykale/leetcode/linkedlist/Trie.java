package cn.curlykale.leetcode.linkedlist;

/**
 * Trie (前缀树)
 * 思路：
 * 构造一个Tried独享，Trie包含：
 * 1）一个Trie[26],26是小写字母的总数，Trie[]存储word，搜索时查找Trie[]
 * 2）isEndOfWord,表示字符串是否终止，全字段搜索时判断字符串是否结束
 * 备注：word.toCharArray() 转换为char，通过“i - 'a'”获取字符串存储位置
 */
class Trie {
    private static final int ALPHABET_SIZE = 26;
    private Trie[] children = new Trie[ALPHABET_SIZE];
    private boolean isEndOfWord = false;

    Trie() {
    }

    void insert(String word) {
        Trie tmp = this;
        for (char i : word.toCharArray()) {
            if (tmp.children[i - 'a'] == null) {
                tmp.children[i - 'a'] = new Trie();
            }
            tmp = tmp.children[i - 'a'];
        }
        tmp.isEndOfWord = true;
    }

    boolean search(String word) {
        Trie tmp = this;
        for (char i : word.toCharArray()) {
            if (tmp.children[i - 'a'] == null) {
                return false;
            }
            tmp = tmp.children[i - 'a'];
        }
        return tmp.isEndOfWord;
    }

    boolean startsWith(String prefix) {
        Trie tmp = this;
        for (char i : prefix.toCharArray()) {
            if (tmp.children[i - 'a'] == null) {
                return false;
            }
            tmp = tmp.children[i - 'a'];
        }
        return true;
    }
}
