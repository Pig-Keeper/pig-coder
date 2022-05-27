/*
 * @Created on Sat May 28 2022 03:26:34
 * @ProblemLink https://leetcode.com/problems/first-bad-version/
 *
 * @Author Pig Keeper
 */

package leetcode;

import java.util.Scanner;

public class First_Bad_Version_278 {
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        System.out.println((new Inner()).firstBadVersion(sc.nextInt()));
        sc.close();
    }

    static class Inner {
        private int badVersion;
        /**
         * This method is implemented in question.
         * I have added here for the sake of testing
         * @param version
         */
        private boolean isBadVersion(int version) {
            return version >= this.badVersion;
        }

        public int firstBadVersion(int versions) {
            this.badVersion = (int) ((Math.random() * (versions - 1)) + 1);
            System.out.println("bad version : " + this.badVersion + " : versions : " + versions);
            return firstBadVersion(1, versions, versions);
        }

        private int firstBadVersion(int start, int end, int versions) {
            if(start > end) {
                return -1;
            }
            
            int mid = (int)(((long)start)/2 + ((long)end)/2);
            
            /**
             * Better approach to find mid:
             * int mid = start + (end - start)/2;
             */

            if(isBadVersion(mid)) {
                if(mid == 1 || !isBadVersion(mid - 1)) {
                    /**
                     * If mid is badversion and the version before it is a good version 
                     * then mid is the first bad version.
                     */
                    return mid;
                } else {
                    /**
                     * If mid is badversion and the version before it is also a bad version 
                     * then the first bad version exists somewhere b/w start and mid - 1;
                     */
                    return firstBadVersion(start, mid -1, versions);
                }
            } else {
                if(mid != versions && isBadVersion(mid + 1)) {
                    /**
                     * If mid is good version and the version after it, is a bad version 
                     * then mid + 1 is the first bad version.
                     */
                    return mid + 1;
                } else {
                    /**
                     * If mid is good version and the version after it, is also a good version 
                     * then the first bad version exist somewhere b/w mid + 1 and end
                     */
                    return firstBadVersion(mid + 1, end, versions);
                }
            }
        }
    }
}
