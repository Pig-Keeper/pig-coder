/*
 * @Created on Thu Jun 09 2022 20:40:37
 * @ProblemLink https://leetcode.com/problems/climbing-stairs/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

public class Climbing_Stairs_70 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println((new Inner()).climbStairs(n));
        sc.close();
    }

    static class Inner {
        public int climbStairs(int n) {
            int[] arr = new int[]{0, 1, 2};

            for(int i = 3; i <= n; i++) {
                if(i % 3 == 0) {
                    arr[0] = arr[1] + arr[2];
                } else if(i % 3 == 1) {
                    arr[1] = arr[0] + arr[2];
                } else {
                    arr[2] = arr[0] + arr[1];
                }
            }

            return arr[n%3];
        }
    }
}
