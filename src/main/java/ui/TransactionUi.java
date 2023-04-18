package ui;

import order.Order;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class TransactionUi extends Ui {

    public void promptMoreOrderEntries() {
        System.out.println("\nDo you have more items to add? (yes/no/cancel)");
    }

    public void promptPayment() {
        System.out.println("\nPlease use /pay -a <amount> -t <type> or pay to make payment.");
    }

    public void promptOrderID() {
        System.out.println("\nPlease enter order ID to refund order.");
    }

    public void promptPaymentAmount() {
        System.out.println("\nPlease enter amount to pay.");
    }

    public void promptPaymentType() {
        System.out.println("\nPlease enter payment type.");
    }

    public void promptItemQuantity() {
        System.out.println("\nPlease enter the quantity of the item: ");
    }

    public void promptItemName() {
        System.out.println("\nPlease enter the item's name or index: ");
    }

    public void printChangeGiven(Double change) {
        System.out.printf("\nThe calculated change is $%.2f.\n", change);
    }

    public void printOrderList(ArrayList<Order> orders) {

        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println("\n================================================\n");
        if (orders.size() != 0) {
            for (int i = 0; i < orders.size(); i++) {

                System.out.println("Order " + (i + 1));
                System.out.println("Order ID: " + orders.get(i).getOrderId());
                System.out.println("Order status: " + orders.get(i).getStatus());
                System.out.println("Order time: " + orders.get(i).getFormatDateTime());

                for (int j = 0; j < orders.get(i).getOrderEntries().size(); j++) {
                    System.out.println((j + 1) + ". "
                            + orders.get(i).getOrderEntries().get(j).getItem().getName()
                            + " x" + orders.get(i).getOrderEntries().get(j).getQuantity());
                }

                String subtotal = df.format(orders.get(i).getSubTotal());
                System.out.println("\nSubtotal: $" + subtotal);
                System.out.println("\n================================================");
            }
        } else {
            System.out.println("\nOrder list is empty.\n");
        }

    }


    public void printSuccessfulPayment() {
        System.out.println("\nOrder has been paid!\n");
    }

    public void printSuccessfulListOrder() {
        System.out.println("\nAll transactions have been listed!\n");
    }

    public void printSuccessfulRefundOrder() {
        System.out.println("\nThe order's status is now refunded!\n");
    }

    public void printEmptyTransaction() {
        System.out.println("\nThere is no order to refund!\n");
    }

    public void printOrderAdded(Double total) {
        DecimalFormat df = new DecimalFormat("#.00");
        String subtotal = df.format(total);
        System.out.println("\nSubtotal: $" + subtotal);
        System.out.println("Order has been added successfully.");
    }

    public void printInvalidInputEntered() {

        System.out.println("\nInvalid input entered.\n");
    }

    @Override
    public void printError(Flags.Error error) {
        System.out.print("\nError: ");
        switch (error) {
        //addorder flags
        case MISSING_ORDER_FLAG:
            System.out.println("Please input the item's index using -i <index> or --item <index>.\n");
            break;
        case MISSING_ORDER_FLAG_ARGUMENT:
            System.out.println("Item index is empty. Please enter the item index.\n");
            break;
        case MISSING_QUANTITY_FLAG_ARGUMENT:
            System.out.println("Quantity is empty. Please enter the quantity.\n");
            break;
        case INVALID_ORDER_ITEM_INDEX_FORMAT:
            System.out.println("Index must be a number.\n");
            break;
        case NEGATIVE_ORDER_ITEM_INDEX:
            System.out.println("Index cannot be negative.\n");
            break;
        case INVALID_ORDER_ITEM_INDEX_OUT_OF_BOUNDS:
            System.out.println("Index does not exist.\n");
            break;
        case INVALID_QUANTITY_FORMAT:
            System.out.println("Quantity must be a number.\n");
            break;
        case INVALID_NEGATIVE_QUANTITY:
            System.out.println("Quantity must be more than 0.\n");
            break;
        case NO_SUCH_ITEM:
            System.out.println("No such item exists.\n");
            break;
        case MULTIPLE_SIMILAR_ITEMS:
            System.out.println("Multiple items with similar names found. Please enter a more specific item name!" +
                    "\nHere are a list of items that matched your input:");
            break;
        //add multiple order flags
        case INVALID_MULTIPLE_ORDER_FORMAT_EXCEPTION:
            System.out.println("Please use the correct format: /addorder -I [index:quantity].\n");
            break;
        case MISSING_MULTIPLE_ORDER_ARGUMENT_EXCEPTION:
            System.out.println("Please specify the item index " +
                    "and quantity in [index:quantity] format after the flag.\n");
            break;
        case MISSING_MULTIPLE_ORDER_FLAG_EXCEPTION:
            System.out.println("Please use -I or --items flag to add multiple orders.\n");
            break;
        //payment flags
        case INVALID_PAY_TYPE:
            System.out.println("Please enter a valid payment type (Card/Cash/Others).\n");
            break;
        case INVALID_PAYMENT_AMOUNT_FOR_CARD:
            System.out.println("Please input exact amount for card payment.\n");
            break;
        case INVALID_PAY_AMOUNT_NEGATIVE:
            System.out.println("Payment amount must be more than 0.\n");
            break;
        case INVALID_PAY_AMOUNT_FORMAT:
            System.out.println("Payment amount must be a number.\n");
            break;
        case INVALID_PAY_AMOUNT_DECIMAL_PLACE:
            System.out.println("Payment amount cannot have more than 2 decimal place.\n");
            break;
        case INSUFFICIENT_PAY_AMOUNT:
            System.out.println("Insufficient amount. Payment amount must be more than or equals to subtotal.\n");
            break;
        case MISSING_PAY_TYPE_FLAG:
            System.out.println("Please include the payment type using -t or --type <type>.\n");
            break;
        case MISSING_PAY_TYPE_ARGUMENT:
            System.out.println("Payment type cannot be empty.\n");
            break;
        case MISSING_PAY_AMOUNT_FLAG:
            System.out.println("Please include the payment amount using -a or --amount <amount>.\n");
            break;
        case MISSING_PAY_AMOUNT_ARGUMENT:
            System.out.println("Payment amount cannot be empty.\n");
            break;
        case MISSING_PAY_COMMAND:
            System.out.println("Please use /pay -a <amount> -t <type> to make payment.\n");
            break;
        //refund flags
        case MISSING_REFUND_ORDER_FLAG:
            System.out.println("Please include the order ID using -i or --id <order id>.\n");
            break;
        case MISSING_REFUND_ORDER_ARGUMENT:
            System.out.println("Order ID cannot be empty.\n");
            break;
        case MISSING_QUOTES:
            System.out.println("The entered item name must either be an index from /listitem " +
                    "or be the actual or part of the item name, surrounded with \" \"." +
                    "\nFor example, \"Chicken Rice\".\n");
            break;
        case INVALID_REFUND_ORDER_ID:
            System.out.println("Invalid order ID.\n");
            break;
        case INVALID_REFUND_ORDER_TYPE:
            System.out.println("Order is already refunded.\n");
            break;
        case INVALID_INDEX:
            System.out.println("You have entered an invalid item index.\n");
            break;
        default:
            // Fallthrough
        }
    }

}


