/*
 * @Created on Tue Jun 14 2022 14:17:59
 * @ProblemLink https://leetcode.com/problems/reverse-bits/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

public class Reverse_Bits_190 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println((new Inner()).reverseBits(n));

        sc.close();
    }

    static class Inner {
        public long reverseBits(int n) {
            long ans = 0;
            long twos = 1;
            String binary = Integer.toBinaryString(n);

            for(int i = 0; i < 32 - binary.length() ; i++) {
                twos *=2;
            }

            for(int i = 0; i < binary.length() ; i++) {
                ans += (binary.charAt(i) - '0')*twos;
                twos *=2;
            }

            return ans;
        }
    }
}

