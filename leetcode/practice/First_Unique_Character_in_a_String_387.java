/*
 * @Created on Sat Jun 04 2022 02:35:56
 * @ProblemLink https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Arrays;
import java.util.Scanner;

public class First_Unique_Character_in_a_String_387 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println((new Inner()).firstUniqChar(sc.nextLine()));
        sc.close();
    }

    static class Inner {
        public int firstUniqChar(String str) {
            int[] count = new int[26];
            int[] index = new int[26];

            int length = str.length();
            int res = length;

            Arrays.fill(count, 0);
            Arrays.fill(index, 0);

            for(int i = 0; i < length; i++) {
                int j = str.charAt(i) - 'a';
                if(count[j] == 0) {
                    index[j] = i;
                }
                count[j]++;
            }

            for(int i = 0; i < 26; i++) {
                if(count[i] == 1 && res > index[i]) {
                    res = index[i];
                }
            }

            return res == length ? -1 : res;
        }
    }
}
