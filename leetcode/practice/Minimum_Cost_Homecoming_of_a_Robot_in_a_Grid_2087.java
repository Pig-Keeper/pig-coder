/*
 * @Created on Tue Jun 14 2022 18:11:06
 * @ProblemLink https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

public class Minimum_Cost_Homecoming_of_a_Robot_in_a_Grid_2087 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[] startPos = new int[2];
        int[] homePos = new int[2];

        int[] rowCosts = new int[rows];
        int[] colCosts = new int[cols];

        startPos[0] = sc.nextInt();
        startPos[1] = sc.nextInt();

        homePos[0] = sc.nextInt();
        homePos[1] = sc.nextInt();

        for(int i = 0; i < rows; i++) {
            rowCosts[i] = sc.nextInt();
        }

        for(int i = 0; i < cols; i++) {
            colCosts[i] = sc.nextInt();
        }

        System.out.println((new Inner()).minCost(startPos, homePos, rowCosts, colCosts));
        sc.close();
    }

    static class Inner {
        public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
            int rowDiff = homePos[0] - startPos[0];
            int colDiff = homePos[1] - startPos[1];

            if(rowDiff != 0) {
                startPos[0] += (rowDiff > 0 ? 1 : -1);
                return rowCosts[startPos[0]] + minCost(startPos, homePos, rowCosts, colCosts);
            }

            if(colDiff != 0) {
                startPos[1] += (colDiff > 0 ? 1 : -1);
                return colCosts[startPos[1]] + minCost(startPos, homePos, rowCosts, colCosts);
            }

            return 0;
        }
    }
}
