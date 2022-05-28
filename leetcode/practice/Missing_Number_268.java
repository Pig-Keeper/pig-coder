/*
 * @Created on Sat May 28 2022 17:52:54
 * @ProblemLink https://leetcode.com/problems/missing-number/
 *
 * @Author Pig Keeper
 */
package leetcode.practice;

import java.util.Scanner;

public class Missing_Number_268 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println((new Inner()).missingNumber(arr));

        sc.close();
    }

    static class Inner {
        public int missingNumber(int[] arr) {
            int length = arr.length;
            int totalSum = (length * (length + 1))/2;

            for(int i = 0; i < length; i++) {
                totalSum -= arr[i];
            }

            return totalSum;
        }
    }
}
