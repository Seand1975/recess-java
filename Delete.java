import java.io.*;
import java.util.*;

public class Delete implements Serializable {

    public static void del(String name) throws Exception {
        Scanner sc = new Scanner(System.in);
        if(!Session.sessName.isEmpty()){
            if(name.equals(Session.sessName)){
                System.out.println("Do you really intend to"+Main.RED+" delete"+Main.RESET+" your account?\nIf you do, type your username one more time.");
                String verify = sc.nextLine();
                if (verify.equals(Session.sessName)) {
                    String data = "del: "+verify+"\n";
                    FileWriter out = new FileWriter("anka.txt", true);
                    out.write(data);
                    FileWriter w = new FileWriter("session.txt",false);
                    Session.reset();
                    out.close();
                    w.close();
                    //wait for cron response here.
                }
            }else
                System.out.println("That is not the name of the current logged in user.");
        }else
            System.out.println("No currently logged in account.");
    }
}
