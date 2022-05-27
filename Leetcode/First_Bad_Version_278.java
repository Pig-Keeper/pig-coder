/*
 * @Author: Pig Keeper 
 * @Date: 2022-05-27 15:36:31 
 * @Last Modified by: Pig Keeper
 * @Last Modified time: 2022-05-27 16:44:36
 */
package Leetcode;

import java.util.Scanner;

public class First_Bad_Version_278 {
    private int badVersion;

    public First_Bad_Version_278() {
        Scanner sc = new Scanner(System.in);
        System.out.println(firstBadVersion(sc.nextInt()));
        sc.close();
    }

    /**
     * This method is implemented in question.
     * I have added here for the sake of testing
     * @param version
     */
    private boolean isBadVersion(int version) {
        return version >= this.badVersion;
    }

    private int firstBadVersion(int versions) {
        this.badVersion = 1702766719; //(int) (Math.random() * versions);
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
