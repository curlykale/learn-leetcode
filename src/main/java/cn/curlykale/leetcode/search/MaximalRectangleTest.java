package cn.curlykale.leetcode.search;

import org.junit.Test;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * 85. 最大矩形
 * https://leetcode-cn.com/problems/maximal-rectangle/
 *
 * @author maxp
 * @date 2020/06/15
 */
public class MaximalRectangleTest {

    private Logger logger = Logger.getLogger("MaximalRectangleTest");

    @Test
    public void testSearch() {
        char[][] nums = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int s = maximalRectangle(nums);
        String val = String.valueOf(s);
        logger.info(val);
    }

    /**
     * 思路：
     * 动态规划
     * @param matrix
     * @return
     */
    private int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n);
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            int curLeft = 0;
            int curRight = n;

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = n;
                    curRight = j;
                }
            }

            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }

        }
        return maxArea;
    }
}
