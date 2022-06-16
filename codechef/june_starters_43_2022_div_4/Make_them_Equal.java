/*
 * @Created on Wed Jun 15 2022 21:40:12
 * @ProblemCode MAKEQUAL
 * @ProblemLink https://www.codechef.com/START43D/problems/MAKEQUAL
 *
 * @Author Pig Keeper
 */

package codechef.june_starters_43_2022_div_4;

import java.util.Scanner;

public class Make_them_Equal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            System.out.println((new Inner()).makeThemEqual(a, b, c));
        }

        sc.close();
    }

    static class Inner {
        public String makeThemEqual(int a, int b, int c) {
            int i = 1;
            int twos = 1;

            while(true) {
                if(a == b && b == c) {
                    return "YES";
                }

                char[] binA = Integer.toBinaryString(a).toCharArray();
                char[] binB = Integer.toBinaryString(b).toCharArray();
                char[] binC = Integer.toBinaryString(c).toCharArray();
    
                int lengthA = binA.length;
                int lengthB = binB.length;
                int lengthC = binC.length;

                if((i > lengthA && i > lengthB) || (i > lengthA && i > lengthC) || (i > lengthB && i > lengthC)) {
                    return "NO";
                }

                char cA = i <= lengthA ? binA[lengthA - i] : '0';
                char cB = i <= lengthB ? binB[lengthB - i] : '0';
                char cC = i <= lengthC ? binC[lengthC - i] : '0';

                if(cA == cB && cA != cC ) {
                    c += twos;
                } else if(cA == cC && cA != cB) {
                    b += twos;
                } else if(cB == cC && cB != cA) {
                    a += twos;
                } else {
                    return "NO";
                }

                i++;
                twos *= 2;
            }
        }
    }
}
