public class CircularDeque {

    // Attributes
    private int[] deque;
    private int front, rear, size, capacity, totalEntered, totalRemoved;

    // Constructor
    public CircularDeque(int capacity) {
        deque = new int[capacity];
        front = rear = -1;
        this.capacity = capacity;
    }

    // Methods
    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isEqual() {
        return front == rear;
    }

    public void insertFront(int vehicleNumber) {
        if (isFull()) {
            System.out.printf("Parking lot is already full. The vehichle [%04d] cannot enter.\n", vehicleNumber);
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else
            front = (front - 1 + capacity) % capacity;
        deque[front] = vehicleNumber;
        size++;
        totalEntered++;
        System.out.printf("The vehicle [%04d] has successfully entered in the parking lot\n", vehicleNumber);
    }

    public void insertRear(int vehicleNumber) {
        if (isFull()) {
            System.out.printf("Parking lot is already full. The vehichle [%04d] cannot enter.\n", vehicleNumber);
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else
            rear = (rear + 1) % capacity;
        deque[rear] = vehicleNumber;
        size++;
        totalEntered++;
        System.out.printf("The vehicle [%04d] has successfully entered in the parking lot\n", vehicleNumber);
    }

    public void delFront() {
        if (isEmpty()) {
            System.out.println("Parking lot is already empty. Nothing to remove.");
            return;
        }
        int temp = deque[front];
        if (isEqual()) {
            front = rear = -1;
        } else
            front = (front + 1) % capacity;
        size--;
        totalRemoved++;
        System.out.printf("The vehicle [%04d] has successfully deleted from the parking lot\n", temp);
    }

    public void delRear() {
        if (isEmpty()) {
            System.out.println("Parking lot is already empty. Nothing to remove.");
            return;
        }
        int temp = deque[rear];
        if (isEqual()) {
            front = rear = -1;
        } else
            rear = (rear - 1 + capacity) % capacity;
        size--;
        totalRemoved++;
        System.out.printf("The vehicle [%04d] has successfully deleted from the parking lot\n", temp);
    }

    public void displayInfo() {
        System.out.println("Available Space: " + (capacity - size));
        System.out.println("Ocupied Space: " + size);
        System.out.println("Total Space: " + capacity);

        System.out.println("\nTotal Entered Cars: " + totalEntered);
        System.out.println("Total Removed Cars: " + totalRemoved);
    }
}


