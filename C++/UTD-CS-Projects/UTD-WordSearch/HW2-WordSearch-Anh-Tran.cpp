/*
    Name: Anh Tran
    Program name: SnakeGame
    Date Created: 01/24/22
    Notes:
        -   Should be able to create multiple fruits and automatically
            add a new one to replace when eaten
        -   Should asked if user wants to replay the game after losing
        -   Separate the code into multiple functions to hide info about
            the program and shorten lines in each functions (separate of concerns)
        -   Show instructions and game setups for the user to decide on
        -   The user should be able to pause the game at any given time
            and re-pause the game also.
        -
    Changelog:
        -   01/24/22 - v1: reformatted the style of the program to Java.
        -   01/28/22 - v2:
            -   re-factored names of global variables:
                    +   x, y to snakeHeadXLoc, snakeHeadYLoc
                    +   fruitX, fruitY to fruitXLoc, fruitYLoc
                    +   nTails to numTails
                    +   dir to snakeDir
            -   added the code of GenerateFruit() that was
                originally in the Setup().
            -   added the code of BorderDraw() that was
                originally in the Draw().
            -   added the code of WallCollision(), HeadTailCollision(),
                and TailIncrease() that were originally in the Logic().
            -   added the code of Movement() that was
                originally in the Logic().
            -   added a new constant: const int fruitBonus for the
                score to update when it eats a fruit
        -   01/30/22 - v3:
            -   added a fruitBonus global variables for the score
                to increment when eaten a fruit
        -   02/04/22 - v4:
            -   added new global variables:
                    +   speed - for the snake's speed
                    +   hardMode - for the game's difficulty involving hitting the wall
                    +   numFruits - for the number of fruits on the board at any time
                    +   fruitLimit - constant variable for limit of fruits that can be generated
                    +   maxTails - constant variables for maximum tails that can be drawn
            -   added a debugging showFlow() function that shows what the current function,
                that it is in, is called
            -   rewrote the code for the fruit generating function
                GenerateAllFruits() to create multiple fruits
            -   added DisplayScore(), ShowFruitLocations() to show the info of the game
            -   added a ShowInstructions() that include NumFruitChoice() and GameMode()
                to show instructions for the player when first opening the game
            -   refactored BorderDraw() to TopBottomBorderDraw()
            -   added ShowFruitLocations() to show the fruit locations,
                ShowSnakeLocations() to show the snake's head's location
            -   separate the if - else statements in Draw() to individual functions:
                    -   CheckSnakeHeadLoc() which checks the snake's head to the current location to
                        draw the head on the board
                    -   CheckFruitLocation() which checks the fruits' location with the current drawing
                        location to draw it
                    -   CheckTailLocation() - the same as the other but checking the tail parts
            -   added Replay() to restart the game after losing or quitting.
        -   02/06/22 - v5:
            -   added GenerateBomb() and CheckBombLocation to add bombs onto the board
                that can the snake to die if eaten.
*/

#include <iostream>

using namespace std;

bool search2D() {

}

bool patternSearch() {

}

int main () {

    return 0;
}