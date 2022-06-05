/*
 * @Created on Sun Jun 05 2022 08:14:09
 * @ProblemLink https://leetcode.com/contest/weekly-contest-296/problems/min-max-game/
 *
 * @Author Pig Keeper
 */

package leetcode.practice.Weekly_Contest_296;

import java.util.Scanner;

public class Min_Max_Game_2293 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println((new Inner()).minMaxGame(arr));
        sc.close();
    }

    static class Inner {
        public int minMaxGame(int[] arr) {
            int length = arr.length;
            
            if(length == 1) {
                return arr[0];
            }

            int[] next = new int[length/2];

            for(int i = 0; i < length/2; i++) {
                if(i % 2 == 0) {
                    next[i] = Math.min(arr[2 * i], arr[2 * i + 1]);
                } else {
                    next[i] = Math.max(arr[2 * i], arr[2 * i + 1]);
                }
            }
            return minMaxGame(next);
        }
    }
}
