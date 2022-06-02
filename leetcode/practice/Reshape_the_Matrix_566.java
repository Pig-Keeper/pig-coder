/*
 * @Created on Thu Jun 02 2022 19:06:10
 * @ProblemLink https://leetcode.com/problems/reshape-the-matrix/
 *
 * @Author Pig Keeper
 */
package leetcode.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Reshape_the_Matrix_566 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();

        int[][] arr = new int[row][column];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int r = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(Arrays.deepToString((new Inner()).matrixReshape(arr, r, c)));
        sc.close();
    }

    static class Inner{
        public int[][] matrixReshape(int[][] arr, int r, int c) {
            int row = arr.length;
            int totalCount = 0;

            for(int i = 0; i < row; i++) {
                totalCount += arr[i].length;
            }

            if(totalCount == r * c) {
                int[][] res = new int[r][c];
                int k = 0;
                int l = 0;
                for(int i = 0; i < r; i++) {
                    for(int j = 0; j < c; j++) {
                        res[i][j] = arr[k][l];
                        
                        l++;
                        
                        if(l == arr[k].length) {
                            l = 0;
                            k++;
                        }

                        if(k == arr.length) {
                             break;
                        }
                    }
                }

                return res;
            }

            return arr;
        }
    }
}
