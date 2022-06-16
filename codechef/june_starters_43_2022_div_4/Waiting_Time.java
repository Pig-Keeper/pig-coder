/*
 * @Created on Wed Jun 15 2022 20:10:18
 * @ProblemCode WAITTIME
 * @ProblemLink https://www.codechef.com/START43D/problems/WAITTIME
 *
 * @Author Pig Keeper
 */

package codechef.june_starters_43_2022_div_4;

import java.util.Scanner;

public class Waiting_Time {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int k = sc.nextInt();
            int x = sc.nextInt();

            System.out.println((new Inner()).waitingTime(k, x));
        }

        sc.close();
    }

    static class Inner {
        public int waitingTime(int k, int x) {
            return (7*k) - x;
        }
    }
}
