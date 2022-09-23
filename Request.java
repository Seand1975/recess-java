import java.io.*;

public class Request {
    public static void requested() throws Exception {
        System.out.println("Request sent, \n Response may take a while \n You may log in later and the response will be available");
        FileWriter output = new FileWriter("Request.txt");
        output.write("Request");

        int i;
        FileReader input = new FileReader("Request.txt");
        while ((i = input.read()) != -1) {
            System.out.print((char)i);

        }
        System.out.println("\n");

        input.close();

    }
}


