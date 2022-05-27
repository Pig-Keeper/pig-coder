/*
 * @Created on Sat May 27 2022 21:45:50 
 * @ProblemLink https://leetcode.com/problems/maximum-subarray/
 *
 * @Author Pig Keeper
 */

package Leetcode;

import java.util.Scanner;

public class Maximum_Subarray_53 {
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println((new Inner()).maxSubArray(arr));
        sc.close();
    }

    static class Inner {
        public int maxSubArray(int[] arr) {
            int currSum = arr[0];
            int resSum = arr[0];
            
            int size = arr.length;
    
            for(int i = 1; i < size; i++) {
                currSum = Math.max(currSum + arr[i], arr[i]);
                resSum = Math.max(resSum, currSum);
            }
            return resSum;
        }
    }
}
