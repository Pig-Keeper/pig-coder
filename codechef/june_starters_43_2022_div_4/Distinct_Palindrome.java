/*
 * @Created on Wed Jun 15 2022 20:38:48
 * @ProblemCode DISPAL
 * @ProblemLink https://www.codechef.com/START43D/problems/DISPAL
 *
 * @Author Pig Keeper
 */

package codechef.june_starters_43_2022_div_4;

import java.util.Scanner;

public class Distinct_Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            System.out.println((new Inner()).distinctPalindrome(n, x));
        }

        sc.close();
    }

    static class Inner {
        public String distinctPalindrome(int n, int x) {
            int pd = n%2 == 0 ? n/2: n/2 + 1;
            
            if(pd < x) {
                return String.valueOf(-1);
            }

            char[] res = new char[n];
            char c = 'a';
            int l = 0 , r = n - 1;

            while(l <= r) {
                res[l] = res[r] = c;
                if(--x > 0) {
                    c++;
                }
                l++;
                r--;
            }
            return String.valueOf(res);
        }
    }
}
