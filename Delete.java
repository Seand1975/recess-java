import java.io.*;
import java.util.*;

public class Delete implements Serializable {

    public static void del(String name) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileWriter out = new FileWriter("anka.txt", true);
        if(!Session.sessName.isEmpty()){
            if(name == Session.sessName){
                System.out.println("Do you really intend to delete your account?\nIf you do, type your username one more time.");
                String verify = sc.nextLine();
                if (verify == Session.sessName) {
                    String data = "del: "+verify+"\n";
                    out.write(data);
                    Session.reset();
                    //wait for cron response here.
                }
            }else
                System.out.println("That is not the name of the current logged in user.");
        }else
            System.out.println("No currently logged in account.");
        out.close();
        sc.close();
    }
}