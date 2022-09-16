import java.io.FileReader;

public class Request {
    public static void requested() throws Exception {
        System.out.println("Request sent, \n Response may take a while \n You may log in later and the response will be available");
        int i;
        FileReader input = new FileReader("Request.txt");
        while ((i = input.read()) != -1) {
            System.out.print((char)i);

        }
        System.out.println("\n");

        input.close();

    }
}


