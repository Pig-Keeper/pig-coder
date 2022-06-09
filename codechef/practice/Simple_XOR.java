/*
 * @Created on Sun Jun 05 2022 20:52:13
 * @ProblemCode SIMPLE_XOR
 * @ProblemLink https://www.codechef.com/COOK142D/problems/SIMPLE_XOR
 *
 * @Author Pig Keeper
 */

package codechef.practice;

import java.util.Scanner;

public class Simple_XOR {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
    
            (new Inner()).simpleXor(l, r);
        }
        sc.close();
    }

    static class Inner {
        public void simpleXor(int l, int r) {
            // when l is even then XOR of l and l + 1 will be 1
            // and XOR of l + 2 and l + 2 will be 1 and 1 XOR 1 is zero  
            if(l % 2 == 0) {
                System.out.println(l + " " + (l + 1) + " " + (l + 2) + " " + (l + 3));
            } else {
                if(r - l > 3) {
                    // l + 1 will be even
                    System.out.println((l + 1) + " " + (l + 2) + " " + (l + 3) + " " + (l + 4));
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}
