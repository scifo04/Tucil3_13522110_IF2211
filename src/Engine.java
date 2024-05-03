import java.util.*;
import java.util.HashMap;

public class Engine {
    private HashMap<String,Boolean> dictionary;
    private Node start;
    private String end;
    private Node resultado;
    private String[] message;
    private long exec;
    private long runtime;

    public Engine() {
        this.start = new Node();
        this.end = "";
    }
    public String[] getMessage() {
        return message;
    }
    public String getMessageGet(int i) {
        return message[i];
    }
    public long getExec() {
        return exec;
    }
    public long getMem() {
        return runtime;
    }
    public void Start(String start, String end, int choice) {
        this.dictionary = FileController.readToList();
        this.resultado = new Node();

        this.start.setCost(0);
        this.start.setInfo(start);
        this.end = end;
        PriorityQueue<Node> emptyList = new PriorityQueue<Node>(new NodeComparator());

        if (!(this.dictionary.get(start) != null && this.dictionary.get(end) != null)) {
            message = new String[1];
            message[0] = "Please insert proper english word!";
            return;
        }

        long startTime = System.currentTimeMillis();
        Search results = new Search(this.dictionary);
        switch(choice) {
            case 1:
                this.resultado = results.SearchSolution(this.start, this.end, this.dictionary, emptyList, "UCS");
                break;
            case 2:
                this.resultado = results.SearchSolution(this.start, this.end, this.dictionary, emptyList, "GBFS");
                break;
            case 3:
                this.resultado = results.SearchSolution(this.start, this.end, this.dictionary, emptyList, "AS");
                break;
            default:
                break;
        }
        Runtime runtime = Runtime.getRuntime();
        long endTime = System.currentTimeMillis();
        this.message = this.resultado.moveToList();
        this.exec = endTime-startTime;
        this.runtime = (runtime.totalMemory()-runtime.freeMemory())/(1024L*1024L);
    }
}
