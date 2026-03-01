public class Testing {

    static int capacity = 5;
    static int[] stack1 = new int[capacity];
    static int[] stack2 = new int[capacity];

    static int top1 = -1;
    static int top2 = -1;

    public static void main(String[] args) {
        enqueue(10);
        enqueue(20);
        enqueue(30);

        System.out.println(dequeue()); // 10
        System.out.println(dequeue()); // 20

        enqueue(40);

        System.out.println(dequeue()); // 30
        System.out.println(dequeue()); // 40
    }

    static void enqueue(int value) {
        if (top1 == capacity - 1) {
            System.out.println("Queue Overflow");
            return;
        }
        stack1[++top1] = value;
    }

    static int dequeue() {

        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        if (top2 == -1) {
            while (top1 != -1) {
                stack2[++top2] = stack1[top1--];
            }
        }

        return stack2[top2--];
    }

    static boolean isEmpty() {
        return top1 == -1 && top2 == -1;
    }
}