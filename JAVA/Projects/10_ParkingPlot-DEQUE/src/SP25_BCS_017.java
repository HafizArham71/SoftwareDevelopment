public class SP25_BCS_017 {
    static void main(String[] args) {
        CircularDeque parkingLot = new CircularDeque(5);
        parkingLot.insertFront(1);
        parkingLot.insertFront(2);
        parkingLot.insertFront(3);
        parkingLot.insertRear(4);
        parkingLot.delRear();
        parkingLot.insertFront(5);
        parkingLot.insertFront(6);
        parkingLot.displayInfo();
    }
}
