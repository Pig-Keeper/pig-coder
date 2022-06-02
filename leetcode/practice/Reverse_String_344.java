/*
 * @Created on Thu Jun 02 2022 20:24:37
 * @ProblemLink https://leetcode.com/problems/reverse-string/
 *
 * @Author Pig Keeper
 */
package leetcode.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Reverse_String_344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();

        (new Inner()).reverseString(arr);

        System.out.println(Arrays.toString(arr));
        sc.close();
    }
    
    static class Inner {
        public void reverseString(char[] s) {
            int length = s.length;

            for(int i = 0; i < length/2; i++) {
                char temp = s[i];
                s[i] = s[length - i - 1];
                s[length - i - 1] = temp;
            }
        }
    }
}
