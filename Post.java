import java.io.*;

public class Post implements Serializable {

    public static void postProduct(String name, String desc, String price) throws Exception {
        if (name.equals(Session.sessItem)) {
            String data = "post: "+Session.sessName+"," + name + "," + desc + "," + price + "\n";
            FileWriter out = new FileWriter("anka.txt", true);
            out.write(data);
            out.close();
        }else CronResponse.error("That is not the product you registered.");
    }
}
