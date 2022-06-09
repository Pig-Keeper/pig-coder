/*
 * @Created on Wed Jun 08 2022 20:43:00
 * @ProblemCode EQUALDIST
 * @ProblemLink https://www.codechef.com/START42D/problems/EQUALDIST
 *
 * @Author Pig Keeper
 */

package codechef.starters_42_div_4;

import java.util.Scanner;

public class Equal_Distribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println((new Inner()).equalDistribution(a, b));
        }
        sc.close();
    }

    static class Inner {
        // Approach -> Correct
        public String equalDistribution(int a, int b) {
            return (a + b)%2 == 0 ? "YES" : "NO";
        }
    }
}
