/*
 * @Created on Wed Jun 08 2022 20:48:08
 * @ProblemCode MINFLIPS
 * @ProblemLink https://www.codechef.com/START42D/problems/MINFLIPS
 *
 * @Author Pig Keeper
 */

package codechef.june_starters_42_2022_div_4;

import java.util.Scanner;

public class Minimum_number_of_Flips {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];

            for(int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println((new Inner()).minimumNumberOfFlips(arr));
        }
        sc.close();
    }

    static class Inner {
        // Approach -> Correct
        public int minimumNumberOfFlips(int[] arr) {
            if(arr.length % 2 == 0) {
                int countNeg = 0;
                int countPos = 0;
                for(int i = 0; i < arr.length; i++) {
                   if(arr[i] < 0) {
                       countNeg++;
                   } else {
                       countPos++;
                   }
                }

                if(countNeg > countPos) {
                    return (countNeg - countPos)/2;
                } else {
                    return (countPos - countNeg)/2;
                }
            } else {
                return -1;
            }
        }
    }
}
