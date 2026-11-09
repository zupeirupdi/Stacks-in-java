import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> {
    private final static int DEFAULT_CAPACITY = 2; // constant
    private int top;   // next free slot = number of elements
    private T[] stack;

    public ArrayStack() {                    // empty stack, default capacity
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity) { // empty stack, given capacity
        top = 0;
        stack = (T[]) (new Object[initialCapacity]); // generic array trick
    }

    public void push(T element) {
        if (size() == stack.length)
            expandCapacity();                // full? double the array
        stack[top] = element;
        top++;
    }

    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    public T pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException(); // underflow
        top--;
        T result = stack[top];
        stack[top] = null;
        return result;
    }

    public T peek() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        return stack[top - 1];               // look only, do not remove
    }

    public int size() { return top; }
    public boolean isEmpty() { return top == 0; }
    public int capacity() { return stack.length; } // added for the trace
}
