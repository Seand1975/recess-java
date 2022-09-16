import java.io.FileWriter;

public class Login {

    public static void log(String name, String pass) throws Exception {
        String data = "login: " + name + "," + pass + "\n";
        FileWriter out = new FileWriter("anka.txt", true);
        out.write(data);
        out.close();
    }

}
