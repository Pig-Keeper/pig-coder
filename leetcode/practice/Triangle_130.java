/*
 * @Created on Fri Jun 10 2022 14:50:55
 * @ProblemLink https://leetcode.com/problems/triangle/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Triangle_130 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < row; i++) {
            List<Integer> temp = new ArrayList<>(i + 1);
            for(int j = 0; j <= i; j++) {
                temp.add(sc.nextInt());
            }
            list.add(temp);
        }

        System.out.println((new Inner()).minimumTotal(list));
        sc.close();
    }

    static class Inner {
        public int minimumTotal(List<List<Integer>> list) {
            int length = list.size();
            int[] arr = new int[length];

            for(int i = 0; i < length; i++) {
                arr[i] = list.get(length - 1).get(i);
            }

            for(int i = length - 2; i >= 0; i--) {
                for(int j = 0; j <= i; j++) {
                    arr[j] = list.get(i).get(j) + Math.min(arr[j], arr[j + 1]);
                }
            }

            return arr[0];
        }
    }
}
