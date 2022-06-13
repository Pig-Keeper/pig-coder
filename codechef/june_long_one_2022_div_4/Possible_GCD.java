/*
 * @Created on Sat Jun 11 2022 00:10:19
 * @ProblemCode DISTGCD
 * @ProblemLink https://www.codechef.com/JUNE221D/problems/DISTGCD
 *
 * @Author Pig Keeper
 */

package codechef.june_long_one_2022_div_4;

import java.util.Scanner;

public class Possible_GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println((new Inner()).possibleGcd(a, b));
        }
        sc.close();
    }

    static class Inner {
        public int possibleGcd(int a, int b) {
            int diff = (int)Math.abs(a - b);
            int sqrt = (int)Math.pow(diff, 0.5);
            int count = 0;
            for(int i = 1; i <= sqrt; i++) {
                if(diff%i == 0) {
                    if(i == diff/i) {
                        count++;
                    } else {
                        count+=2;
                    }
                }
            }
            return count;
        } 
    }
}
