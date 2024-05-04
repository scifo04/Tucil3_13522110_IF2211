import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Util {
    public static boolean checkAvail(ArrayList<String> liste, String teste) {
        boolean checker = false;
        for (int i = 0; i < liste.size(); i++) {
            if (teste.equals(liste.get(i))) {
                checker = true;
                return checker;
            }
        }
        return checker;
    }

    public static boolean checkAvailCostly(Node liste, String teste) {
        boolean checker = false;
        Node tracker = new Node(liste);
        while(tracker != null) {
            if (tracker.getInfo().equals(teste)) {
                checker = true;
                return checker;
            }
            tracker = tracker.getPrev();
        }
        return checker;
    }

    public static int mapChar(char a) {
        return (a - 97);
    }

    public static char mapInt(int a) {
        return (char) ('a' + a);
    }

    public static int find_cost(String a, String b) {
        int count = 0;
        if (a.length() <= b.length()) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static Node smallestDistance(ArrayList<Node> liste) {
        System.out.println(liste.size());
        Node temp = liste.get(0);
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getCost() < temp.getCost()) {
                temp = liste.get(i);
            }
        }
        return temp;
    }

    public static boolean isInTheEnd(ArrayList<Node> liste, String teste) {
        boolean checker = false;
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).compareList(teste)) {
                    checker = true;
                    return checker;
            }
        }
        return checker;
    }

    public static PriorityQueue<Node> getPossibleValues(Node word, HashMap<String,Boolean> dict, String end, String choice) {
        String temp = word.getInfo();
        PriorityQueue<Node> temp_list = new PriorityQueue<>(new NodeComparator());
        Node tracker;
        int cost = 0;
        for (int i = 0; i < temp.length(); i++) {
            for (int j = 0; j < 26; j++) {
                temp = temp.substring(0, i) + mapInt(j) + temp.substring(i + 1);
                if (dict.get(temp) != null && !dict.get(temp) && !word.getInfo().equals(temp) && word.getInfo() != null) {
                    if (choice.equals("UCS")) {
                        cost = word.getSize()+1;
                    } else if (choice.equals("GBFS")) {
                        cost = find_cost(end, temp);
                    } else if (choice.equals("AS")) {
                        cost = word.getSize()+1+find_cost(end, temp);
                    }
                    tracker = new Node(temp, word, cost);
                    dict.put(temp, true);
                    temp_list.add(tracker);
                }
            }
            temp = word.getInfo();
        }
        return temp_list;
    }

    public static ArrayList<Node> toList(PriorityQueue<Node> pq) {
        PriorityQueue<Node> pq2 = new PriorityQueue<Node>(pq);
        ArrayList<Node> liste = new ArrayList<>();
        while (pq2.size() > 0) {
            Node n = new Node();
            n = pq2.poll();
            liste.add(n);
        }
        return liste;
    }

    public static void printList(ArrayList<Node> liste) {
        for (int i = 0; i < liste.size(); i++) {
            System.out.print(liste.get(i).getInfo()+" ");
        }
        System.out.println();
    }
}
