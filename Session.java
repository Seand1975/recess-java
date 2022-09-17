import java.io.*;
import java.util.*;

public class Session {
    public static String sessName="";
    public static String sessItem="";

    public static void define(String name, String item) throws IOException {
        sessName = name;
        sessItem = item;
        String sess = sessName+","+sessItem;
        FileWriter w = new FileWriter("session.txt");
        w.write(sess);
        w.close();
    }

    public static void init(){
        try {
            FileReader r = new FileReader("session.txt");
            Scanner s = new Scanner(r);
            String currUser = s.nextLine();
            String[] info = currUser.split(",");
            s.close();
            sessName = info[1];
            sessItem = info[2];
        } catch (FileNotFoundException e) {
            System.out.print("");
        }
    }

    public static void session() {
       if (!sessName.isBlank()) {
        System.out.println("Participant: "+sessName+", Item: "+sessItem);
       } else {
        System.out.println("No current user.");
       } 
    }

    public static void reset() {
        sessName = "";
        sessItem = "";
    }
}
