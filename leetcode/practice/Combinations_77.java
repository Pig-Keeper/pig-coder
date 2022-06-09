/*
 * @Created on Wed Jun 08 2022 14:41:56
 * @ProblemLink https://leetcode.com/problems/combinations/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combinations_77 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<List<Integer>> list = (new Inner()).combine(n, k);
        
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
        
        sc.close();
    }

    static class Inner {
        public List<List<Integer>> list;

        public List<List<Integer>> combine(int n, int k) {
            list  = new ArrayList<>();

            if(k == 0) {
                return list;
            }

            for(int i = 0 ; i <= n - k ; i++) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(i + 1);
                combine(n, k - 1, i + 1, tempList);
            }

            return list;
        }

        public void combine(int n, int k, int start, List<Integer> list) {
            if(k == 0) {
                this.list.add( new ArrayList<>(list));
            }

            for(int i = start; i < n; i++) {
                list.add(i + 1);
                combine(n, k - 1, i + 1, list);
                list.remove(Integer.valueOf(i + 1));
            }
        }
    }
}
