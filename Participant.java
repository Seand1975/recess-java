import java.io.*;

public class Participant implements Serializable {

    public static void register(String name, String pass, String dob, String product) throws Exception {
        String data = "reg: " + name + "," + pass + "," + dob + "," + product + "\n";
        FileWriter out = new FileWriter("anka.txt", true);
        out.write(data);
        out.close();
        CronResponse.get();
    }
}
