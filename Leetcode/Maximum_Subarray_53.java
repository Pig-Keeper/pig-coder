/*
 * @Author: Pig Keeper 
 * @Date: 2022-05-27 21:45:50 
 * @Last Modified by: Pig Keeper
 * @Last Modified time: 2022-05-27 21:57:59
 */
package Leetcode;

import java.util.Scanner;

public class Maximum_Subarray_53 {
    public Maximum_Subarray_53() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maxSubArray(arr));
        sc.close();
    }

    private int maxSubArray(int[] arr) {
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
