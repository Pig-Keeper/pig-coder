/*
 * @Author: Pig Keeper 
 * @Date: 2022-05-27 21:35:44 
 * @Last Modified by: Pig Keeper
 * @Last Modified time: 2022-05-27 21:41:50
 */
package Leetcode;

import java.util.HashSet;
import java.util.Scanner;

public class Contains_Duplicate_217 {
    public Contains_Duplicate_217() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(containsDuplicate(arr));
        sc.close();
    }

    private boolean containsDuplicate(int[] arr) {
        int size = arr.length;
        
        HashSet<Integer> hashSet = new HashSet<>(size);

        for(int i = 0; i < size; i++) {
            if(hashSet.contains(arr[i])) {
                return true;
            } else {
                hashSet.add(arr[i]);
            }
        }
        return false;
    }   
}
