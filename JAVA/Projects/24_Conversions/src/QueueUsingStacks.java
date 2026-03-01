public class QueueUsingStacks {

    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.add(5);
        q.print();

        q.add(4);
        q.print();

        q.add(3);
        q.print();

        q.remove();
        q.print();

        q.remove();
        q.print();

        q.add(10);
        q.print();
    }
}

class Queue {

    private Stack s1;
    private Stack s2;

    public Queue(int length) {
        s1 = new Stack(length);
        s2 = new Stack(length);
    }

    public void add(int elem) {

        if (s1.isFull()) {
            System.out.println("Queue is Full.");
            return;
        }

        s1.push(elem);
    }

    public int remove() {

        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return -1;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public void print() {

        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return;
        }

        System.out.print("Queue: ");

        // Print s2 elements from top to bottom
        for (int i = s2.getTop(); i >= 0; i--) {
            System.out.print(s2.getStack(i) + " ");
        }

        // Print s1 elements from bottom to top
        for (int i = 0; i <= s1.getTop(); i++) {
            System.out.print(s1.getStack(i) + " ");
        }

        System.out.println();
    }
}

class Stack {

    private int top;
    private int[] stack;

    public Stack(int length) {
        stack = new int[length];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public int size() {
        return top + 1;
    }

    public int push(int elem) {
        if (isFull()) {
            return -1;
        }
        return stack[++top] = elem;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return stack[top];
    }

    public int getTop() {
        return top;
    }

    public int getStack(int index) {
        return stack[index];
    }
}