/*
 * @Created on Tue Jun 14 2022 14:46:57
 * @ProblemLink https://leetcode.com/problems/single-number/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

public class Single_Number_136 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n ; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println((new Inner()).singleNumber(nums));
        sc.close();
    }

    static class Inner {
        public int singleNumber(int[] nums) {
            int ans = nums[0];

            for(int i = 1; i < nums.length; i++) {
                ans = ans^nums[i];
            }
            return ans;
        }
    }
}
