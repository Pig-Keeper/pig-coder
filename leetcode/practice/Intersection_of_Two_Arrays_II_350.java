/*
 * @Created on Thu Jun 02 2022 14:38:15
 * @ProblemLink https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * @Author Pig Keeper
 */
package leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class Intersection_of_Two_Arrays_II_350 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length1 = sc.nextInt();
        int[] arr1 = new int[length1];
        for(int i = 0; i < length1; i++) {
            arr1[i] = sc.nextInt();
        }

        int length2 = sc.nextInt();
        int[] arr2 = new int[length2];
        for(int i = 0; i < length2; i++) {
            arr2[i] = sc.nextInt();
        }
        
        System.out.println(Arrays.toString((new Inner()).intersect(arr1, arr2)));
        sc.close();
    }

    static class Inner{
        private class ValueCount {
            private int valueCountFirst;
            private int valueCountSecond;
    
            public ValueCount() {
                valueCountFirst = 0;
                valueCountSecond = 0;
            }
    
            public void incrementFirst() {
                valueCountFirst++;
            }
    
            public void incrementSecond() {
                valueCountSecond++;
            }
    
            public int getFirst() {
                return valueCountFirst;
            }
    
            public int getSecond() {
                return valueCountSecond;
            }
        }

        public int[] intersect(int[] arr1, int[] arr2) {
            int length1 = arr1.length;
            int length2 = arr2.length;
            ArrayList<Integer> arrayList = new ArrayList<>();

            HashMap<Integer, ValueCount> hashMap = new HashMap<>(length1 > length2 ? length1 : length2);

            for(int i = 0; i < length1; i++) {
                ValueCount valueCount;
                if(hashMap.containsKey(arr1[i])) {
                    valueCount = hashMap.get(arr1[i]);
                } else {
                    valueCount = new ValueCount();
                }
                valueCount.incrementFirst();
                hashMap.put(arr1[i], valueCount);
            }

            for(int i = 0; i < length2; i++) {
                if(hashMap.containsKey(arr2[i])) {
                    ValueCount valueCount = hashMap.get(arr2[i]);
                    valueCount.incrementSecond();
                    hashMap.put(arr2[i], valueCount);
                }
            }

            for(Entry<Integer, ValueCount> entry: hashMap.entrySet()) {
                ValueCount valueCount = entry.getValue();
                int minCount = valueCount.getFirst() > valueCount.getSecond() ? valueCount.getSecond() : valueCount.getFirst();
                for(int i = 0; i < minCount; i++) {
                    arrayList.add(entry.getKey());
                }
            }

            return arrayList.stream().mapToInt((num) -> num.intValue()).toArray();
        }
    }
}
