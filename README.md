Brief

The Brief for this task was to produce a programme that allows the player to play two separate card games through the
terminal in Java. The requirements stated that we work together to build classes for the deck and card classes and then
work separately to build two separate card games that can be selected through a menu system in the game.

The two games that you can play though the programme are Three Card Poker and BlackJack. The rules can be accessed in
the game and also from the Assets folder.

The Card Game allows the player to enter their name and submit their winning scores to a leaderboard.

-------------

File Structure

```
card-games
├── README.md
├── pom.xml
├── src
│   └── main
│       └── java
│           └── org
│               └── example
│                   ├── Assets
│                   │   ├── BlackjackRules.txt
│                   │   ├── BlackjackScores.txt
│                   │   ├── PokerRules
│                   │   ├── PokerRules.txt
│                   │   ├── PokerScores.txt
│                   │   ├── Rules BlackJack.txt
│                   │   └── Welcome.txt
│                   ├── CardDeck
│                   │   ├── Card.java
│                   │   ├── Deck.java
│                   │   ├── Suits.java
│                   │   └── Symbols.java
│                   ├── Games
│                   │   ├── BlackJack
│                   │   │   └── BlackJack.java
│                   │   └── Poker
│                   │       ├── Color.java
│                   │       ├── Dealer.java
│                   │       ├── HandState.java
│                   │       └── Poker.java
│                   ├── Main.java
│                   └── UserInteractions
│                       ├── CommandOptions.java
│                       ├── FileRead.java
│                       ├── ListOfCommands.java
│                       └── UserPlayer.java
```

----------------------

Shared game classes and responsabilities

Card.java:

- Holds the variables for each individual card
- Overrides Comparable.compare method to compare card values

Deck.java:

- Build a deck of 52 cards with different values, suits and symbols
- Shuffles the deck
- Deals cards

Suits.java:

- Defines enum for all card suits

Symbols:

- Defines enum for all card symbols

CommandOptions.java:

- Defines enum for all CLI messages

FileRead.java:

- Instantiates Buffer reader and Buffer writer
- Writes scores to leaderboards
- Reads and prints scores from leaderboards
- Reads and prints instructions files
- Reads and prints Welcome screen

UserPlayer:

- Receives number input from user and returns it to the game

Poker solo classes and responsabilities

Color.java:

- Holds ANSI escape codes and color variables

Dealer.java:

- Handles hand comparison logic
- Handles winning logic

Handstate.java:

- Holds game state
- Holds hands state

Poker.java:

- Handles game logic
- Prints messages to the CLI.

Black Jack solo classes responsibilities:

Black Jack:

- Handles Gameplay Flow
- Receives Input From The Player
- Computes When Player Has Gone Bust
- Decides When Computer Should Stick Or Twist
- Ends Game and Writes To Leaderboard

-----------------------


Code Authors
Hamish Lawson & Pablo Rial