/*
 * @Created on Wed Jun 15 2022 20:32:53
 * @ProblemCode JOINING
 * @ProblemLink https://www.codechef.com/START43D/problems/JOINING
 *
 * @Author Pig Keeper
 */

package codechef.june_starters_43_2022_div_4;

import java.util.Scanner;

public class Joining_Date {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            System.out.println((new Inner()).joiningDate(n, k));
        }

        sc.close();
    }

    static class Inner {
        public int joiningDate(int n, int k) {
            int totalBucket = n%5 == 0? n/5 : n/5 + 1;
            int kBucket = k%5 == 0? k/5 : k/5 + 1;

            return totalBucket - kBucket;
        }
    }
}
