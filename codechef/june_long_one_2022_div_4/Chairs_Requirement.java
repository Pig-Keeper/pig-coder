/*
 * @Created on Fri Jun 10 2022 22:37:31
 * @ProblemCode CHAIRS_
 * @ProblemLink https://www.codechef.com/JUNE221D/problems/CHAIRS_
 *
 * @Author Pig Keeper
 */

package codechef.june_long_one_2022_div_4;

import java.util.Scanner;

public class Chairs_Requirement {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println((new Inner()).chairRequirement(x, y));
        }
        sc.close();
    }

    static class Inner {
        public int chairRequirement(int x, int y) {
            return x >= y ? x - y : 0;
        }
    }
}
