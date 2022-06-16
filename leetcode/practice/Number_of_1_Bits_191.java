/*
 * @Created on Tue Jun 14 2022 13:35:59
 * @ProblemLink https://leetcode.com/problems/number-of-1-bits/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

public class Number_of_1_Bits_191 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println((new Inner()).hammingWeight(n));

        sc.close();
    }

    static class Inner {
        public int hammingWeight(int n) {
            int count = 0;
            int k = n;

            if( k < 0) {
                k = ~k;
            }

            while(k != 0) {
                if((k & 1) == 1) {
                    count++;
                }
                k = k >> 1;
            }
            return n < 0 ? 32 - count : count;
        }
    }
}
