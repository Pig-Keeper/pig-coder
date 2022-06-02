/*
 * @Created on Thu Jun 02 2022 19:32:46
 * @ProblemLink https://leetcode.com/problems/pascals-triangle/
 *
 * @Author Pig Keeper
 */
package leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pascals_Triangle_118 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println((new Inner()).generate(sc.nextInt()));
        sc.close();
    }

    static class Inner {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            
            for(int i = 0 ; i < numRows; i++) {
                List<Integer> tempRes = new ArrayList<>();
                for(int j = 0; j <= i; j++) {

                    if(i == j || j == 0) {
                        tempRes.add(1);
                    } else {
                        tempRes.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                    }
                }
                result.add(tempRes);
            }
            
            return result;
        }
    }
}
