package cn.curlykale.leetcode.search;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * 240. 搜索二维矩阵 II
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * @author maxp
 * @date 2020/06/01
 */
public class SearchMatrixTest {

    private Logger logger = Logger.getLogger("SearchMatrixTest");


    @Test
    public void testSearchMatrix() {
        int[][] nums = new int[][]{
                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};

        int target = 0;
        boolean b = searchMatrix(nums, target);
        String val = String.valueOf(b);
        logger.info(val);
    }

    /**
     * 思路：
     * 左下角的元素是这一行中最小的元素，同时又是这一列中最大的元素。比较左下角元素和目标：
     * matrix > target, 则元素不可能在当前行，row--
     * matrix < target, 则元素不可能在当前列，col++
     * matrix = target, 则找到元素，返回true
     *
     * @param matrix 二维矩阵
     * @param target 要查找的目标值
     * @return boolean
     */
    private boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int col = 0;
        int row = matrix.length - 1;
        while (row >= 0 && matrix[0].length > col) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
