public class StackImplementations {
    static void main(String[] args) {
        Stack1 stack = new Stack1(10);

        stack.pop();

        for(int i=0; i<10; i++)
            stack.push(i+1);

        stack.push(11);

        for(int i=0; i<10; i++)
            System.out.println(stack.pop());

        stack.pop();
    }
}

class Stack1 {

    int top;
    int[] stack;

    public Stack1(int length) {
        top = -1;
        stack = new int[length];
    }

    public boolean isFull() {
        return top == stack.length-1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top+1;
    }

    public int push(int elem) {
        if(isFull()) {
            System.out.println("Stack1 is already full!");
            return -1;
        }

        return stack[++top] = elem;
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack1 is Empty!");
            return -1;
        }

        return stack[top--];
    }

    public int peek() {
        return stack[top];
    }
}
