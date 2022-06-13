/*
 * @Created on Sat Jun 11 2022 01:45:59
 * @ProblemCode RED0
 * @ProblemLink https://www.codechef.com/JUNE221D/problems/RED0
 *
 * @Author Pig Keeper
 */

package codechef.june_long_one_2022_div_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reduce_to_zero {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        long testcases = fr.nextLong();

        while(testcases-- > 0) {
            long x = fr.nextLong();
            long y = fr.nextLong();

            if(x < y) {
                System.out.println((new Inner()).reduceToZero(y, x));
            } else {
                System.out.println((new Inner()).reduceToZero(x, y));
            }
        }
    }

    
    static class Inner {
        public long reduceToZero(long x, long y) {
            if(x == 0 && y == 0) {
                return 0;
            }

            if(x == 0 || y == 0) {
                return -1;
            }

            long count = (long)((Math.log(x)/Math.log(2)) - (Math.log(y)/Math.log(2)));
            long temp = count;

            while(temp-- > 0) {
                y = y << 1;
            }

            return x == y ? count + x : count + 1 + x;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
  
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
  
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
  
        int nextInt() { return Integer.parseInt(next()); }
  
        long nextLong() { return Long.parseLong(next()); }
  
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
  
        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
