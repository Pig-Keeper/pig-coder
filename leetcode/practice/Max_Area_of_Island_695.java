/*
 * @Created on Sat Jun 04 2022 17:38:22
 * @ProblemLink https://leetcode.com/problems/max-area-of-island/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

public class Max_Area_of_Island_695 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int[][] arr = new int[rows][columns];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println((new Inner()).maxAreaOfIsland(arr));

        sc.close();

    }

    static class Inner {
        public int maxAreaOfIsland(int[][] arr) {
            int rows = arr.length;
            int columns = arr[0].length;

            int max = 0;
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < columns; j++) {
                    if(arr[i][j] == 1) {
                        max = Math.max(max, maxAreaOfIslandUtil(arr, i, j));
                    }
                }
            }
            return max;
        }

        public int maxAreaOfIslandUtil(int[][] arr, int row, int column) {
            if(arr[row][column] == 1) {
                arr[row][column] = 0;

                int tempMax = 1; 

                if(row > 0) {
                    tempMax += maxAreaOfIslandUtil(arr, row - 1, column);
                }

                if(column > 0) {
                    tempMax += maxAreaOfIslandUtil(arr, row, column - 1);
                }

                if(row < arr.length - 1) {
                    tempMax += maxAreaOfIslandUtil(arr, row + 1, column);
                }

                if(column < arr[row].length - 1) {
                    tempMax += maxAreaOfIslandUtil(arr, row, column + 1);
                }

                return tempMax;
            }
            return 0;
        }
    }
}
