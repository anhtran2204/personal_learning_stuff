// SnakeGame - Orig from the Web
// Original code by N. Vitanovic
// see his YouTube video here: https://bit.ly/29WZ5Ml

/*
    Name: Anh Tran
    Program name: SnakeGame
    Date: 01/24/22
    Notes:
    Changelog:
        - 01/24/22 - v1: reformatted the style of the program to Java.
        - 01/28/22 - v2:
            - refactored names of global variables:
                + x, y to snakeXLoc, snakeYLoc
                + fruitX, fruitY to fruitXLoc, fruitYLoc
                + nTails to numTails
                + dir to snakeDir
            - added the code of GenerateFruit() that was
              originally in the Setup().
            - added the code of BorderDraw() that was
              originally in the Draw().
            - added the code of WallCollision(), HeadTailCollision(),
              and TailIncrease() that were originally in the Logic().
            - added the code of Movement() that was
              originally in the Logic().
            - added a new constant: const int fruitBonus for the
              score to update when it eats a fruit


*/

#include <iostream>
#include <conio.h>
#include <windows.h>

using namespace std;

//--------------------------------------------------------------//
bool gameOver;
const int width = 20;
const int height = 20;
const int fruitBonus = 10;
int snakeXLoc, snakeYLoc; // location of the snake on the board
int fruitXLoc, fruitYLoc; // location of the fruit on the board
int score;
int tailXLoc[100], tailYLoc[100];
int numTails;
enum eDirecton
{
    STOP = 0,
    LEFT,
    RIGHT,
    UP,
    DOWN
};
eDirecton snakeDir;

//--------------------------------------------------------------//

/** Function to create the fruit for setup */
void GenerateFruits()
{
    fruitXLoc = rand() % width;
    fruitYLoc = rand() % height;
} //GenerateFruit

void Setup()
{
    gameOver = false;

    // Setting up the snake's initial motion
    snakeDir = STOP;

    // Generate the snake head's at the center
    snakeXLoc = width / 2;
    snakeYLoc = height / 2;

    score = 0;

    // Initialize the first fruit
    GenerateFruits();
} //Setup

/** Function to create the top and
    bottom border of the game
*/
void BorderDraw()
{
    for (int i = 0; i < width + 2; i++)
        cout << "#";
    cout << endl;
} // BorderDraw

/** Function to draw the plane where the
    snake will be moving in
*/
void Draw()
{
    system("cls");
    //    system("clear");ww

    BorderDraw();
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            if (j == 0)
                cout << "#"; // Drawing the left and right borders
            if (i == snakeYLoc && j == snakeXLoc)
                cout << "O"; // Updating the snake's head
            else if (i == fruitYLoc && j == fruitXLoc)
                cout << "F"; // Drawing the fruit
            else
            {
                bool print = false;
                for (int k = 0; k < numTails; k++)
                {
                    if (tailXLoc[k] == j && tailYLoc[k] == i)
                    {
                        cout << "o"; // Drawing the tails
                        print = true;
                    }
                }
                if (!print)
                    cout << " ";
            }

            if (j == width - 1)
                cout << "#";
        }
        cout << endl;
    }
    BorderDraw();
    cout << "Score:" << score << endl;
} // Draw

/** Function to continuously update the tails
    of the snake after eating a fruit
*/
void TailIncrease()
{
    if (snakeXLoc == fruitXLoc && snakeYLoc == fruitYLoc)
    {
        score += fruitBonus;
        GenerateFruits();
        numTails++;
    }
} // TailIncrease

/** Function that takes user input from
    keyboard to move the snake around
*/
void Input()
{
    if (_kbhit())
    {
        switch (_getch())
        {
        case 'a':
            snakeDir = LEFT;
            break;
        case 'd':
            snakeDir = RIGHT;
            break;
        case 'w':
            snakeDir = UP;
            break;
        case 's':
            snakeDir = DOWN;
            break;
        case 'x':
            gameOver = true;
            break;
        }
    }
} // Input

/** Function to check if the snake
    had collision with the wall
*/
void WallCollision()
{
    //    if (snakeXLoc > width || snakeXLoc < 0 || snakeYLoc > height || snakeYLoc < 0)
    //        gameOver = true;

    // This portion of code is for the snake
    // to continuously travel throughout the map
    // without having to end the game when
    // hitting the borders
    if (snakeXLoc >= width)
        snakeXLoc = 0;
    else if (snakeXLoc < 0)
        snakeXLoc = width - 1;
    if (snakeYLoc >= height)
        snakeYLoc = 0;
    else if (snakeYLoc < 0)
        snakeYLoc = height - 1;

} // WallCollision

/** Function to check if the head and tail
    of the snake touch each other
*/
void HeadTailCollision()
{
    for (int i = 0; i < numTails; i++)
        if (tailXLoc[i] == snakeXLoc && tailYLoc[i] == snakeYLoc)
            gameOver = true;
} // HeadTailCollision

/** Function that update the movement
    of the snake's head according to
    the user's input
*/
void HeadMovement()
{
    switch (snakeDir)
    {
    case LEFT:
        snakeXLoc--;
        break;
    case RIGHT:
        snakeXLoc++;
        break;
    case UP:
        snakeYLoc--;
        break;
    case DOWN:
        snakeYLoc++;
        break;
    default:
        break;
    }
} // HeadMovement

/** Function that continuously update the
    snake's tail movement following the head
*/
void TailMovement()
{
    int prevX = tailXLoc[0];
    int prevY = tailYLoc[0];
    int prev2X, prev2Y;
    tailXLoc[0] = snakeXLoc;
    tailYLoc[0] = snakeYLoc;
    for (int i = 1; i < numTails; i++)
    {
        prev2X = tailXLoc[i];
        prev2Y = tailYLoc[i];
        tailXLoc[i] = prevX;
        tailYLoc[i] = prevY;
        prevX = prev2X;
        prevY = prev2Y;
    }
}

void Logic()
{
    TailMovement();
    HeadMovement();
    WallCollision();
    HeadTailCollision();
    TailIncrease();
} // Logic

int main()
{
    Setup();
    while (!gameOver)
    {
        Draw();
        Input();
        Logic();
        Sleep(10); //sleep(10);
    }
    return 0;
} // main
