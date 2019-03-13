import java.util.*;

public class StringTest {
    public static void main(String[] args) {
        LinkedList<String> testList = new LinkedList<>();
        String first = "hello";

    }

    public void addFirst(Object obj) {
        Node newNode = new Node();
        newNode.data = obj;
        newNode.next = first;
        first = newNode;
    }
}


class Node<String> extends LinkedList {
    private String data;
    private Node<String> next;

    public Node(String data, Node<String> next) {
        this.data = data;
        this.next = next;
    }

    public void getData() {
        return data;
    }

    public void getNext() {
        return next;
    }
}
