package Server;
//1445089

import Client.Cliente;
import Server.Collections.Comander;
import Server.Collections.Message;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Servidor {
    private static DatagramSocket socket;
    private boolean running;
    private static final byte[] buffer = new byte[1024];
    private static DatagramPacket receiveCommand;
    static Scanner Command = new Scanner(System.in);
    static String CommandToBytes;


    public static void ModuleConnection(int port) throws Exception{
      socket = new DatagramSocket(port);
    }

    public static void ModuleLectureCommands() throws IOException {

        while(true) {
            receiveCommand = new DatagramPacket(buffer, buffer.length);
            socket.receive(receiveCommand);
            CommandToBytes = new String(receiveCommand.getData(), 0, receiveCommand.getLength());
            System.out.println("Enter command " + CommandToBytes);
            ModuleResponseCommands(CommandToBytes);
        }
    }

    public static void ModuleResponseCommands(String commandToBytes) throws IOException {

        ArrayList<String> allCommands = new ArrayList<>();
        boolean salir = true;

        while (salir) {
            System.out.println("Enter a Command 2 part ");

            //commandToBytes = Command.next();


            try {
                //USE OF THE COMMANDS
                String sd = null;
                allCommands.add(sd);

                switch (commandToBytes) {
                    case "help" -> {
                        Comander.help();
                        salir = false;
                    }
                    case "info" -> {
                        Comander.info();
                        salir = false;
                    }
                    case "show" ->{
                        Comander.show();
                        salir = false;
                    }
                    case "insert" -> {
                        Comander.parameterPerson();
                        salir = false;
                    }
                    case "update" -> {
                        Comander.update();
                        salir = false;
                    }
                    case "remove_key" -> {
                        Comander.removeKey();
                        salir = false;
                    }
                    case "clear" -> {
                        Comander.clear();
                        salir = false;
                    }
                    case "save" -> {
                        Comander.save();
                        salir = false;
                    }
                    case "execute_script" -> {
                        Comander.generateScript(allCommands);
                        salir = false;
                    }
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

    public static void ModuleResponseClient() throws IOException {
        DatagramPacket packet = new DatagramPacket(receiveCommand.getData(), receiveCommand.getLength(),receiveCommand.getAddress(),receiveCommand.getPort());
        socket.send(packet);
    }

    public static void main(String[] args) throws Exception {
        ModuleConnection(2345);

        ModuleLectureCommands();
        ModuleResponseClient();

    }

}