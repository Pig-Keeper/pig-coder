/*
 * @Created on Wed Jun 15 2022 22:40:46
 * @ProblemCode PERMAND
 * @ProblemLink https://www.codechef.com/START43D/problems/PERMAND
 *
 * @Author Pig Keeper
 */

package codechef.june_starters_43_2022_div_4;

import java.util.Scanner;

public class Permutation_AND {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int n = sc.nextInt();
            int[] res = new int[n];

            (new Inner()).permutationAnd(n, res);

            if(res[0] == -1) {
                System.out.println(-1);
            } else {
                for(int i = 1; i <= n; i++) {
                    System.out.print(i + " ");
                }
                System.out.println("");

                for(int i = 1; i <= n; i++) {
                    System.out.print(res[i - 1] + " ");
                }
                System.out.println("");
            }
        }

        sc.close();
    }

    static class Inner {
        public void permutationAnd(int n, int[] res) {
            if(n == 1) {
                res[0] = 1;
                return;
            }
            if(n % 2 == 1) {
                res[0] = -1;
                return;
            }

            permutate(n, res);
        }

        private void permutate(int n, int[] res) {
            if(n < 1){
                return;
            }

            int anti = antiBit(n);
            int l = anti, r = n;

            while(l < r) {
                res[l - 1] = r;
                res[r - 1] = l;
                l++;
                r--;
            }

            permutate(anti - 1, res);
        }

        private int antiBit(int n) {
            int twos = 1;
            int res = 0;
            while(n != 0) {
                if(n%2 == 0) {
                    res += twos;
                }
                n /= 2;
                twos *= 2;
            }
            return res;
        }
    }
}
