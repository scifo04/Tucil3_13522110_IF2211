import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
    public int compare(Node a, Node b) {
        if (a.getCost() < b.getCost()) {
            return -1;
        } else if (a.getCost() > b.getCost()) {
            return 1;
        } else {
            return 0;
        }
    }
}
