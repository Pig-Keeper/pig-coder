/*
 * @Created on Sun Jun 05 2022 17:00:03
 * @ProblemLink https://leetcode.com/contest/weekly-contest-296/problems/partition-array-such-that-maximum-difference-is-k/
 *
 * @Author Pig Keeper
 */

package leetcode.Weekly_Contest_296;

import java.util.Arrays;
import java.util.Scanner;

public class Partition_Array_Such_That_Maximum_Difference_Is_K_2294 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();    
        }

        int k = sc.nextInt();

        System.out.println((new Inner()).partitionArray(arr, k));
        sc.close();
    }

    static class Inner {
        public int partitionArray(int[] arr, int k) {
            Arrays.sort(arr);
            
            int start = 0;
            int result = 0;
            
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] - arr[start] > k) {
                    start = i;
                    result++;
                }    
            }
            return ++result;
        }
    }
}
