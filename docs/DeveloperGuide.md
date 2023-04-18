# Developer Guide

<div style="width:30%; height:auto; margin-left: auto; margin-right: auto;">


<img src="https://i.imgur.com/ptkwkny.png">


</div>

## Table of Contents

* [Acknowledgements](#acknowledgements)
* [Introduction](#introduction)
* [Design](#design)
* [Implementation](#implementation)
    * [Item Commands](#item-commands)
    * [Order Commands](#order-commands)
    * [Report Commands](#report-commands)
* [Requirements](#requirements)
    * [Project Scope](#project-scope)
    * [User Stories](#user-stories)
    * [Non-functional Requirements](#non-functional-requirements)
    * [Glossary](#glossary)
* [Appendix](#appendix)
    * [Instructions for manual testing](#instructions-for-manual-testing)

<div style="page-break-after: always;"></div>

## Acknowledgements

We would like to acknowledge [Address Book (Level-3)](https://github.com/se-edu/addressbook-level3) as we have
referenced their [User Guide (UG)](https://se-education.org/addressbook-level3/UserGuide.html)
and [Developer Guide (DG)](https://se-education.org/addressbook-level3/DeveloperGuide.html) to structure our
documentation.

## Introduction

The aim of this guide is to provide a comprehensive explanation of the internal mechanisms of MoneyGoWhere.
This will enable upcoming software engineers to acquire a detailed understanding of the application's implementation,
making it easier for them to work on the project.

For all sequence diagrams included in this guide, we will not include the interaction
with the [Parser](#glossary) and Router classes as it is implied that all inputs will first be parsed through them.

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

## Design

### Architecture Design

![](./images/developersGuide/architectureDiagram.png)
<br>
*Figure 1: Architecture diagram to illustrate the high-level design of MoneyGoWhere application.*

### Overview of components

`Main`

- Upon app launch, its sole purpose is to create an instance of `MoneyGoWhere`.

`MoneyGoWhere`

- Upon creation, it initialises and loads `Menu` and `Transaction` from [storage](#glossary) and caches them.
- On run, it initialises [`Ui`](#glossary) and `Router` and runs the following in a loop:
    - [`Ui`](#glossary) receives user input and uses `Command` to format the input so that it can be understood by the
      application.
    - The `Command` is then passed to the `Router` for further processing.

[`Ui`](#glossary)

- Handles the process of obtaining user input and presenting the application's output to the user.

[`Parser`](#glossary)

- Handles the process of formatting user input for the `Command`.
- Handles the formatting of the `Menu` and `Transaction` components for the `Store`.

`Command`

- Work closely with [`Parser`](#glossary) to ensure that user input is accurately formatted.
- Stores the necessary information in a comprehensible format that can be readily utilised across the application.

`Router`

- Given the `Command`, it identifies the appropriate function to execute.

`Validation`

- Oversees the validation process of the components within `Transaction`, `Menu`, `Payment`, or `Statistic`, ensuring
  that user input aligns with our requirements.

`Transaction`

- Maintain a list of orders and its corresponding details.
- Any changes made to the list will be saved to the file defined by `Store`. More elaboration is provided in later
  sections.

`Menu`

- Maintain a list of items and its corresponding details
- Any changes made to the list will be saved to the file defined by `Store`. More elaboration is provided in later
  sections.

`Payment`

- Handles every payment and refund process for every new and existing orders in `Transaction`.

`Statistic`

- This component uses the data in `Transaction` to generate the relevant performance report for the user to analyse.

`Store`

- Handles the [storage](#glossary) operation of the application.

###### [Back to table of contents](#table-of-contents)

<hr>
<div style="page-break-after: always;"></div>
### MoneyGoWhere Component

![](./images/developersGuide/MoneyGoWhereComponent.png)
<br>
*Figure 2: Class diagram for MoneyGoWhere component*

`MoneyGoWhere` is initialised by the `Main` class and has a series of jobs to perform.

First, it initialises and maintains the instance of `Menu` and `Transaction` objects.

After initialisation, it will proceed to run a loop which prompts the user for their input. When it receives an input
from the user, it will invoke `Command` to stores the information in a comprehensible format.

The [`Parser`](#glossary) is a helper class that assists the `Command` object to extract and format the relevant
information from the given user input.

After the `Command` object has been successfully parsed, it will be handed over to `Router` to determine which methods
to run.

If `MoneyGoWhere` detects that the user entered the command `exit`, the application will terminate the loop.

<hr>

### Menu Component

![](./images/developersGuide/MenuComponent.png)
<br>
*Figure 3: Class diagram for Menu component*

The `Menu` component is a crucial part of `MoneyGoWhere`, responsible for managing and accessing all data related to
menu commands.

Whenever a menu command is entered, the `Router` in the `MoneyGoWhere` component will pass the `Command` object to
the `Menu` component for further processing.

The `Menu` component comprises 3 main classes: `Menu`, `Item`, and `MenuAssistant`.

The `Item` class represents a specific menu item created by the user, containing its name and price.

The `Menu` class is a handy container that keeps track of all `Item` objects created by the user. It offers convenient
methods to modify the list of items and manipulate the corresponding `Item` objects.

In addition to managing and accessing all data related to menu commands, the `Menu` class also ensures that all values
passed to its corresponding methods are valid, by utilising the `Validation` component.

The `MenuAssistant` class offers a user-friendly interface for the user to interact with the items in the `Menu` object.
It makes use of the `MenuAssistantUi` class to provide an intuitive and guided way for users to manage their menu.

<hr>

### Transaction Component

![](./images/developersGuide/TransactionComponent.png)
<br>
*Figure 4: Class diagram for Transaction component*

The `Transaction` component is another crucial part of `MoneyGoWhere`, responsible for managing and accessing all data
related to order commands.

Whenever a order command is entered, the `Router` in the `MoneyGoWhere` component will pass the `Command` object to
the `Transaction` component for further processing.

The `Transaction` component comprises 4 classes: `Transaction`, `Order`, `OrderEntry` and `OrderAssistant`.
Additionally, this component also has an interface: `ComputeOrder`.

The `OrderEntry` class represents an item in the menu and the corresponding quantity entered by the user.

The `Order` class serves as a data structure that contains a list of `OrderEntry` objects along with information such as
order id, date, time and status. It also calculates the subtotal using the `ComputeOrder` interface.

The `Transaction` class acts as a container, tracking all `Order` objects generated by the user, and providing methods
to add new orders to the `Order` list.

The `Validation` component is utilised by the `Transaction` class to ensure the validity of all values passed to its
methods.

The `OrderAssistant` class offers a user-friendly interface for the user to add new orders to the `Transaction` object,
leveraging the `TransactionUi` class to offer an intuitive and guided experience for users.

<hr>

### Payment Component

![](./images/developersGuide/PaymentComponent.png)
<br>
*Figure 5: Class diagram for Payment component*

The `Payment` component serves as an extension to the `Transaction` component. It enables updates to be made to the
status and payment type in the given `Order` object.

Whenever a pay or refund command is entered, the `Router` in the `MoneyGoWhere` component will pass the `Command` object
to the `Payment` component for further processing.

The `Payment` component comprises 4 main classes: `Payment`, `Refund`, `PaymentAssistant` and `RefundAssistant`.

When presented with both an `Order` object and the user-provided amount value, the `Payment` class takes care of
updating the order status and calculating the necessary change. This information is then displayed to the user through
the `TransactionUi` class.

The `Refund` class searches for the user-provided order-id in the `Transaction` object's `Order` list. Once found, it
updates the status of that particular `Order` object.

The `Validation` component is utilised by both the `Payment` and `Refund` class to ensure the validity of all values
passed to its methods.

The `PaymentAssistant` and `RefundAssistant` classes provide an intuitive and user-friendly interface for users to
perform the above-mentioned functions. By leveraging on the `TransactionUi` class, these assistant classes offer a
guided experience for users.

<hr>

### Statistic Component

![](./images/developersGuide/StatisticComponent.png)
<br>
*Figure 6: Class diagram for Statistic component*

The `Statistic` component provides a reporting feature for `MoneyGoWhere`.

Whenever a report command is entered, the `Router` in the `MoneyGoWhere` component will pass the `Command` object to
the `Statistic` component for further processing.

The `Payment` component comprises 4 main classes: `Statistic`, `SalesReport`, `RankReport`, `ItemRank`, `Chart`

The `Statistic` class is a parent class for both `SalesReport` and `RankReport` classes.

When presented with both a `Transaction` object and the user-provided date range, the `SalesReport` class filters and
generates relevant sales-related reports based on the transactions within the date range.

The `Chart` class uses the `StatisticUi` class to generate an intuitive bar chart from the `SalesReport` object.

When presented with the `Transaction` object, the `RankReport` class ranks items in the `Menu` object based on quantity
sold or revenue made and display the results in a table using the `StatisticUi` class.

The `ItemRank` is a wrapper class that stores the name and values for the `RankReport` to compute the ranking of the
items.

The `Validation` component is utilised by the `Statistic` class and its children to ensure the validity of all values
passed to its methods.

<hr>

### Store Component

![](./images/developersGuide/StoreComponent.png)
<br>
*Figure 7: Class diagram for Store component*

The `Store` class facilitates the saving and loading of both `Transaction` and `Menu` objects to and from
the `./datastore` directory.

Both `Transaction` and `Menu` objects undergo JSON serialisation prior to being persisted to a file through
the [`Parser`](#glossary) component.

The [`Parser`](#glossary) component parses the JSON data retrieved from the file, converting it into either
a `Transaction` or `Menu` object.

<hr>

### Ui Component

![](./images/developersGuide/UiComponent.png)
<br>
*Figure 8: Class diagram for [Ui](#glossary) component*

The `Ui` component manages the process of gathering user input and displaying the application's output to the user.

The `Ui` class encompasses all common Ui elements utilised throughout the `MoneyGoWhere` application, including the
essential function of accepting user input.

The `MenuUi` and `MenuAssistantUi` classes are responsible for menu-related Ui.

The `TransactionUi` class are responsible for order-related Ui.

The `StatisticUi` class are responsible for statistic-related Ui.

The `StoreUi` class are responsible for store-related Ui.

The [`Flag`](#glossary) enumeration is a comprehensive collection of all error [flags](#glossary) utilised throughout
the entirety of the MoneyGoWhere application.

<hr>

### Validation Component

![](./images/developersGuide/ValidationComponent.png)
<br>
*Figure 9: Class diagram for Validation component*

The `Validation` component validates user input data before processing.

Each class within the `Validation` component is dedicated to validating a specific command.

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

## Implementation

### Item Commands

#### Overview

* [Add an Item](#add-an-item)
    * [Experienced Mode](#experienced-mode-add-an-item)
    * [New User Mode](#new-user-mode-add-an-item)
* [Delete an Item](#delete-an-item)
    * [Experienced Mode](#experienced-mode-delete-an-item)
    * [New User Mode](#new-user-mode-delete-an-item)
* [List all Items](#list-all-items)
* [Update an Item](#update-an-item)
    * [Experienced Mode](#experienced-mode-update-an-item)
    * [New User Mode](#new-user-mode-update-an-item)
* [Find an Item](#find-an-item)
    * [Experienced Mode](#experienced-mode-find-an-item)
    * [New User Mode](#new-user-mode-find-an-item)

<hr>

#### Add an Item

##### Experienced Mode Add an Item

The expected inputs to add only one menu item into an order is as such:

* `/additem -n <item_name> -p <price>`

This sequence diagram models the interaction between various components in MoneyGoWhere when the user inputs the
command `/additem`.

![](./images/developersGuide/SequenceDiagrams/Item/addItem.png)

The general workflow of `/additem` is as follows:

1. User input is passed to `MoneyGoWhere`.
2. `MoneyGoWhere` then creates a new `Command` object using the user input, whose constructor invokes
   `Parser#formatArguments` method to extract the arguments for each flag into a `Map`.
3. `Router#handleRoute` is then invoked to process the command and calls `Router#proRoute` which invokes `Menu#addItem`
   method to run the `/additem` command.
4. Once the command runs, `Menu#addItem` invokes `AddItemValidation#validateFlags` to check if all the required flags
   have been given.
    * If there are missing flags, a message indicating that the usage is invalid will be printed using `Ui#println` and
      control is given back to `MoneyGoWhere`.
5. `Menu#addItem` then invokes `AddItemValidation#validateCommand` which in turn, calls all the following validation
   method to check the arguments provided.
    * `AddItemValidation#validateArgument` checks if the user input `String` is empty.
        * If the user input is empty, a message indicating that the input is empty is printed using `MenuUi#printError`
          and control is given back to `MoneyGoWhere`.
    * `AddItemValidation#validateName` checks if the given name is empty or exceeds the limit of 25 characters.
        * If the name violates these naming constraints, a message indicating that the name is too short or too long is
          printed using `MenuUi#printError` and control is given back to `MoneyGoWhere`.
    * `AddItemValidation#validateDuplicateName` checks if the given name already exists in the `ArrayList<Item> items`
      of `Menu`.
        * If the name already exists, a message indicating that the item name already exists is printed using
          `MenuUi#printError` and control is given back to `MoneyGoWhere`.
    * `AddItemValidation#validatePrice` checks if the given price is empty, is not a number, is negative or has more
      than 2 decimal points.
        * If any of the above is true, a message indicating the constraint that it has violated is printed using
          `MenuUi#printError` and control is given back to `MoneyGoWhere`.
6. `Menu#processAddItem` is then invoked, and it creates a new `Item` object using the name and price given. It then
   calls `Menu#appendItem` on the new `Item` object to add it to `ArrayList<Item> items` in `Menu`.
   Then, `Menu#save` is invoked to save the changes to the local storage file.
7. The `Router` object then calls `MenuUi#printCommandSuccess` to print a message indicating that the item has been
   successfully added to the menu.

##### New User Mode Add an Item

The expected inputs to add only one menu item into an order is as such:

* `additem`
* `1`

The sequence diagram is similar to the `Experienced Mode Add an Item`.

The general workflow of `additem` is as follows:

1. `MoneyGoWhere` creates a new `Command` object using the user input, whose constructor invokes the
   `Parser#formatArguments` method to extract the arguments for each flag into a `Map`.
2. `Router#handleRoute` is then invoked to process the command and calls `Router#assistRoute` which invokes the
   `MenuAssistant#addItem` method to run the `additem` command.
3. Once the command runs, it can be aborted at any time before completion when the user inputs `/cancel`.
4. `MenuAssistant#addItem` invokes `MenuAssistant#getName` to get the name of the item to be added.
5. `MenuAssistant#getName` gets the name from the user and invokes `AddItemValidation#validateName` to check if the
   given name is empty or exceeds the limit of 25 characters and `AddItemValidation#validateDuplicateName` to check if
   the given name already exists in the `ArrayList<Item> items` of `Menu`.
    * If the name violates these naming constraints, a message indicating that the name is too short or too long is
      printed using `MenuUi#printError` and re-prompts the user to enter a new name.
    * If the name already exists, a message indicating that the item name already exists is printed using
      `MenuUi#printError` and re-prompts the user to enter a new name.
6. `MenuAssistant#addItem` then invokes `MenuAssistant#getPrice` to get the price of the item to be added.
7. `MenuAssistant#getPrice` gets the price from the user and invokes `AddItemValidation#validatePrice` to check if the
   given price is empty, is not a number, is negative or has more than 2 decimal points.
    * If any of the above is true, a message indicating the constraint that it has violated is printed using
      `MenuUi#printError` and re-prompts the user to enter a new price.
8. A new `Item` object is then created using the name and price given by the user.
9. `Menu#appendItem` is invoked on the new `Item` object to add it to `ArrayList<Item> items` in `Menu`.
10. Then, `Menu#save` is invoked to save the changes to the local storage file.
11. `Router#assistRoute` then calls `MenuAssistant#printResult` to print a message indicating that either the item has
    been successfully added to the menu, or the user has cancelled the command.

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

#### Delete an Item

##### Experienced Mode Delete an Item

The expected inputs to delete only one menu item into an order is as such:

* `/deleteitem -i <index>`

This sequence diagram models the interaction between various components in MoneyGoWhere when the user inputs the
command `/deleteitem`.

![](./images/developersGuide/SequenceDiagrams/Item/deleteItem.png)

The general workflow of `/deleteitem` is as follows:

1. User input is passed to `MoneyGoWhere`.
2. `MoneyGoWhere` then creates a new `Command` object using the user input, whose constructor invokes
   `Parser#formatArguments` method to extract the arguments for each flag into a `Map`.
3. `Router#handleRoute` is then invoked to process the command and calls `Router#proRoute` which invokes
   `Menu#deleteItem` method to run the `/deleteitem` command.
4. Once the command runs, `Menu#deleteItem` checks if the list of items is empty. If empty, a message indicating that
   there is nothing to be deleted using `MenuUi#printError` and control is given back to `MoneyGoWhere`.
5. `Menu#deleteItem` invokes `DeleteItemValidation#validateFlags` to check if all the required flags have been given.
    * If there are missing flags, a message indicating that the usage is invalid will be printed using
      `MenuUi#printError` and control is given back to `MoneyGoWhere`.
6. `Menu#deleteItem` then invokes `DeleteItemValidation#validateCommand` which in turn, calls the following
   validation methods to check the arguments provided.
    * `DeleteItemValidation#validateArgument` checks if the user input `String` is empty
        * If the user input is empty, a message indicating that the input is empty is printed using `MenuUi#printError`
          and control is given back to `MoneyGoWhere`.
    * `DeleteItemValidation#validateIndex` checks if the given index is valid and exists
        * If the index is invalid, a message indicating the index does not exist is printed using `MenuUi#printError`
          and control is given back to `MoneyGoWhere`.
7. `Menu#processDeleteItem` is then invoked, and it calls `Menu#removeItem` on the given index to delete it from the
   list of items. Then, `Menu#save` is invoked to save the changes to the local storage file.
8. `Router` object then calls `MenuUi#printCommandSuccess` to print a message indicating that the item has been
   successfully added to the menu.

##### New User Mode Delete an Item

The expected inputs to delete only one menu item into an order is as such:

* `deleteitem`
* `2`

The sequence diagram is similar to the `Experienced Mode Delete an Item`.

The general workflow of `deleteitem` is as follows:

1. `MoneyGoWhere` then creates a new `Command` object using the user input, whose constructor invokes
   `Parser#formatArguments` method to extract the arguments for each flag into a `Map`.
2. `Router#handleRoute` is then invoked to process the command and calls `Router#assistRoute` which invokes
   `MenuAssistant#deleteItem` method to run the `deleteitem` command.
3. Once the command runs, it can be aborted at any time when the user inputs `/cancel`.
4. `MenuAssistant#deleteItem` checks if the list of items is empty. If empty, a message indicating that there is
   nothing to be deleted using `MenuUi#printError` and control is given back to `MoneyGoWhere`.
5. `MenuAssistant#deleteItem` invokes `MenuAssistant#getIndex` to get the index of the item to be deleted.
6. `MenuAssistant#getIndex` gets the index from the user and invokes `DeleteItemValidation#validateIndex` if the given
   index is valid and exists.
    * If the index is invalid, a message indicating the index does not exist is printed using `MenuUi#printError`
      and re-prompts the user to enter a new index.
7. `Menu#removeItem` is then invoked on the given index to delete it from the list of items. Then, `Menu#save` is
   invoked to save the changes to the local storage file.
8. `Router#assistRoute` then calls `MenuAssistant#printResult` to print a message indicating that if the item has been
   successfully added to the menu or if the user has cancelled the command accordingly.

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

#### List all Items

The expected inputs to list all item is as such:

* `/listitem`
* `listitem`
* `3`

This sequence diagram models the interaction between various components in MoneyGoWhere when the user inputs any of the
commands above.

![](./images/developersGuide/SequenceDiagrams/Item/listItem.png)

Note that the work flow for both Basic and Experienced Mode is the same.

The general workflow of `/listitem` is as follows:

1. `MoneyGoWhere` then creates a new `Command` object using the user input.
2. `Router#handleRoute` is then invoked to process the command and calls `Router#assistRoute` or `Router#proRoute` which
   invokes `MenuAssistant#displayList` method to run the `/listitem` command.
3. The menu items list will be printed onto the console.

###### [Back to table of contents](#table-of-contents)

<hr>

#### Update an Item

##### Experienced Mode Update an Item

The expected inputs to update only one menu item into an order is as such:

* `/updateitem -i <index> -n <name> -p <price>`, where `-n <name>` and `-p <price>` are optional, but at least one of
  them must be present.

This sequence diagram models the interaction between various components in MoneyGoWhere when the user inputs the
command `/updateitem`.

![](./images/developersGuide/SequenceDiagrams/Item/updateItem.png)

The general workflow of `/updateitem` is as follows:

1. User input is passed to `MoneyGoWhere`.
2. `MoneyGoWhere` then creates a new `Command` object using the user input, whose constructor invokes
   `Parser#formatArguments` method to extract the arguments for each flag into a `Map`.
3. `Router#handleRoute` is then invoked to process the command and calls `Router#proRoute` which invokes
   `Menu#updateItem` method to run the `/updateitem` command.
4. Once the command runs, `Menu#updateItem` checks if the list of items is empty. If empty, a message indicating that
   there is nothing to be updated is printed using `MenuUi#printError` and control is given back to `MoneyGoWhere`.
5. `Menu#updateItem` invokes `UpdateItemValidation#validateFlags` to check if all the required flags have been given.
    * If there are missing flags, a message indicating that the usage is invalid will be printed using
      `MenuUi#printError` and control is given back to `MoneyGoWhere`.
6. `Menu#addItem` then invokes `UpdateItemValidation#validateCommand` which in turn, calls the following
   validation methods to check the arguments, if they are provided.
    * `UpdateItemValidation#validateArgument` checks if the user input `String` is empty
        * If the user input is empty, a message indicating that the input is empty is printed using `MenuUi#printError`
          and control is given back to `MoneyGoWhere`.
    * `DeleteItemValidation#validateIndex` checks if the given index is valid and exists
        * If the index is invalid, a message indicating the index does not exist is printed using `MenuUi#printError`
          and control is given back to `MoneyGoWhere`.
    * `AddItemValidation#validateName` checks if the given name is empty or exceeds the limit of 25 characters
        * If the name violates these naming constraints, a message indicating that the name is too short or too long is
          printed using `MenuUi#printError` and control is given back to `MoneyGoWhere`.
    * `AddItemValidation#validateDuplicateName` checks if the given name already exists in the `ArrayList<Item> items`
      of `Menu`.
        * If the name already exists, a message indicating that the item name already exists is printed using
          `MenuUi#printError` and control is given back to `MoneyGoWhere`.
    * `AddItemValidation#validatePrice` checks if the given price is empty, is not a number, is negative
      or has more than 2 decimal points
        * If any of the above is true, a message indicating the constraint that it has violated is printed using
          `MenuUi#printError` and control is given back to `MoneyGoWhere`.
7. `Menu#processUpdateItem` is then invoked and calls `Menu#getItem` with `Menu#setName` and/or `Menu#setPrice`
   on the given index to update its name and/or price. Then, `Menu#save` is invoked to save the changes to the
   local storage file.
8. `Router` object then calls `MenuUi#printCommandSuccess` to print a message indicating that the item has been
   successfully updated.

##### New User Mode Update an Item

The expected inputs to update only one menu item into an order is as such:

* `updateitem`
* `4`

The sequence diagram is similar to the `Experienced Mode Update an Item`.

The general workflow of `updateitem` is as follows:

1. `MoneyGoWhere` then creates a new `Command` object using the user input, whose constructor invokes
   `Parser#formatArguments` method to extract the arguments for each flag into a `Map`.
2. `Router#handleRoute` is then invoked to process the command and calls `Router#assistRoute` which invokes
   `MenuAssistant#updateItem` method to run the `updateitem` command.
3. Once the command runs, it can be aborted at any time when the user inputs `/cancel`.
4. `MenuAssistant#updateItem` checks if the list of items is empty. If empty, a message indicating that there
   is nothing to be updated using `MenuUi#printError` and control is given back to `MoneyGoWhere`.
5. `MenuAssistant#updateItem` invokes `MenuAssistant#getIndex` to get the index of the item to be updated.
6. `MenuAssistant#getIndex` gets the index from the user and invokes `DeleteItemValidation#validateIndex` to check if
   the given index is valid and exists.
    * If the index is invalid, a message indicating the index does not exist is printed using `MenuUi#printError`
      and re-prompts the user to enter a new index.
7. `MenuAssistant#updateItem` then asks the user if the item's name is to be updated.
8. If user indicates that the item's name is to be updated, `MenuAssistant#getName` is invoked to get the name from
   the user and invokes `AddItemValidation#validateName` to check if the given name is empty or exceeds the limit of
   25 characters and `AddItemValidation#validateDuplicateName` to check if the given name already exists in the
   `ArrayList<Item> items` of `Menu`.
    * If the name violates these naming constraints, a message indicating that the name is too short or too long is
      printed using `MenuUi#printError` and re-prompts the user to enter a new name.
    * If the name already exists, a message indicating that the item name already exists is printed using
      `MenuUi#printError` and re-prompts the user to enter a new name.
9. `MenuAssistant#updateItem` then asks the user if the item's price is to be updated.
10. If user indicates that the item's price is to be updated, `MenuAssistant#getPrice` is invoked to get the price
    from the user and invokes `AddItemValidation#validatePrice` to check if the given price is empty, is not a number,
    is negative or has more than 2 decimal points
    * If any of the above is true, a message indicating the constraint that it has violated is printed using
      `MenuUi#printError` and re-prompts the user to enter a new price.
11. `Menu#getItem` is then invoked with `Menu#setName` and/or `Menu#setprice` on the given index to update its name
    and/or price. Then, `Menu#save` is invoked to save the changes to the local storage file.
12. `Router#assistRoute` then calls `MenuAssistant#printResult` to print a message indicating that if the item has been
    successfully updated or if the user has cancelled the command accordingly.

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

#### Find an Item

##### Experienced Mode Find an Item

The expected inputs to find any or all items that match the input is as such:

* `/finditem <"description">`

This sequence diagram models the interaction between various components in MoneyGoWhere when the user inputs the
command `/finditem`.

![](./images/developersGuide/SequenceDiagrams/Item/findItem.png)

The general workflow of `finditem` is as follows:

1. `MoneyGoWhere` then creates a new `Command` object using the user input, whose constructor invokes
   `Parser#formatArguments` method to extract the arguments for each flag into a `Map`.
2. `Router#handleRoute` is then invoked to process the command and calls `Router#proRoute` which invokes
   `Menu#showResultsOffFind` method to run the `/finditem` command.
3. `Menu#showResultsOffFind` will then instantiate `FindItemValidation` class to call the `validateName` method to
   ensure the item description is not empty.
4. If there is a matching result, the control will pass to `MenuUi` class to print the list of matched item names.
5. If there is no matching names found, the control will pass to `MenuUi` class to print no matching item names found.

<hr>

##### New User Mode Find an Item

The sequence diagram is similar to the Experienced Mode Find an Item.

The general workflow of finditem is as follows:

1. `MoneyGoWhere` then creates a new `Command` object using the user input, whose constructor invokes
   `Parser#formatArguments` method to extract the arguments for each flag into a `Map`.
2. `Router#handleRoute` is then invoked to process the command and calls `Router#assistRoute` which invokes
   `MenuAssistant#showResultsOffFind` method to run the `finditem` command.
3. Once the command runs, it can be aborted at any time when the user inputs `/cancel`.
4. `MenuAssistant#showResultsOffFind` invokes `MenuAssistant#promptItemKeyword` to get the description of the item to be
   searched.
5. It then calls the experienced search method `Menu#showResultsOfFind` to search for the matching items.
   If there is matching result, the control will pass to `MenuUi` class to print the list of matched item names.
6. If there is no matching names found, the control will pass to `MenuUi` class to print no matching item names found.
7. `Router#assistRoute` then calls `MenuAssistant#printResult` to print a message indicating that if the item has been
   successfully found or if the user has cancelled the command accordingly.

###### [Back to table of contents](#table-of-contents)

<hr> 

<div style="page-break-after: always;"></div>

### Order Commands

#### Overview

* [Add an Order](#add-an-order)
    * [Add a Single Item](#add-only-one-menu-item-into-an-order)
    * [Add Multiple Items](#add-multiple-menu-items-into-an-order)
    * [New User Mode](#new-user-mode-add-an-order)
* [Make payment](#make-payment)
    * [Experienced Mode](#experienced-mode-make-payment)
    * [New User Mode](#new-user-mode-make-payment)
* [List all Orders](#list-all-orders)
* [Refund an Order](#refund-an-order)
    * [Experienced Mode](#experienced-mode-refund-an-order)
    * [New User Mode](#new-user-mode-refund-an-order)

<hr>

#### Add an Order

There are three ways to add an order into MoneyGoWhere.

1. By adding only one menu item into an order.
2. By adding one or more menu items into an order.
3. By using New User Mode to add one or more menu items into an order.

All the ways work similarly, but are parsed differently.

This sequence diagram shows the interaction between various components in MoneyGoWhere when a user inputs commands to
add an order.

![](./images/developersGuide/SequenceDiagrams/Order/addOrder.png)

The next section will describe exactly how the inputs are parsed into the `addorder` command through each of the
described ways.

##### Add only one menu item into an order

The expected inputs to add only one menu item into an order is as such:

- `/addorder -i <item_index> -q <quantity>`
- `/addorder -i <substring_of_item_name> -q <quantity>`
- `/addorder --item <item_index> --quantity <quantity>`
- `/addorder --item <substring_of_item_name> --quantity <quantity>`

This sequence diagram models the interaction between various components in MoneyGoWhere when the user inputs these
commands.

![](./images/developersGuide/SequenceDiagrams/Order/addOrderValidation.png)

The general workflow of this `/addorder` command is as follows:

1. User input is passed to `MoneyGoWhere`.
2. `MoneyGoWhere` then passes it to the `Command` class, which uses the `Parser` class to extract the command
   as `/addorder`.
3. The `/addorder` command gets passed back to `MoneyGoWhere` to check which method it should call.
4. `MoneyGoWhere` passes the user input to the `Order` class to create an `Order`.
5. The `Order` class passes the user input to the `AddOrderValidation` class for input validation.
6. If the input is invalid, the user will be shown an error message about the mistake made, and the correct format to
   enter the command will be shown.
7. If the input is valid, a `Payment` object will be created with the current `Order` as an input.
8. Once payment is made, the `Order` will be passed to the `Transactions` class, where this `Order` will be appended to
   the list of `Transactions`.

<hr>

##### Add multiple menu items into an order

The expected inputs to add multiple menu items into an order is as such:

- `/addorder -I [<item_index>:<quantity>,<substring_of_item_name>:<quantity>,...]`
- `/addorder -I [<substring_of_item_name>:<quantity>,<item_index>:<quantity>,...]`
- `/addorder --items [<item_index>:<quantity>,<substring_of_item_name>:<quantity>,...]`
- `/addorder --items [<substring_of_item_name>:<quantity>,<item_index>:<quantity>,...]`

This sequence diagram models the interaction between various components in MoneyGoWhere when the user inputs the
command `/addorder`.

![](./images/developersGuide/SequenceDiagrams/Order/addMultipleAddOrders.png)

The general workflow of the `/addorder` command is as follows:

1. User input is passed to `MoneyGoWhere`
2. `MoneyGoWhere` then passes it to the `Command` class, which uses the `Parser` class to extract the command
   as `/addorder`.
3. The `/addorder` command gets passed back to `MoneyGoWhere` to check which method it should call.
4. `MoneyGoWhere` creates a new `Order` object and parses the user input into it as a parameter.
5. The `Order` class passes the user input to the `AddMultipleAddOrderValidation` class for input validation.
6. If the input is invalid, the user will be shown an error message about the mistake made, and the correct format to
   enter the command will be shown.
7. If the input is valid, a `Payment` object will be created with the current `Order` as an input.
8. Once payment is made, the `Order` will be passed to the `Transactions` class, where this `Order` will be appended to
   the list of `Transactions`.

<hr>


##### New User Mode Add an Order

This sequence diagram models the interaction between various components in MoneyGoWhere when the user inputs the
command `addorder` or `6`.

![](./images/developersGuide/SequenceDiagrams/Order/assistedAddOrder.png)

The general workflow of `addorder` is as follows:

1. User input is passed to `MoneyGoWhere`.
2. `MoneyGoWhere` then passes it to the `Command` class, which uses the `Parser` class to extract the command
   as `addorder`.
3. The `addorder` command gets passed back to `MoneyGoWhere` to check which function it should call.
4. `MoneyGoWhere` calls the `OrderAssistant` class' `assistedAddOrder` method, which continuously prompts the user for
   inputs with simple-to-follow instructions.
5. If the user enters "NO" when prompted for more items to add to the order, the entire input will be formatted into the
   valid format.
6. The newly formatted input will be parsed into Advance Mode's function to add multiple menu items into an order.
7. Control will be returned to `MoneyGoWhere` if the user cancels the order at any point when being prompted to add menu
   items into the order, or if the user enters "NO" when prompted, to complete the order.

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

#### Make payment

##### Experienced Mode Make Payment

This sequence diagram shows what happens after a valid add order command is executed.

![](./images/developersGuide/SequenceDiagrams/Order/handlePayment.png)

The general workflow of `/pay` is as follows:

1. If the input is valid, a `Payment` object will be created with the current `Order` as an input.
2. The `Payment` object uses the `handlePayment` method to prompt the user to enter the `/pay` command with the valid
   arguments.
3. `Payment#handlePayment` then instantiates the validation class `PaymentValidation` to validate the arguments
   provided.
4. The method `PaymentValidation#validatePayment` is invoked to check the following:
    * The correct command format is used.
    * The flag for payment type and amount flags are present.
    * If the payment type is by card, the payment amount must be exact.
    * The payment amount is a valid 2 decimal place double and must be more than or equals to the subtotal of the order.
5. If the command passes all the validation checks, control is given back to `Payment` class and the `Order.status` will
   be updated to `completed`, and the payment type and amount are also updated accordingly and is saved to
   the `orders.json` file using the `Transaction#save` method.
6. Lastly, the control will be given back to the `Router` class, and it then invokes the `Ui#printCommandSuccess` to
   print a message indicating that the command has executed successfully.

<hr>

#### New User Mode Make Payment

The sequence diagram is similar to `Experienced Mode Make Payment`.

The general workflow of `pay` is as follows:

1. If the input is valid, a `Payment` object will be created with the current `Order` as an input.
2. The `Payment` object uses the `handlePayment` method to prompt the user to enter the `pay` command.
3. `Payment#handlePayment` then instantiates the assistant class `PaymentAssistant` and invoke its `makePayment` method.
4. The method `PaymentAssistant#makePayment` is invoked to check the following:
    * If the user enters `/cancel`, abort the command and return the control to `Router` class.
    * The `getAmount` and `getType` methods are called to prompt user to enter the payment amount and type, then calls
      the `PaymentValidation` class to validate the input:
        * If the payment type is by card, the payment amount must be exact.
        * The payment amount is a valid 2 decimal place double and must be more than or equals to the subtotal of the
          order.
5. If the command passes all the validation checks, control is given back to `PaymentAssistant` class and
   the `Order.status` will be updated to `completed`, the payment type and amount are also updated accordingly and is
   saved to the `orders.json` file using the `Transaction#save` method.
6. Lastly, the control will be given back to the `Router` class, and it then invokes the `Ui#printCommandSuccess` to
   print a message indicating that the command has executed successfully.

###### [Back to table of contents](#table-of-contents)

<hr>


#### List all Orders

This sequence diagram models the interaction between various components in MoneyGoWhere when the user inputs the
command `/listorder`.

![](./images/developersGuide/SequenceDiagrams/Order/listOrders.png)

Note that the work flow for both Basic and Experienced Mode is the same, and if the user input is `7` or `listorder`.

The general workflow of `/listorder` is as follows:

1. User input is passed to `MoneyGoWhere`.
2. `MoneyGoWhere` then passes it to the `Command` class, which uses the `Parser` class to extract the command
   as `listorder`.
3. The obtained command is then passed back to `MoneyGoWhere`, which calls the `displayList` method in
   the `Transactions` object that was initialized alongside `MoneyGoWhere`.
4. The transactions will be printed onto the console.

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

#### Refund an Order

##### Experienced Mode Refund an Order

This sequence diagram models the interaction between various components in MoneyGoWhere when the user inputs the
command `/refundorder`.

![](./images/developersGuide/SequenceDiagrams/Order/refundOrder.png)

The general workflow of `/refundorder` is as follows:

1. User input is passed to `MoneyGoWhere`. `MoneyGoWhere` then passes it to the `Command` class, which instantiates a
   new `Parser` object to extract the command as `/refundorder`.
2. The `Parser` object then uses `Parser#formatInput` method from `Parser` class to extract all the arguments from the
   user input.
3. `Router#handleRoute` is then invoked to process the command. It calls the `Router#proRoute` for the experienced mode
   commands.
4. The obtained command `refundorder` is then passed back to `MoneyGoWhere`, which instantiates a new `Refund` object
   and calls the `Refund#refundTransaction` method.
5. `Refund#refundTransaction` then instantiates the validation class `refundOrderValidation`. The
   method `refundOrderValidation#validateRefundOrder` is invoked to validate the arguments provided.
    * `refundOrderValidation#checkArgument` checks if the required argument is present. The expected argument is
      the `Order.UUID`.
    * `refundOrderValidation#checkOrder` first check if the argument is indeed a valid `Order.UUID` then checks
      the `Order.status`.
        * If the `Order.status` is already `refunded`, then the command would be invalid.
6. If the command passes all the validation checks, control is given back to `Refund` class and
   the `Order.status` will be updated to `refunded` and is saved to the `orders.json` file using
   the `Transaction.save` method.
7. Lastly, the control will be given back to the `Router` class, and it then invokes the `Ui#printCommandSuccess` to
   print a message indicating that the command has executed successfully.

<hr>

##### New User Mode Refund an Order

The sequence diagram is similar to the `Experienced mode Refund an Order`.

The general workflow of `refundorder` is as follows:

1. User input is passed to `MoneyGoWhere`. `MoneyGoWhere` then passes it to the `Command` class, which instantiates a
   new `Parser` object to extract the command as `refundorder`.
2. The `Parser` object then uses `Parser#formatInput` method from Parser class to extract all the arguments from the
   user input.
3. `Router#handleRoute` is then invoked to process the command. It calls the `Router#assistRoute` for the new user mode
   commands.
4. Once the command runs, it can be aborted at any time when the user inputs `/cancel`.
5. The obtained command `refundorder` is then passed back to `MoneyGoWhere`, which instantiates a new `RefundAssistant`
   object and calls the `RefundAssistant#refundOrder` method.
6. `RefundAssistant#refundOrder` invokes the `getID` method to get and validate the order ID to be refunded.
    * If the order list is empty, the command would be invalid.
    * If the order ID is invalid, the command would be invalid.
7. If the command passes all the validation checks, control is given back to `Refund` class and the `Order.status` will
   be updated to `refunded` and is saved to the `orders.json` file using the `Transaction#save` method.
8. `Router#assistRoute` then calls `MenuAssistant#printResult` to print a message indicating that if the item has been
   successfully added to the menu or if the user has cancelled the command accordingly.

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

### Report Commands

#### Overview

* [Generate Sales Report](#generate-sales-report)
* [Generate Ranking Report](#generate-rank-report)

#### Statistics

This sequence diagram models the overview of the statistic components when the user inputs the command `\report`.

![](./images/developersGuide/SequenceDiagrams/Statistic/statistic.png)

#### Generate sales report

This sequence diagram models the interaction between various components in MoneyGoWhere when the user inputs the command
`/report -s <type> {-y <year>} {-f <start-date> -t <end-date>}`, where of the following:

* The type of `-s` is either `daily` or `monthly`.
* Only one of `-y <year>` or `-f <start-date> -t <end-date>` must be present.
    * If the option `-s monthly` is used, `-y <year>` must be present.

![](./images/developersGuide/SequenceDiagrams/Statistic/createSalesReport.png)

The general workflow of `/report -s <type> {-y <year>} {-f <start-date> -t <end-date>}` is as follows:

1. User input is passed to `MoneyGoWhere`. `MoneyGoWhere` then passes it to the `Command` class, which instantiates a
   new `Parser` object to extract the command as `/report`.
2. The `Parser` object then uses `parser#formatInput` method from `Parser` class to extract all the arguments from the
   user input.
3. `Router#handleRoute` is then invoked to process the command and calls `Router#proRoute` which invokes
   `Statistic#handleStatisticRoute` method to run the `/report` command.
4. It then instantiates the validation class `StatisticValidation` and invokes the `validateRequiredFlag` method. This
   validates the user input to contain all the required flags, in the correct format.
5. Once the input is validated, it is passed to instantiate the `SalesReport` class.
6. The `totalSales` method is then invoked to calculate the subtotal of all the completed orders.
7. If the user input is `daily`, `Chart` class is instantiated and calls the `dailySalesChart` to generate the bar
   charts based off daily sales.
8. If the user input is `monthly`, `Chart` class is instantiated and calls the `monthlySalesChart` to generate the bar
   charts based off monthly sales.
9. Lastly, the control will be given back to the `MoneyGoWhere` class to prompt for new user input.

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

#### Generate rank report

This sequence diagram models the interaction between various components in MoneyGoWhere when the user inputs the command
`/report -r <type> {-y <year>} {-f <start-date> -t <end-date>}`

* The type for `-r` is either `sales` or `popular`.
* Only one of `-y <year>` or `-f <start-date> -t <end-date>` must be present.
    * If the option `-s monthly` is used, `-y <year>` must be present.

![](./images/developersGuide/SequenceDiagrams/Statistic/createRankReport.png)

The general workflow of `/report -r <type> {-y <year>} {-f <start-date> -t <end-date>}` is as follows:

1. User input is passed to `MoneyGoWhere`. `MoneyGoWhere` then passes it to the `Command` class, which instantiates a
   new `Parser` object to extract the command as `/report`.
2. The `Parser` object then uses `parser#formatInput` method from `Parser` class to extract all the arguments from the
   user input.
3. `Router#handleRoute` is then invoked to process the command and calls `Router#proRoute` which invokes
   `Statistic#handleStatisticRoute` method to run the `/report` command.
4. It then instantiates the validation class `StatisticValidation` and invokes the `validateRequiredFlag` method. This
   validates the user input to contain all the required flags in the correct format.
5. If the user input is `sales`, the `rankBySales` method is invoked to rank the menu items according to total order
   sales.
    * The `StatisticUi#printSalesRankingTable` is called to print the ranking table to the console.
6. If the user input is `popular`, the `rankByPopularity` method is invoked to rank the menu items according to total
   number of order quantities.
    * The `StatisticUi#printPopularityRankingTable` is called to print the ranking table to the console.
7. Lastly, the control will be given back to the `MoneyGoWhere` class to prompt for new user input.

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

## Requirements

### Project Scope

**Target user profile**

Our target user profile is the NUS canteen hawker owners.

* Canteen operators looking to streamline their operations and improve efficiency.
* Familiar with basic computer usage and is able to type fast.
* Concerned about the cost of traditional point-of-sale (POS) systems and looking for a more affordable and flexible
  solution.

**Value Proposition**

MoneyGoWhere is a comprehensive and easy-to-use CLI application designed to simplify canteen operations and streamline
business processes.
With its robust features, including menu management, payment processing, and sales statistics generation, MoneyGoWhere
is an ideal solution for canteens of any size.

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

### User Stories

| Version | As a...            | I want to...                                     | So that I can...                                                                 |
|---------|--------------------|--------------------------------------------------|----------------------------------------------------------------------------------|
| v1.0    | Hawker Store Owner | Add an item                                      | Add it to an order in the future                                                 |
| v1.0    | Hawker Store Owner | Delete an item                                   | Remove it from the menu                                                          |
| v1.0    | Hawker Store Owner | List all items                                   | View all items in the menu, including its index and price                        |
| v1.0    | Hawker Store Owner | Add an item to an order                          | Track what customers order and calculate its total cost                          |
| v1.0    | Hawker Store Owner | Add multiple items to an order                   | Save time by combining multiple items from a single customer into one order      |
| v1.0    | Hawker Store Owner | List orders                                      | See all orders, including the total cost of each other                           |
| v1.0    | Returning User     | Save menu items                                  | Save time by using the same menu, without entering each item over again each day |
| v1.0    | Returning User     | Save transactions from previous days             | Keep track of all orders easily, even across multiple days                       |
| v1.1    | Hawker Store Owner | Search for an item                               | Check its index or price                                                         |
| v1.1    | Hawker Store Owner | Add items to an order by name                    | Add items without remembering its index                                          |
| v2.0    | Hawker Store Owner | Void an order                                    | Provide refunds or ignore orders with wrong inputs                               |
| v2.0    | New User           | Add an item step-by-step                         | Get used to the new system                                                       |
| v2.0    | New user           | Delete an item step-by-step                      | Get used to the new system                                                       |
| v2.0    | New User           | Add an item(s) to an order step-by-step          | Get used to the new system                                                       |
| v2.0    | Returning User     | See statistics on based on previous transactions | Obtain statistics about my various items for sale                                |

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

### Non-functional Requirements

1. The application should be able to run on any operating system with `Java 11` installed.
2. The application should be responsive.
3. The application should be simple enough for a novice who is not familiar with a Command Line Interface (CLI) to use.
4. The application should be easily adaptable to people who are already well-versed in using a traditional POS system.

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

### Glossary

The glossary is shown in alphabetical order. If you have any additional questions, please reach out to our team.

| Term    | Explanation                                                                                                                                              |
|---------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
| Flag    | Used to specify instructions and change the behaviour of a command. In this application, flags have a short-form and a long-form, ie. `-n` and `--name`. |
| Parser  | A Parser is responsible for making sense of the user inputs and processing them as commands for the application to run.                                  |                                                                                                                                      |
| Storage | A Storage is in charge of saving and reading to and from the save file respectively.                                                                     |
| Ui      | A UI is an user interface that the user sees on the CLI.                                                                                                 |

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

### Appendix

### Instructions for manual testing

Below are some instructions to test MoneyGoWhere manually.


> These instructions only provide a starting point for testers to work on; testers are free to do more exploratory
> testing.

#### Overview

* [Launch and Shutdown](#launch-and-shutdown)
* [Menu Testing](#menu-testing)
* [Order Testing](#order-testing)
* [Payment Testing](#payment-testing)
* [Refund testing](#refund-testing)
* [Statistic Testing](#statistic-testing)
* [Storage Testing](#storage-testing)

### Launch and shutdown

Initial launch

```
1. Ensure that Java 11 or above is installed.
2. Download the latest .jar version of MoneyGoWhere from [here](https://github.com/AY2223S2-CS2113T-T09-2/tp/releases/tag/v2.1).
3. Copy the file to the folder you wish to use as a home folder for MoneyGoWhere.
4. Open a terminal and navigate to the folder.
5. Start the application by executing java -jar MoneyGoWhere.jar in the terminal.
6. Once MoneyGoWhere has successfully launched a welcome message should appear. 
7. When launched for the first time, a folder will be created for file storage.
```

Shutting down

```
1. Quit the application using the command `exit`.
2. MoneyGoWhere prints a farewell message before terminating.
```

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

### Menu Testing

### Adding a menu item

Adding an item when menu is empty.

```
1. Test case: `/additem -n "chicken rice" -p 3.50`

   Expected: Item added successfully.

2. Test case: `/additem -n "duck rice" -p three dollars`

   Expected: Item is not added to the menu. An error message is displayed along with the reason:
   Price must be a number.

3. Other incorrect add commands to test: `/additem`, `/additem "name"`, `/additem -n "name"` and `/additem -p 2.50`
```

Adding an item when menu is not empty.

```
1.  Test case: `/additem -n "chicken rice" -p 3.50`

  Expected: Item is not added to the menu. An error message is displayed along with the reason: 
  Name already exists. Please choose a different name.
```

### Deleting a menu item

Deleting an item when menu is empty.

```
1. Test case: `/deleteitem -i 1`

   Expected: Item is not deleted. An error message is displayed along with the reason:
   There are no items on the menu
```

Deleting an item when menu is not empty.

```
1.  Test case: `/deleteitem -i 1`

  Expected: Item at index 1 is deleted successfully.

2. Test case: `/deleteitem -i 999`

   Expected: Item is not deleted. An error message is displayed along with the reason:
   Index does not exist

3. Other incorrect commands to test: `/deleteitem`, `/deleteitem something`, `/deleteitem -i` and `/deleteitem -i something`
```

### Updating a menu item

Updating an item when menu is empty.

```
1. Test case: `/updateitem -i 1 `

   Expected: Item is not updated. An error message is displayed along with the reason:
   Index does not exist.
```

Updating an item when menu is not empty.

```
1.  Test case: `/updateitem -i 1 -p 5.50`

  Expected: Item at index 1 is updated successfully.

2. Test case: `/updateitem -i 2 -n "new name"`

   Expected: Item at index 2 is updated successfully.
3. Test case: `/updateitem -i 2 -p "something"`

   Expected: Item is not updated. An error message is displayed along with the reason:
   Price must be a number.
4. Other incorrect commands to test: `/updateitem`, `/updateitem something`, `/updateitem -i` and `/updateitem -i 1`
```

### Finding a menu item

Finding an item when menu is empty.

```
1. Test case: `/finditem "something"`

   Expected: No menu items matching something were found.
```

Finding an item when menu is not empty.

```
1.  Test case: `/finditem "rice"`

  Expected: All items that contain "rice" in its names will be displayed.

2. Test case: `/finditem`

   Expected: Command is not valid. An error message is displayed along with the reason:
   Please specify the keyword to search for.
```

### List items

Menu list is empty

```
1. Test case: `listitem`

   Expected: There are no items on the menu
```

Menu list is not empty

```
1. Test case: `listitem`

   Expected: All the menu items are listed

2. Test case: `listitem something`
   Expected: Command is not recognised
```

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

### Order Testing

### Adding an order

Add single order.

```
1. Test case: `/addorder -i 1`

   Expected: Subtotal: $3.00. Order has been added successfully.
   Please use /pay -a <amount> -t <type> or pay to make payment.

2. Test case: `/addorder -i 2 -q 10`

   Expected: Subtotal: $34.50. Order has been added successfully.
   Please use /pay -a <amount> -t <type> or pay to make payment.

3. Test case: `/addorder -i 999`
   
   Expected: Order is not added. An error message is displayed along with the reason:
   Index does not exist.

4. Other incorrect add commands to test: `/addorder`, `/addorder -i something` and `/addorder -i 1 -q name`
```

Add multiple orders.

```
1. Test case: `/addorder -I [1:1]`

   Expected: Subtotal: $3.00. Order has been added successfully.
   Please use /pay -a <amount> -t <type> or pay to make payment.

2. Test case: `/addorder -I [1:2,2:3]`

   Expected: Subtotal: $16.35. Order has been added successfully.
   Please use /pay -a <amount> -t <type> or pay to make payment.

3. Test case: `/addorder -I [999:1]`

   Expected: Order is not added. An error message is displayed along with the reason:
   Index does not exist.

4. Other incorrect add commands to test: `/addorder -I`, `/addorder -I [something]` and `/addorder -I [something:something]`
```

### List orders

Order list is empty

```
1. Test case: `listorder`

   Expected: Order list is empty.
```

Order list is not empty

```
1. Test case: `listorder`

   Expected: All transactions are listed
2. Test case: `listorder something`
   Expected: Command is not recognised
```

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

### Payment testing

Paying an order

> Test case:
>
> Subtotal: $30.00. Order has been added successfully. Please use /pay -a <amount> -t <type> or pay to make payment.

```
1. Test case: `/pay -a 40 -t cash`

   Expected: The calculated change is $10.00. Order has been paid.

2. Test case: `/pay -a 20 -t cash`

   Expected: Order is not completed. An error message is displayed along with the reason:
   Insufficient amount. Payment amount must be more than or equals to subtotal.

3. Test case: `/pay -a 50 -t card`

   Expected: Order is not completed. An error message is displayed along with the reason:
   Please input exact amount for card payment.

4. Other incorrect commands to test: `/pay 40`, `/pay -a thirty`, `/pay -a 10 -t 10` and `/pay -t cash`
```

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

### Refund testing

### Refunding an order

Refund an order when order list is empty.

```
1. Test case: `/refundorder -i 204vfenefnef03nf0`

   Expected: Command is not valid. An error message is displayed along with the reason:
   There is no order to refund.
```

Refund an order when order list is not empty.

```
1. Test case: `/refundorder -i b0d70428-c5b2-4024-82e9-ce77cf89dc0c`

   Expected: The order's status is now refunded.

2. Test case: `/refundorder -i 2b9262ce-e1db-4e31-9b8e-c9e149669d35`

  Expected: Order is not refunded. An error message is displayed along with the reason:
  Order is already refunded.

3. Test case: `/refundorder -i some39399thing`

  Expected: Order is not refunded. An error message is displayed along with the reason:
  Invalid order ID.
```

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

### Statistic testing

Rank by sales

```
1. Test case: `/report -s daily -y 2023`

   Expected: The chart table is displayed to show all the sales in the year of 2023, grouped by each day.

2. Test case: `/report -s monthly -y 2023`

   Expected: The chart table is displayed to show all the sales in the year of 2023, grouped by each month.

3. Test case: `/report -s weekly -y 2023`

   Expected: Command is not recognised. An error message is displayed along with the reason:
   Report type specified in [-r|--rank] or [-s|--sales] option not recognised.

4. Other incorrect commands to test: `/report`, `/report -s` and `/report -s yearly`
```

Rank by popularity

```
1. Test case: `/report -r sales -y 2023`

   Expected: The chart table is displayed to rank items by sales in the year of 2023.

2. Test case: `/report -r popular -y 2023`

   Expected: The chart table is displayed to rank items by popularity in the year of 2023.

3. Test case: `/report -r sales -y monthly`

   Expected: Command is not recognised. An error message is displayed along with the reason:
   Year format provided in [-y|--year] is/are not recognised

4. Other incorrect commands to test: `/report`, `/report -r` and `/report -r something`
```

###### [Back to table of contents](#table-of-contents)

<hr>

<div style="page-break-after: always;"></div>

### Storage Testing

MoneyGoWhere.jar is placed in a location where read and write permissions are given.

```
1. Test case: First time launched

   Expected: Datastore folder will be created for menu.json and orders.json file.

2. Test case: File is corrupted
   Expected: The application will detect it as a corrupted file, correct the format and restore the data.
```

MoneyGoWhere.jar is placed in a location with no read and write permissions

```
1. Test case: First time launched

   Expected: No files are created and saved. Error message is displayed.
```

###### [Back to table of contents](#table-of-contents)


<div style="page-break-after: always;"></div>


### Final Comments

If you have read until the end, thank you! We hope you have understood the inner mechanisms of MoneyGoWhere, and that 
you had a relatively easy time reading through this Developer Guide. 

We (the original MoneyGoWhere team) put in a considerable amount of effort to make the guide as detailed 
and correct as possible. We hope that the information in this guide will be useful in improving MoneyGoWhere, 
and we look forward to seeing it being continuously loved and improved upon. 

Once again, thank you for reading the guide!

<hr>
