public class StackConcepts {

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.pop();
        stack.print();
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.print();

    }


}

class Stack {
        private int[] stack;
        private int top;

        public Stack(int length) {
            stack = new int[length];
            top = -1;
        }

        public int peek() {
        if(!isEmpty())
            return stack[top];
        else {
            System.out.println("Stack is Empty");
            return -1;
        }
    }
        public int size() { return top+1; }
        public boolean isEmpty() { return top == -1; }
        public boolean isFull() { return top == stack.length-1; }
        public int push(int elem) {
        if(!isFull())
            return stack[++top] = elem;
        else {
            System.out.println("Overflow");
            return -1;
        }
    }
        public int pop() {
        if(!isEmpty()) {
            return stack[top--];
        } else {
            System.out.println("Underflow");
            return -1;
        }
    }
        public void print() {
        if(!isEmpty())
            for(int i=top; i>=0; i--)
                System.out.print(stack[i]);
        else
            System.out.println("Stack is empty");
    }

    }
