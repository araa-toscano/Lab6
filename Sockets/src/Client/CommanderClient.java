package Client;

import Server.Collections.Comander;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommanderClient extends Thread{
    static Scanner Command = new Scanner(System.in);

    @Override
    public void run() {
        ArrayList<String> allCommands = new ArrayList<>();

        boolean salir = true;

        while (salir) {
            System.out.println("Enter a Command 2.0 ");
            String identifier = Command.next();

            try {
                //USE OF THE COMMANDS
                String sd= null;
                allCommands.add(sd);

                switch (identifier) {
                    case "help" -> Comander.help();
                    case "info" -> Comander.info();
                    case "show" -> Comander.show();
                    case "insert" -> {    }
                    case "update" -> {    }
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
}
