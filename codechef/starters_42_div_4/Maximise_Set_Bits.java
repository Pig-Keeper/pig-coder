/*
 * @Created on Wed Jun 08 2022 21:48:32
 * @ProblemCode MAXIMISEBITS
 * @ProblemLink https://www.codechef.com/START42D/problems/MAXIMISEBITS
 *
 * @Author Pig Keeper
 */

package codechef.starters_42_div_4;

import java.util.Scanner;

public class Maximise_Set_Bits {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println((new Inner()).maximiseSetBits(a, b));
        }
        sc.close();
    }

    static class Inner {
        // Approach -> wrong
        public int maximiseSetBits(int n, int k) {
             System.out.println(n + " " + k);

            if(k == 0 || n == 0) {
                return 0;
            }

            if(n == 1) {
                int count = 0;
                while(k != 0) {
                    if(k%2 == 1) {
                        count ++;
                    }
                    k = k >> 1;
                }
                return count;
            }
            
            int currTwo = 1;
            int curr = 1;

            int max = 0;
            int maxCurr = 0;
            int maxNum = 0;

            int count = 1;

            while(curr <= k){
                if(k/curr <= n) {
                    int num = k/curr;
                    if(num * curr != k) {
                        num--;
                    }
                    if(num * count > max) {
                        max = num * count;
                        maxCurr = curr;
                        maxNum = num;
                    }
                }
                currTwo *= 2;
                curr = curr + currTwo;
                count++;
            }

            if(max == 0) {
                curr -= currTwo;
            }

            System.out.println(max + " " + maxCurr + " " + maxNum);
            
            return max + maximiseSetBits(n - maxNum, k - maxCurr* maxNum);
        }
    }
}
