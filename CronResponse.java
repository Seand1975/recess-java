import java.io.*;
import java.util.concurrent.TimeUnit;

public class CronResponse{
    public static void get() throws Exception {
        TimeUnit.SECONDS.sleep(160);
        System.out.println("Process running, wait about 160 seconds.");
        FileReader r = new FileReader("anka.txt");
        //code here to read from anka.txt/anka.json after cron job
        //Session.define(name,item);
        r.close();
    }
}
