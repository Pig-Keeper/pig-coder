/*
 * @Created on Wed Jun 08 2022 21:13:28
 * @ProblemCode HOWMANYMAX
 * @ProblemLink https://www.codechef.com/START42D/problems/HOWMANYMAX
 *
 * @Author Pig Keeper
 */

package codechef.starters_42_div_4;

import java.util.Arrays;
import java.util.Scanner;

public class How_Many_Maximums {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int n = sc.nextInt();
            String str = sc.next();

            System.out.println((new Inner()).howManyMaximums(str, n));
        }
        
        sc.close();
    }

    static class Inner {
        // Approach -> Correct
        public int howManyMaximums(String str, int n) {
            boolean[] arr = new boolean[n];
            int count = 0;
            Arrays.fill(arr, true);

            for(int i = 0; i < n - 1; i++) {
                if(str.charAt(i) - '0' == 0) {
                    arr[i] = false;
                } else if(str.charAt(i) - '0' == 1) {
                    arr[i + 1] = false;
                }
            }

            for(int i = 0; i < n; i++) {
                if(arr[i]) {
                    count++;
                }
            }

            return count;
        }
    }
}
