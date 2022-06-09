/*
 * @Created on Sun Jun 05 2022 20:52:13
 * @ProblemCode SIMPLE_XOR
 * @ProblemLink https://www.codechef.com/COOK142D/problems/SIMPLE_XOR
 *
 * @Author Pig Keeper
 */

package codechef.june_cook_off_2022_div_4;

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

    static class Inner{
        // Approach -> Wrong
        // Somehow submission was successful
        public void simpleXor(int l, int r) {
            if(!binarySearch(l ,r)) {
                System.out.println(-1);
            }
            

        }

        public boolean binarySearch(int l, int r) {
            if(l + 3 == r) {
                if((l^(l+1)^(l+2)^(l+3)) == 0) {
                    System.out.println(l + " " + (l + 1) + " " + (l+2) + " " + r);
                    return true;
                } else {
                    return false;
                }
            }

            if(l + 3 > r) {
                return false;
            }

            int mid = l + ((r - l)/2);
            return binarySearch(l, mid, r) || binarySearch(l + 1, r) || binarySearch(l, r - 1);
        }

        public boolean binarySearch(int l, int mid, int r) {
            if(l + 3 == r) {
                if((l^(l+1)^(l+2)^(l+3)) == 0) {
                    System.out.println(l + " " + (l + 1) + " " + (l+2) + " " + r);
                    return true;
                } else {
                    return false;
                }
            }

            if(l + 3 > r) {
                return false;
            }

            if(mid > l && mid < r) {
                int fourth = l^r^mid;
                if(fourth > l && fourth < r && fourth != mid) {
                    System.out.println(l + " " + mid + " " + r + " " + fourth);
                    return true;
                }

                return binarySearch(l, (l + ((mid - l)/2)), mid) || binarySearch(mid, (mid + ((r - mid)/2)), r);
            }
            return false;
        }

    }
}
