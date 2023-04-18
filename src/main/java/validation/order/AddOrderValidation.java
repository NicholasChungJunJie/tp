package validation.order;

import app.Command;
import exception.DuplicateArgumentFoundException;
import exception.item.NoSuchItemException;
import exception.order.MissingOrderFlagException;
import exception.order.MissingOrderArgumentException;
import exception.order.MissingQuantityArgumentException;
import exception.order.InvalidIndexNumberFormatException;
import exception.order.InvalidIndexNegativeException;
import exception.order.InvalidIndexOutOfBoundsException;
import exception.order.InvalidQuantityNumberFormatException;
import exception.order.InvalidQuantityNegativeException;
import exception.order.MultipleSimilarItemsFoundException;
import item.Menu;
import ui.Flags;
import ui.TransactionUi;
import validation.Validation;

/**
 * Handles order related input validation
 */
public class AddOrderValidation extends Validation {
    private Menu menu;

    private TransactionUi transactionUi;

    public AddOrderValidation(Menu menu) {
        this.menu = menu;
        this.transactionUi = new TransactionUi();
    }

    public boolean validateItemName(Command command)
            throws DuplicateArgumentFoundException, MultipleSimilarItemsFoundException, NoSuchItemException {

        command.mapArgumentAlias("item", "i");

        String item;

        if (command.getArgumentString().contains("-i")) {
            item = command.getArgumentMap().get("i");
            if (isInteger(item)) {
                return true;
            }
        } else {
            item = command.getArgumentMap().get("item");
        }


        return checkIfSingleItemNameValid(item);

    }

    public boolean checkIfSingleItemNameValid(String itemName)
            throws DuplicateArgumentFoundException, MultipleSimilarItemsFoundException, NoSuchItemException {

        if (menu.findMatchingItemNames(itemName).size() > 1) {
            transactionUi.printError(Flags.Error.MULTIPLE_SIMILAR_ITEMS);
            Command findItemCommand = new Command("finditem " + itemName);
            menu.showResultsOfFindWithoutSuccessMsg(findItemCommand);
            throw new MultipleSimilarItemsFoundException();
        } else if (menu.findMatchingItemNames(itemName).size() == 0) {
            throw new NoSuchItemException();
        }

        return true;
    }

    public boolean checkValidItemName(String itemName) throws DuplicateArgumentFoundException {

        if (!isInteger(itemName)) {
            if (!(itemName.substring(0, 1).equals("\"")) ||
                    !(itemName.substring(itemName.length() - 1).equals("\""))) {
                transactionUi.printError(Flags.Error.MISSING_QUOTES);
                return false;
            }

            // Strip itemName of double quotes
            if (!isInteger(itemName)) {
                itemName = itemName.substring(1, itemName.length() - 1);
            }

            if (menu.findMatchingItemNames(itemName).size() > 1) {
                transactionUi.printError(Flags.Error.MULTIPLE_SIMILAR_ITEMS);
                Command findItemCommand = new Command("finditem " + itemName);
                menu.showResultsOfFindWithoutSuccessMsg(findItemCommand);
                return false;
            } else if (menu.findMatchingItemNames(itemName).size() == 0) {
                transactionUi.printError(Flags.Error.NO_SUCH_ITEM);
                return false;
            }

        } else {
            if (Integer.parseInt(itemName) < 0) {
                transactionUi.printError(Flags.Error.INVALID_INDEX);
                return false;
            } else if (Integer.parseInt(itemName) >= menu.getItems().size()) {
                transactionUi.printError(Flags.Error.INVALID_INDEX);
                return false;
            }
        }


        return true;
    }

    public boolean checkValidQuantity(String quantity) {
        if (!isInteger(quantity)) {
            transactionUi.printError(Flags.Error.INVALID_QUANTITY_FORMAT);
            return false;
        }

        if (Integer.parseInt(quantity) < 0) {
            transactionUi.printError(Flags.Error.INVALID_NEGATIVE_QUANTITY);
            return false;
        }

        return true;
    }

    /**
     * Validate the item index and quantity
     *
     * @param arg  user command
     * @param menu menu
     */
    public Command validateCommand(Command arg, Menu menu)
            throws DuplicateArgumentFoundException, NoSuchItemException {
        assert arg.getUserInput() != null : "Null input should be handled";
        String item = "";
        String newItem = "";

        if (arg.getArgumentString().contains("-i")) {
            item = arg.getArgumentMap().get("i").trim();
        } else if (arg.getArgumentString().contains("--item")) {
            item = arg.getArgumentMap().get("item").trim();
        }

        if (!isInteger(item)) {
            newItem = Integer.toString(menu.findItemIndex(item));

            if (Integer.valueOf(newItem) == -1) {
                throw new NoSuchItemException();
            }

            String newArgumentString = arg.getArgumentString().replace(item, newItem);
            Command newCommand = new Command("/addorder " + newArgumentString);
            return newCommand;
        }

        return arg;
    }

    /**
     * Check if the user input contains the valid flag and arguments
     *
     * @param arg user input
     * @throws MissingOrderFlagException        missing -i flag
     * @throws MissingOrderArgumentException    missing argument
     * @throws MissingQuantityArgumentException missing argument for -q flag
     */
    public void validateFlag(Command arg)
            throws MissingOrderFlagException, MissingOrderArgumentException, MissingQuantityArgumentException {
        if (arg.getArgumentString().contains("-i") || arg.getArgumentString().contains("--item")) {
            if (arg.getArgumentMap().get("i") == null && arg.getArgumentMap().get("item") == null) {
                throw new MissingOrderArgumentException();
            }
        } else {
            throw new MissingOrderFlagException();
        }

        if (arg.getArgumentString().contains("-q") || arg.getArgumentString().contains("--quantity")) {
            if (arg.getArgumentMap().get("q") == null && arg.getArgumentMap().get("quantity") == null) {
                throw new MissingQuantityArgumentException();
            }

        }
    }

    /**
     * Validate the item index in the user input
     *
     * @param arg  user input
     * @param menu list of menu items
     * @throws InvalidIndexNumberFormatException item index is not an integer
     * @throws InvalidIndexNegativeException     item index is negative
     * @throws InvalidIndexOutOfBoundsException  item index > menu size
     */
    public void validateIndex(Command arg, Menu menu)
            throws InvalidIndexNumberFormatException, InvalidIndexNegativeException, InvalidIndexOutOfBoundsException,
            DuplicateArgumentFoundException {

        arg.mapArgumentAlias("i", "item");

        if (!isInteger(arg.getArgumentMap().get("i").trim())) {
            throw new InvalidIndexNumberFormatException();
        } else {
            int index = Integer.parseInt(arg.getArgumentMap().get("i").trim());
            if (index < 0) {
                throw new InvalidIndexNegativeException();
            } else if (!isValidIndex(Integer.toString(index), menu)) {
                throw new InvalidIndexOutOfBoundsException();
            }
        }
    }

    /**
     * Validate quantity in the user input
     *
     * @param arg user input
     * @throws InvalidQuantityNumberFormatException quantity is not an integer
     * @throws InvalidQuantityNegativeException     quantity is less than 0
     */
    public void validateQuantity(Command arg)
            throws InvalidQuantityNumberFormatException, InvalidQuantityNegativeException,
            DuplicateArgumentFoundException {

        arg.mapArgumentAlias("q", "quantity");

        if (arg.getArgumentMap().get("q") != null) {
            if (!isInteger(arg.getArgumentMap().get("q").trim())) {
                throw new InvalidQuantityNumberFormatException();
            } else {
                int quantity = Integer.parseInt(arg.getArgumentMap().get("q").trim());
                if (quantity <= 0) {
                    throw new InvalidQuantityNegativeException();
                }
            }
        }

    }

    /**
     * Check if the input is integer
     *
     * @param input the user input after flags
     * @return validation outcome (true/false)
     */
    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException n) {
            return false;
        }

        return true;
    }

    public Menu getMenu() {
        return menu;
    }

}



