/*
 * @Created on Wed Jun 08 2022 21:00:08
 * @ProblemCode MODULO3
 * @ProblemLink https://www.codechef.com/START42D/problems/MODULO3
 *
 * @Author Pig Keeper
 */

package codechef.june_starters_42_2022_div_4;

import java.util.Scanner;

public class Divisible_by_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println((new Inner()).divisibleBy3(a, b));
        }
        sc.close();
    }

    static class Inner {
        // Approach -> Correct
        public int divisibleBy3(int a, int b) {
             if(a%3 == 0 || b%3 == 0) {
                 return 0;
             } else if((a%3) - (b%3) == 0) {
                 return 1;
             } else {
                 return 2;
             }
        }   
    }
}
