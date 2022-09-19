import java.util.*;

public class Main {
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    static Scanner enter = new Scanner(System.in);

    public static void runner() throws Exception {
        System.out.print(">> ");
        System.out.print(GREEN);
        String inp = enter.nextLine();
        String[] command = inp.split(" ");

        switch (command[0]) {
            case "Register":
                System.out.print(RESET);
                if (command.length == 5) {
                    Participant.register(command[1], command[2], command[3], command[4]);
                } else
                    System.err.println(RED+
                            "Not enough arguments for Register.\nUse 'Register name password date_of_birth product' "+RESET);
                runner();
                break;
            case "Post_product":
                System.out.print(RESET);
                if(Session.sessName.isBlank()){
                    System.err.println(RED+"No user currently logged in or registered\nUse Login or Register command."+RESET);
                    runner();
                    break;
                }
                if (command.length == 4) {
                    Post.postProduct(command[1], command[2], command[3]);
                } else
                    System.err.println(RED+
                            "Not enough arguments for Post_product.\nUse 'Post_product product_name \"description\" unit price' "+RESET);
                runner();
                break;
            case "Qty_update":
                System.out.print(RESET);
                if(Session.sessName.isBlank()){
                    System.err.println(RED+"No user currently logged in or registered\nUse Login or Register command."+RESET);
                    runner();
                    break;
                }
                if (command.length == 2) {
                    QuantityUpdate.publish(Integer.parseInt(command[1]));
                } else
                    System.err.println(RED+
                            "Not enough arguments for Qty_update.\nUse 'Qty_update quantity"+RESET);
                runner();
                break;
            case "Login":
                System.out.print(RESET);
                if (command.length == 3) {
                    Login.log(command[1], command[2]);
                } else
                    System.err.println(RED+
                            "Not enough arguments for Login.\nUse 'Login name password' "+RESET);
                runner();
                break;
            case "Performance":
                System.out.print(RESET);
                if(Session.sessName.isBlank()){
                    System.err.println(RED+"No user currently logged in or registered\nUse Login or Register command."+RESET);
                    runner();
                    break;
                }
                if (command.length == 1) {
                    Request.requested();
                } else
                    System.err.println(RED+
                            "Too many arguments for Performance.\nUse 'Performance' "+RESET);
                runner();
                break;
            case "Quit":
                System.out.print(RESET);
                if (command.length == 1) {
                    termination();
                } else {
                    System.err.println(RED+
                            "Too many arguments for Quit.\nUse 'Quit' "+RESET);
                    runner();
                }
                break;
            case "Delete":
                System.out.print(RESET);
                if(Session.sessName.isBlank()){
                    System.err.println(RED+"No user currently logged in or registered\nUse Login or Register command."+RESET);
                    runner();
                    break;
                }
                if (command.length == 2) {
                    Delete.del(command[1]);
                } else {
                    System.err.println(RED+
                            "Not enough arguments for Delete.\nUse 'Delete name' "+RESET);
                }
                runner();
                break;
            case "Session":
                System.out.print(RESET);
                if (command.length == 1) {
                    Session.session();
                } else
                System.err.println(RED+
                        "Too many arguments for Session.\nUse 'Session' "+RESET);
                
                runner();
                break;
            default:
                System.out.print(RED);
                System.err.println("Unknown command."+RESET);
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
