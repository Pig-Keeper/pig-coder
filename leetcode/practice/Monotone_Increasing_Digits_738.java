/*
 * @Created on Tue Jun 14 2022 18:35:47
 * @ProblemLink https://leetcode.com/problems/monotone-increasing-digits/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

public class Monotone_Increasing_Digits_738 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println((new Inner()).monotoneIncreasingDigits(n));

        sc.close();
    }

    static class Inner {
        public int monotoneIncreasingDigits(int n) {
            int temp = n;
            int ans = 0;

            int pos = -1;
            int index = 0;

            while(temp != 0) {
                int currDigit = temp%10;
                temp = temp/10;
                int nextDigit = temp%10;

                if(nextDigit > currDigit) {
                    temp--;
                    pos = index;
                }
                index++;
            }

            if(pos == -1) {
                return n;
            }

            temp = n;
            int tens = 1;
            for(int i = 0; i < index; i++) {
                if(i <= pos) {
                    ans = ans*10 + 9;
                } else {
                    if(i == pos + 1) {
                        temp--;
                    }
                    ans += (temp%10)*tens;
                }
                tens *= 10;
                temp /= 10;
            }
            return ans;
        }
    }
}
