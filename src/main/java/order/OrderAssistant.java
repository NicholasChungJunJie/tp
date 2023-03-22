package order;

import app.Command;
import exception.OrderException;
import item.Menu;
import utility.Ui;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderAssistant {

    Ui ui;
    Scanner sc;

    private final ArrayList<String> CANCELS = new ArrayList<>() {
        {
            add("/cancel");
            add("cancel");
            add("CANCEL");
            add("/CANCEL");
        }
    };
    private final ArrayList<String> YESES = new ArrayList<>() {
        {
            add("yes");
            add("y");
            add("YES");
            add("Y");
            add("/yes");
            add("/y");
            add("/YES");
            add("/Y");
        }
    };
    private final ArrayList<String> NOS = new ArrayList<>() {
        {
            add("no");
            add("n");
            add("NO");
            add("N");
            add("/no");
            add("/n");
            add("/NO");
            add("/N");
        }
    };

    public OrderAssistant() {
        ui = new Ui();
        sc = new Scanner(System.in);
    }

    public boolean assistedAddOrder(Menu menu, Transaction transaction) throws OrderException {

        Order order;
        Command command;
        String commandString = "";

        boolean hasMoreOrderEntry = true;

        while (hasMoreOrderEntry) {

            String itemName = getItem();
            if (CANCELS.contains(itemName)) {
                return true;
            }

            String quantity = getQuantity();
            if (CANCELS.contains(quantity)) {
                return true;
            }

            String hasMoreOrderEntryString = askIfGotMoreOrderEntries();
            if (YESES.contains(hasMoreOrderEntryString)) {
                hasMoreOrderEntry = true;
            } else if (NOS.contains(hasMoreOrderEntryString)) {
                hasMoreOrderEntry = false;
            } else if (CANCELS.contains(hasMoreOrderEntryString)) {
                return true;
            }

            // Append to final command string
            commandString += "\"" + itemName + "\":" + quantity + ",";

        }

        commandString = formatCommandStringForOrders(commandString);
        command = new Command(commandString);
        order = new Order(command, menu, transaction);

        // Returns false when there are no more orderEntries to add
        return false;
    }

    private String getItem() {

        String item = "";

        ui.promptItemName();
        item = sc.nextLine();

        return item;

    }

    private String getQuantity() {

        String quantity = "";

        ui.promptItemQuantity();
        quantity = sc.nextLine();

        return quantity;
    }

    private String askIfGotMoreOrderEntries() {

        String response = "";

        ui.promptMoreOrderEntries();
        response = sc.nextLine();

        return response;
    }

    private String formatCommandStringForOrders(String ordersString) {

        // Remove trailing ,
        ordersString = ordersString.substring(0, ordersString.length() - 1);

        ordersString = "/addorder -I [" + ordersString + "]";
        return ordersString;

    }

}
