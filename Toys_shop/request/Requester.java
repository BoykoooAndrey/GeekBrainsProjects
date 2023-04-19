package request;

import java.util.Scanner;
import controller.Controller;

public class Requester {
    private Controller controller;

    public Requester(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        Commands com = Commands.NONE;
        while (true) {
            String command = prompt("Введите команду(Для вызова помощи введите HELP): ");
            try {
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT)
                    return;
                switch (com) {
                    case SHOWW:
                        showWarehouseToys();
                        break;
                    case ADD:
                        addToy();
                        break;
                    case DELETE:
                        showWarehouseToys();
                        deletToy();
                        showWarehouseToys();
                        break;
                    case SHOWC:
                        showWarehouseCastToys();
                        break;
                    case ADDC:
                        addCastToy();
                        break;
                    case CAST:
                        cast();
                        break;
                    case HELP:
                        reqHelpManual();
                        break;
                    case EXIT:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Not found");
            }
        }
    }

    private void showWarehouseToys() {
        controller.showToys();
    }

    private void addToy() throws Exception {
        String name = prompt("Наименование игрушки: ");
        try {
            Integer quantity = Integer.parseInt((prompt("Количество: ")));
            
            controller.addToy(name, quantity);
        } catch (Exception e) {
            System.out.println("Ввели не число!");
        }
    }

    private void deletToy() {
        controller.delToy(reqID());

    }

    private void showWarehouseCastToys() {
        controller.showCastToys();
    }

    private void addCastToy() {
        showWarehouseToys();
        try {
            Integer ID = reqID();
            double chance = Double.parseDouble((prompt("Введите шанс: ")));
            controller.addCastToy(ID, chance);
        } catch (Exception e) {
            System.out.println("Ввели не число!");
        }
    }

    public void cast() {
        showWarehouseCastToys();
        controller.castToy(reqID());
    }

    private Integer reqID() {
        try {
            Integer ID = Integer.parseInt((prompt("Введите ID: ")));
            return ID;
        } catch (Exception e) {
            System.out.println("Ввели не число!");
        }
        return reqID();
    }

    private void reqHelpManual() {
        System.out.println("Для просмотра склада игрушек введите - SHOWW\n" +
                "Для просмотра разыгрываемых игрушек введите - SHOWC\n" +
                "Для добавления игрушек на склад введите - ADD\n" +
                "Для выбора игрушек со склада для розыгрыша введите - ADDC\n" +
                "Для удаления игрушек со склада введите - DELETE\n" +
                "Для того что бы разыграть игрушку введите - CAST\n");
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        String value = in.nextLine();
        return value;
    }

    //

}
