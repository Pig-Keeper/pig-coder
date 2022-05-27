/*
 * @Author: Pig Keeper 
 * @Date: 2022-05-27 15:24:16 
 * @Last Modified by: Pig Keeper
 * @Last Modified time: 2022-05-27 15:31:30
 */
package Leetcode;

import java.util.Scanner;

public class Binary_Search_704 {
    public Binary_Search_704() {
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        System.out.println(search(arr, target));
        
        sc.close();
    }

    private int search(int[] arr, int target) {
        return search(arr, target, 0, arr.length - 1);
    }

    private int search(int[] arr, int target, int start, int end) {
        if(start > end) {
            return -1;
        }

        int midIndex = (start + end)/2;

        if(arr[midIndex] == target) {
            return midIndex;
        }

        if(arr[midIndex] > target) {
            return search(arr, target, start, midIndex - 1);
        } else {
            return search(arr, target, midIndex + 1, end);
        }
    }
}
