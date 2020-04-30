package cn.curlykale.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 八皇后问题求解
 *
 * @author maxp
 * @date 2020/04/29
 */
public class Nempress {
    private static Logger logger = Logger.getLogger("Nempress");

    private static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        int rowNum = 8;
        solveNQueens(rowNum);
        logger.info(String.valueOf(res.size()));
        logger.info(JSON.toJSONString(res));
    }

    /**
     * 输入棋盘边长 n，返回所有合法的放置
     */
    private static void solveNQueens(int n) {
        // "." 表示空，"Q" 表示皇后，初始化空棋盘。
        String[][] board = new String[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ".";
            }
        }
        backtrack(board, 0);
    }

    /**
     * 路径：board 中小于 row 的那些行都已经成功放置了皇后
     * 选择列表：第 row 行的所有列都是放置皇后的选择
     * 结束条件：row 超过 board 的最后一行
     *
     * @param board 棋盘数组
     * @param row   行数
     */

    private static void backtrack(String[][] board, int row) {
        // 触发结束条件
        if (row == board.length) {
            res.add(JSON.toJSONString(board));
            return;
        }

        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            board[row][col] = "Q";
            // 进入下一行决策
            backtrack(board, row + 1);
            // 撤销选择
            board[row][col] = ".";
        }
    }

    /**
     * 是否可以在 board[row][col] 放置皇后？
     */
    private static boolean isValid(String[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后互相冲突
        for (String[] strings : board) {
            if ("Q".equals(strings[col])) {
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if ("Q".equals(board[i][j])) {
                return false;
            }
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if ("Q".equals(board[i][j])) {
                return false;
            }
        }
        return true;
    }
}
