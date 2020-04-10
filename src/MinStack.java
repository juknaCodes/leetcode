import java.util.Stack;

class MinStack {

    long min;
    Stack<Long> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack();
    }

    public void push(int x) {
        if (minStack.isEmpty()) {
            min = x;
            minStack.push((long) x);
            return;
        }

        if (x > min) {
            minStack.push((long) x);
        } else {
            long product = 2*(long)x;
            minStack.push(product - min);
            min = x;
        }
    }

    public void pop() {
        if (minStack.isEmpty())
            return;

        if(minStack.peek() < min) {
            long top = minStack.pop();
            long product = 2*min;
            min = product - top;
        } else {
            minStack.pop();
        }

    }

    public int top() {

        if (!minStack.isEmpty()) {
            if(minStack.peek() < min) {
                return (int)min;
            } else {
                return minStack.peek().intValue();
            }
        }
        return -1;
    }

    public int getMin() {
        if (!minStack.isEmpty())
            return (int) min;

        return -1;
    }
}
