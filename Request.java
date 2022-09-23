import java.io.*;
import java.util.Scanner;

public class Request {
    public static void requested() throws Exception {
        FileWriter output = new FileWriter("Request.txt",false);
        
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
            System.out.println("New request being made to server");
        } catch (Exception e) {
            //this part only runs the first time a request is made
            System.out.println("Request sent, \n Response may take a while \n You may check later and the response will be available");
        } finally {
            //this part runs all the time
            output.write("Request");
            output.close();
        }
        
        
    }
}


