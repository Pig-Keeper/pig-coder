/*
 * @Created on Wed Jun 15 2022 20:13:43
 * @ProblemCode DNASTORAGE
 * @ProblemLink https://www.codechef.com/START43D/problems/DNASTORAGE
 *
 * @Author Pig Keeper
 */

package codechef.june_starters_43_2022_div_4;

import java.util.Scanner;

public class DNA_Storage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int n = sc.nextInt();
            String str = sc.next();
            System.out.println((new Inner()).dnaStorage(n, str));
        }

        sc.close();
    }

    static class Inner {
        public String dnaStorage(int n, String str) {
            String res = "";

            for(int i = 0; i < n ; i = i + 2) {
                
                if(str.charAt(i) == '0' && str.charAt(i + 1) == '0') {
                    res += "A";
                } else if(str.charAt(i) == '0' && str.charAt(i + 1) == '1') {
                    res += "T";
                } else if(str.charAt(i) == '1' && str.charAt(i + 1) == '0') {
                    res += "C";
                } else {
                    res += "G";
                }
            }

            return res;
        }
    }
}
