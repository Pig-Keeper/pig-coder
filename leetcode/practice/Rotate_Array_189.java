/*
 * @Created on Sat May 28 2022 17:21:02
 * @ProblemLink https://leetcode.com/problems/rotate-array/
 *
 * @Author Pig Keeper
 */
package leetcode.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Rotate_Array_189 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int  k = sc.nextInt();

        (new Inner()).rotate(arr, k);
        System.out.println(Arrays.toString(arr));

        sc.close();
    }

    static class Inner {
        public void rotate(int[] arr, int k) {
            int length = arr.length;
            k = k % length;

            int hcf = hcf(length, k);

            for(int i = 0; i < hcf; i++) {
                int temp = arr[i];
                int j = (i + k) % length;

                while(j != i) {
                    int swap = temp;
                    temp = arr[j];
                    arr[j] = swap;
                    j = (j + k) % length;
                }
                
                arr[i] = temp;
            }
        }

        private int hcf(int a, int b) {
            return b == 0 ? a : hcf(b, a % b);
        }
    }
}
