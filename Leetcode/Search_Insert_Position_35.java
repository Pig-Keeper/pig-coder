package Leetcode;

import java.util.Scanner;

public class Search_Insert_Position_35 {
    public Search_Insert_Position_35() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size]; 

        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        
        System.out.println(searchInsert(arr, target));
        sc.close();
    }

    private int searchInsert(int[] arr, int target) {
        return searchInsert(arr, target, 0, arr.length - 1);
    }

    private int searchInsert(int[] arr, int target, int start, int end) {
        if(start > end) {
            return -1;
        }

        int mid = (start + end)/2;

        if(arr[mid] == target) {
            return mid;
        }

        if(arr[mid] > target && (mid == 0 || arr[mid - 1] < target)) {
            return mid;
        }

        if(arr[mid] < target && (mid == arr.length - 1 || arr[mid + 1] > target)) {
            return mid + 1;
        }

        if(arr[mid] > target) {
            return searchInsert(arr, target, start, mid - 1);
        } else {
            return searchInsert(arr, target, mid + 1, end);
        }
    }
}
