/*
 * @Created on Sat May 28 2022 16:07:41
 * @ProblemLink https://leetcode.com/problems/two-sum/
 *
 * @Author Pig Keeper
 */
package leetcode.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Two_Sum_1 {
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

    static class Inner {
        public int[] twoSum(int[] arr, int target) {
            int[] res = new int[2];
            int length = arr.length;
            HashMap<Integer, Integer> hashMap = new HashMap<>(length);

            for(int i = 0; i < length; i++) {
                if (hashMap.containsKey(target - arr[i])) {
                    res[0] = hashMap.get(target - arr[i]);
                    res[1] = i;
                    return res;
                } else {
                    hashMap.put(arr[i], i);
                }
            }
            return res;
        }
    }
}
