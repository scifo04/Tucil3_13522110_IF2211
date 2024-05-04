import java.util.ArrayList;

public class Node {
    private Node prev;
    private String info;
    private int cost;

    public Node() {
        this.info = "";
        this.cost = 0;
    }

    public Node(String info, Node prev, int cost) {
        this.info = info;
        this.prev = prev;
        this.cost = cost;
    }

    public Node(final Node other) {
        this.info = other.info;
        this.prev = other.prev;
        this.cost = other.cost;
    }

    public Node getPrev() {
        return this.prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void printNodes() {
        ArrayList<String> container = new ArrayList<>();
        Node containerNode = new Node(this);
        container.add(info);
        while (containerNode.prev != null) {
            containerNode = containerNode.prev;
            container.add(containerNode.info);
        }
        for (int i = container.size()-1; i >= 0; i--) {
            System.out.print(container.get(i)+" ");
        }
        System.out.println();
    }

    public int getSize() {
        int count = 0;
        Node tracker = new Node(this);
        while (tracker != null) {
            count++;
            tracker = tracker.getPrev();
        }
        return count;
    }

    public boolean compareList(String teste) {
        boolean checker = false;
        Node tracker = new Node(this);
        while(tracker != null) {
            if (teste.equals(tracker.getInfo())) {
                checker = true;
                return checker;
            }
            tracker = tracker.getPrev();
        }
        return checker;
    }

    public String[] moveToList() {
        String[] temp = new String[this.getSize()];
        int sizeRef = this.getSize()-1;
        int i = 0;
        Node tracker = new Node(this);
        while (tracker != null) {
            temp[sizeRef-i] = tracker.getInfo();
            tracker = tracker.getPrev();
            i++;
        }
        return temp;
    }
}
