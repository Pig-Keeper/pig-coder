/*
 * @Created on Sun Jun 05 2022 20:15:50
 * @ProblemCode https://www.codechef.com/COOK142D/problems/SONGS
 * @ProblemLink SONGS
 *
 * @Author Pig Keeper
 */

package codechef.june_cook_off_2022_div_4;

import java.util.Scanner;

public class Playlist {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while(testcases-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
    
            System.out.println((new Inner()).playlist(x, y));
        }
        sc.close();
    }

    static class Inner{
        public int playlist(int x, int y) {
            return x / (3 * y);
        }
    }
}
