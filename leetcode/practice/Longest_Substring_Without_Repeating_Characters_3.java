/*
 * @Created on Fri Jun 03 2022 18:16:15
 * @ProblemLink https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * @Author Pig Keeper
 */
package leetcode.practice;

import java.util.HashMap;
import java.util.Scanner;

public class Longest_Substring_Without_Repeating_Characters_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println((new Inner()).lengthOfLongestSubstring(str));
        sc.close();
    }

    static class Inner {
        public int lengthOfLongestSubstring(String str) {
            int length = str.length();
            HashMap<Character, Integer> hashMap = new HashMap<>();
            int start = 0;
            int max = 0;
            for(int i = 0; i < length; i++) {
                if(hashMap.containsKey(str.charAt(i)) && hashMap.get(str.charAt(i)) >= start) {
                    max = Math.max(max, i - start);
                    start = hashMap.get(str.charAt(i)) + 1;
                    hashMap.put(str.charAt(i), i);
                } else {
                    hashMap.put(str.charAt(i), i);
                }
            }

            return Math.max(max, length - start);
        }
    }
}
