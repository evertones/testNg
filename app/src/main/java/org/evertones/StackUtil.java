package org.evertones;

import java.util.Random;
import java.util.Stack;

public class StackUtil {

    public static Stack<Integer> reverseOrder(Stack<Integer> stack) {
        if (stack == null || stack.empty()) {
            throw new IllegalArgumentException("THe stack to be reversed is empty.");
        }

        Stack<Integer> originalStack = (Stack<Integer>) stack.clone();
        Stack<Integer> newStack = new Stack<>();
        while (!originalStack.empty()) {
            newStack.push(originalStack.pop());
        }

        return newStack;
    }

    public static Stack<Integer> initStack(int size) {
        Stack<Integer> stack = new Stack<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            stack.push(random.nextInt());
        }

        return stack;
    }

}
