/*
 * @Created on Thu Jun 02 2022 21:13:28
 * @ProblemCode CBSPEED
 * @ProblemLink https://www.codechef.com/submit-v2/CBSPEED
 *
 * @Author Pig Keeper
 */
package codechef.practice;

import java.util.Scanner;

public class Chef_and_Brain_Speed {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println((new Inner()).chefAndBrainSpeed(sc.nextInt(), sc.nextInt()));
        sc.close();
    }   

    static class Inner {
        public String chefAndBrainSpeed(int x, int y) {
            if(y > x) {
                return "YES";
            }
            return "NO";
        }
    }
    
}
