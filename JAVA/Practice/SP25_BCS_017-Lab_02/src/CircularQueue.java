public class CircularQueue {

    // Attributes
    private int[] deque;
    private int front, rear, size, capacity;

    // Methods
    public boolean isFull() {
        return size == capacity;
    }
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }
    public void insertFront(int vehicleNumber) {
        if(isFull()) {
            System.out.println("Parking lot is already full.");
        } else


    }
}
