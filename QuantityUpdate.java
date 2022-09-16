import java.io.*;

public class QuantityUpdate implements Serializable {

    public static void publish(int qty) throws Exception {
        String data = "qty: " + qty + "\n";
        FileWriter out = new FileWriter("anka.txt", true);
        out.write(data);
        out.close();
    }
}
