/*
 * @Created on Fri Jun 10 2022 22:58:43
 * @ProblemCode ALTERADD
 * @ProblemLink https://www.codechef.com/JUNE221D/problems/ALTERADD
 *
 * @Author Pig Keeper
 */

package codechef.june_long_one_2022_div_4;

import java.util.Scanner;

public class Alternate_Additions {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println((new Inner()).alternateAdditions(a, b));
        }
        sc.close();
    }

    static class Inner {
        public String alternateAdditions(int a, int b) {
            return (b - a)%3 == 0 || (b - a)%3 == 1 ? "YES" : "NO";
        } 
    }    
}
