package cn.alycat.leetcode.PascalsTriangleII;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        int rows = 30;
        List<Integer> list = new Solution().getRow2(rows);
        for (int i : list) System.out.println(i);
    }

    /**
     * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
     * <p>
     * Note that the row index starts from 0.
     * <p>
     * <p>
     * In Pascal's triangle, each number is the sum of the two numbers directly above it.
     * <p>
     * Example:
     * <p>
     * Input: 3
     * Output: [1,3,3,1]
     * Follow up:
     * <p>
     * Could you optimize your algorithm to use only O(k) extra space?
     */

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex < 0 || rowIndex > 33) {
            return null;
        }
        BigDecimal number = BigDecimal.ONE;
        for (int j = 0; j <= rowIndex; j++) {
            result.add(number.intValue());
            number = number.multiply (BigDecimal.valueOf(rowIndex - j)).divide(BigDecimal.valueOf(j + 1));
        }
        return result;
    }

    public static List getRow2(int rowIndex) {

        List<Integer> storage = new LinkedList<>();

        storage.add(1);
        if (rowIndex == 0) {
            return storage;
        }

        storage.add(1);
        if (rowIndex == 1) {
            return storage;
        }

        return getTriangleRow(storage, rowIndex, 1);
    }

    private static List<Integer> getTriangleRow(List<Integer> currentRow,
                                                int rowIndex,
                                                int currentIndex) {

        if (currentIndex == rowIndex) {
            return currentRow;
        }

        List<Integer> nextRow = new LinkedList<>();
        nextRow.add(1);

        for (int index = 0; index < currentIndex; index++) {
            int summ = currentRow.get(index) + currentRow.get(index + 1);
            nextRow.add(summ);
        }
        nextRow.add(1);

        return getTriangleRow(nextRow, rowIndex, currentIndex + 1);
    }

    public List<Integer> getRow3(int rowIndex) {
        int index=0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while(index != rowIndex) {
            int size=queue.size();
            while(size != 1) {
                int num=queue.poll();
                if(queue.isEmpty()) {
                    break;
                }
                num += queue.peek();
                queue.offer(num);
                size--;
            }
            queue.offer(1);
            index++;
        }
        return new LinkedList<>(queue);
    }
}
