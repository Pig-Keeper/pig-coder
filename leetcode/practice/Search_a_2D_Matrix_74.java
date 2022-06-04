/*
 * @Created on Fri Jun 03 2022 17:37:10
 * @ProblemLink https://leetcode.com/problems/search-a-2d-matrix/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

public class Search_a_2D_Matrix_74 {
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
        
        int target = sc.nextInt();

        System.out.println((new Inner()).searchMatrix(arr, target));
        sc.close();
    }

    static class Inner {
        public boolean searchMatrix(int[][] arr, int target) {
            int rowStart = 0, colStart = 0;
            int rowEnd = arr.length - 1;
            int colEnd = arr[0].length - 1;
            while(colStart <= colEnd && rowStart <= rowEnd) {
                int midCol = (colStart + colEnd)/2;
                int midRow = (rowStart + rowEnd)/2;
    
                if(arr[midRow][midCol] == target) {
                    return true;
                }
    
                if(target < arr[midRow][colStart]) {
                    rowEnd = midRow - 1;
                } else if(target > arr[midRow][colEnd]) {
                    rowStart = midRow + 1;
                } else if(target < arr[midRow][midCol]) {
                    rowStart = rowEnd = midRow;
                    colEnd = midCol - 1;
                } else {
                    rowStart = rowEnd = midRow;
                    colStart = midCol + 1;
                }
            }
            return false;
        }
    }
}
