import java.io.*;
import java.util.concurrent.TimeUnit;

public class CronResponse{
    public static void get() throws Exception {
        System.out.println("Process running, wait about 2 minutes.");
        TimeUnit.SECONDS.sleep(10);
        FileReader r = new FileReader("anka.txt");
        //code here to read from anka.txt/anka.json after cron job
        Session.define("agani", "shoes");
        r.close();
    }
}
