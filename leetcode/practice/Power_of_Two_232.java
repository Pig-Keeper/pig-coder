/*
 * @Created on Mon Jun 13 2022 20:33:57
 * @ProblemLink https://leetcode.com/problems/power-of-two/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

public class Power_of_Two_232 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println((new Inner().isPowerOfTwo(n)));

        sc.close();
    }

    static class Inner {
        public boolean isPowerOfTwo(int n) {
            if(n == 0) {
                return false;
            }

            while((n & 1) != 1) {
                n = n >> 1;
            }
            return n == 1? true : false;
        }
    }
}
