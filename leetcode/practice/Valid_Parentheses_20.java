/*
 * @Created on Wed Jun 08 2022 16:24:43
 * @ProblemLink `Enter Problem Link here`
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;
import java.util.Stack;

public class Valid_Parentheses_20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println((new Inner()).isValid(str));

        sc.close();
    }

    static class Inner {
        public boolean isValid(String str) {
            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                    stack.push(str.charAt(i));
                } else if(!stack.empty() && ((str.charAt(i) == ')' && stack.peek() == '(') || 
                    (str.charAt(i) == '}' && stack.peek() == '{') || 
                        (str.charAt(i) == ']' && stack.peek() == '['))) {
                            stack.pop();
                    continue;
                } else {
                    return false;
                }
            }

            return stack.isEmpty() ? true : false;
        }
    }
}
