import java.util.HashMap;
import java.util.PriorityQueue;

public class Search {
    private HashMap<String,Boolean> dictionary;

    public Search(final HashMap<String,Boolean> dictionary) {
        this.dictionary = dictionary;
    }

    public Node SearchSolution(Node start, String end, HashMap<String,Boolean> dict, PriorityQueue<Node> cont, String choice) {
        Node gottenCostElement;
        Node tracker;
        PriorityQueue<Node> temp;
        int sizeRef;
        while (true) {
            if (cont.peek() == null) {
                gottenCostElement = new Node(start);
            } else {
                gottenCostElement = cont.poll();
            }
            temp = Util.getPossibleValues(gottenCostElement, this.dictionary, end, choice);
            sizeRef = temp.size();
            for (int i = 0; i < sizeRef; i++) {
                tracker = temp.poll();
                if (tracker != null) {
                    cont.add(tracker);
                }
                if (tracker.getInfo().equals(end)) {
                    return tracker;
                }
            }
            if (cont.size() <= 0) {
                return new Node("Solution not found", null, 0);
            }
        }
    }
}
