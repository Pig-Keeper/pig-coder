/*
 * @Created on Wed Jun 08 2022 21:27:27
 * @ProblemCode MINORMAX
 * @ProblemLink https://www.codechef.com/START42D/problems/MINORMAX
 *
 * @Author Pig Keeper
 */

package codechef.june_starters_42_2022_div_4;

import java.util.Scanner;

public class Minimum_or_Maximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println((new Inner()).minimumOrMaximum(arr, n));
        }
        
        sc.close();
    }

    static class Inner {
        // Approach -> Correct
        public String minimumOrMaximum(int[] arr, int n) {
            int min = arr[0], max = arr[0];

            for(int i = 0; i < n; i++) {
                if(arr[i] <= min) {
                    min = arr[i];
                    continue;
                } else if(arr[i] >= max) {
                    max = arr[i];
                } else {
                    return "NO";
                }
            }
            return "YES";
        }
    }
}
