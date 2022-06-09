/*
 * @Created on Wed Jun 08 2022 14:05:18
 * @ProblemLink https://leetcode.com/problems/rotting-oranges/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Rotting_Oranges_994 {
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
    
        System.out.println((new Inner()).orangesRotting(arr));
        sc.close();
    }

    static class Inner {
        public int orangesRotting(int[][] arr) {
            int rows = arr.length;
            int columns = arr[0].length;
            int res = 0;

            Queue<int[]> queue = new LinkedList<>();
            
            for(int i = 0; i < rows; i++) {
                for(int j = 0 ; j < columns; j++) {
                    if(arr[i][j] == 2) {
                        queue.offer(new int[]{i , j , 0});
                    }
                }
            }

            while(!queue.isEmpty()) {
                int[] curr = queue.poll();
                int row = curr[0];
                int column = curr[1];
                int tempRes = curr[2];

                if(arr[row][column] == 1) {
                    res = Math.max(res, tempRes);
                    arr[row][column] = 2;
                }


                if(row > 0 && arr[row - 1][column] == 1) {
                    queue.offer(new int[]{row - 1, column, tempRes + 1});
                }

                if(row < rows - 1 && arr[row + 1][column] == 1) {
                    queue.offer(new int[]{row + 1, column, tempRes + 1});
                }

                if(column > 0 && arr[row][column - 1] == 1) {
                    queue.offer(new int[]{row, column - 1, tempRes + 1});
                }

                if(column < columns - 1 && arr[row][column + 1] == 1) {
                    queue.offer(new int[]{row, column + 1, tempRes + 1});
                }
            }

            for(int i = 0; i < rows; i++) {
                for(int j = 0 ; j < columns; j++) {
                    if(arr[i][j] == 1) {
                        return -1;
                    }
                }
            }

            return res;
        
        }
    }
}
