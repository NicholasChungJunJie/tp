package validation.order;

import app.Command;

import exception.DuplicateArgumentFoundException;
import exception.order.MissingMultipleOrderArgumentException;
import exception.order.MissingMultpleOrderFlagException;
import exception.order.InvalidMultipleOrderFormatException;
import exception.order.InvalidIndexNegativeException;
import exception.order.InvalidIndexNumberFormatException;
import exception.order.InvalidIndexOutOfBoundsException;
import exception.order.InvalidQuantityNumberFormatException;
import exception.order.InvalidQuantityNegativeException;
import exception.order.MultipleSimilarItemsFoundException;

import item.Menu;

public class AddMultipleAddOrderValidation extends AddOrderValidation {

    public AddMultipleAddOrderValidation(Menu menu) {
        super(menu);
    }

    /**
     * Validate the user input format
     *
     * @param arg user input
     * @return if format is valid, return the user input so can be checked in the next validation method
     * @throws MissingMultipleOrderArgumentException the command has no argument
     * @throws MissingMultpleOrderFlagException      missing -I flag
     * @throws InvalidMultipleOrderFormatException   invalid format
     * @throws InvalidQuantityNumberFormatException  quantity is not an integer
     * @throws InvalidIndexOutOfBoundsException      item index is > item size
     * @throws MultipleSimilarItemsFoundException    more than 1 search item result
     */
    public Command validateFormat(Command arg) throws MissingMultipleOrderArgumentException,
            MissingMultpleOrderFlagException, InvalidMultipleOrderFormatException,
            InvalidQuantityNumberFormatException, InvalidIndexOutOfBoundsException,
            MultipleSimilarItemsFoundException, DuplicateArgumentFoundException {

        String input = arg.getUserInput();
        String regex = "\\/addorder\\s*-I\\s*\\[((\\d+:\\d+)|([^\"]+:\\d+)|([a-zA-Z]+\\d*:\\d+))" +
                "(,((\\d+:\\d+)|([^\"]+:\\d+)|([a-zA-Z]+\\d*:\\d+)))*\\]$";
        String regex2 = "\\/addorder\\s*--items\\s*\\[((\\d+:\\d+)|([^\"]+:\\d+)|([a-zA-Z]+\\d*:\\d+))" +
                "(,((\\d+:\\d+)|([^\"]+:\\d+)|([a-zA-Z]+\\d*:\\d+)))*\\]$";
        String regex3 = "\\/addorder\\s*-I\\s*\\[((\\d+:\\d+)|(\"[^\"]+\":\\d+)|([a-zA-Z]+\\d*:\\d+))" +
                "(,((\\d+:\\d+)|(\"[^\"]+\":\\d+)|([a-zA-Z]+\\d*:\\d+)))*\\]$";
        String regex4 = "\\/addorder\\s*--items\\s*\\[((\\d+:\\d+)|([^\"]+:\\d+)|([a-zA-Z]+\\d*:\\d+))" +
                "(,((\\d+:\\d+)|([^\"]+:\\d+)|([a-zA-Z]+\\d*:\\d+)))*\\]$";
        String regex5 = "\\/addorder\\s*--items\\s*\\[((\\d+:\\d+)|(\"[^\"]+\":\\d+)|([a-zA-Z]+\\d*:\\d+))" +
                "(,((\\d+:\\d+)|(\"[^\"]+\":\\d+)|([a-zA-Z]+\\d*:\\d+)))*\\]$";

        if (!input.matches(regex) && !input.matches(regex2) && !input.matches(regex3)
                && !input.matches(regex4) && !input.matches(regex5)) {

            if (arg.getArgumentString().contains("-I") || arg.getArgumentString().contains("--items")) {

                String itemsArg = arg.getArgumentMap().get("I");

                if (itemsArg.isEmpty()) {
                    itemsArg = arg.getArgumentMap().get("items");
                }

                if (itemsArg == null || itemsArg.isEmpty()) {
                    throw new MissingMultipleOrderArgumentException();
                } else {
                    throw new InvalidMultipleOrderFormatException();
                }

            } else {
                throw new MissingMultpleOrderFlagException();
            }
        } else {
            return splitMultipleOrdersIntoArrayList(input);
        }
    }

    /**
     * Validate the arguments in the user input
     *
     * @param arg   user input
     * @param items a list of menu items
     * @throws InvalidIndexNegativeException        item index is negative
     * @throws InvalidIndexNumberFormatException    item index is not an integer
     * @throws InvalidIndexOutOfBoundsException     item index is > item list size
     * @throws InvalidQuantityNumberFormatException quantity is not an integer
     * @throws InvalidQuantityNegativeException     quantity is negative
     */
    public void validateArguments(Command arg, Menu items) throws InvalidIndexNegativeException,
            InvalidIndexNumberFormatException, InvalidIndexOutOfBoundsException,
            InvalidQuantityNumberFormatException, InvalidQuantityNegativeException {

        String input = arg.getUserInput();
        String orderPairsString = input.replaceAll("[^\\d\\s,:]", "");
        String[] orderPairs;

        if (orderPairsString.contains(",")) {
            orderPairs = orderPairsString.split(",\\s*");
        } else {
            orderPairs = new String[]{orderPairsString};
        }

        for (String order : orderPairs) {
            String[] numbers = order.trim().split(":");

            if (isInteger(numbers[0])) {
                if (Integer.parseInt(numbers[0]) < 0) {
                    throw new InvalidIndexNegativeException();
                }
                if (!isValidIndex(numbers[0], items)) {
                    throw new InvalidIndexOutOfBoundsException();
                }
            } else {
                throw new InvalidIndexNumberFormatException();
            }
            if (isInteger(numbers[1])) {
                if (Integer.parseInt(numbers[1]) <= 0) {
                    throw new InvalidQuantityNegativeException();
                }
            } else {
                throw new InvalidQuantityNumberFormatException();
            }
        }

    }

    private Command splitMultipleOrdersIntoArrayList(String input)
            throws InvalidQuantityNumberFormatException, InvalidIndexOutOfBoundsException,
            InvalidMultipleOrderFormatException, MultipleSimilarItemsFoundException, DuplicateArgumentFoundException {

        int startOfArgumentsIndex;
        int startOfArgumentsIndexWhenShortFlagUsed = 14;
        int startOfArgumentsIndexWhenLongFlagUsed = 19;

        if (input.contains("-I")) {
            startOfArgumentsIndex = startOfArgumentsIndexWhenShortFlagUsed;
        } else {
            startOfArgumentsIndex = startOfArgumentsIndexWhenLongFlagUsed;
        }

        String orderPairsString = input.substring(startOfArgumentsIndex);
        orderPairsString = orderPairsString.substring(0, orderPairsString.length() - 1);

        String[] orderPairs;

        if (orderPairsString.contains(",")) {
            orderPairs = orderPairsString.split(",\\s*");
        } else {
            orderPairs = new String[]{orderPairsString};
        }

        return castIntoProCommandFormat(orderPairs);

    }

    private Command castIntoProCommandFormat(String[] orderPairs)
            throws InvalidIndexOutOfBoundsException, InvalidQuantityNumberFormatException,
            InvalidMultipleOrderFormatException, MultipleSimilarItemsFoundException,
            DuplicateArgumentFoundException {

        String index;
        String finalCommandString = "";


        for (String order : orderPairs) {

            String[] elements = order.trim().split(":");

            if (elements[0].contains("\"")) {
                elements[0] = elements[0].replace("\"", "");
            }

            if (!isInteger(elements[0])) {

                if (!super.checkValidItemName("\"" + elements[0] + "\"")) {
                    throw new MultipleSimilarItemsFoundException();
                }

                index = Integer.toString(super.getMenu().findItemIndex(elements[0]));
                elements[0] = index;
            }

            if (elements.length == 2 && isInteger(elements[0]) && isInteger(elements[1])) {

                String itemIndex = elements[0];

                if (!(isValidIndex(itemIndex, super.getMenu()))) {
                    throw new InvalidIndexOutOfBoundsException();
                }

                if (Integer.parseInt(elements[1]) <= 0) {
                    throw new InvalidQuantityNumberFormatException();
                }

                finalCommandString += elements[0] + ":" + elements[1] + ",";

            } else {
                throw new InvalidMultipleOrderFormatException();
            }

        }

        finalCommandString = finalCommandString.substring(0, finalCommandString.length() - 1);

        assert true : "This is true";

        return new Command("/addorder -I [" + finalCommandString + "]");

    }

}
