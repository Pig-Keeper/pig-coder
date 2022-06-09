/*
 * @Created on Wed Jun 08 2022 16:04:02
 * @ProblemLink https://leetcode.com/problems/letter-case-permutation/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Letter_Case_Permutation_784 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println((new Inner()).letterCasePermutation(str));
        sc.close();
    }

    static class Inner {
        private List<String> list;
        
        public List<String> letterCasePermutation(String str) {
            list = new ArrayList<>();
            letterCasePermutation(str, 0, new StringBuilder());
            return list;
        }

        private void letterCasePermutation(String str, int start, StringBuilder stringBuilder) {
            if(stringBuilder.length() == str.length()){
                list.add(stringBuilder.toString());
                return;
            }

            stringBuilder.append((char)str.charAt(start));
            letterCasePermutation(str, start + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            if(str.charAt(start) - 'A' >= 0 && str.charAt(start) - 'Z' <= 0) {
                stringBuilder.append((char)(str.charAt(start) + 32));
                letterCasePermutation(str, start + 1, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                

            } else if(str.charAt(start) - 'a' >= 0 && str.charAt(start) - 'z' <= 0) {
                stringBuilder.append((char)(str.charAt(start) - 32));
                letterCasePermutation(str, start + 1, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            } else {
                // do nothing
            }
        }
    }
}
