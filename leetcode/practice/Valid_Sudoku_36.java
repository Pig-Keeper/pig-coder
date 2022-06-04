/*
 * @Created on Sat Jun 04 2022 15:07:55
 * @ProblemLink https://leetcode.com/problems/valid-sudoku/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.HashSet;
import java.util.Scanner;

public class Valid_Sudoku_36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] arr = new char[9][9];

        for(int i = 0; i < 9; i++) {
            arr[i] = sc.next().toCharArray();
        }

        System.out.println((new Inner()).isValidSudoku(arr));

        sc.close();
    }

    static class Inner {
        public boolean isValidSudoku(char[][] arr) {
            return isValidSuokuRows(arr) && isValidSuokuColumns(arr) && isValidSuokuBlocks(arr);
        }

        private boolean isValidSuokuRows(char[][] arr) {
            for(int i = 0; i < 9; i++) {
                HashSet<Character> hashSet = new HashSet<>();
                for(int j = 0; j < 9; j++) {
                    if(hashSet.contains(arr[i][j])) {
                        return false;
                    } else if(arr[i][j] != '.') {
                        hashSet.add(arr[i][j]);
                    }
                }
            }
            return true;
        }
        
        private boolean isValidSuokuColumns(char[][] arr) {
            for(int i = 0; i < 9; i++) {
                HashSet<Character> hashSet = new HashSet<>();
                for(int j = 0; j < 9; j++) {
                    if(hashSet.contains(arr[j][i])) {
                        return false;
                    } else if(arr[j][i] != '.'){
                        hashSet.add(arr[j][i]);
                    }
                }
            }
            return true;
        }
        
        private boolean isValidSuokuBlocks(char[][] arr) {
            for(int i = 0; i < 9; i = i + 3) {
                for(int j = 0; j < 9; j = j + 3) {
                    HashSet<Character> hashSet = new HashSet<>();
                    for(int k = i; k <= i + 2; k++) {
                        for(int l = j; l <= j + 2; l++) {
                            if(hashSet.contains(arr[k][l])) {
                                return false;
                            } else if(arr[k][l] != '.'){
                                hashSet.add(arr[k][l]);
                            }
                        }
                    }
                }
            }
            return true;
        } 
    }
}
