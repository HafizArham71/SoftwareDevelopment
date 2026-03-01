public class QueueImplementations {
    static void main() {
        LinearQueue queue = new LinearQueue(5);

        queue.pop();

        for(int i=0; i<5; i++)
            System.out.println(queue.push(i+1));
        queue.push(6);

        for(int i=0; i<5; i++)
            System.out.println(queue.pop());

        queue.pop();
    }
}

class LinearQueue {

    private int front, back, capacity;
    private int[] queue;

    public LinearQueue(int capacity) {
        this.capacity = capacity;
        front = -1; back = -1;
        queue = new int[capacity];
    }

    public int size() {
        if(front == -1 && back == -1)
            return -1;
        return back-front+1;
    }

    public boolean isFull() {
        return size() == capacity;
    }

    public boolean isEmpty() {
        return size() == -1;
    }

    public int push(int elem) {
        if(isFull()) {
            System.out.println("Queue is already full!");
            return -1;
        }

        if(front == -1) {
            front++;
        }

        return queue[++back] = elem;
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        if(front == back) {
            int temp = back;
            front = -1; back = -1;
            return queue[temp];
        } else
            front++;

        return queue[front-1];
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return queue[back];
    }
}
