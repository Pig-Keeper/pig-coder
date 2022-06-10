/*
 * @Created on Fri Jun 10 2022 13:27:12
 * @ProblemLink https://leetcode.com/problems/house-robber/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

public class House_Robber_198 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println((new Inner()).rob(arr));
        sc.close();
    }

    static class Inner {
        public int rob(int[] arr) {
            int[] res = new int[arr.length + 1];
            res[0] = 0;

            if(arr.length >= 1) {
                res[1] = arr[0];
            }

            if(arr.length >= 2) {
                res[2] = arr[1];
            }

            for(int i = 3; i <= arr.length; i++) {
                res[i] = arr[i - 1] + Math.max(res[i - 2], res[i - 3]);
            }

            return Math.max(res[arr.length], res[arr.length - 1]);
        }
    }
}
