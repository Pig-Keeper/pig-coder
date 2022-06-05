/*
 * @Created on Sun Jun 05 2022 20:35:42
 * @ProblemCode BREAKSTICK
 * @ProblemLink https://www.codechef.com/COOK142D/problems/BREAKSTICK
 *
 * @Author Pig Keeper
 */

package codechef.june_cook_off_2022_div_4;

import java.util.Scanner;

public class Break_the_Stick {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
    
            System.out.println((new Inner()).breakTheStick(x, y));
        }
        sc.close();
    }

    static class Inner{
        public String breakTheStick(int x, int y) {
            return x%2 == 1 && y%2 == 0 ? "NO" : "YES";
        }
    }
}
