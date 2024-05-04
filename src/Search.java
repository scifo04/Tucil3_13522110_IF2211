import java.util.HashMap;
import java.util.PriorityQueue;

public class Search {
    private HashMap<String,Boolean> dictionary;

    private int visited;

    public Search(final HashMap<String,Boolean> dictionary) {
        this.dictionary = dictionary;
    }

    public int getVisited() {
        return visited;
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
                visited++;
            }
            temp = Util.getPossibleValues(gottenCostElement, this.dictionary, end, choice);
            sizeRef = temp.size();
            if (choice.equals("GBFS")) {
                cont.removeAll(cont);
            }
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
