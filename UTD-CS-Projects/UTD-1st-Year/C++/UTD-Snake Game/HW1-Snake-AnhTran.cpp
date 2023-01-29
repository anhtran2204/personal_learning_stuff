// SnakeGame - Orig from the Web
// Original code by N. Vitanovic
// see his YouTube video here: https://bit.ly/29WZ5Ml

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
#include <chrono>
#include <conio.h>
#include <windows.h>

using namespace std;

//------------------------ATTRIBUTES-------------------------//
bool gameOver;
const int width = 20;
const int height = 20;
const int fruitBonus = 10;
const int maxTails = 100; // maximum number of tails the snake can gain
const int fruitLimit = 5; // maximum number of fruits allowed to be present
const int bombLimit = 5;
int numFruits;                                    // number of fruits the user wants to have on the board
int numBombs;                                     // number of bombs that would be present - randomly generated each time
int snakeHeadXLoc, snakeHeadYLoc;                 // location of the snake on the board
int fruitXLoc[fruitLimit], fruitYLoc[fruitLimit]; // locations of the fruit on the board
int tailXLoc[maxTails], tailYLoc[maxTails];       // locations of each part of the tail on the board
int bombXLoc[bombLimit], bombYLoc[bombLimit];     // locations of the bombs on the board
int numTails;
int score;
int speed = 30; // initial speed of the snake
bool hardMode;  // difficulty mode of the game involving not hitting the wall
int timer;
enum eDirecton
{
    STOP = 0,
    LEFT,
    RIGHT,
    UP,
    DOWN
};
eDirecton snakeDir;

//-----------------------DEBUGGING---------------------------//
bool debugging = false; // Debugging trigger

/** Debugging function that shows the
    current function's name
 */
void showFlow(string location)
{
    if (debugging)
    {
        cout << "---- " << location << " ----" << endl;
        system("pause");
    }
} // showFlow

//-----------------------GAME SETUP--------------------------//

/** Function to create the fruits for setup */
void GenerateAllFruits()
{
    showFlow("GenerateAllFruits");

    srand(time(0));
    for (int i = 0; i < numFruits; i++)
    {
        fruitXLoc[i] = (rand() % (width - 2)) + 1;
        fruitYLoc[i] = (rand() % (height - 2)) + 1;
    }
    showFlow("LEAVING GenerateAllFruits");
} //GenerateFruit

/** Function to create the bombs for setup */
void GenerateAllBombs()
{
    showFlow("GenerateAllBombs");

    srand(time(0));
    for (int i = 0; i < numBombs; i++)
    {
        bombXLoc[i] = (rand() % (width - 1)) + 1;
        bombYLoc[i] = (rand() % (height - 1)) + 1;
    }
    showFlow("LEAVING GenerateAllBombs");
}

/** Function to create the top and
    bottom border of the game
*/
void TopBottomBorder()
{
    showFlow("TopBottomBorder");

    for (int i = 0; i < width + 2; i++)
        cout << "#";
    cout << endl;

    showFlow("LEAVING TopBottomBorder");
} // BorderDraw

/** Function that takes user input from
    keyboard to move the snake around
*/
void Input()
{
    showFlow("Input");

    if (_kbhit())
    {
        switch (_getch())
        {
        case 'a':
        case 'A':
            snakeDir = LEFT;
            break;
        case 'd':
        case 'D':
            snakeDir = RIGHT;
            break;
        case 'w':
        case 'W':
            snakeDir = UP;
            break;
        case 's':
        case 'S':
            snakeDir = DOWN;
            break;
        case 'x':
        case 'X':
        case 'q':
        case 'Q':
            gameOver = true;
            break;
        case 'p':
        case 'P':
            while (!_kbhit())
            {
                // do nothing and wait for user input
            }
        }
    }

    showFlow("LEAVING Input");
} // Input

/** Function that display the score
    after eating a fruit
*/
void DisplayScore()
{
    showFlow("DisplayScore");

    cout << "Score:" << score << endl;

    showFlow("LEAVING DisplayScore");
} // DisplayScore

/** Function that iterate through the fruits
    and return the location of each fruit
*/
void ShowFruitLocations()
{
    showFlow("ShowFruitLocations");

    for (int i = 0; i < numFruits; i++)
    {
        cout << "Fruit " << i + 1 << ": " << fruitXLoc[i] << ", " << fruitYLoc[i] << endl;
    }

    showFlow("LEAVING ShowFruitLocations");
} // ShowFruitLocations

/** Function that prints out the location of the snake's head location */
void ShowSnakeLocations()
{
    showFlow("ShowSnakeLocations");
    cout << "Snake Location: " << snakeHeadXLoc << ", " << snakeHeadYLoc << endl;
    showFlow("LEAVING ShowSnakeLocations");
}

/** Function that check the difficulty mode
    chosen by the user and return true or false
*/
void GameMode()
{
    showFlow("GameMode");

    int gameMode;
    cout << "Which game mode would you like to play?\n\t1. Easy mode\n\t2. Hard mode" << endl;
    cin >> gameMode;

    while (true)
    {
        switch (gameMode)
        {
        case 1:
            hardMode = false;
            break;
        case 2:
            hardMode = true;
            break;
        default:
            cout << "Please choose again!" << endl;
            cout << "Which game mode would you like to play?\n\t1. Easy mode\n\t2. Hard mode" << endl;
            cin >> gameMode;
        }
        break;
    }

    showFlow("LEAVING GameMode");
} // GameMode

/** Function that ask the user for input
    about the number of fruits to be present
    on the board
*/
void NumFruitsChoice()
{
    showFlow("NumFruitsChoice");

    cout << "How many fruits would you like to have? Max of 5 at any time." << endl;
    cin >> numFruits;

    showFlow("LEAVING NumFruitsChoice");
} // NumFruitChoice

/** Function that shows the instructions
    at the start of the game and calls the
    GameMode() and NumFruitChoice() for the
    user to choose.
*/
void ShowInstructions()
{
    showFlow("ShowInstructions");

    system("cls");
    cout << "Welcome to the Snake Game!" << endl;

    GameMode();
    NumFruitsChoice();

    cout << "Good luck on the game!" << endl;

    showFlow("LEAVING ShowInstructions");
} // ShowInstructions

/** Function that setup the game */
void Setup()
{
    showFlow("Setup");

    gameOver = false;
    snakeDir = STOP;                     // Setting up the snake's initial motion
    numTails = 0;                        // Set the tail back to 0 in case the game was restarted
    numBombs = (rand() % bombLimit) + 1; // Set a random number of bombs to be generated

    // Generate the snake head's at the center
    snakeHeadXLoc = width / 2;
    snakeHeadYLoc = height / 2;

    score = 0;
    timer = 0;

    // Initialize the first fruit
    GenerateAllFruits();
    GenerateAllBombs();

    showFlow("LEAVING Setup");
} //Setup

//-------------------------LOGIC----------------------------//

/** Function that iterate through the fruits
    and check if the current location matches
    the current iterated fruit's location
*/
bool CheckFruitLocation(int currentXLoc, int currentYLoc)
{
    showFlow("CheckFruitLocation");

    for (int i = 0; i < numFruits; i++)
    {
        if (currentXLoc == fruitXLoc[i] && currentYLoc == fruitYLoc[i])
        {
            showFlow("LEAVING CheckFruitLocation");
            return true;
        }
    }
    showFlow("LEAVING CheckFruitLocation");
    return false;
} // CheckFruitLocation

/** Function that iterate through the bombs
    and check if the current location matches
    the current iterated bomb's location
*/
bool CheckBombLocation(int currentXLoc, int currentYLoc)
{
    showFlow("CheckBombLocation");

    for (int i = 0; i < numBombs; i++)
    {
        if (currentXLoc == bombXLoc[i] && currentYLoc == bombYLoc[i])
        {
            showFlow("LEAVING CheckBombLocation");
            return true;
        }
    }
    showFlow("LEAVING CheckBombLocation");
    return false;
} // CheckBombLocation

/** Function that checks whether the current location
    matches the snake's head location
*/
bool CheckSnakeHeadLoc(int currentXLoc, int currentYLoc)
{
    showFlow("CheckSnakeHeadLoc");

    if (currentYLoc == snakeHeadYLoc && currentXLoc == snakeHeadXLoc)
    {
        showFlow("LEAVING CheckSnakeHeadLoc");
        return true;
    }
    else
    {
        showFlow("LEAVING CheckSnakeHeadLoc");
        return false;
    }
} // CheckSnakeHeadLoc

/** Function that checks whether the current location matches
    where the tail should be and then prints out a part of the tail
*/
void CheckTailLocation(bool &print, int currentXLoc, int currentYLoc)
{
    showFlow("CheckTailLocation");

    for (int i = 0; i < numTails; i++)
    {
        if (tailXLoc[i] == currentXLoc && tailYLoc[i] == currentYLoc)
        {
            cout << "o";
            print = true;
        }
    }

    showFlow("LEAVING CheckTailLocation");
} // CheckTailLocation

/** Function to continuously increase the tails
    of the snake after eating a fruit
*/
void TailIncrease()
{
    showFlow("TailIncrease");

    for (int i = 0; i < numFruits; i++)
    {
        if (snakeHeadXLoc == fruitXLoc[i] && snakeHeadYLoc == fruitYLoc[i])
        {
            score += fruitBonus;

            srand(time(0));
            fruitXLoc[i] = rand() % width + 1;
            fruitYLoc[i] = rand() % height + 1;

            numTails++;
            speed--;
            if (speed <= 0)
            {
                speed = 0;
            }
        }
    }

    showFlow("LEAVING TailIncrease");
} // TailIncrease

/** Function to check if the snake
    had collision with the wall
*/
void WallCollision()
{
    showFlow("WallCollision");

    if (hardMode)
    { // Initialize hard mode that checks if the snake run into the wall to end game
        if (snakeHeadXLoc > width || snakeHeadXLoc < 0 || snakeHeadYLoc > height || snakeHeadYLoc < 0)
        {
            cout << "You hit the wall!" << endl;
            gameOver = true;
        }
    }
    else
    {
        // This portion of code is for the snake
        // to continuously travel throughout the map
        // without having to end the game when
        // hitting the borders
        if (snakeHeadXLoc >= width)
            snakeHeadXLoc = 0;
        else if (snakeHeadXLoc < 0)
            snakeHeadXLoc = width - 1;
        if (snakeHeadYLoc >= height)
            snakeHeadYLoc = 0;
        else if (snakeHeadYLoc < 0)
            snakeHeadYLoc = height - 1;
    }

    showFlow("LEAVING WallCollision");
} // WallCollision

/** Function to check if the head and tail
    of the snake touch each other
*/
void HeadTailCollision()
{
    showFlow("HeadTailCollision");

    for (int i = 0; i < numTails; i++)
    {
        if (tailXLoc[i] == snakeHeadXLoc && tailYLoc[i] == snakeHeadYLoc)
        {
            cout << "You ate your own tail!" << endl;
            gameOver = true;
        }
    }

    showFlow("LEAVING HeadTailCollision");
} // HeadTailCollision

/** Function to check if the snake
    had collision with the bomb
*/
void BombCollision()
{
    showFlow("BombCollision");

    for (int i = 0; i < numBombs; i++)
    {
        if (snakeHeadXLoc == bombXLoc[i] && snakeHeadYLoc == bombYLoc[i])
        {
            cout << "You ate a bomb!" << endl;
            gameOver = true;
        }
    }

    showFlow("LEAVING BombCollision");
}

/** Function that update the movement
    of the snake's head according to
    the user's input
*/
void HeadMovement()
{
    showFlow("HeadMovement");

    switch (snakeDir)
    {
    case LEFT:
        snakeHeadXLoc--;
        break;
    case RIGHT:
        snakeHeadXLoc++;
        break;
    case UP:
        snakeHeadYLoc--;
        break;
    case DOWN:
        snakeHeadYLoc++;
        break;
    default:
        break;
    }

    showFlow("LEAVING HeadMovement");
} // HeadMovement

/** Function that continuously update the
    snake's tail movement following the head
*/
void TailMovement()
{
    showFlow("TailMovement");

    int prevTailXLoc = tailXLoc[0]; // Letting the previous X-loc to be the first position of the tail
    int prevTailYLoc = tailYLoc[0]; // Letting the previous Y-loc to be the first position of the tail
    int prev2TailXLoc, prev2TailYLoc;
    tailXLoc[0] = snakeHeadXLoc;
    tailYLoc[0] = snakeHeadYLoc;
    for (int i = 1; i < numTails; i++)
    {
        prev2TailXLoc = tailXLoc[i];
        prev2TailYLoc = tailYLoc[i];
        tailXLoc[i] = prevTailXLoc;
        tailYLoc[i] = prevTailYLoc;
        prevTailXLoc = prev2TailXLoc;
        prevTailYLoc = prev2TailYLoc;
    }

    showFlow("LEAVING TailMovement");
} // TailMovement

/** Function that ask the user whether to restart
    the same either after losing or quitting
*/
bool Replay()
{
    showFlow("Replay");

    char choice;
    cout << "Would you like to play again? (Y/N) ";
    cin >> choice;

    while (true)
    {
        switch (choice)
        {
        case 'Y':
        case 'y':
            return true;
        case 'N':
        case 'n':
            cout << "\nThank you for playing!" << endl;
            return false;
        default:
            cout << "Please choose again!" << endl;
            cout << "Would you like to play again? (Y/N) ";
            cin >> choice;
        }
    }

    showFlow("LEAVING Replay");
} // Replay

void GameOverCheck()
{
    WallCollision();
    HeadTailCollision();
    BombCollision();
}

/** Function that handles the logic
    of the snake's movement
*/
void Logic()
{
    showFlow("Logic");

    TailMovement();
    HeadMovement();
    GameOverCheck();
    TailIncrease();

    if (timer > 0 && timer % 100 == 0)
    {
        GenerateAllBombs();
    }

    showFlow("LEAVING Logic");
} // Logic

//--------------------------DRAW---------------------------//

/** Function to draw the plane where the
    snake will be moving in
*/
void Draw()
{
    showFlow("Draw");

    system("cls");
    //    system("clear");ww

    TopBottomBorder();
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            if (j == 0)
                cout << "#"; // Drawing the left and right borders
            if (CheckSnakeHeadLoc(j, i))
                cout << "O"; // Updating the snake's head
            else if (CheckFruitLocation(j, i))
                cout << "F"; // Drawing the fruit
            else if (CheckBombLocation(j, i))
                cout << "B"; // Drawing the bomb
            else
            {
                bool print = false;
                CheckTailLocation(print, j, i); // Drawing the tails
                if (!print)
                    cout << " ";
            }

            if (j == width - 1)
                cout << "#";
        }
        cout << endl;
    }
    TopBottomBorder();
    DisplayScore();
    ShowSnakeLocations();
    ShowFruitLocations();

    showFlow("LEAVING Draw");
} // Draw

//--------------------------MAIN---------------------------//

void Update()
{
    while (!gameOver)
    {
        Draw();
        Input();
        Logic();
        Sleep(speed); //sleep(10);
        timer++;
    }
}

/** Main function that executes the game
    and calls the other methods
*/
int main()
{
    showFlow("main");

    ShowInstructions();
    Setup();
    Update();

    // Checks if the user wants to replay
    // If yes, then execute main() again
    if (Replay())
    {
        main();
    }

    showFlow("LEAVING main");

    return 0;
} // main
