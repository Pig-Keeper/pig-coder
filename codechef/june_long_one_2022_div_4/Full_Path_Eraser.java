/*
 * @Created on Sat Jun 11 2022 08:46:35
 * @ProblemCode FPE
 * @ProblemLink https://www.codechef.com/JUNE221D/problems/FPE
 *
 * @Author Pig Keeper
 */

package codechef.june_long_one_2022_div_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.StringTokenizer;

public class Full_Path_Eraser {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int testcases = fr.nextInt();

        while(testcases-- > 0) {
            int n = fr.nextInt();
            List<List<Integer>> list = new ArrayList<>(n);

            for(int i = 0; i < n; i++) {
                list.add(new ArrayList<Integer>());
            }

            long[] arr = new long[n];
            
            for(int i = 0; i < n; i++) {
                arr[i] = fr.nextLong();
            }

            for(int i = 0; i < n - 1; i++) {
                int u = fr.nextInt();
                int v = fr.nextInt();

                list.get(u - 1).add(v - 1);
                list.get(v - 1).add(u - 1);
            }

            System.out.println((new Inner()).fullPathEraser(list, arr, n));
        }
    }

    static class Inner {
        public long fullPathEraser(List<List<Integer>> list, long[] arr, int n) {
            long[][] info = new long[n][5];

            for(int i = 0; i < n; i++) {
                Arrays.fill(info[i], 0);
            }

            fullPathEraser(list, info, arr, n, 0);

            // System.out.println(Arrays.deepToString(info));
            return info[0][1];
        }

        public void fullPathEraser(List<List<Integer>> list, long[][] info, long[] arr, int n, int index) {
            List<Integer> children = list.get(index);
            int size = children.size();

            info[index][4] = 1;

            boolean visitedAllchild = true;

            for(int i = 0; i < size; i++) {
                if(info[children.get(i)][4] == 0) {
                    visitedAllchild = false;
                    break;
                }
            }

            if(size == 0 || visitedAllchild) {
                // index is a leaf node
                // gcd when index is not removed
                info[index][0] = arr[index];
                 // gcd when index is removed, not possible for leaf node
                info[index][1] = 0;
                // child removed to achieve max gcd
                info[index][2] = -1;
                // has child
                info[index][3] = -1;
                return;
            }

            // contains child
            info[index][3] = 1;

            for(int i = 0; i < size; i++) {
                int child = children.get(i);
                if(info[child][4] != 1) {
                    fullPathEraser(list, info, arr, n, child);
                }
            }
            
            // case when index is not removed
            info[index][0] = arr[index];
            for(int i = 0; i < size; i++) {
                info[index][0] = gcd(info[index][0], info[children.get(i)][0]);
                if(info[index][0] == 1) {
                    break;
                }
            }

            // case when index is removed
            // which child to remove
            int childToRemove = -1;
            info[index][1] = 0;

            for(int i = 0; i < size; i++) {
                int childI = children.get(i);
                if(info[childI][3] == 1) {
                    if(childToRemove == -1 && info[childI][1] > info[childI][0]) {
                        childToRemove = childI;
                    } else if(childToRemove != -1 && info[childI][1] + info[childToRemove][0] > info[childToRemove][1] + info[childI][0]) {
                        childToRemove = childI;
                    }
                }
                info[index][1] += info[childI][0];
            }
            
            if(childToRemove != -1) {
                info[index][1] += (info[childToRemove][1] - info[childToRemove][0]);
                info[index][2] = childToRemove;
            } else {
                // when no child is removed
                info[index][2] = -1;
            }
        }

        private long gcd(long a, long b) {
            if(b == 0) {
                return a;
            }

            if(a == 0) {
                return b;
            }

            if(a < b) {
                return gcd(b, a);
            }
            return gcd(b, a%b);
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
