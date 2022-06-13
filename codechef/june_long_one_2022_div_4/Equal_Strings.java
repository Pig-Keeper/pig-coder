/*
 * @Created on Fri Jun 10 2022 23:07:39
 * @ProblemCode EQUALSTRING
 * @ProblemLink https://www.codechef.com/JUNE221D/problems/EQUALSTRING
 *
 * @Author Pig Keeper
 */

package codechef.june_long_one_2022_div_4;

import java.util.Arrays;
import java.util.Scanner;

public class Equal_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int n = sc.nextInt();
            String a = sc.next();
            String b = sc.next();

            System.out.println((new Inner()).equalStrings(n, a, b));
        }
        sc.close();
    }

    static class Inner {
        public int equalStrings(int n, String a, String b) {
            boolean[] arr = new boolean[26];

            Arrays.fill(arr, false);

            for(int i = 0; i < n; i++) {
                if(a.charAt(i) != b.charAt(i)) {
                    arr[b.charAt(i) - 'a'] = true;
                }
            }

            int count = 0;
            for(int i = 0; i < 26; i++) {
                if(arr[i]){
                    count++;
                }
            }
            return count;
        }
    }
}
