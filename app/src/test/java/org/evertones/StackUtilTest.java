package org.evertones;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

@Test
public class StackUtilTest {

    @Test
    public void testReverseStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);

        Stack<Integer> expected = new Stack<>();
        expected.push(10);
        expected.push(9);
        expected.push(8);
        expected.push(7);
        expected.push(6);
        expected.push(5);
        expected.push(4);
        expected.push(3);
        expected.push(2);
        expected.push(1);

        Stack<Integer> reverseStack = StackUtil.reverseOrder(stack);

        Assert.assertEquals(reverseStack, expected);
    }

    @Test
    public void testReverseStackTwice() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);

        Stack<Integer> reverseStackOnce  = StackUtil.reverseOrder(stack);
        Stack<Integer> reverseStackTwice = StackUtil.reverseOrder(reverseStackOnce);

        Assert.assertEquals(stack, reverseStackTwice);
    }

    @Test
    public void testReverseStackWithNullElements() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(null);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(null);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(null);

        Stack<Integer> expected = new Stack<>();
        expected.push(null);
        expected.push(9);
        expected.push(8);
        expected.push(7);
        expected.push(null);
        expected.push(5);
        expected.push(4);
        expected.push(3);
        expected.push(null);
        expected.push(1);

        Stack<Integer> reverseStack = StackUtil.reverseOrder(stack);

        Assert.assertEquals(reverseStack, expected);
    }

    @Test
    public void testStackUniqueElementAfterReverse() {
        Stack<Integer> stack = StackUtil.initStack(1);
        Stack<Integer> reverseStack = StackUtil.reverseOrder(stack);

        Assert.assertEquals(reverseStack.size(), 1);
    }


    @Test
    public void testStackSizeAfterReverse() {
        Stack<Integer> stack = StackUtil.initStack(10);
        Stack<Integer> reverseStack = StackUtil.reverseOrder(stack);

        Assert.assertEquals(reverseStack.size(), 10);
    }

    @Test
    public void testStackFirstAfterReverse() {
        Stack<Integer> stack = StackUtil.initStack(10);
        Integer first = stack.get(0);

        Stack<Integer> reverseStack = StackUtil.reverseOrder(stack);

        Assert.assertEquals(reverseStack.peek(), first);
    }

    @Test
    public void testStackLastAfterReverse() {
        Stack<Integer> stack = StackUtil.initStack(10);
        Integer last = stack.get(9);

        Stack<Integer> reverseStack = StackUtil.reverseOrder(stack);

        Assert.assertEquals(reverseStack.get(0), last);
    }

    @Test
    public void testStackEmptyReverse() {
        Assert.assertThrows(IllegalArgumentException.class, () -> StackUtil.reverseOrder(new Stack<>()));
    }

    @Test
    public void testStackNullReverse() {
        Assert.assertThrows(IllegalArgumentException.class, () -> StackUtil.reverseOrder(null));
    }

}
