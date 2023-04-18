<h1> MoneyGoWhere User Guide </h1>

<div style="width:30%; height:auto; margin-left: auto; margin-right: auto;">


<img src="https://i.imgur.com/ptkwkny.png">


</div>

## Hello Hawker!

Thank you for your interest in MoneyGoWhere!

Our team would like to express our heartfelt gratitude in giving our application a chance. Allow us to bring you many steps closer towards making more money from your business, and to help with the dream of preserving hawker culture in Singapore!


This is the user guide for MoneyGoWhere.
**It is designed to help you, a hawker at NUS, learn how to use our product easily**.

The purpose of this guide is to **show you easy-to-understand instructions on how to use our product**.

<hr style="width:90%;margin:50px auto;">

## Table of Contents

* [What is MoneyGoWhere](#what-is-moneygowhere)
* [Why we created MoneyGoWhere](#why-we-created-moneygowhere)
* [Urgent Help](#problems)
* [How to use this Guide](#how-to-use-the-guide)
* [Tutorial on Command Line Interface](#tutorial-on-command-line-interface)
* [Setting up MoneyGoWhere](#setting-up-moneygowhere)
* [MoneyGoWhere Commands](#moneygowhere-commands)
* [Style Features](#style-features)
* [Summary of Features](#summary-of-features)
   * [Help](#help)
   * [Item Features](#item-features)
   * [Order Features](#order-features)
   * [Statistics and Report](#statistics-and-report)
* [Frequently Asked Questions](#frequently-asked-questions)
* [Glossary](#glossary)

<hr style="width:90%;margin:50px auto;">

## What is MoneyGoWhere?

MoneyGoWhere is a [*computer program*](#glossary) made by computing students from the National University of Singapore (NUS) that **helps you keep track of your sales**.

It works like the "cashier machine" that you have been using, but is even better! With MoneyGoWhere, **you can also see how
much money you make each day** and **what items you sell the most**.

**Now, you can make smarter business decisions, save time, and money**. _Steady_!

###### [Back to table of contents](#table-of-contents)

<hr style="width:90%;margin:50px auto;">

## Why we created MoneyGoWhere

MoneyGoWhere was created as we noticed most hawkers in the National University of Singapore (NUS) already had an existing [*Point-of-Sale*](#glossary) (POS) System, but most of them were not using them. After conducting interviews with the hawkers, we identified three main reasons why they were not using the system:

1. **The system is too slow** and becomes **unresponsive** too frequently.
2. **An internet connection is required** to use the POS system, but the Internet connection system in NUS frequently fails.
3. There is **no real incentive to use a system** that does not work, even if they have to **pay $200 a month** to use it.

After identifying these problems, our team of computing students has taken on the responsibility of creating an effective solution that addresses these issues. We aim to improve the lives of hawkers and enhance their businesses using technology.

In creating MoneyGoWhere, we had four goals in mind:
1. **To improve the business processes of hawkers**, so that they only need to focus on making food and can pay little attention to handling finances and order tracking, making their workflow more efficient. 
2. **To create a cheap solution**, increasing the profit of hawkers.
3. **To create a solution that does not require an internet connection,** providing around-the-clock availability and preventing downtime, especially when it matters most.
4. **To help support the digitalization efforts of the Government**, so that the older generation of hawkers may become more tech-savvy, within the comfort and familarity of their hawker stalls.

Upon completing the first version of our program, we have tested our system with one of our team member's parents, who are hawkers. They gave us honest feedback about MoneyGoWhere, and we have made adjustments according to their feedback.

When the second version of MoneyGoWhere was presented to them, they were more comfortable with our solution, and could confidently say that the goals of MoneyGoWhere were met.

We hope that you, as a hawker, can feel the same in using MoneyGoWhere!

###### [Back to table of contents](#table-of-contents)

<hr style="width:90%;margin:50px auto;">

## "I have problems right now, that's why I am reading the guide!" <a name="problems"></a>
### "But I cannot find what I am looking for, how now?"
We understand that using a new system can be confusing and frustrating. That is why we reduced our usage of technical words, and included examples in this guide.

We understand that you may be referencing this guide when business is booming - **you can already barely cope, and you don't have the time to search for instructions on how to use a feature.**

Don't worry! The guide is written in such a way that you can easily find what you are looking for.

There may be new words and phrases used in the guide that you may have never seen or heard of before. To make this guide easier to understand, our team has made sure all the "technical" words and phrases will be in blue, [*like this*]()! What this means is that if you click on them, it will lead you to a mini-dictionary of words at the bottom of the guide, called a [glossary](#glossary). These blue phrases are also known as [*hyperlinks*](#glossary). You can check out what it means in the glossary by clicking on it.

Additionally, *[these italicized hyperlinks](#glossary)* will bring you to our glossary at the bottom of the guide, while [non-italicized hyperlinks]() like these will bring you to the relevant sections of the guide.

If you cannot find what you are looking for, you may **call us at 9123 4567** so that we can help you as soon as possible.

###### [Back to table of contents](#table-of-contents)

<hr style="width:90%;margin:50px auto;">

## How to use the Guide 

This guide will bring you through:

1. How to use a [*Command Line Interface*](#glossary),
2. How to set up MoneyGoWhere, and
3. How to use our various [*commands*](#glossary) to track items, add orders, and generate statistic reports!

We will also provide some information on how [your data is saved](#frequently-asked-questions).
<!-- ^^ We can potentially omit this section -->

Before we begin, we want to let you know that this guide uses **three different colored blocks** and **icons** to indicate different things.

<blockquote style="background-color:#EAF5FF; color:#364253; border-color:#3399FF; padding: 2% 3%">
    📖 This is a story block! Story blocks provide an example on when and how to use the many features of MoneyGoWhere. 
</blockquote>

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
    💡 These blocks contain information that you should take note of, or additional details that you might be interested in. Each block refers to a different point, so you may encounter two blocks right next to each other. 
</blockquote>

<blockquote style="background-color:#FADDDD; color:#364253; border-color:#893232; padding: 2% 3%">
    ❗ These are warning blocks. They are used to show that the next part will feature some errors that you may encounter. 
</blockquote>

###### [Back to table of contents](#table-of-contents)

<hr style="width:90%;margin:50px auto;">

## Tutorial on Command Line Interface
<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
    💡  If you're already familiar with a <a href="#glossary"><i>Command Line Interface (CLI)</i></a>, otherwise known as a <a href="#glossary"><i>CLI</i></a>, that's great! Feel free to <a href="setting-up-moneygowhere"><i>move on to the next section</i></a> about setting up
MoneyGoWhere.

<br>

Otherwise, if you are new to the <a href="glossary"><i>CLI</i></a>, please continue reading this section for a simple introduction. The <a href="glossary"><i>CLI</i></a> is important in using MoneyGoWhere, so it is a good idea to know what you are looking at.
</blockquote>

Without further ado, let us begin exploring the [CLI](#glossary)! You may choose to follow the steps listed in the tutorial as we go along, so that you may get a better understanding.

### Opening a [*Terminal*](#glossary)

To begin, let us open a [*terminal*](#glossary) to view your [*CLI*](#glossary). You may enter `cmd` in your start menu and select the first [*option*](#glossary) that appears.
![](https://i.imgur.com/Ezt3rky.png)

### What's on a [*CLI*](#glossary)?

After opening the [*terminal*](#glossary), you should see a window similar to the one shown in the picture below.

![](https://imgur.com/FitjoRf.png)

For the sake of simplicity, going forward, we will be calling this window the [*CLI*](#glossary).

Now, let us break down the different parts of the [*CLI*](#glossary) for you!

From the very top, we can see the text `Microsoft Windows [Version 10.0.22621.1413]`, followed by a [*Copyright*](#glossary) text. This may be different for every machine, so do not worry if what you see in your own [*CLI*](#glossary) is different.

![](https://imgur.com/IUTmjGe.png)

Next, we have the current directory. If you followed the [previous instruction](#opening-a-terminal), you should see `C:\Users\`, followed by your name on the screen, just like in this next screenshot. In this case, the name in the screenshot is `sean_`. This will look different in your own [*CLI*](#glossary), so do not panic if you see something different!

![](https://imgur.com/cRpNden.png)

A "current directory" is like a special folder that you are looking at right now on your computer. It is like a magic box that you can put things in or take things out of, but only if you're looking at that box right now. So if you want to find something or put something away, you need to make sure you're looking at the right magic box, or "current directory".

### What can I do on this?

You can type and run [*commands*](#glossary), one example of which is the command to launch MoneyGoWhere!

The following screenshot shows where you are able to type.

![](https://imgur.com/q6WTOE4.png)

To run the [*command*](#glossary) that you have just typed, you can press the `Enter` button on your keyboard.

However, if you entered `Hello Hawker, I can type here!` as shown in the previous screenshot, you will see an error message, stating that it is an invalid [command](#glossary) as shown in the next screenshot. This is because the sentence `Hello Hawker, I can type here!` is not a valid [command](#glossary).

![](https://imgur.com/zNtdks0.png)

One example of a valid [command](#glossary) is to change the name of the [CLI](#glossary) window. This can be done by using the `title` [command](#glossary).

We will show you how to use it soon, but first, notice how the `CLI` looks like now. In the screenshot below, the window is named `Command Prompt`.

![](https://imgur.com/WBuFLtU.png)

To change the name of the [CLI](#glossary) window from `Command Prompt` to `My favoruite application`, you can enter and run the [command](#glossary) `title My favourite application`.

If you have done it right, you should notice a change in the name of the window, like this!

![](https://imgur.com/RubluYJ.png)

You can also do things like delete or list the files in the current directory. However, this guide will not be covering these topics as they are not relevant to MoneyGoWhere. If you want to know more about [CLI](#glossary) and what other things you can do with them, [you may read up more about it from this article](https://blog.testproject.io/2021/03/30/a-beginners-guide-to-command-line-interface-cli/).

### Congratulations, you have completed the [CLI](#glossary) tutorial!

Now that you are familiar with how the [CLI](#glossary) works, you are now able to use MoneyGoWhere to its maximum potential! Let us now proceed to the next section, where we will guide you on how to set up MoneyGoWhere.

###### [Back to table of contents](#table-of-contents)

<hr style="width:90%;margin:50px auto;">

## Setting up MoneyGoWhere

1. Before installing and using MoneyGoWhere, do note that Java 11 is required. If you do not already have it installed,
   you can do so [here](https://www.oracle.com/sg/java/technologies/downloads/#java11).
   * For Windows users, download the x64 Installer. Ensure you are on the "Windows" page and download the correct
     version as shown in the red boxes. Click `jdk-11.10.18_windows-x64_bin.exe` to begin your download.

     ![](https://i.imgur.com/ibRX7fQ.png)

     * For Mac users, download the ARM 64 DMG Installer. Ensure you are on the "macOS" page and download the correct
      version, in the red box. Click `jdk-11.0.18_macos-aarch64_bin.dmg` to begin your download

      ![](https://i.imgur.com/DGn8lrt.png)

2. Next, open the downloaded installer and follow the instructions on the installer to install Java 11.

3. After installing Java 11, [please download the latest release of the `MoneyGoWhere.jar` file](https://github.com/AY2223S2-CS2113T-T09-2/tp/releases).
   Click on `MoneyGoWhere.jar` to automatically download the file. Ensure that it is the latest version (the one with the biggest number).

   ![](https://i.imgur.com/9qXdll7.png)

4. Find `MoneyGoWhere.jar` in your Downloads folder.

5. Open `cmd` and navigate to the folder where the `MoneyGoWhere.jar` file is. If you are unsure of how to do so, follow
   steps 6 to 8. Otherwise, you may skip ahead to step 8.

6. Open a [*terminal*](#glossary) by entering `cmd` in your start menu and select the first option that appears.
   ![](https://i.imgur.com/Ezt3rky.png)

7. Get the file path of `MoneyGoWhere.jar` in your computer. To easily do so, you can do the following:

   * For Windows users, right-click the file and select the "Properties" [*option*](#glossary). Then, copy the text
     under "Location".
     ![](https://i.imgur.com/bc72Izn.png)

   * For Mac users, right-click the file and select "Copy".
     ![](https://i.imgur.com/mKfwVrc.png)

8. In the CLI, navigate to the location of the folder by typing `cd `, type or paste the file path that you found from
   the previous step by pressing `CTRL` and `V` keys at the same time on your keyboard, then press enter.

   * For example, if the file path that you have is `C:\Users\natas\Downloads\Folder`, then you should
     enter `cd C:\Users\natas\Downloads\Folder` into the CLI.
    

9. Use the [*command*](#glossary) `java -jar MoneyGoWhere.jar` to launch MoneyGoWhere.
   If done correctly, you will see this on your first start up:
   ![](https://i.imgur.com/4K6rkQi.png)

   Note that returning users will not see the first two lines. Instead, they will see our logo and the remaining text.


10. When you are done using the app, enter `exit` to shut the application down or simply close the window by clicking on
    the `X` on the top right hand corner of the CLI.

###### [Back to table of contents](#table-of-contents)

<hr style="width:90%;margin:50px auto;">

## MoneyGoWhere [Commands](#glossary)

<blockquote style="background-color:#EAF5FF; color:#364253; border-color:#3399FF; padding: 2% 3%">
📖 Meet <strong>John</strong>! He will be a character that is constantly referenced throughout the next few sections to better explain how the <a href="#glossary"><i>commands</i></a> work. John is an aspiring hawker, and plans on running a new stall at The Deck in NUS. 
</blockquote>

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 For new users, it is recommended to read the sections labelled as <strong>For New Users</strong>. These sections will bring you through using <a href="#glossary"><i>command</i></a> in a guided, step-by-step manner.

As you become more familiar with MoneyGoWhere and want to speed up using the application, we recommend reading sections labelled as  <strong>For Experienced Users</strong>. In these sections, we provide examples on how to use each feature with just a single line of input.
</blockquote>

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 Even though the <strong>New User</strong> and <strong>Experienced User</strong> <a href="#glossary"><i>command</i></a> are entered into the application slightly differently, they both work exactly the same. 

In other words, there is nothing that the <strong>Experienced User</strong> <a href="#glossary"><i>command</i></a> can do that the <strong>New User</strong> <a href="#glossary"><i>command</i></a> cannot.
</blockquote>

###### [Back to table of contents](#table-of-contents)

<hr style="width:90%;margin:50px auto;">

## Style Features

For the following sections, all examples on how to run [*commands*](#glossary) are shown through pictures. There are four
things
to take note of:

1. Standard text printed by the application is written in **white**.
2. User input is signified and is written in <text style="color:#88B3F6"><strong>blue</strong></text>.
3. Success messages and examples of expected output is written in <text  style="color:#7ED321"><strong>green</strong></text>.
4. Error messages are written in <text style="color:#F25569"><strong>red</strong></text>.

**When you use the application, the text on your screen will be in white.**

We have chosen to color-code our examples to make it easier for you to follow along and tell apart different parts of
the examples.

Here is an example of what you can expect to see in this Guide.

![](https://i.imgur.com/MT5YgYP.png)

For those reading the **New User** sections, do also note the following:

1. At any point, if you wish to exit from the [*command*](#glossary), you can do so with `/cancel`

For those reading the **Experienced User** sections, do also note the following:

1. Any words surrounded by `<>`, such as `<price>` are for you to fill in.
2. [*Options*](#glossary) that are surrounded by `{}`, such as `{-n "<name>"}` are optional.
3. All values have to be accompanied by [*options*](#glossary) (begins with `-`, such as `-n` or `--price`). [*Commands*](#glossary) such
   as `/deleteitem delete -i 10` will be an invalid [*command*](#glossary).

###### [Back to table of contents](#table-of-contents)

<hr style="width:90%;margin:50px auto;">

## Summary of Features

There are 10 features built into MoneyGoWhere, as described in the table below.
More details are provided in their individual sections.

| Name                                             | Description                                                            |
|--------------------------------------------------|------------------------------------------------------------------------|
| [Help](#help)                                    | Displays information about various [*commands*](#glossary)             |
| [**Item Features**](#item-features)              |                                                                        |
| [Add an Item](#add-an-item)                      | Adds an item to the menu                                               |
| [Delete an Item](#delete-an-item)                | Deletes an item from the menu                                          |
| [List All Items](#list-all-items)                | Lists items in the menu                                                |
| [Update an Item](#update-an-item)                | Updates an item in the menu                                            |
| [Find an Item](#find-an-item)                    | Finds an item in the menu, based on its name                           |
| [**Order Features**](#order-features)            |                                                                        |
| [Add an Order](#add-an-order)                    | Adds an order, with the [*index*](#glossary) and quantity of each item |
| [List All Orders](#list-all-orders)              | Lists all orders                                                       |
| [Refund an Order](#refund-an-order)              | Refunds an order based on the unique order ID                          |
| [**Statistics**](#statistics-and-report)         |                                                                        |
| [Statistics and Reports](#statistics-and-report) | Generates a report based on various [*options*](#glossary)             |

###### [Back to table of contents](#table-of-contents)

<hr style="width:70%;margin:50px auto;">

## Help

This [command](#glossary) displays information about the other [*commands*](#glossary) available in MoneyGoWhere.

<blockquote style="background-color:#EAF5FF; color:#364253; border-color:#3399FF; padding: 2% 3%">
📖 John has just downloaded MoneyGoWhere. Unlike you, he does not know that MoneyGoWhere has a user guide and wants to find out more about the various <a href="#glossary"><i>commands</i></a> offered by MoneyGoWhere. To find out more about the <a href="#glossary"><i>commands</i></a> offered, he can use the <code>help</code> <a href="#glossary"><i>commands</i></a>. 

Currently, all he knows is that he can do <code>help</code>, or <code>/help</code>.
</blockquote>

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 The help <a href="#glossary"><i>command</i></a> does not accept any other input. Entering anything other than <code>help</code> or <code>/help</code> will cause an error.
</blockquote>

<h3> For New Users </h3>
<blockquote style="background-color:#EAF5FF; color:#364253; border-color:#3399FF; padding: 2% 3%">
📖 As someone who is unfamiliar with the application, John wants to be guided step-by-step to use MoneyGoWhere. To view the <a href="#glossary"><i>commands</i></a> available to him, he can use the <code>help</code> command.
</blockquote>

1. When John enters `help`, MoneyGoWhere prints out all the various [*commands*](#glossary) he can use. With the information printed out, he also now knows that there is a user guide! 
![](https://i.imgur.com/OlmWorh.png)

<hr style="width:50%;margin:50px auto;"/>

<h3> For Experienced Users </h3>
<blockquote style="background-color:#EAF5FF; color:#364253; border-color:#3399FF; padding: 2% 3%">
📖 In the future, John develops a love for typing and now prefers to use just one line to complete a <a href="#glossary"><i>command</i></a>. He can use the <code>/help</code> <a href="#glossary"><i>command</i></a> to view how to use these single-line <a href="#glossary"><i>commands</i></a>.
</blockquote>

1. When John enters `help`, MoneyGoWhere prints out all the various [*commands*](#glossary) he can use. With the information printed out, he also now knows that there is a user guide!
   ![](https://i.imgur.com/FBxnCgC.png)

<h3> Error Messages </h3>

**1. Adding words or letters after the [*command*](#glossary)**

MoneyGoWhere does not allow for additional letters or words after the `help` [*command*](#glossary) word.

![](https://i.imgur.com/Wki6DmO.png)

**Solution:** Only enter the [*command*](#glossary) word, `help` or `/help`.

###### [Back to table of contents](#table-of-contents)

<hr style="width:70%;margin:50px auto;">

## Item Features

Before you start taking orders, you will need to set up your menu. This must be done at least once.

Depending on the size of your menu, you may need to spend quite a bit of time to add all of your menu items into
MoneyGoWhere. It is important that you do this before opening shop for the day, to ensure that your business can be run
without any disruptions.

You may continue to add new items to the menu at any point of time.
<!--This should be a one-time process, but you can always add more items or remove old items at any point.-->

## Item Table of Contents

* [Add an Item](#add-an-item)
* [List all Items](#list-all-items)
* [Delete an Item](#delete-an-item)
* [Update an Item](#update-an-item)
* [Find an Item](#find-an-item)

## Add an Item

If you need to add an item to the menu, you can use this [*command*](#glossary). To add an item, you will need the
item's
name and price.

<blockquote style="background-color:#EAF5FF; color:#364253; border-color:#3399FF; padding: 2% 3%">
📖 John wants to run a Chicken Rice store.  Currently, he only has two things to sell and has already set the cost: <strong>White Chicken Rice ($4.50)</strong> and <strong>Egg ($0.80)</strong>. He will need to use the <code>additem</code> <a href="#glossary"><i>command</i></a> to add these two items.
</blockquote>

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 There are restrictions for the name and price of items, as shown below:

</blockquote>

| Option      | Description            | Restrictions                                                                                                                                                                                                                                                   |
|-------------|------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Item Name` | The name of the item.  | Any input that is not empty and has less than 25 characters. <br> It cannot only have numbers.                                                                                                                                                                 |
| `Price`     | The price of the item. | A number, with up to 2 <a href="#glossary"><i>decimal places</i></a>. For example, `1`, `10.23` and `5.20` are valid inputs. However, `1.234` is not a valid input. <br> Avoid entering a high number, ie. above `100,000` as it may cause unexpected results. |


<h3> <strong>For New Users </strong></h3>

This example will show you how to add an item step-by-step.

1. John starts the application for the first time. He sees the greeting and knows that he set up the application
   correctly. Now, he wants to add **White Chicken Rice**, which costs **$4.50** to the menu.

   ![](https://i.imgur.com/YBkgvEQ.png)

2. He sees that he is successful and feels happy that the application is easy to use. Now, he wants to add **Egg**,
   which costs **$0.80** to the menu.

   ![](https://i.imgur.com/qeTaDFj.png)

3. Lastly, John uses [`listitem`](#list-all-items) to check that he has added the items correctly.

   ![](https://i.imgur.com/yiScNE0.png)

<hr style="width:50%;margin:50px auto;"/>

<h3> <strong>For Experienced Users </strong></h3>

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 To use the <a href="#glossary"><i>command</i></a> in this manner, remember to add a <code>/</code> before the <a href="#glossary"><i>command</i></a>, such as <code>/additem</code>. 
</blockquote>

**[*Command*](#glossary) Format**

These are the different [*command*](#glossary) formats that are accepted when adding a new item into the menu.

```text
/additem --name "<item name>" --price <price>
```

```text
/additem -n "<item name>" -p <price>
```

You may also interchange the location of the [*options*](#glossary) in the [*commands*](#glossary).

For example, the following [*command*](#glossary) is also valid.

```text
/additem  -p <price> -n "<item name>"
```

This example below will show you how to add an item in a single [*command*](#glossary).

1. John starts the application for the first time. He sees the greeting and knows that he set up the application
   correctly. Now, he wants to add **White Chicken Rice**, which costs **$4.50** to the menu.

   ![](https://i.imgur.com/iblVSBb.png)

2. He sees that he is successful and feels happy that the application is easy to use. Now, he wants to add **Egg**,
   which costs **$0.80** to the menu.

   ![](https://i.imgur.com/ARJOgRB.png)

3. Lastly, John uses [`listitem`](#list-all-items) to check that he has added the items correctly.

   ![](https://i.imgur.com/pYNA0uT.png)

<hr style="width:50%;margin:50px auto;"/>

<h3>Error Messages</h3>

<blockquote style="background-color:#FADDDD; color:#364253; border-color:#893232; padding: 2% 3%">
❗ The next few examples are invalid inputs, designed to show off some error messages we have in place. This is not the full list of error messages. Additionally, these error messages will be shown for both <strong>New User</strong> and <strong>Experienced User</strong> <a href="#glossary"><i>commands</i></a> if the mistake is made. 
</blockquote>

**1. Name already exists**

MoneyGoWhere does not allow for multiple items with the same name. If you try to put in an item with the same name, you
will get the following error.

![](https://i.imgur.com/ULSYB6F.png)

**Solution:** Use a different name.


**2. Price has more than two [*decimal places*](#glossary)**

MoneyGoWhere does not allow you to enter a number with more than two [*decimal places*](#glossary). This is because
there
are no such denominations in real life.

![](https://i.imgur.com/bGhE59B.png)

**Solution:** Limit the price to 2 decimal points.

###### [Back to table of contents](#table-of-contents)

<hr style="width:70%;margin:50px auto;"/>

## List all Items

To see all the items you have entered in your menu, use this [*command*](#glossary)!

<blockquote style="background-color:#EAF5FF; color:#364253; border-color:#3399FF; padding: 2% 3%">
    📖  John has spent the past 10 minutes entering all the items he plans to sell. Happy with his work, he wants to look at all the items in the menu to make sure that everything has been entered correctly. To view the items in his menu, he will need the <code>listitem</code> <a href="#glossary"><i>command</i></a>.
</blockquote>

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 This <a href="#glossary"><i>command</i></a> uses only one word. Adding anything else after the <a href="#glossary"><i>command</i></a> will cause MoneyGoWhere to not recognize the <a href="#glossary"><i>command</i></a>. 
</blockquote>

1. John has added 10 items to the menu, and he wants to check that they are all correct. He uses the [*command*](#glossary) `listitem`
   or `/listitem` to do so.

   ![](https://i.imgur.com/4TZqeA7.png)

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 Notice typos? Don't worry, it's intentional! These typos will be used in later sections. 
</blockquote>

<hr style="width:50%;margin:50px auto;"/>

<h3>Error Messages</h3>

<blockquote style="background-color:#FADDDD; color:#364253; border-color:#893232; padding: 2% 3%">
❗ The next example is an invalid input, designed to show off the error messages we have in place. This is not the full list of error messages. Additionally, these error messages will be shown for both <strong>New User</strong> and <strong>Experienced User</strong> commands if the mistake is made. 
</blockquote>

**1. Adding words or letters after the [*command*](#glossary).**

Adding anything after `listitem` or `/listitem` will cause the [*command*](#glossary) to be invalid.

![](https://i.imgur.com/oPwXAGW.png)

###### [Back to table of contents](#table-of-contents)

<hr style="width:70%;margin:50px auto;"/>

## Delete an Item

If you decide to stop selling a particular item, you can remove it from the menu with this [*command*](#glossary).

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">💡By using this <a href="#glossary"><i>command</i></a>, you may potentially change the other <a href="#glossary"><i>index</i></a> numbers of your other menu items. This may or may not affect the way you add items to orders. It is recommended that you use <code>listitem</code> to confirm if there are any changes.</blockquote>

To view more about listitem, [click here](#list-all-items).

<blockquote style="background-color:#EAF5FF; color:#364253; border-color:#3399FF; padding: 2% 3%">
📖  As per the previous example, John currently plans to sell Fried Rice. However, after asking his friends, he realized that no one wants to buy Fried Rice from a Chicken Rice stall. The menu currently looks like this: 

 <img src="https://i.imgur.com/V30OtYU.png">

So, he has decided to delete Fried Rice, which has an <a href="#glossary"><i>index</i></a> of <strong>8</strong> from his menu using
the <code>deleteitem</code> <a href="#glossary"><i>command</i></a>.
</blockquote>

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 There are restrictions for the index, as shown below:

</blockquote>

| Option  | Description                           | Restrictions                                                                                                                                         |
|---------|---------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Index` | The position of the item in the menu. | The entered number must be a valid <a href="#glossary"><i>index</i></a> number from `listitem`. <br> The entered number cannot be a negative number. |

<h3> For New Users </h3>

1. John wants to delete **Fried Rice**, which has [*index*](#glossary) number **8**.

![](https://i.imgur.com/M2twWZL.png)


<hr style="width:50%;margin:50px auto;"/>

<h3> For Experienced Users </h3>

**[*Command*](#glossary) Format**

```text
/deleteitem --index <index>
```

```text
/deleteitem -i <index>
```

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
    💡 To use the <a href="#glossary"><i>command</i></a> in this manner, remember to add a <code>/</code> before the <a href="#glossary"><i>command</i></a>, such as <code>/deleteitem</code>. 
</blockquote>

1. John wants to delete **Fried Rice**, which has [*index*](#glossary) number **8**.

![](https://i.imgur.com/Gagm3P2.png)

<h3>Error Messages </h3>
<blockquote style="background-color:#FADDDD; color:#364253; border-color:#893232; padding: 2% 3%">
    ❗ The next example is an invalid input, designed to show off the error messages we have in place. This is not the full list of error messages. Additionally, these error messages will be shown for both <strong>New User</strong> and <strong>Experienced User</strong> commands if the mistake is made. 
</blockquote>

**1. Invalid [*Index*](#glossary)**

You will not be able to delete an item if the [*index*](#glossary) number of that item does not exist in the menu.
In other words, you cannot remove something that does not exist!

![](https://i.imgur.com/dXH4yq4.png)

**Solution:** Use a valid [*index*](#glossary).

###### [Back to table of contents](#table-of-contents)

<hr style="width:70%;margin:50px auto;"/>

## Update an Item

Realised you entered the wrong name or price? You can update your items with this [*command*](#glossary) !

<blockquote style="background-color:#EAF5FF; color:#364253; border-color:#3399FF; padding: 2% 3%">
📖 John has been happily using MoneyGoWhere to input all his items. However, he is a bit clumsy and entered a few wrong things. This is what the menu currently looks like: 

<img src="https://i.imgur.com/6Q3hSNz.png"> 

He wants to change two things. First, the word <strong>"Vegebatles"</strong>, at <a href="#glossary"><i>index</i></a> number 6, is spelt
wrongly. Also, he wants to <strong>increase the price of "Vegetables" to $2.00</strong>.

Next, the item <strong>"Curry Chicken Rice" should cost $5.50</strong>. He can update these items with the <code>updateitem</code> <a href="#glossary"><i>command</i></a>.
</blockquote>

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 There are restrictions for the <a href="#glossary"><i>index</i></a>, name, and price of items, as shown below:
</blockquote>

| Option  | Description                                                  | Restrictions                                                                                                                                                      |
|---------|--------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Index` | The <a href="#glossary"><i>index</i></a> number of the item. | Must be a valid <a href="#glossary"><i>index</i></a> from `listitem`, cannot be a negative number. <br> This <a href="#glossary"><i>option</i></a> is compulsory. |
| `Name`  | The new name of the item.                                    | It cannot already exist in the menu. <br> This <a href="#glossary"><i>option</i></a> is not compulsory.                                                           |
| `Price` | The new price of the item.                                   | It can have at most two <a href="#glossary"><i>decimal places</i></a>. <br> This <a href="#glossary"><i>option</i></a> is not compulsory.                         |

<h3> For New Users </h3>

1. John wants to **change spelling of the word "Vegebatle" to "Vegetable"**. To do so, he first enters
   the [*command*](#glossary) `updateitem`, then confirms that he wants to change the name. He puts in the correct
   spelling, **without quotation marks**, and then indicates he does not want to change the price.

   ![](https://i.imgur.com/z09QX60.png)

2. John wants to **change the price of "Curry Chicken Rice" to $5.50, instead of $55**. To do so, he first enters the
   [*command*](#glossary), indicates he does not want to change the name, then confirms he wants to change the price. He
   then puts in
   the correct price.

   ![](https://i.imgur.com/esb1Agx.png)

3. After updating, John checks to make sure that the items are now correct with `listitem`.

   ![](https://i.imgur.com/w4JXXNl.png)

<hr style="width:50%;margin:50px auto;"/>

<h3> For Experienced Users </h3>

**[*Command*](#glossary) Format**

```text
/updateitem --index <index> {--name "<name>"} {--price <price>}
```

```text
/additem -i <index> {-n "<name>"} {-p <price>}
```

**Name and Price**
* Do note that of the two, at least one must be present in the [command](#glossary). This means that you can have one of the following combinations in it:
  * Name,
  * Price, or
  * Name and Price


<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 To use the <a href="#glossary"><i>command</i></a> in this manner, remember to add a <code>/</code> before the <a href="#glossary"><i>command</i></a>, such as <code>/updateitem</code>. 
</blockquote>

1. John wants to change the name "Vegebatle" to **"Vegetable"**. The item is currently at [*index*](#glossary) **6**.

   ![](https://i.imgur.com/k859ijM.png)

2. Next, John wants to change the price of "Curry Chicken Rice", at [*index*](#glossary) 8, to **$5.50** instead of $55.

   ![](https://i.imgur.com/4qA5esD.png)

3. After updating, John checks to make sure that the items are now correct with `/listitem`.

   ![](https://i.imgur.com/2gHDVK3.png)

<hr style="width:50%;margin:50px auto;"/>

<h3> Error Messages </h3>
<blockquote style="background-color:#FADDDD; color:#364253; border-color:#893232; padding: 2% 3%">
❗ The next example is an invalid input, designed to show off the error messages we have in place. This is not the full list of error messages. Additionally, these error messages will be shown for both <strong>New User</strong> and <strong>Experienced User</strong> commands if the mistake is made. 
</blockquote>

**1. Missing [*Index*](#glossary)**

Without indicating the [*index*](#glossary), MoneyGoWhere will not know what item you want to update.

![](https://i.imgur.com/ou1bDzX.png)

**Solution:** Include the [*index*](#glossary).

###### [Back to table of contents](#table-of-contents)

<hr style="width:70%;margin:50px auto;"/>

## Find an Item

If you forget the [*index*](#glossary) of an item, or want to see all items with a specific word in the name, you can
use
this [*command*](#glossary).

<blockquote style="background-color:#EAF5FF; color:#364253; border-color:#3399FF; padding: 2% 3%">
    📖  It's a new day and John wants to continue exploring MoneyGoWhere. However, his memory isn't the best, and he cannot remember how many items he has with the word "Chicken" in the name. So, he wants to find all of these items, with the <code>finditem</code> <a href="#glossary"><i>command</i></a>. 
</blockquote>

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 There are restrictions for keyword, as shown below: 
</blockquote>

| Option    | Description                                              | Restrictions                 |
|-----------|----------------------------------------------------------|------------------------------|
| `Keyword` | The name or part of the item name you are searching for. | The keyword cannot be empty. |

<h3> For New Users </h3>

1. John enters the [*command*](#glossary), and then enters "chicken" to search for all items that have "chicken" in the name,
   regardless of whether the item name contains capital letters.

![](https://i.imgur.com/0F1hPZK.png)


<hr style="width:50%;margin:50px auto;"/>

<h3> For Experienced Users </h3>

**[*Command*](#glossary) Format**

```text
/finditem "<keyword>"
```

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
    💡 To use the <a href="#glossary"><i>command</i></a> in this manner, remember to add a <code>/</code> before the <a href="#glossary"><i>command</i></a>, such as <code>/finditem</code>. 
</blockquote>

1. John enters the [*command*](#glossary), and then enters "chicken" to search for all items that have "chicken" in the name,
   regardless of capitalization.

![](https://i.imgur.com/g18iIZL.png)

<hr style="width:50%;margin:50px auto;"/>

<h3> Error Messages </h3>

<blockquote style="background-color:#FADDDD; color:#364253; border-color:#893232; padding: 2% 3%">
    ❗ The next example is an invalid input, designed to show off the error messages we have in place. This is not the full list of error messages. Additionally, these error messages will be shown for both <strong>New User</strong> and <strong>Experienced User</strong> <a href="#glossary"><i>command</i></a> if the mistake is made. 
</blockquote>

**1. Not entering a keyword**

Without a keyword, MoneyGoWhere will not know what to look for your menu.

![](https://i.imgur.com/0q8kQFd.png)

**Solution:** Include the word or letters you want to look for.

###### [Back to table of contents](#table-of-contents)

<hr style="width:70%;margin:50px auto;">

## Order Features

If you have been successful in adding items to your menu, congratulations! You are now ready to start taking orders.

During business operations, you will be spending almost all of your time adding orders on MoneyGoWhere.

Therefore, it is a good idea to give this section a read if you want to familiarise yourself with adding orders.

## Order Table of Contents

* [Add an Order](#add-an-order)
* [List all Orders](#list-all-orders)
* [Refund an Order](#refund-an-order)

## Add an Order

After adding your items to the menu, you can begin to take orders from your many customers with
this [*command*](#glossary).

Once an order has been added, the program will calculate the total cost of the order. You will then be asked to enter
how much the customer gives you into the program, and MoneyGoWhere will calculate the change for you.

<blockquote style="background-color:#EAF5FF; color:#364253; border-color:#3399FF; padding: 2% 3%">
📖  A few days later, John's Chicken Rice stall is finally open! John is so happy that he has MoneyGoWhere as it is very easy and intuitive to use. After familiarizing himself with the system, John is ready to take an order from his hungry customers. 

His menu currently looks like this:

<img src="https://i.imgur.com/GXwOhpJ.png"> 

His first customer orders just <strong>one plate of Roast Chicken Rice</strong>, and the second orders <strong>two
plates of White Chicken Rice, and two eggs</strong>.

To add their orders, he will use the <code>addorder</code> <a href="#glossary"><i>command</i></a>.
</blockquote>

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 There are restrictions for the <a href="#glossary"><i>index</i></a>/name and quantity of items, as shown below: 
</blockquote>

| Option       | Description                                                              | Restrictions                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
|--------------|--------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Index/Name` | The [*index*](#glossary) number or name of the item in the menu.         | If you choose to enter an [*index*](#glossary) number, it must be a valid [*index*](#glossary) number from `listitem`. The [*index*](#glossary) number cannot be negative. <br> You may also choose to enter the full or partial name of the item. However, the entered part of the name must be specific. <br> In other words, if your menu contains items with names such as `Chicken Rice`, `Chicken Noodle`, and `Cereal`, then you at least have to enter `chicken r`, `ice`, or `rice` so that the program knows that you are trying to enter `Chicken Rice` and not any of the other two items. |
| `Quantity`   | The number of the specified menu item that the customer wishes to order. | The quantity cannot be negative, and avoid entering numbers larger than `10000` as it can cause the program to work incorrectly.                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 As for payment, there are restrictions for the amount, and payment type:
</blockquote>

| Option   | Description                       | Restrictions                                                                                     |
|----------|-----------------------------------|--------------------------------------------------------------------------------------------------|
| `amount` | The amount paid by your customer. | Can have up to two decimal points, and has to be the same or greater than the cost of the order. |
| `type`   | The type of payment.              | The accepted inputs are `cash`, `card`, or `others`.                                             |


<h3> For New Users </h3>

1. John enters the [command](#glossary) `addorder`.

   He forgets the [*index*](#glossary) of "Roast Chicken Rice", and instead chooses to search by name instead of [*index*](#glossary). Take note that
   the item name must be entered within `""` marks.

   Next, he enters the quantity and states that he has no more items to add. As the customer pays with cash, John then
   enters the payment information.

   ![](https://i.imgur.com/3MLgvzN.png)

   <blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
   💡 When prompted to add more items, entering anything other than the provided inputs will cause MoneyGoWhere to interpret the input as <code>cancel</code>. 
   </blockquote>

2. For the second customer, John repeats the same process.

   He enters the [*command*](#glossary), then the [*index*](#glossary) of "White Chicken Rice" and indicates the quantity.

   He repeats the same process for adding "Egg" to the order, then completes the process by entering the payment
   details.

   ![](https://i.imgur.com/AoK5cUD.png)

<hr style="width:50%;margin:50px auto;"/>

<h3> For Experienced Users </h3>

**[*Command*](#glossary) Format**

There are two main ways in which an order can be entered using a single `/addorder` [*command*](#glossary). Listed below are the
acceptable formats of the `/addorder` [*command*](#glossary).

1. To add a single item into an order, using the item [*index*](#glossary), by using the item name, or by using part of
   the item name,
   use any of these formats:
    ```text
    /addorder -i <index> -q <quantity>
    ```
    ```text
    /addorder --item <index> -q <quantity>
    ```
    ```text
    /addorder -i "<name>" --quantity <quantity>
    ``` 

    ```text
    /addorder --item "<name>" --quantity <quantity>
    ```
   If the quantity is not specified, it will be set to 1.

2. To add multiple items into an order using the item [*indexes*](#glossary), by using the item names, or by using part
   of the item
   names, use any of these formats:
    ```text
    /addorder -I [<index>:<quantity>,"<name>":<quantity>,...]
    ```
    ```text
    /addorder --items [<index>:<quantity>,"<name>":<quantity>,...]
    ```

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
    💡 To use the <a href="#glossary"><i>command</i></a> in this manner, remember to add a <code>/</code> before the <a href="#glossary"><i>command</i></a>, such as <code>/addorder</code>.
</blockquote>

Here is an example of how the `/addorder` [*command*](#glossary) may be used to add orders.

1. John enters the [*command*](#glossary) `/addorder`. He uses the [*index*](#glossary) of "Roast Chicken Rice", and enters the
   quantity.

   As his customer pays with cash, John then enters the payment information with the `/pay` [*command*](#glossary) and by entering the
   customer's payment details based on the instructions from the program.

   ![](https://i.imgur.com/QCkbbcR.png)

2. For the second customer, John temporarily forgets the [*index*](#glossary) of "White Chicken Rice".

   As he knows there is only one item with "White Chicken" in the name, he enters that as the first item, along with the
   quantity.

   Then, he uses the [*index*](#glossary) of "Egg", along with the quantity. After adding both items, he proceeds to
   enter the payment.

   This time, the customer chose to pay by card, which John enters into the application to reflect that mode of payment.

   ![](https://i.imgur.com/8cjkkOK.png)

<hr style="width:50%;margin:50px auto;"/>

<h3> Error Messages </h3>

<blockquote style="background-color:#FADDDD; color:#364253; border-color:#893232; padding: 2% 3%">
    ❗ The next example is an invalid input, designed to show off the error messages we have in place. This is not the full list of error messages. Additionally, these error messages will be shown for both <strong>New User</strong> and <strong>Experienced User</strong> <a href="#glossary"><i>commands</i></a> if the mistake is made. 
</blockquote>

**1. Insufficient cash**

This error message will appear when the customer attempts to pay an amount less than the total cost of their order.

![](https://i.imgur.com/BHSv3ZA.png)

**Solution:** Ensure that the customer pays more than or the exact cost of the order.

**2. Paying with card**

When your customers pay with their card, entering an amount different from the subtotal will be rejected.

![](https://i.imgur.com/F15Xj8G.png)

**Solution:** Enter the exact price of the order into the program.

###### [Back to table of contents](#table-of-contents)

<hr style="width:70%;margin:50px auto;"/>

## List all Orders

After a long, busy, and profitable day, you can use this [*command*](#glossary) to review all the orders you have entered.

This feature allows you to view the cost, order IDs, the items included in each order, and the time at which the orders
were made.

<blockquote style="background-color:#EAF5FF; color:#364253; border-color:#3399FF; padding: 2% 3%">
📖 John's first day is a huge success! He has fed so many hungry students and could see them enjoying his delicious food. At the end of the day, he wants to take a look at all the orders he has taken over the day. He will use the <code>listorder</code> command. 

<strong>Note: Only the first two orders will be shown to reduce the length of the user guide.</strong>
</blockquote>

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 This <a href="#glossary"><i>command</i></a> uses only one word. Adding anything else after the <a href="#glossary"><i>command</i></a> will cause MoneyGoWhere to not recognize the <a href="#glossary"><i>command</i></a>. 
</blockquote>

1. John uses the [*command*](#glossary) `listorder` or `/listorder` to look through all his orders.

   ![](https://i.imgur.com/HPkJTvq.png)

<hr style="width:50%;margin:50px auto;"/>

<h3> Error Messages </h3>

<blockquote style="background-color:#FADDDD; color:#364253; border-color:#893232; padding: 2% 3%">
❗ The next example is an invalid input, designed to show off the error messages we have in place. This is not the full list of error messages. Additionally, these error messages will be shown for both <strong>New User</strong> and <strong>Experienced User</strong> <a href="#glossary"><i>commands</i></a> if the mistake is made. 
</blockquote>

**1. Adding words or letters after the [*command*](#glossary).**

As mentioned, adding anything after `listorder` or `/listorder` will cause the [*command*](#glossary) to be an invalid error.

![](https://i.imgur.com/taGiKBr.png)

###### [Back to table of contents](#table-of-contents)

<hr style="width:70%;margin:50px auto;"/>

## Refund an Order

Did you enter the wrong item, or did a customer change their mind after paying for an item?

Don't worry! If the order has not yet been served or if you allow it, you can use this [*command*](#glossary) to mark an order as
refunded.

<blockquote style="background-color:#EAF5FF; color:#364253; border-color:#3399FF; padding: 2% 3%">
📖  After using MoneyGoWhere for a few days, John has encountered his worst nightmare: an indecisive customer! This customer wanted Curry Chicken Rice with Vegetables, but has now changed his mind. 

Not wanting to receive bad reviews about his newly opened stall, John decides to give in to his demands for a refund.

John checked his list of orders using the <code>listorder</code> <a href="#glossary"><i>command</i></a>, and found out that the order ID is <strong>9a382d0f-81ee-4855-b29e-547e8e164f9a</strong>.

John needs to refund the order, and can do so with the <code>refundorder</code> <a href="#glossary"><i>command</i></a>.
</blockquote>

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 There are restrictions for the name and price of items, as shown below:

</blockquote>

| Option     | Description                    | Restrictions                                                                                                                       |
|------------|--------------------------------|------------------------------------------------------------------------------------------------------------------------------------|
| `Order ID` | A randomly generated order ID. | The entered ID must be a valid entered as shown exactly from the output of the `listorder` <a href="#glossary"><i>command</i></a>. |

<h3> For New Users </h3>

1. John uses `listorder` to look through the list of orders and gets the ID as `9a382d0f-81ee-4855-b29e-547e8e164f9a`.
   He then copies the ID.
2. Next, he uses the [*command*](#glossary) `refundorder` and inputs the copied order ID from earlier, when asked to do so by the
   program.

![](https://i.imgur.com/mEdseoT.png)


<hr style="width:50%;margin:50px auto;"/>

<h3> For Experienced Users </h3>

**[*Command*](#glossary) Format**

```text
/refundorder -i <order_id>
```

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 To use the <a href="#glossary"><i>command</i></a> in this manner, remember to add a <code>/</code> before the <a href="#glossary"><i>command</i></a>, such as <code>/refundorder</code>. 
</blockquote>

1. John uses `/listorder` to look through the list of orders and gets the ID as `9a382d0f-81ee-4855-b29e-547e8e164f9a`.
   He copies the order ID from the [*CLI*](#glossary).
2. Next, he uses the [*command*](#glossary) `/refundorder` and inputs the copied order ID from earlier.

![](https://i.imgur.com/HYRlOwu.png)

<hr style="width:50%;margin:50px auto;"/>

<h3> Error Messages </h3>

<blockquote style="background-color:#FADDDD; color:#364253; border-color:#893232; padding: 2% 3%">
❗ The next example is an invalid input, designed to show off the error messages we have in place. This is not the full list of error messages. Additionally, these error messages will be shown for both <strong>New User</strong> and <strong>Experienced User</strong> <a href="#glossary"><i>commands</i></a> if the mistake is made. 
</blockquote>

**1. Wrong order ID.**

If you entered an invalid or non-existent order ID, MoneyGoWhere will not recognise it.

![](https://i.imgur.com/UwyZCfT.png)

**Solution:** Copy the order ID directly from `listorder` and paste it to ensure there are no errors.
</br>

###### [Back to table of contents](#table-of-contents)

<hr style="width:70%;margin:50px auto;"/>

## Statistics and Report

This important feature of MoneyGoWhere allows you to generate reports to view sales data. For now, there is only one way
to generate reports.

<blockquote style="background-color:#EAF5FF; color:#364253; border-color:#3399FF; padding: 2% 3%">
📖  At this point, John has been running the stall for a few months. He's making so much money that it is hard for him to keep track of how much money he has made. He wants to see four things: 

1. For the year 2023, which items bring in the most income?

2. For the month of January, which were ordered the most?

3. John wants to check how his income has changed over the year.

4. John wants to check his income for the first 10 days of March.
</blockquote>

**[*Command*](#glossary) Format**

```text
/report {--rank <type>} {--sale <type} {--year <year>} {--from <start-date> --to <end-date>}
```

```text
/report {-r <type>} {-s <type} {-y <year>} {-f <start-date> -t <end-date>}
```

<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 We understand that these <a href="#glossary"><i>command</i></a> formats may be complicated. Here is a refresher on how such formats can be more easily understood.
<br>
1. Any words surrounded by <code><></code>. 
<br>
2. <a href="#glossary"><i>Options</i></a> that are surrounded by <code>{}</code> are optional. 
<br>
3. All values have to be accompanied by <a href="#glossary"><i>options</i></a> (begins with <code>-</code>, such as <code>-n</code> or <code>--price</code>). <a href="#glossary"><i>Commands</i></a> such as <code>/deleteitem delete -i 10</code> will be an invalid <a href="#glossary"><i>command</i></a>.
</blockquote>


<blockquote style="background-color:#FEEFD0; color:#364253; border-color:#877039; padding: 2% 3%">
💡 There are restrictions for <a href="#glossary"><i>options</i></a>, as shown below:

</blockquote>

| Option          | Description                                                      | Accepted Inputs                                                                                          |
|-----------------|------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| `rank`          | Order items in the menu based on criteria.                       | `sales` or `popular`                                                                                     |
| `sale`          | Shows your income based on criteria.                             | `daily` or `monthly`                                                                                     |
| `year`          | The year you are trying to generate a report for.                | A year in the format `YYYY`. Entering a negative year will cause the application to not work as intended |
| `from` and `to` | The start and end dates you are trying to generate a report for. | A date in the format `DD/MM/YYYY`                                                                        |


Don't worry if you find yourself still confused by the format. We admit, it is pretty complex. So, let's break it down:

**Rank vs Sale**

Of the two, only one can be present in your [*command*](#glossary).

* When generating your report, you can choose between the [*options*](#glossary) `rank` or `sale`.
   * Rank orders the items on your menu based on either `sales` (monetary income) or `popular` (quantity ordered).
   * Meanwhile, Sale shows your income, either on a `daily` basis or `monthly` basis.

**Year vs From/To**

Of the two, only one can be present in your [*command*](#glossary).

* You can choose which dates to generate the report.
   * Year takes the format `YYYY`
   * From/To takes the format `DD/MM/YYYY`

<blockquote style="background-color:#EAF5FF; color:#364253; border-color:#3399FF; padding: 2% 3%">
📖  Now, we will show you how John was able to use this <a href="#glossary"><i>command</i></a> to achieve his goals. 
</blockquote>

1. John indicates the `rank` [*option*](#glossary) to be `sales`, and the `year` to be `2023`.

   ![](https://i.imgur.com/5QhmPmq.png)

2. John indicates the `rank` [*option*](#glossary) to be `popular`, and the date range to be from `01 Jan 2023`
   to `31 Jan 2023`.

   ![](https://i.imgur.com/3bVzNuc.png)

3. Now, he wants to look at his monthly sales report for 2023. He indicates the `sale` [*option*](#glossary) to
   be `monthly` and
   enters `2023` for the `year` [*option*](#glossary).

   Note that the remaining months have been removed as they are all empty.

   ![](https://i.imgur.com/gCxyEhW.png)

4. Lastly, he wants to check his daily sales report for the first 10 days of March 2023. He indicates the `sale` [*option*](#glossary)
   to be `daily` and enters the date range `01/03/2023` to `10/03/2023`.

   ![](https://i.imgur.com/RCFs2KN.png)

<hr style="width:50%;margin:50px auto;"/>

<h3> Error Messages </h3>
<blockquote style="background-color:#FADDDD; color:#364253; border-color:#893232; padding: 2% 3%">
❗ The next example is an invalid input, designed to show off the error messages we have in place. This is not the full list of error messages.
</blockquote>

**1. Generating a Montly Sale report with From/To**

This happens when you try to generate a montly sale report without using the `year` [*option*](#glossary).

![](https://i.imgur.com/RNe0j66.png)

**Solution:** When generating a monthly sale report, use the `year` [*option*](#glossary).

**2. Wrong Date Format**

This happens if you enter the wrong format for the date, such as swapping the month and day.

![](https://i.imgur.com/BWY4U4X.png)

**Solution:** Use the correct format of `DD/MM/YYYY`.

###### [Back to table of contents](#table-of-contents)

<hr style="width:90%;margin:50px auto;"/>

## Frequently Asked Questions

**Q: I'm switching to a new laptop. Do I need to re-enter all the items on my menu? And what about my transactions?**

**A:** Don't worry! At MoneyGoWhere, we understand that you may change the laptop you use. When changing to a new
laptop, simply copy the entire folder! This way, the application and all your data will stay the same across devices.

**Q: Where is my save file?**

**A:** Your menu and transaction list are stored in a folder called `datastore`. Inside it, you should see two
files: `menu.json` and `orders.json`. However, all changes to your data should be made through the application itself,
as we are not liable for any data loss as a result of [*tampering*](#glossary) with those files.

###### [Back to table of contents](#table-of-contents)

<hr style="width:90%;margin:50px auto;"/>

## Glossary

| Term                   | Explanation                                                                                                                                                                        |
|------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Computer Program       | An application or app that you run on computers.                                                                                                                                   |
| Point-of-Sale System   | A set of devices, software and payment services merchants use to make and track sales in person.                                                                                   |
| Hyperlink              | A phrase or text that you can click.                                                                                                                                               |
| CLI                    | An abbreviation for Command Line Interface.                                                                                                                                        |
| Command Line Interface | A text-based interface. This means there are no icons to click and everything has to be typed.                                                                                     |
| Command                | An instruction given to the program.                                                                                                                                               |
| Terminal               | A tool used to run CLI commands and other tools. It accepts text input and outputs text.                                                                                           |
| Copyright              | A type of intellectual property that gives its owner the exclusive right to copy, distribute, adapt, display, and perform a creative work.                                         |
| Decimal Places         | The number of digits behind a decimal point. For example `2.123` has 3 decimal places, while `4.20` has 2 decimal places.                                                          |
| Index                  | A set of ordered numbers used to uniquely indicate items in a list. For example, index numbers are used to uniquely identify the different levels of a building.                   |
| Option                 | Used to specify instructions and change the behaviour of a command. In this application, options have a short-form and a long-form, for example, in the case of `-n` and `--name`. |
| Tampering              | The act of intentionally changing an object, in this case, a file, that is not intended to be changed.                                                                             |

###### [Back to table of contents](#table-of-contents)
  
