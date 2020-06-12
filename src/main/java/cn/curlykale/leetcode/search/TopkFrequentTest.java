package cn.curlykale.leetcode.search;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;
import java.util.logging.Logger;

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author maxp
 * @date 2020/06/12
 */
public class TopkFrequentTest {
    private Logger logger = Logger.getLogger("TopkFrequentTest");

    @Test
    public void testSearch() {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 5, 7, 7, 9};
        int k = 3;
        int[] s = topKFrequent(nums, k);
        String val = JSON.toJSONString(s);
        logger.info(val);
    }

    /**
     * 思路：
     * hashmap存储每个元素出现的频率，最小堆 优先队列筛选前k个高频元素：
     * 每次都将新的元素与堆顶元素（堆中频率最小的元素）进行比较，如果新的元素的频率比堆顶端的元素大，
     * 则弹出堆顶端的元素，将新的元素添加进堆中，最终，堆中的 k 个元素即为前 k 个高频元素
     *
     * @param nums 源数组
     * @param k    top k位
     * @return int数组
     */
    private int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>(nums.length);
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(count::get));
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> topK = new LinkedList<>();
        while (!heap.isEmpty()) {
            topK.add(heap.poll());
        }
        Collections.reverse(topK);
        int[] a = new int[topK.size()];
        for (int i = 0; i < topK.size(); i++) {
            a[i] = topK.get(i);
        }

        return a;
    }

}
