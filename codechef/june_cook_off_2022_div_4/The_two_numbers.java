/*
 * @Created on Sun Jun 05 2022 22:00:45
 * @ProblemCode TWONUMBERS
 * @ProblemLink https://www.codechef.com/COOK142D/problems/TWONUMBERS
 *
 * @Author Pig Keeper
 */

package codechef.june_cook_off_2022_div_4;

import java.util.Scanner;

public class The_two_numbers {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int x = sc.nextInt();
    
            System.out.println((new Inner()).theTwoNumbers(x));
        }
        sc.close();
    }

    static class Inner{
        public int theTwoNumbers(int x) {
            int half = x/2;
            if(x % 2 == 0) {
                int first = half - 1;
                int second = half + 1;
                int max = 0;

                int gc = gcd(first, second);
                while(gc != 1) {
                    Math.max(max, (first * second)/gc - gc);
                    first--;
                    second++;
                    gc = gcd(first, second);
                } 
                return Math.max(max, (first*second) - 1);
            } else {
                return half*(half+1) - 1; 
            }
        }

        private int gcd(int a, int b) {
            if(b == 0) {
                return a;
            }
            return gcd(b, a%b);
        }
    }
}
