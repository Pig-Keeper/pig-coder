/*
 * @Created on Thu Jun 02 2022 23:35:08
 * @ProblemCode INCREAR
 * @ProblemLink https://www.codechef.com/submit-v2/INCREAR
 *
 * @Author Pig Keeper
 */

package codechef.practice;

import java.util.Scanner;

public class Equal_Integers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            System.out.println((new Inner()).equalIntegers(sc.nextInt(), sc.nextInt()));
        }
        sc.close();
    }

    static class Inner {
        public int equalIntegers(int x, int y) {
            if(x <= y) {
                return y - x;
            } else {
                return (x - y)%2 == 0 ? (x - y)/2 : (x + 1 - y)/2 + 1;
            }
        }
    }
}
