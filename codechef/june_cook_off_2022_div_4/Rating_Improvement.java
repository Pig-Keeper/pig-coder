/*
 * @Created on Sun Jun 05 2022 20:06:25
 * @ProblemCode ADVANCE
 * @ProblemLink https://www.codechef.com/COOK142D/problems/ADVANCE
 *
 * @Author Pig Keeper
 */

package codechef.june_cook_off_2022_div_4;

import java.util.Scanner;

public class Rating_Improvement {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
    
            System.out.println((new Inner()).ratingImprovement(x, y));
        }
        sc.close();
    }

    static class Inner{
        public String ratingImprovement(int x, int y) {
            return y >= x && y - x <= 200 ? "YES" : "NO";
        }
    }
}
