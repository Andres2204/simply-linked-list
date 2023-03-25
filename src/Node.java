public class Node {
    private Node next;
    private float data;

    public Node() {
        this.next = null;
        this.data = 0;
    }

    public Node(float d) {
        this.next = null;
        this.data = d;
    }

    // getter setters

    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public float getData() {
        return data;
    }
    public void setData(float data) {
        this.data = data;
    }
}
