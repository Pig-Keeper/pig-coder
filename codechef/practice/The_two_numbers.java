/*
 * @Created on Sun Jun 05 2022 22:00:45
 * @ProblemCode TWONUMBERS
 * @ProblemLink https://www.codechef.com/COOK142D/problems/TWONUMBERS
 *
 * @Author Pig Keeper
 */

package codechef.practice;

import java.util.Scanner;

public class The_two_numbers {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            long n = sc.nextInt();
    
            System.out.println((new Inner()).theTwoNumbers(n));
        }
        sc.close();
    }

    static class Inner{
        public long theTwoNumbers(long n) {
            if(n == 2) {
                return 0;
            } else if(n%2 == 1) {
                long half = n / 2;
                // gcd of x and x + 1 will always be 1
                // when a + b = n, then for all a, b pairs max(a*b) will be when b and a are close.
                // in this case n/2*n/2 but n is odd.    
                return (half * (half + 1)) - 1;
            } else {
                if((n/2 - 1)%2 == 1) {
                    long half = (n/2 - 1);
                    //gcd of two odd numbers separated by 2 i.e x and x + 2 where x is odd is 1
                    /**
                     * Proof using Euclidean algorithm i.e. gcd(a,b) = gcd(b, a%b)
                     * gcd(x + 2, x) => gcd(x, 2) => gcd(2, 1) => gcd(1, 0)
                     * Since x is odd, x % 2 = 1
                     */
                    return (half * (half + 2)) - 1;
                } else {
                    long half = (n/2 - 2);
                    //gcd of two odd numbers separated by 4 i.e x and x + 4 where x is odd is 1
                    /**
                     * Proof using Euclidean algorithm i.e. gcd(a,b) = gcd(b, a%b)
                     * gcd(x + 4, x) => gcd(x, 4) => gcd(4, 1) => gcd(1, 0) => 1
                     *                            => gcd(4, 3) => gcd(3, 1) => gcd(1, 0) => 1
                     * Since x is odd, x % 4 can either be 1, 3
                     */
                    return (half * (half + 4)) - 1;
                }
            }
        }
    }
}
