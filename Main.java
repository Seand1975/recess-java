import java.util.*;

public class Main {
    static Scanner enter = new Scanner(System.in);

    public static void runner() throws Exception {
        System.out.print(">> ");
        String inp = enter.nextLine();
        String[] command = inp.split(" ");

        switch (command[0]) {
            case "Register":
                if (command.length == 5) {
                    Participant.register(command[1], command[2], command[3], command[4]);
                } else
                    System.err.println(
                            "Not enough arguments for Register.\nUse 'Register name password date_of_birth product' ");
                runner();
                break;
            case "Post_product":
                if(Session.sessName.isBlank()){
                    System.err.println("No user currently logged in or registered\nUse Login or Register command.");
                    runner();
                    break;
                }
                if (command.length == 4) {
                    Post.postProduct(command[1], command[2], command[3]);
                } else
                    System.err.println(
                            "Not enough arguments for Post_product.\nUse 'Post_product product_name \"description\" unit price' ");
                runner();
                break;
            case "Qty_update":
                if(Session.sessName.isBlank()){
                    System.err.println("No user currently logged in or registered\nUse Login or Register command.");
                    runner();
                    break;
                }
                if (command.length == 2) {
                    QuantityUpdate.publish(Integer.parseInt(command[1]));
                } else
                    System.err.println(
                            "Not enough arguments for Qty_update.\nUse 'Qty_update quantity");
                runner();
                break;
            case "Login":
                if (command.length == 3) {
                    Login.log(command[1], command[2]);
                } else
                    System.err.println(
                            "Not enough arguments for Login.\nUse 'Login name password' ");
                runner();
                break;
            case "Performance":
                if(Session.sessName.isBlank()){
                    System.err.println("No user currently logged in or registered\nUse Login or Register command.");
                    runner();
                    break;
                }
                if (command.length == 1) {
                    Request.requested();
                } else
                    System.err.println(
                            "Too many arguments for Performance.\nUse 'Performance' ");
                runner();
                break;
            case "Quit":
                if (command.length == 1) {
                    termination();
                } else {
                    System.err.println(
                            "Too many arguments for Quit.\nUse 'Quit' ");
                    runner();
                }
                break;
            case "Delete":
                if(Session.sessName.isBlank()){
                    System.err.println("No user currently logged in or registered\nUse Login or Register command.");
                    runner();
                    break;
                }
                if (command.length == 2) {
                    Delete.del(command[1]);
                } else {
                    System.err.println(
                            "Not enough arguments for Delete.\nUse 'Delete name' ");
                }
                runner();
                break;
            case "Session":
                if (command.length == 1) {
                    Session.session();
                } else
                System.err.println(
                        "Too many arguments for Session.\nUse 'Session' ");
                
                runner();
                break;
            default:
                System.err.println("Unknown command.");
                runner();
        }
    }

    public static void termination() throws Exception {
        System.out.println("Do you wish to quit (Y/n) ");
        String inp = enter.nextLine();
        String proceed = inp.toLowerCase();
        switch (proceed) {
            case "n":
                runner();
                break;
            case "y":
                System.out.println("\nThank you for choosing ANKA Business Support Systems\nCome Again\n");
                break;
            default:
                System.out.println("Didn't quite get that..");
                termination();
        }
    }

    public static void main(String[] args) throws Exception {
        Session.init();
        System.out.println(
                "\n-Welcome to ANKA Business Support Systems. \nThank you for participating in the competition.-");
        System.out.println("COMMANDS:\n    Register: 'Register name password date_of_birth product' \n    Post_product: 'Post_product product_name \"description\" unit price' \n    Performance: 'Performance' \n    Login: 'Login name password' \n    Qty_update: 'Qty_update quantity' \n    Delete: 'Delete name' \n    Quit: 'Quit' \n    Session: 'Session' \n");

        runner();
        enter.close();
    }
}
