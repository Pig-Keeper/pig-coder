/*
 * @Created on Sat May 28 2022 04:03:37
 * @ProblemCode PRIZEPOOL
 * @ProblemLink https://www.codechef.com/submit-v2/PRIZEPOOL
 *
 * @Author Pig Keeper
 */


package codechef.practice;

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
