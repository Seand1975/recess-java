import java.io.*;

public class Post implements Serializable {
    public static boolean posted = false;
    public static void postProduct(String name, String desc, String price) throws Exception {
        if (name.equals(Session.sessItem)&& !posted ) {
            String data = "post: "+Session.sessName+"," + name + "," + desc + "," + price + "\n";
            FileWriter out = new FileWriter("anka.txt", true);
            out.write(data);
            out.close();
            posted = true;
        }else CronResponse.error("You have already posted. Use Qty_update to update quantities.");
    }
}
