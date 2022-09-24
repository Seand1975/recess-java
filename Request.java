import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Request {
    public static void requested() throws Exception {
        boolean seen = false;
        try {
            FileReader input = new FileReader("Request.txt");
            Scanner scan = new Scanner(input);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();//looking for a line like response=Name:dan,Points:345,Return Buyers:12,....
                if (line.contains("response")) {
                    String[] content = line.split("=");//splits at =
                    String[] response = content[1].split(",");//gets part after the '=' and splits using commas
                    for (String string : response) {
                        System.out.println(string);//prints each onto a new line
                    }
                }
            }
            seen = true;
            System.out.println(Main.GREEN+"New request being made to server"+Main.RESET);
        } catch (Exception e) {
            //this part only runs the first time a request is made
            System.out.println(Main.GREEN+"Request sent, \n Response may take a while \n You may check later (about 2 minutes) and the response will be available"+Main.RESET);
        } finally {
            //this part runs all the time
            FileWriter output = new FileWriter("Request.txt",false);
            String date = LocalDateTime.now().toString();
            date = date.replaceAll("-", "/");
            String data = "Request:"+Session.sessName+","+date;
            if (seen) {
                data = "Seen:"+Session.sessName+","+date+"\n"+data;
            }
            output.write(data);
            output.close();
        }
        
    }
}


