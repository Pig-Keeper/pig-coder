/*
 * @Created on Mon Jun 06 2022 11:39:41
 * @ProblemLink https://leetcode.com/problems/01-matrix/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Matrix_542 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
    
        int[][] arr = new int[rows][columns];
    
        for(int i = 0; i < rows; i++) {
            for(int j = 0 ; j < columns; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(Arrays.deepToString((new Inner()).updateMatrix(arr)));
        sc.close();
    }

    static class Inner {
        public int[][] updateMatrix(int[][] arr) {
            int rows = arr.length;
            int columns = arr[0].length;

            int[][] res = new int[arr.length][arr[0].length];

            Queue<Indices> queue = new LinkedList<>();
            
            for(int i = 0; i < rows; i++) {
                Arrays.fill(res[i], -1);
            }
            
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < columns; j++) {
                    if(arr[i][j] == 0) {
                        queue.add(new Indices(i, j, 0));
                    }
                }
            }

            while(!queue.isEmpty()) {
                Indices curr = queue.poll();
                int row = curr.getRow();
                int column = curr.getColumn();
                int dist = curr.getDist();

                if(res[row][column] == -1) {
                    res[row][column] = dist;

                    if(row > 0 && res[row - 1][column] == -1) {
                        queue.add(new Indices(row - 1, column, dist + 1));
                    }

                    if(column > 0 && res[row][column - 1] == -1) {
                        queue.add(new Indices(row, column - 1, dist + 1));
                    }

                    if(row < rows - 1 && res[row + 1][column] == -1) {
                        queue.add(new Indices(row + 1, column, dist + 1));
                    }

                    if(column < columns -1 && res[row][column + 1] == -1) {
                        queue.add(new Indices(row, column + 1, dist + 1));
                    }
                }
            }

            return res;
        }

        /**
         * We can use Pair class of Java to store two values
         * https://docs.oracle.com/javase/9/docs/api/javafx/util/Pair.html
         */
        private class Indices {
            private int row;
            private int column;
            private int dist;

            public Indices(int row, int column, int dist) {
                this.row = row;
                this.column = column;
                this.dist = dist;
            }

            public int getDist() {
                return dist;
            }

            public int getColumn() {
                return column;
            }
            public int getRow() {
                return row;
            }

            public boolean equals(Object obj) {
                if (obj == null) {
                    return false;
                }
        
                if (obj.getClass() != this.getClass()) {
                    return false;
                }

                Indices otherIndices = (Indices) obj;

                return row == otherIndices.row && column == otherIndices.column;
            }

            public int hashCode() {
                return ("" + row + column).hashCode();
            }
        }
    }
}
