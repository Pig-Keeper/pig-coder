/*
 * @Created on Thu Jun 02 2022 20:37:37
 * @ProblemLink https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *
 * @Author Pig Keeper
 */
package leetcode.practice;

import java.util.Scanner;

public class Reverse_Words_in_a_String_III_557 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println((new Inner()).reverseWords(str));

        sc.close();
    }

    static class Inner {
        public String reverseWords(String str) {
            char[] charArr = str.toCharArray();

            int length = charArr.length;
            int start, end;

            for(int i = 0; i < length;) {
                while(i < length && charArr[i] == ' ') {
                    i++;
                }

                start = i;

                while(i < length && charArr[i] != ' ') {
                    i++;
                }

                end = i - 1;

                while(start < end) {
                    char temp = charArr[start];
                    charArr[start++] = charArr[end];
                    charArr[end--] = temp;
                }
            }

            return String.valueOf(charArr);
        }
    }
}
