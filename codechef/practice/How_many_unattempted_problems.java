/*
 * @Created on Thu Jun 02 2022 23:53:39
 * @ProblemCode PRACLIST
 * @ProblemLink https://www.codechef.com/submit-v2/PRACLIST
 *
 * @Author Pig Keeper
 */

package codechef.practice;

import java.util.Scanner;

public class How_many_unattempted_problems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println((new Inner()).howManyUnattempedProblems(sc.nextInt(), sc.nextInt()));
        sc.close();
    }

    static class Inner {
        public int howManyUnattempedProblems(int x, int y) {
            return x >= y ? x - y : 0;
        }
    }
}
