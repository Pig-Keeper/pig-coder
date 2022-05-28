/*
 * @Created on Sat May 28 2022 16:22:39
 * @ProblemLink https://leetcode.com/problems/merge-sorted-array/
 *
 * @Author Pig Keeper
 */
package leetcode.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Merge_Sorted_Array_88 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int size1 = sc.nextInt();
        int[] arr1 = new int[size1];
        for(int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        int size2 = sc.nextInt();
        int[] arr2 = new int[size2];
        for(int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        (new Inner()).merge(arr1, m, arr2, n);
        System.out.println(Arrays.toString(arr1));
        sc.close();
    }

    static class Inner {
        public void merge(int[] arr1, int m, int[] arr2, int n) {
            int k = m + n - 1;
            int i = m - 1, j = n - 1;
            for(; i >= 0 && j >= 0;) {
                if(arr1[i] > arr2[j]) {
                    arr1[k--] = arr1[i--];
                } else {
                    arr1[k--] = arr2[j--];
                }
            }

            while(j >= 0) {
                arr1[k--] = arr2[j--];
            }
        }
    }
}
