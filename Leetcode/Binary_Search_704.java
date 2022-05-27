/*
 * @Created on Sat May 27 2022 15:24:16
 * @ProblemLink https://leetcode.com/problems/binary-search/
 *
 * @Author Pig Keeper
 */

package leetcode;

import java.util.Scanner;

public class Binary_Search_704 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        System.out.println(( new Inner()).search(arr, target));
        
        sc.close();
    }
    
    static class Inner {    
        public int search(int[] arr, int target) {
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
}
