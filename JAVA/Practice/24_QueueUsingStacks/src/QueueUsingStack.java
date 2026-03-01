public class QueueUsingStack {

    static int front;
    static int back;

    static int[] stack1;
    static int[] stack2;

    static void main() {
        stack1(10);
        stack2(10);

        push(10);
        print(stack1);
        push(20);
        print(stack1);
        push(30);
        print(stack1);
        push(40);
        pop();
        print(stack2);
        pop();
        print(stack2);
    }

    static void stack1(int capacity) {
        stack1 = new int[capacity];
        back = -1;
    }

    static void stack2(int capacity) {
        stack2 = new int[capacity];
        front = -1;
    }

    static int push(int elem) {
        back++;

        if (back<stack1.length) {
            stack1[back] = elem;
        } else System.out.println("Array is full");

        if(front == -1) front++;

        return elem;
    }

    static int pop() {

        if(front < back) {
            for (int i = ++front; i <= back; i++)
                stack2[i] = stack1[i];
        }
        else if(front == -1) System.out.println("Nothing to pop");
        else System.out.println("Array is full");

        return stack2[front-1];
    }

    static void print(int[] stack) {
        for(int i=front; i<=back; i++)
            System.out.print(stack[i] + ", ");

        System.out.println();
    }
}
