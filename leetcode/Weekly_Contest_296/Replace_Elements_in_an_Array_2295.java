/*
 * @Created on Sun Jun 05 2022 17:05:05
 * @ProblemLink https://leetcode.com/contest/weekly-contest-296/problems/replace-elements-in-an-array/
 *
 * @Author Pig Keeper
 */

package leetcode.Weekly_Contest_296;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Replace_Elements_in_an_Array_2295 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();    
        }

        int operationsSize = sc.nextInt();
        int[][] operations = new int[operationsSize][2];

        for(int i = 0; i < operationsSize; i++) {
            operations[i][0] = sc.nextInt(); 
            operations[i][1] = sc.nextInt();   
        }

        System.out.println(Arrays.toString((new Inner()).arrayChange(arr, operations)));
        sc.close();
    }

    static class Inner {
        public int[] arrayChange(int[] arr, int[][] operations) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            
            for(int i = 0; i < arr.length; i++) {
                hashMap.put(arr[i], i);
            }
            
            for(int i = 0; i < operations.length; i++) {
                hashMap.put(operations[i][1], hashMap.get(operations[i][0]));
                arr[hashMap.get(operations[i][0])] = operations[i][1];
                hashMap.remove(operations[i][0]);
                
            }
            
            return arr;
        }
    }
}
