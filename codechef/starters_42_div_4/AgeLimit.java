/*
 * @Created on Wed Jun 08 2022 20:36:57
 * @ProblemCode AGELIMIT
 * @ProblemLink https://www.codechef.com/START42D/problems/AGELIMIT
 *
 * @Author Pig Keeper
 */

package codechef.starters_42_div_4;

import java.util.Scanner;

public class AgeLimit {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int a = sc.nextInt();

            System.out.println((new Inner()).ageLimit(x, y, a));
        }
        sc.close();
    }

    static class Inner {
        // Approach -> Correct
        public String ageLimit(int x, int y, int a) {
            return a >= x && a < y ? "YES" : "NO";
        }
    }
}
