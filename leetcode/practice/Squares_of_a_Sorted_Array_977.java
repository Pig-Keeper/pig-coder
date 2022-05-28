/*
 * @Created on Sat May 28 2022 16:43:52
 * @ProblemLink https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * @Author Pig Keeper
 */

 package leetcode.practice;

import java.util.Arrays;
import java.util.Scanner;

 public class Squares_of_a_Sorted_Array_977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
    
        System.out.println(Arrays.toString((new Inner()).sortedSquares(arr)));
        sc.close();
    }

    static class Inner {
        public int[] sortedSquares(int[] arr) {
            int length = arr.length;
            int[] res = new int[length];
            int k = length - 1;

            for(int i = 0; i < length; i++) {
                arr[i] *= arr[i];
            }

            for(int i = 0, j = length - 1; i <= j;) {
                if(arr[i] > arr[j]) {
                    res[k--] = arr[i++];
                } else {
                    res[k--] = arr[j--];
                }
            }
            return res;
        }
    }
 }
