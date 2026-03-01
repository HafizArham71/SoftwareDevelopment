public class LinkedListConcepts {
    static void main(String[] args) {

        Node node1 = new Node();
        Node node2 = new Node();
        node1.data = 5;
        node1.addressOfNext = node2;
        node2.data = 6;
        node1.addressOfNext = null;


    }
}

class Node {

    // Attributes
    int data;
    Node addressOfNext;
}