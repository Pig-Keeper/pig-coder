/*
 * @Created on Thu Jun 02 2022 21:19:08
 * @ProblemCode CCHOCOLATES
 * @ProblemLink https://www.codechef.com/submit-v2/CCHOCOLATES
 *
 * @Author Pig Keeper
 */
package codechef.practice;

import java.util.Scanner;

public class Chef_and_Chocolates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            System.out.println((new Inner()).chefAndChocolates(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        sc.close();
    }

    static class Inner{
        public int chefAndChocolates(int x, int y, int z) {
            int totalMoney = 5 * x + 10 * y;
            return totalMoney/z;
        }
    }
}
