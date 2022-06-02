/*
 * @Created on Thu Jun 02 2022 23:29:12
 * @ProblemCode WINNERR
 * @ProblemLink https://www.codechef.com/submit-v2/WINNERR
 *
 * @Author Pig Keeper
 */
package codechef.practice;

import java.util.Scanner;

public class Determine_the_Winner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            System.out.println((new Inner()).determineTheWinner(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        sc.close();
    }

    static class Inner {
        public String determineTheWinner(int pA, int pB, int qA, int qB) {
            return Math.max(pA, pB) == Math.max(qA, qB) ? "TIE" : Math.max(pA, pB) > Math.max(qA, qB) ? "Q" : "P";
        }
    }
}
