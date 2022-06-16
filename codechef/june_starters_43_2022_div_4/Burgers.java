/*
 * @Created on Wed Jun 15 2022 20:04:38
 * @ProblemCode BURGERS
 * @ProblemLink https://www.codechef.com/START43D/problems/BURGERS
 *
 * @Author Pig Keeper
 */

package codechef.june_starters_43_2022_div_4;

import java.util.Scanner;

public class Burgers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println((new Inner()).burgers(a, b));
        }

        sc.close();
    }

    static class Inner {
        public int burgers(int a, int b) {
            return a <= b? a : b;
        }
    }
}
