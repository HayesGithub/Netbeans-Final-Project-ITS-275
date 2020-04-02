/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codepackage;
 import java.util.Random;
	//Java utility used to create a random number

	import java.util.Scanner;
	//Java utility that generates random outcomes

/**
 *
 * @author hahay
 */
public class coinflipbody {

	static Scanner input = new Scanner(System.in);
	// create new static scanner that use's system in

	static String name;
	// String name to store input from user as "name"

	static String[] mainmenu = {"1.) Play Game", "\n2.) Rules", "\n3.) Exit Game"};
	// Array used for displaying the Game Menu options

	static int currency;
	//Static integer variable named "currency" that stores the user's current currency

	static int betchoice;
	//Static integer variable named "betchoice" used to store user choice for heads or tails

	static int betcurrency;
	//Static integer used to store the user's currency they wish to bet on the next coin flip


	public static void menudisplay() {
	//Method that ask's user for name and displays the welcome line

	System.out.println("Please enter your name here: ");
	//Print line asking user for name input

	name = input.nextLine();
	//Assigning next line input to the variable "name"

	playgamemenu();//Calls to the playgamemenu() method
	}

	public static void playgamemenu() {
	//Method that displays the Game Menu, read's user input to determine the user selection

	System.out.println("Welcome, "+ name +"!" + "\n\nGAME MENU" + "\n\nContinue by selecting a number: \n");
	//System out print line welcoming user to game and stringing the user name input to the welcome line

	for(int i=0;i<mainmenu.length;i++) {
	System.out.println(mainmenu[i]);
	//For loop that accesses the mainmenu Array
	}

	int menuselect = input.nextInt();
	//New integer that stores the next user input integer as "menuselect"

	if (menuselect == 1) {
	currency();
	//If statement that declares if the user input integer for "menuselect" is equal to 1, access the currency() method  
	}

	else if (menuselect == 2) {
	rules();
	//Else if statement that declares if the user input integer for "menuselect" is equal to 2, access the rules() method
	}

	else { exitgame();}
	//Else statement that declares if the user inputs anything other that 1 or 2 for the integer "menuselect" access the exitgame() method
	}

	public static void rules() {
	//Method that displays the Rules

	int answer;
	//Declares answer as an integer value

	System.out.println("Double or Nothing Rules: \n\nThis game is very simple, Heads or Tails with a little twist!\n\n1.) You will start with a determined amount of money.\n");
	System.out.println("2.) You will then be given the option of choosing Heads or Tails. You do this by entering either 1 for Heads or 2 for Tails\n");
	System.out.println("3.) After you enter your choice, you will then be propted to enter the wager you wish to bet out of the intial money.\n");
	System.out.println("4.) The game will generate a random outcome for the coin toss, depending on that outcome you will either win or lose that coin flip.\n");
	System.out.println("5.) If you win, you will recieve double the wager you placed. If you lose you will lose you will recieve nothing and the wager placed will be subtracted from your money pool.\nYour new balance will be presented.\n");
	System.out.println("6.) You will then be given an option to keep playing or cash out. If you cash out, the game ends and you will see your total winnings for that game\n\n");
	//System out print lines that display the game rules

	System.out.println(name + ", are you flippin ready?\n");
	System.out.println("Yes (1) or No (2): ");
	//System out that prompts the user to select if they are ready to play the game

	answer = input.nextInt();
	//Declares next integer input to be assigned to the answer integer
	if (answer == 1) {
	System.out.println("\nGreat, Good Luck!");
	currency();
	//If statement that uses the user input for the answer integer, if it equals to 1, access the currency() method
	}

	else { playgamemenu();}
	//Else statement that uses the user input for the "answer" integer, if it equals anything other than 1, access the playgame() method
	}

	public static void currency() {
	//Method that assign's a value to the "currency" static integer and display's it to the user

	currency = 1000;
	//Assigning value of 1000 to the user's "currency" static integer

	System.out.println("\nYou have $"+currency+" to play with.");
	//System print line that display's to the user how much "currency" they start with

	betchoice();
	//Accesses the betchoice() method
	}

	public static void betchoice() {
	//Method that takes user input and stores it as "betchoice" variable, check's to make sure user has entered a valid option

	System.out.println("\nPlease select what side of the coin you would like to choose.\n\nHeads (1) or Tails (2):");
	//System print line asking the user to select what side of the coin they wish to bet on using 1 for heads and 2 for tails

	betchoice = input.nextInt();
	//Declares "betchoice" as the next input integer

	if(betchoice>=3) {
	System.out.println("That is not an option!");
	betchoice();
	//If statement that checks to make sure the user has entered a valid option, if user selects 3 or higher it displays "not an option" and returns to betchoice() method
	}

	else
	userbet();
	//Else statement that accesses the userbet() method if the user has input a vailid choice option 1 or 2
	}

	public static void userbet() {
	//Method that prompts the user to enter a wager and stores it as "betcurrency" integer variable
	//Method checks to make sure user has enough currency to place the wager

	System.out.println("\nPlease enter the wager you wish to place: ");
	//Print line that prompts user to enter a wager they wish to place

	betcurrency = input.nextInt();
	//Sets "betcurrecny" as the next integer input

	if(betcurrency>currency) {
	System.out.println("You dont have enough to bet that much!");
	betchoice();
	//If statement that checks if the bet currency is less than the amount of currency the user has
	//If true the program displays they don't have enough to bet this much, returns to betchoice() method
	}

	else if (currency == 0) {
	System.out.println("Sorry, you have lost everything!");
	exitgame();
	//Else if statement that check's to see if the user's currency is equal to 0, if true display sorry you lost everything
	//If true return to exitgame() method
	}

	else {
	System.out.println("You bet $"+ betcurrency + " on this game.");
	coinflip();
	//Else statement when user inputs a valid wager, displays print line showing the amount of currency they placed on this flip
	//If true access coinflip() method
	}
	}

	public static void coinflip() {
	//Method that generates a random outcome for coin flip, compares to user input
	//Lets user know if they win or lose, depending on outcome will increase or decrease user total currency

	Random rnd = new Random();
	//declaring rnd as a new random variable number

	int n1 = rnd.nextInt(2)+1;
	//Declare "n1" to store the next "rnd" random integer

	int C = 2;
	//Declare Integer constant as variable C to be set equal to 2

	int pot = betcurrency * C;
	//Declare integer "pot" to be equal to "betcurrency" multiplied by the constant C

	int win = currency + pot;
	//Declare integer "win" to be equal to "currency" variable added to the "pot" integer

	int lose = currency - betcurrency;
	//Declare integer "lose" to be equal to "currency" variable minus the value the user entered to "betcurrecy"

	System.out.println("\nThe coin landed on " + n1);
	//System print line showing the user what side the coin landed on using the value from "n1"

	if (betchoice == n1) {
	System.out.println("\nAwesome! You won $" + pot + "\n\nYour new balance is $" + win );
	currency = win;
	cashout();
	//If statement that compares the user input from "betchoice" to check if it is equal to random value "n1"
	//If user choice equals random result, displays winnings, adds winnings to currency value to display new balance
	//Returns to the cashout() method
	}

	else {
	System.out.println("\nSorry, you lost $" + betcurrency + "\n\nYour new balance is $"+ lose);
	currency = lose;
	//nested Else statement that displays if the user loses the coin flip, displays the amount lost and new balance after wager has been subtracted

	if (lose == 0) {

	System.out.println("\n\nYou are all out of money!");
	exitgame();}
	//nested if statement checks to see if the amount of money lost brings the balance of currency to 0, retruns to exitgame() method

	else {cashout();}
	//nested else statement returns to the cashout() method
	}
	}

	public static void cashout() {

	System.out.println("\nKeep Playing (1) or Cash out (2):");
	//prompts user to chose between keep playing or cash out

	int response;
	//declares "response" as new integer variable

	response = input.nextInt();
	//set response equal to next integer input from scanner

	if (response>=2) {
	System.out.println("\nCongrats, " + name + "!" + "\n\nYour total winning's for this game is: $" + currency);
	exitgame();
	//if statement that will display winnings if the user chooses to cash out by inputing a value >=2 , then returns to "exitgame()" method
	}
	else {betchoice();}
	//else statement that returns to "betchoice()" method if the user wishes to continue playing
	}

	public static void exitgame() {
	//Method that is used to exit the game, ask user if they would like to play again if they lost all their currency

	int answer1;
	//Declares "answer1" to be a new integer variable


	System.out.println("\n\nDo you wish to play a new game?");
	//Prompts user to answer if they wish to play a new game

	System.out.println("\nYes (1) or No (2): ");
	//Prompts user to answer if they wish to play a new game

	answer1 = input.nextInt();
	//Assigns "answer1" integer to be the next input integer

	if (answer1 == 1) {
	System.out.println("\nGreat, Good Luck " + name + "!");
	currency();
	//If statement that compares user input for "answer1" to 1 to see if they wish to play another game
	//If true returns to currency() method
	}
	else {
	//Else statement that displays have a great day plus the string "name" if user enters anything other than 1 for "answer1" input
	System.out.println("\nThanks for playing Double or Nothing, " + name +"!");
	//Print line displaying thank you for playing Double or Nothing with string "name" inserted
	System.out.println("\nHave a Great Day!");
	//Print line displaying have a great day

	}

	}



}
