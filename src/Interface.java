import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Interface extends JFrame implements ItemListener {
    static JFrame f;
 
    // label
    static JLabel l, l1, l2, l3;
 
    // combobox
    static JComboBox c1;

    // input
    static JTextField t1,t2;

    // button
    static JButton b;

    static JPanel resultPanel;

    public Interface() {
        f = new JFrame("Word Solver");
        f.setLayout(new FlowLayout());

        String[] option = {"Uniform Cost Search", "Greedy Best First Search", "A*"};

        t1 = new JTextField(50);
        t2 = new JTextField(50);
        c1 = new JComboBox(option);
        c1.addItemListener(this);
        l = new JLabel("Insert the first word");
        l1 = new JLabel("Insert the final word");
        l2 = new JLabel("Select your method");
        l3 = new JLabel("Chosen algorithm: Uniform Cost Search");
        l.setForeground(Color.red);
        l1.setForeground(Color.blue);
        JPanel p = new JPanel(new GridLayout(0, 1));
        b = new JButton("Search");
        p.add(l);
        p.add(t1);
        p.add(l1);
        p.add(t2);
        p.add(l2);
        p.add(c1);
        p.add(l3);
        p.add(b);
        f.add(p);

        // Initialize the result panel
        resultPanel = new JPanel(new BorderLayout());
        resultPanel.setPreferredSize(new Dimension(350, 200));
        f.add(resultPanel);

        f.setSize(700, 500);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close terminal when pressing x

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String starte = t1.getText();
                String ende = t2.getText();
                if (starte.length() == ende.length()) {
                    Engine eng = new Engine();
                    if (c1.getSelectedItem().equals("Uniform Cost Search")) {
                        eng.Start(starte, ende, 1);
                    } else if (c1.getSelectedItem().equals("Greedy Best First Search")) {
                        eng.Start(starte, ende, 2);
                    } else {
                        eng.Start(starte, ende, 3);
                    }
                    DefaultListModel<String> listModel = new DefaultListModel<>();
                    listModel.addElement("Execution time: " + Long.toString(eng.getExec()) + " ms");
                    listModel.addElement("Score: " + eng.getMessage().length);
                    for (int i = 0; i < eng.getMessage().length; i++) {
                        listModel.addElement(eng.getMessageGet(i));
                    }
                    JList<String> li = new JList<>(listModel); // Use listModel instead of eng.getMessage()
                    li.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    JScrollPane scrollPane = new JScrollPane(li);

                    // Remove previous search results
                    resultPanel.removeAll();
                    resultPanel.add(scrollPane, BorderLayout.CENTER);

                    // Refresh layout
                    f.revalidate();
                    f.repaint();
                } else {
                    return;
                }
            }
        });
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == c1) {
            l3.setText("Chosen algorithm: "+c1.getSelectedItem());
        }
    }
}
