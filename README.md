
Brief

The Brief for this task was to produce a programme that allows the player to play two separate card games through the terminal in Java. The requirements stated that we work together to build classes for the deck and card classes and then work separately to build two separate card games that can be selected through a menu system in the game.

The two games that you can play though the programme are Three Card Poker and BlackJack. The rules can be accessed in the game and also from the Assets folder.

The Card Game allows the player to enter their name and submit their winning scores to a leaderboard.   

-------------

File Structure
```
card-games
── src
   ├── main
   │   └── java
   │   	└── org
   │       	└── example
   │           	├── Assets
   │           	│   ├── BlackjackRules.txt
   │           	│   ├── BlackjackScores.txt
   │           	│   ├── PokerRules
   │           	│   ├── PokerRules.txt
   │           	│   ├── PokerScores.txt
   │           	│   ├── ReadMe.md
   │           	│   └── Rules BlackJack.txt
   │           	├── CardDeck
   │           	│   ├── BlackJackCard.java
   │           	│   ├── Card.java
   │           	│   ├── Dealer.java
   │           	│   ├── Deck.java
   │           	│   ├── Suits.java
   │           	│   └── Symbols.java
   │           	├── Games
   │           	│   ├── BlackJack
   │           	│   │   └── BlackJack.java
   │           	│   └── Poker
   │           	│   	├── ComputerHandState.java
   │           	│   	├── PlayerHandState.java
   │           	│   	└── Poker.java
   │           	├── Main.java
   │           	└── UserInteractions
   │               	├── CommandOptions.java
   │               	├── ComputerPlayer.java
   │               	├── FileRead.java
   │               	├── ListOfCommands.java
   │               	├── Player.java
   │               	├── ScoreKeeping.java
   │               	└── UserPlayer.java
   └── test
   	└── java
       	└── org
           	└── example
               	└── CardDeck
                   	├── DealerTest.java
                   	└── DeckTest.java

```
----------------------
Code Authors
Hamish Lawson & Pablo Rial