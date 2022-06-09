/*
 * @Created on Wed Jun 08 2022 16:37:04
 * @ProblemLink https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * @Author Pig Keeper
 */

package leetcode.practice;

import java.util.Scanner;
import java.util.Stack;

public class Implement_Queue_using_Stacks_232 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyQueue queue = new MyQueue();

        while(true) {
            String operation = sc.next();
            if(operation.trim().equals("push")) {
                queue.push(sc.nextInt());
            } else if(operation.trim().equals("pop")) {
                System.out.println(queue.pop());
            } else if(operation.trim().equals("peek")) {
                System.out.println(queue.peek());
            } else if(operation.trim().equals("empty")) {
                System.out.println(queue.empty());
            } else if(operation.trim().equals("exit")) {
                break;
            } else {
                System.out.println("The provided operation '" + operation + "' is invalid for queue");
            }
        }

        sc.close();
    }

    static class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }
        
        public void push(int x) {
            stack1.push(x);
        }
        
        public int pop() {
            if(stack2.empty()) {
                while(!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
        
        public int peek() {
            if(stack2.empty()) {
                while(!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }
        
        public boolean empty() {
            return stack1.empty() && stack2.empty();
        }  
    }
}
