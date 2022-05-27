/*
 * @Author: Pig Keeper 
 * @Date: 2022-05-26 15:49:53 
 * @Last Modified by: Pig Keeper
 * @Last Modified time: 2022-05-27 15:51:05
 */
package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.util.Map.entry;

public class Roman_to_Integer_13 {
    /**
     * values : used to store all the unique possible roman values
     */
    private String[] values = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    /**
     * hashMap : map the corresponding unique roman value and their integer values.
     */
    private HashMap<String, Integer> hashMap = new HashMap<>(Map.ofEntries(
        entry("I", 1),
        entry("IV", 4),
        entry("V", 5),
        entry("IX", 9),
        entry("X", 10),
        entry("XL", 40),
        entry("L", 50),
        entry("XC", 90),
        entry("C", 100),
        entry("CD", 400),
        entry("D", 500),
        entry("CM", 900),
        entry("M", 1000)
    ));

    public Roman_to_Integer_13() {
        Scanner sc = new Scanner(System.in);

        System.out.println(romanToInt(sc.nextLine()));

        sc.close();
    }

    private int romanToInt(String s) {
        int result = 0; 
        int valuesLength = values.length;
        int stringLength = s.length();
        int k = 0;

        // Start from input value first char and from last unique possible roman numbers
        for(int i = valuesLength - 1; i >= 0 && k < stringLength;) {
            String value = values[i];
            int valueLength = value.length();
            boolean flag = true;

            // check if the ith unique roman matches with kth string
            for(int j = 0 ; j < valueLength; j++) {
                if(s.charAt(k + j) != value.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                // when matches, add the value to result and increment the k 
                result += hashMap.get(value);
                k += valueLength;
            } else {
                // when no match, check with lesser roman literal.
                i--;
            }
        }
        return result;
    }
}
