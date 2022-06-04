/*
 * @Created on Sat Jun 04 2022 02:53:34
 * @ProblemLink https://leetcode.com/problems/ransom-note/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Ransom_Note_383 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println((new Inner()).canConstruct(sc.nextLine(), sc.nextLine()));
        sc.close();
    }

    static class Inner {
        public boolean canConstruct(String str1, String str2) {
            int length1 = str1.length();
            int length2 = str2.length();

            if(length1 <= length2) {
                int[] arr1 = new int[26];
                int[] arr2 = new int[26];
                
                Arrays.fill(arr1, 0);
                Arrays.fill(arr2, 0);

                for(int i = 0; i < length1; i++) {
                    arr1[str1.charAt(i)  - 'a']++;
                }

                for(int i = 0; i < length2; i++) {
                    arr2[str2.charAt(i)  - 'a']++;
                }

                return testConstruct(arr1, arr2);
            }
            return false;
        }

        private boolean testConstruct(int[] arr1, int[] arr2) {
            for(int i = 0; i < 26; i++) {
                if(arr1[i] > arr2[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
