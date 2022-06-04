/*
 * @Created on Sat Jun 04 2022 01:22:30
 * @ProblemLink https://leetcode.com/problems/permutation-in-string/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Permutation_in_String_567 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println((new Inner()).checkInclusion(sc.nextLine(), sc.nextLine()));
        sc.close();
    }

    static class Inner {
        /**
         * Not optimal solution for the problem, still a different approach
         * the solution given here https://leetcode.com/problems/permutation-in-string/solution/
         * Please refer to above link for good optimised solution
         */
        public boolean checkInclusion(String str1, String str2) {
            int length1 = str1.length();
            int length2 = str2.length();
            int[] arr = new int[26];

            if(length1 <= length2) {
                Arrays.fill(arr, 0);

                for(int i = 0; i < length1; i++) {
                    arr[str1.charAt(i) - 'a']++;
                }

                Queue<Character> queue = new LinkedList<>();

                for(int i = 0; i < length2; i++) {
                    int index = str2.charAt(i) - 'a';

                    if(arr[index] == 0) {
                        while(!queue.isEmpty()) {
                            arr[queue.peek() - 'a']++;
                            if(queue.poll() == str2.charAt(i)) {
                                break;   
                            }
                        }
                    }
                    
                    if(arr[index] > 0) {
                        arr[index]--;
                        queue.add(str2.charAt(i));
                    }

                    if(isAllZeros(arr)){
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean isAllZeros(int[] arr) {
            int length = arr.length;
                    
            for(int j = 0; j < length; j++) {
                if(arr[j] != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
