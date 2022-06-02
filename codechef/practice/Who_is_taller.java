/*
 * @Created on Thu Jun 02 2022 23:59:04
 * @ProblemCode TALLER
 * @ProblemLink https://www.codechef.com/submit-v2/TALLER
 *
 * @Author Pig Keeper
 */

package codechef.practice;

import java.util.Scanner;

public class Who_is_taller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            System.out.println((new Inner()).whoIsTaller(sc.nextInt(), sc.nextInt()));
        }
        sc.close();
    }

    static class Inner {
        public String whoIsTaller(int x, int y) {
            return x > y ? "A" : "B";
        }
    }
}
