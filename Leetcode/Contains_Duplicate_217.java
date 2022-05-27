/*
 * @Created on Sat May 27 2022 21:35:44 
 * @ProblemLink https://leetcode.com/problems/contains-duplicate/
 *
 * @Author Pig Keeper
 */

package Leetcode;

import java.util.HashSet;
import java.util.Scanner;

public class Contains_Duplicate_217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println((new Inner()).containsDuplicate(arr));
        sc.close();
    }

    static class Inner {
        public boolean containsDuplicate(int[] arr) {
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
}
