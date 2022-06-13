/*
 * @Created on Fri Jun 10 2022 23:35:02
 * @ProblemCode DIVBYI
 * @ProblemLink https://www.codechef.com/JUNE221D/problems/DIVBYI
 *
 * @Author Pig Keeper
 */

package codechef.june_long_one_2022_div_4;

import java.util.Scanner;

public class Divisible_by_i {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int n = sc.nextInt();

            int arr[] = (new Inner()).divisibleByI(n);

            for(int i = 0; i < n; i++) {
                System.out.print(arr[i]);
                if(i != n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
        sc.close();
    }

    static class Inner {
        public int[] divisibleByI(int n) {
            int[] res = new int[n];
            res[n-1] = n;
            res[n-2] = 1;
            int flag = -1;
            for(int i = n-3; i >=0; i--) {
                res[i] = res[i + 2] + flag;
                flag *= -1; 
            }

            return res;
        } 
    }
}
