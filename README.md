# BlackjackProject

# Description
- Working blackjack application that allows player to play Aces high blackjack against the dealer until they choose to quit or the deck of cards is too low. Rank, Suit, Card, Deck and Hand classes are independent and can be used for the starting basis of any standard 52 card game.

# Technologies Used
- Java
- Eclipse
- Git

# Lessons Learned
- To start this project we had an separate lab where we built general classes to be used for future game applications (Rank, Suit, Card, Deck, Hand). I then created blackjack specific classes that could be easily modified for other games (Player, Dealer, BlackjackHand). 
- The logic for the program is wholly contained in the BlackjackApp. 
- Encapsulation was used however it could probably be tightened up with more practice. Hand is a parent class that is extended by the BlackjackHand class and includes an abstract method getHandValue(). Player is also a parent class that is extended by Dealer who is by default also a player, albeit one that must follow predetermined logic.
- Conditional statements such as loops and if-statements are abundant and could be refactored for a cleaner read through. However given the time constraints and complexity I was happy with meeting the requirements and adding some minor novelties such as a visually appealing menu, unicode emojis, troubleshooting a pesky scanner and adding System.exit() methods for the first time.  
- The BlackjackApp works by creating an instance of the BlackjackApp in main and using launch() to begin the program by running shuffleAndDeal() then hitOrStay(). 
- shuffleOrDeal() calls the Dealer class to shuffle() and return the Deck. Inside of shuffleOrDeal() another method, dealerDeal() runs using a for loop to deal the initial cards, showing the Players hand and total and showing only the second card of the Dealer.
- hitOrStay() then runs which determines if the Player has 21 and won. Else a menu is printed displaying the game options with user input being read by a scanner and iterating through a do while loop with a switch to execute the appropriate next step.
- Within the hitOrStay() loop are two if statements with boolean methods housed within BlackjackHand for either hitting 21 or going over.
- The player can quit at any point during their turn or upon a new hand. After finishing their turn by executing stay() the dealers turn begins. The dealer has predetermined logic, held within dealersLogic() using if-statements and a for loop, which is based on the rules of blackjack. After the dealer shows 17 or higher a whoWon() method is called and returns the winner in a printed statement and calls playAgain().
- playAgain() will run a new game using the same shuffled deck of cards until the deck is too low for a full game.