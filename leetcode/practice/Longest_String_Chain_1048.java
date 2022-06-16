/*
 * @Created on Thu Jun 16 2022 04:35:54
 * @ProblemLink https://leetcode.com/problems/longest-string-chain/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Longest_String_Chain_1048 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];

        for(int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        System.out.println((new Inner()).longestStrChain(words));

        sc.close();
    }

    static class Inner {
        public int longestStrChain(String[] words) {
            int length = words.length;

            int[][] arr = new int[length][length];

            for(int i = 0; i < length; i++) {
                for(int j = i; j < length; j++) {
                    int diff = difference(words[i], words[j]);

                    if(diff == 0) {
                        arr[i][j] = arr[j][i] = 0;
                    } else if(diff == 1) {
                        arr[i][j] = 1;
                        arr[j][i] = 0;
                    } else {
                        arr[i][j] = 0;
                        arr[j][i] = 1;
                    }
                }
            }

            int[] res = new int[length];
            Arrays.fill(res, -1);
           
            int max = 0;

            for(int i = 0; i < length; i++) {
                if(res[i] == -1) {
                    res[i] = 1;
                    for(int j = 0; j < length; j++) {
                        if(arr[i][j] == 1) {
                            res[i] = Math.max(res[i], 1 + longestStrChain(arr, res, j, length));
                        }
                    }
                }
                max = Math.max(res[i], max);
            }

            return max;
        }

        private int longestStrChain(int[][] arr, int[] res, int j, int length) {
            if(res[j] != -1) {
                return res[j];
            }

            res[j] = 1;

            for(int i = 0; i < length; i++) {
                if(arr[j][i] == 1) {
                    res[j] = Math.max(res[j], 1 + longestStrChain(arr, res, i, length));
                }
            }

            return res[j];
        }

        private int difference(String word1, String word2) {
            if(word1.length() + 1 == word2.length()) {
                int length = word2.length();
                for(int i = 0; i < length; i++) {
                    StringBuilder sb = new StringBuilder(word2);
                    if(sb.deleteCharAt(i).toString().equals(word1)) {
                        return 1;
                    }
                }
            }

            if(word2.length() + 1 == word1.length()) {
                int length = word1.length();
                for(int i = 0; i < length; i++) {
                    StringBuilder sb = new StringBuilder(word1);
                    if(sb.deleteCharAt(i).toString().equals(word2)) {
                        return -1;
                    }
                }
            }
            return 0;
        }
    }
}
