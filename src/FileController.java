import java.util.*;
import java.io.*;
import java.util.HashMap;

public class FileController {
    public static HashMap<String,Boolean> readToList() {
        HashMap<String,Boolean> temp = new HashMap<String,Boolean>();
        String placer;
        try {
            File diction = new File("../tc.txt");
            Scanner reader = new Scanner(diction);
            while (reader.hasNextLine()) {
                placer = reader.nextLine();
                temp.put(placer,false);
            }
            reader.close();
            return temp;
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
            return temp;
        }
    }
}
