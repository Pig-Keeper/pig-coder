/*
 * @Created on Sat Jun 04 2022 16:59:59
 * @ProblemLink https://leetcode.com/problems/flood-fill/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Flood_Fill_733 {
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

        System.out.println(Arrays.deepToString((new Inner()).floodFill(arr, sc.nextInt(), sc.nextInt(), sc.nextInt())));

        sc.close();
    }

    static class Inner {
        public int[][] floodFill(int[][] arr, int startRow, int startColumn, int newColor) {
            floodFill(arr, startRow, startColumn, newColor, arr[startRow][startColumn]);
            return arr;
        }

        public void floodFill(int[][] arr, int startRow, int startColumn, int newColor, int startColor) {
            int rows = arr.length;
            int columns = arr[0].length;

            arr[startRow][startColumn] = newColor;

            if(startRow > 0 && arr[startRow - 1][startColumn] != newColor && arr[startRow - 1][startColumn] == startColor) {
                floodFill(arr, startRow - 1, startColumn, newColor);
            }

            if(startColumn > 0 && arr[startRow][startColumn - 1] != newColor && arr[startRow][startColumn - 1] == startColor) {
                floodFill(arr, startRow, startColumn - 1, newColor);
            }

            if(startRow < rows - 1 && arr[startRow + 1][startColumn] != newColor && arr[startRow + 1][startColumn] == startColor) {
                floodFill(arr, startRow + 1, startColumn, newColor);
            }

            if(startColumn < columns - 1 && arr[startRow][startColumn + 1] != newColor && arr[startRow][startColumn + 1] == startColor) {
                floodFill(arr, startRow, startColumn + 1, newColor);
            }
        }
    }
}
