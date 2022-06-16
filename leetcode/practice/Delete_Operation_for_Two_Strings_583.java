/*
 * @Created on Tue Jun 14 2022 14:56:11
 * @ProblemLink https://leetcode.com/problems/delete-operation-for-two-strings/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;

public class Delete_Operation_for_Two_Strings_583 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();

        System.out.println((new Inner()).minDistance(word1, word2));

        sc.close();
    }

    static class Inner {
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];

            dp[0][0] = 0;

            for(int i = 1; i <= word1.length(); i++) {
                dp[i][0] = i;
            }

            for(int j = 1; j <= word2.length(); j++) {
                dp[0][j] = j;
            }

            for(int i = 0; i < word1.length(); i++) {
                for(int j = 0; j < word2.length(); j++) {
                    if(word1.charAt(i) == word2.charAt(j)) {
                        dp[i + 1][j + 1] = Math.min(dp[i + 1][j] + 1, Math.min(dp[i][j + 1] + 1, dp[i][j]));
                    } else {
                        dp[i + 1][j + 1] = Math.min(dp[i + 1][j] + 1, Math.min(dp[i][j + 1] + 1, dp[i][j] + 2));
                    }
                }
            }
            // System.out.println(Arrays.deepToString(dp));
            return dp[word1.length()][word2.length()];
        }
    }
}
