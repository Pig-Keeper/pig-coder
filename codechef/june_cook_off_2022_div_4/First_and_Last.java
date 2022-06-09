/*
 * @Created on Sun Jun 05 2022 20:20:59
 * @ProblemCode FIRSTANDLAST
 * @ProblemLink https://www.codechef.com/COOK142D/problems/FIRSTANDLAST
 *
 * @Author Pig Keeper
 */

package codechef.june_cook_off_2022_div_4;

import java.util.Scanner;

public class First_and_Last {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
    
            System.out.println((new Inner()).firstAndLast(arr));
        }
        sc.close();
    }

    static class Inner{
        // Approach -> Correct
        public int firstAndLast(int[] arr) {
            int length = arr.length;

            if(length == 0) {
                return 0;
            }

            if(length == 1) {
                return arr[0];
            }

            int res = arr[0] + arr[length - 1];

            for(int i = 0; i < length - 1; i++) {
                res = Math.max(res, arr[i] + arr[i + 1]);
            }
            return res;
        }
    }
}
