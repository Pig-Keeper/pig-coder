/*
 * @Created on Fri Jun 10 2022 22:47:24
 * @ProblemCode SUBSCRIBE_
 * @ProblemLink https://www.codechef.com/JUNE221D/problems/SUBSCRIBE_
 *
 * @Author Pig Keeper
 */

package codechef.june_long_one_2022_div_4;

import java.util.Scanner;

public class Subscriptions {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            System.out.println((new Inner()).subscriptions(n, x));
        }
        sc.close();
    }

    static class Inner {
        public int subscriptions(int n, int x) {
            return n%6 == 0 ? (n/6) * x : ((n/6) + 1) * x; 
        } 
    }
}
