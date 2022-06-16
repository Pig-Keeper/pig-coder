/*
 * @Created on Wed Jun 15 2022 21:01:00
 * @ProblemCode OPTPAIRS
 * @ProblemLink https://www.codechef.com/START43D/problems/OPTPAIRS
 *
 * @Author Pig Keeper
 */

package codechef.june_starters_43_2022_div_4;

import java.util.Scanner;

public class The_Optimal_Pairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int n = sc.nextInt();

            System.out.println((new Inner()).theOptimalPairs(n));
        }

        sc.close();
    }

    static class Inner {
        public int theOptimalPairs(int n) {
            int sqrtN = (int)Math.sqrt(n);
            int count = 0;

            for(int i = 1; i <= sqrtN; i++) {
                if(n % i == 0) {
                    int div1 = i;
                    int diffDiv1 = n - div1;

                    int div2 = n/i;
                    int diffDiv2 = n - div2;

                    if(div1 == div2) {
                        if(div1 == diffDiv1) {
                            count += 1;
                        } else {
                            count += 2;
                        }
                        continue;
                    }

                    if(div1 == diffDiv1) {
                        count += 1;
                    } else {
                        count += 2;
                    }

                    if(div2 != n) {
                        if(div2 == diffDiv2) {
                            count += 1;
                        } else {
                            count += 2;
                        }
                    }
                }
            }
            return count;
        }
    }
}
