/*
 * @Created on Sat May 28 2022 03:19:26
 * @Author Pig Keeper
 * @ProblemCode PRIZEPOOL
 * @ProblemLink https://www.codechef.com/submit-v2/PRIZEPOOL
 */

package CodeChef;

import java.util.Scanner;

public class Total_Prize_Money {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {

            System.out.println((new Inner()).totalPrizeMoney(sc.nextInt(), sc.nextInt()));
        }
    }

    static class Inner {
        public int totalPrizeMoney(int prizeX, int prizeY) {
            return 10 * prizeX + 90 * prizeY; 
        }
    }  
}
