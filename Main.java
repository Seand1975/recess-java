import java.util.*;

public class Main {
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    static Scanner enter = new Scanner(System.in);

    public static void runner() throws Exception {
        System.out.print(">> ");
        System.out.print(YELLOW);
        String inp = enter.nextLine();
        String[] command = inp.split(" ");
        System.out.print(RESET);

        switch (command[0]) {
            case "Register":
                //System.out.print(RESET);
                if (command.length == 5) {
                    Participant.register(command[1], command[2], command[3], command[4]);
                } else
                    System.err.println(
                            "Not enough arguments for "+RED+"Register"+RESET+".\nUse "+GREEN+"Register name password date_of_birth product"+RESET+" ");
                runner();
                break;
            case "Post_product":
                //System.out.print(RESET);
                if(Session.sessName.isBlank()){
                    System.err.println("No user currently logged in or registered\nUse Login or Register command."+RESET);
                    runner();
                    break;
                }
                if (command.length == 4) {
                    Post.postProduct(command[1], command[2], command[3]);
                } else
                    System.err.println(
                            "Not enough arguments for "+RED+"Post_product"+RESET+".\nUse "+GREEN+"Post_product product_name \"description\" unit price"+RESET+" ");
                runner();
                break;
            case "Qty_update":
                //System.out.print(RESET);
                if(Session.sessName.isBlank()){
                    System.err.println("No user currently logged in or registered\nUse Login or Register command."+RESET);
                    runner();
                    break;
                }
                if (command.length == 2) {
                    QuantityUpdate.publish(Integer.parseInt(command[1]));
                } else
                    System.err.println(
                            "Not enough arguments for "+RED+"Qty_update"+RESET+".\nUse "+GREEN+"Qty_update quanti"+RESET+"y");
                runner();
                break;
            case "Login":
                //System.out.print(RESET);
                if (command.length == 3) {
                    Login.log(command[1], command[2]);
                } else
                    System.err.println(
                            "Not enough arguments for "+RED+"Login"+RESET+".\nUse "+GREEN+"Login name password"+RESET+" ");
                runner();
                break;
            case "Performance":
                //System.out.print(RESET);
                if(Session.sessName.isBlank()){
                    System.err.println("No user currently logged in or registered\nUse Login or Register command."+RESET);
                    runner();
                    break;
                }
                if (command.length == 1) {
                    Request.requested();
                } else
                    System.err.println(
                            "Too many arguments for "+RED+"Performance"+RESET+".\nUse "+GREEN+"Performance"+RESET+" ");
                runner();
                break;
            case "Quit":
                //System.out.print(RESET);
                if (command.length == 1) {
                    termination();
                } else {
                    System.err.println(
                            "Too many arguments for "+RED+"Quit"+RESET+".\nUse "+GREEN+"Quit"+RESET+" ");
                    runner();
                }
                break;
            case "Delete":
                //System.out.print(RESET);
                if(Session.sessName.isBlank()){
                    System.err.println("No user currently logged in or registered\nUse Login or Register command."+RESET);
                    runner();
                    break;
                }
                if (command.length == 2) {
                    Delete.del(command[1]);
                } else {
                    System.err.println(
                            "Not enough arguments for "+RED+"Delete"+RESET+".\nUse "+GREEN+"Delete name"+RESET+" ");
                }
                runner();
                break;
            case "Session":
                //System.out.print(RESET);
                if (command.length == 1) {
                    Session.session();
                } else
                System.err.println(
                        "Too many arguments for "+RED+"Session"+RESET+".\nUse "+GREEN+"Session"+RESET+" ");
                
                runner();
                break;
            default:
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
        System.out.println(GREEN+
                "\n-Welcome to ANKA Business Support Systems. \nThank you for participating in the competition.-"+RESET);
        System.out.println(RED+"COMMANDS"+RESET+":\n    "+GREEN+"Register"+RESET+": 'Register name password date_of_birth product' \n    "+GREEN+"Post_product"+RESET+": 'Post_product product_name \"description\" unit price' \n    "+GREEN+"Performance"+RESET+": 'Performance' \n    "+GREEN+"Login"+RESET+": 'Login name password' \n    "+GREEN+"Qty_update"+RESET+": 'Qty_update quantity' \n    "+GREEN+"Delete"+RESET+": 'Delete name' \n    "+GREEN+"Quit"+RESET+": 'Quit' \n    "+GREEN+"Session"+RESET+": 'Session' \n");

        runner();
        enter.close();
    }
}
