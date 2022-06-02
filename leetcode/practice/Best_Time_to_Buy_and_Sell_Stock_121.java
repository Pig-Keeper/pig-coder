/*
 * @Created on Thu Jun 02 2022 15:29:35
 * @ProblemLink https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @Author Pig Keeper
 */
package leetcode.practice;

import java.util.Scanner;

public class Best_Time_to_Buy_and_Sell_Stock_121 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println((new Inner()).maxProfit(arr));
        sc.close();
    }

    static class Inner {
        public int maxProfit(int[] arr) {
            int maxProfit = 0;
            int max_so_far = 0;

            for(int i = arr.length - 1; i >= 0; i--) {
                maxProfit = Math.max(maxProfit, max_so_far - arr[i]);
                max_so_far = Math.max(max_so_far, arr[i]);
            }
            return maxProfit;
        }
    }
}
