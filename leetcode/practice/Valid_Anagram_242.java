/*
 * @Created on Sat Jun 04 2022 15:09:48
 * @ProblemLink https://leetcode.com/problems/valid-anagram/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Valid_Anagram_242 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println((new Inner()).isAnagram(sc.nextLine(), sc.nextLine()));

        sc.close();
    }

    static class Inner {
        public boolean isAnagram(String str1, String str2) {
            int[] arr1 = new int[26];
            int[] arr2 = new int[26];

            int length1 = str1.length();
            int length2 = str2.length();

            if(length1 == length2) {
                Arrays.fill(arr1, 0);
                Arrays.fill(arr2, 0);
                
                for(int i = 0; i < length1; i++) {
                    arr1[str1.charAt(i) - 'a']++;
                }
    
                for(int i = 0; i < length2; i++) {
                    arr2[str2.charAt(i) - 'a']++;
                }

                for(int i = 0; i < 26; i++) {
                    if(arr1[i] != arr2[i]) {
                        return false;
                    }
                }
                return true;
            }

            return false;
        }
    }
}
