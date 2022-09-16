import java.io.*;

public class Post implements Serializable {

    public static void postProduct(String name, String desc, String price) throws Exception {
        String data = "post: " + name + "," + desc + "," + price + "\n";
        FileWriter out = new FileWriter("anka.txt", true);
        out.write(data);
        out.close();
    }
}
