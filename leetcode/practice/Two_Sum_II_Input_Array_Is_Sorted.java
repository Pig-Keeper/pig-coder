/*
 * @Created on Thu Jun 02 2022 20:13:57
 * @ProblemLink https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @Author Pig Keeper
 */
package leetcode.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Two_Sum_II_Input_Array_Is_Sorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(Arrays.toString((new Inner()).twoSum(arr, target)));
        sc.close();
    }

    static class Inner{
        public int[] twoSum(int[] arr, int target) {
            int[] res = new int[2];
            int length = arr.length;
            int j = length - 1;
            int i = 0;
            while(i < j) {
                if(arr[i] + arr[j] == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    break;
                } else if(arr[i] + arr[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
            return res;
        }
    }
}
