package com.task1;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Queue;


public class IslandsCountInterviewExercise {


    public static void main(String[] args) {
//        int[][] mat=
//                {
//                        { 1, 0, 1, 0, 0, 0, 1, 1, 1, 1 },
//                        { 0, 0, 1, 0, 1, 0, 1, 0, 0, 0 },
//                        { 1, 1, 1, 1, 0, 0, 1, 0, 0, 0 },
//                        { 1, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
//                        { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
//                        { 0, 1, 0, 1, 0, 0, 1, 1, 1, 1 },
//                        { 0, 0, 0, 0, 0, 1, 1, 1, 0, 0 },
//                        { 0, 0, 0, 1, 0, 0, 1, 1, 1, 0 },
//                        { 1, 0, 1, 0, 1, 0, 0, 1, 0, 0 },
//                        { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 }
//                };

//        int[][] mat =
//                {
//                        {1, 0, 1, 0, 0, 1, 1, 1, 1, 1},
//                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
//                };
        int[][] mat = new int[][]{
                {1, 0, 0, 0, 0, 0, 0, 0, 0}, //0
                {}, //1
                {0, 0, 1, 1, 1, 0, 0, 0, 0}, //2
                {0, 0, 0, 1, 0, 0, 1, 0}, //3
                {0, 0, 0, 0, 0, 0, 1, 0, 1}, //4
                {0, 0, 0, 0, 0}, //5
                {0, 0, 0, 0, 0, 0, 0, 1}, //6
                {0, 0, 0, 0, 0, 0, 0}, //7
        };
        System.out.print("The total number of islands is " + countIslandsBfs(mat));
    }


    // all possible cell movements
    private static final int[] rowCellMovements = {-1, -1, -1, 0, 1, 0, 1, 1};
    private static final int[] columnCellMovements = {-1, 1, 0, -1, -1, 1, 0, 1};

    /**
     * Task:
     * Write a short program, which will count the number of islands. The following
     * data structure could be varying in size. Take into assumption, that data
     * structure given to you could be very large in size, so beware of
     * implementation that could result in stack overflow or out-of-memory
     * exception.
     *
     * Algorithm of choice: BFS
     *
     * Algorithm details:
     * V - vertexes, total count of numbers in 2d array
     * E - edges
     * BFS -> time complexity O(v*e)
     *        space complexity(v)
     * Elements that mark land are set to elements representing water after they are
     *
     * @param map2d - 2d array containing 0's and 1's, where 1 = land, 0 = water
     * @return number of islands
     */
    public static int countIslandsBfs(int[][] map2d) {
        // base case
        if (map2d == null || map2d.length == 0) {
            return 0;
        }

        int islands = 0;
        for (int row = 0; row < map2d.length; row++) {
            int colLength = map2d[row].length;
            for (int col = 0; col < colLength; col++) {
                if (map2d[row][col] == 1) {
                    bfs(map2d, row, col);
                    islands++;
                }
            }
        }

        return islands;
    }

    /**
     * Check if there is next step in certain direction
     * @param map2d map
     * @param newRow row to check if it's safe
     * @param newCol column to check if it's safe
     * @param rowRestraint max possible row
     * @param colRestraint max possible column
     * @return
     */
    public static boolean isAvailableNextStep(int[][] map2d, int newRow, int newCol, int rowRestraint, int colRestraint) {
        System.out.println("newRow: " + newRow);
        System.out.println("newCol: " + newCol);
        System.out.println("rowRestraint: " + rowRestraint);
        System.out.println("colRestraint: " + colRestraint);
//        System.out.println("newRow: " + newRow);
        return newRow >= 0 && newRow < rowRestraint
                && newCol >= 0 && newCol < colRestraint
                && newCol < map2d[newRow].length
                && map2d[newRow][newCol] == 1;
    }

    /**
     * Starts with cell pointing to land, then move to all adjacent cell until all nearby land cells are found
     * After processing land cell, set it to water so it won't be processed again
     * @param map2d matrix of map
     * @param cellRow row index of cell with land
     * @param cellCol column index of cell with land
     */
    private static void bfs(int[][] map2d, int cellRow, int cellCol) {
        Queue<AbstractMap.SimpleImmutableEntry<Integer, Integer>> que = new ArrayDeque<>();
        // put initial element denoting land on the queue
        que.add(new AbstractMap.SimpleImmutableEntry<>(cellRow, cellCol));

        // set currently processed cell to 0
        map2d[cellRow][cellCol]=0;

        while (!que.isEmpty()) {
            AbstractMap.SimpleImmutableEntry<Integer, Integer> cell = que.poll();
            int x = cell.getKey();
            int y = cell.getValue();

            for (int k = 0; k < IslandsCountInterviewExercise.rowCellMovements.length; k++) {
                System.out.println("Main.rowCellMovements[k] cell: " + IslandsCountInterviewExercise.rowCellMovements[k] + ","+ IslandsCountInterviewExercise.columnCellMovements[k] + " ");
                int newCol = y + IslandsCountInterviewExercise.columnCellMovements[k];
                int newRow = x + IslandsCountInterviewExercise.rowCellMovements[k];
                if (isAvailableNextStep(map2d, newRow, newCol, map2d.length, map2d[cellRow].length)) {
                    map2d[newRow][newCol]=0;
                    que.add(new AbstractMap.SimpleImmutableEntry<>(newRow, newCol));
                }
            }
        }
    }

}