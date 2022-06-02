/*
 * @Created on Thu Jun 02 2022 19:51:28
 * @ProblemLink https://leetcode.com/problems/move-zeroes/
 *
 * @Author Pig Keeper
 */
package leetcode.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Move_Zeroes_283 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        (new Inner()).moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
        
        sc.close();
    }

    static class Inner {
        public void moveZeroes(int[] arr) {
            int zeroIndex = -1;
            int length = arr.length;

            for(int i = 0; i < length; i++) {
                if(arr[i] == 0 && zeroIndex == -1) {
                    zeroIndex = i;
                } else if(arr[i] != 0 && zeroIndex != -1) {
                    arr[zeroIndex] = arr[i];
                    arr[i] = 0;
                    zeroIndex++;
                }
            }
        }
    }
}
