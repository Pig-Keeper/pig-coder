/*
 * @Created on Wed Jun 08 2022 15:37:44
 * @ProblemLink https://leetcode.com/problems/permutations/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Permutations_46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];
        
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println((new Inner()).permute(arr));
        
        sc.close();
    }

    static class Inner {
        List<List<Integer>> list;
        public List<List<Integer>> permute(int[] arr) {
            list = new ArrayList<>();
            permute(arr, new LinkedHashSet<Integer>());
            return list;

        }

        public void permute(int[] arr, Set<Integer> set) {
            if(set.size() == arr.length) {
                list.add(new ArrayList<>(set));
            }

            for(int i = 0; i < arr.length; i++) {
                if(set.contains(arr[i])) {
                    continue;
                } else {
                    set.add(arr[i]);
                    permute(arr, set);
                    set.remove(arr[i]);
                }
            }
        }
    }
}
