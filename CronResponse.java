import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CronResponse{
    public static void get() throws Exception {
        System.out.println("Process running, wait about 2 minutes.");
        TimeUnit.SECONDS.sleep(120);
        try {
                FileReader r = new FileReader("cron.txt");
                Scanner cron = new Scanner(r);
                boolean has = false;
                if(cron.hasNextLine()) has=true;
                while (cron.hasNextLine()) {
                    String reply = cron.nextLine();
                    String[] content = reply.split(":");
                    switch (content[0]) {
                        case "success":
                            success(content[1]);
                            break;
                        case "error":
                            error(content[1]);
                            break;
                        case "session":
                            String[] cred = content[1].split(",");
                            Session.define(cred[0], cred[1]);
                            break;
                        default:
                            break;
                    }
                }
                if (has) {
                    has = false;
                    Main.runner();
                }
                r.close();
            } catch (Exception e) {
                System.out.print("");
            } finally {
                FileWriter w = new FileWriter("cron.txt", false);
                w.close();
            }
    }
    public static void success(String s) throws Exception {
        System.out.println(Main.GREEN+s+Main.RESET);
    }
    public static void error(String s) throws Exception {
        System.out.println(Main.RED+s+Main.RESET);
    }

}
