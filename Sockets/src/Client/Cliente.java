package Client;

import Server.Collections.Comander;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {
    private static DatagramSocket socket;
    private static InetAddress address;
    static Scanner Command = new Scanner(System.in);
    static String readCommand = Command.next();

    public static void Connection(String serverAddress) throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        address = InetAddress.getByName(serverAddress);
    }

    public static void SendCommands(int port) throws IOException {
        DatagramPacket sendCommands = new DatagramPacket(readCommand.getBytes(), readCommand.length(), address, port);
        socket.send(sendCommands);
    }

    public static void CommandIdentify(String rdCommand) {
        ArrayList<String> allCommands = new ArrayList<>();

        boolean salir = true;

        while (salir) {
            System.out.println("Enter a Command 2.00000 ");
            String identifier = Command.next();

            try {
                //USE OF THE COMMANDS
                String sd= null;
                allCommands.add(sd);

                switch (identifier) {
                    case "help" -> {
                        Comander.help();
                        salir = false;
                    }
                    case "info" -> {
                        Comander.info();
                        salir = false;
                    }
                    case "show" -> Comander.show();
                    case "insert" -> {    }
                    case "update" -> {   }
                    case "remove_key" -> {}
                    case "clear" -> Comander.clear();
                    case "save" -> {}
                    case "execute_script" -> {}
                    case "history" -> Comander.history(allCommands);
                    case "replace_if_greater" -> {                    }
                    case "remove_greater_key" -> {                    }
                    case "remove_all_by_nationality" -> {                    }
                    case "remove_any_by_location" -> {                    }
                    case "group_counting_by_location" -> {}
                    case "exit" -> salir = false;
                    default -> System.out.println("You press something wrong. \nPlease, try again! ");
                }


            } catch (IllegalStateException | IllegalArgumentException | InputMismatchException e) {

            }
        }


    }


    public static void main(String[] args) throws IOException {
        Connection("localhost");
        SendCommands(2345);

    }
}
