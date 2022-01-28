// SnakeGame - Orig from the Web
// Original code by N. Vitanovic
// see his YouTube video here: https://bit.ly/29WZ5Ml

/*  
    Name: Anh Tran
    Program name: snake_game.cpp
    Date: 01/24/22
    Notes: 
    Changelog:
        - 01/24/22 - v1: reformatted the 
*/

#include <iostream>
#include <conio.h>
#include <windows.h>
using namespace std;
bool gameOver;
const int width = 20;
const int height = 20;
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
void GenerateFruit() // Function to create the fruit for setup
{
    fruitXLoc = rand() % width;
    fruitYLoc = rand() % height;
}
void Setup()
{
    gameOver = false;
    snakeDir = STOP;
    snakeXLoc = width / 2;
    snakeYLoc = height / 2;
    GenerateFruit();
    score = 0;
}
void Draw()
{
    system("cls"); //system("clear");
    for (int i = 0; i < width + 2; i++)
        cout << "#";
    cout << endl;

    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            if (j == 0)
                cout << "#";
            if (i == snakeXLoc && j == snakeYLoc)
                cout << "O";
            else if (i == fruitXLoc && j == fruitYLoc)
                cout << "F";
            else
            {
                bool print = false;
                for (int k = 0; k < numTails; k++)
                {
                    if (tailXLoc[k] == j && tailYLoc[k] == i)
                    {
                        cout << "o";
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

    for (int i = 0; i < width + 2; i++)
        cout << "#";
    cout << endl;
    cout << "Score:" << score << endl;
}
void GameOverCheck() 
{
    if (WallCollision() || HeadTailCollision())
        gameOver = true;
}
bool WallCollision()
{
    if (snakeXLoc > width || snakeXLoc < 0 || snakeYLoc > height || snakeYLoc < 0)
        return true;

    // This portion of code is for the snake
    // to continuously travel throughout the map
    // without having to end the game when 
    // hitting the borders
    // if (snakeXLoc >= width)
    //     snakeXLoc = 0;
    // else if (snakeXLoc < 0)
    //     snakeXLoc = width - 1;
    // if (snakeYLoc >= height)
    //     snakeYLoc = 0;
    // else if (snakeYLoc < 0)
    //     snakeYLoc = height - 1;
}
bool HeadTailCollision()
{
    for (int i = 0; i < numTails; i++)
        if (tailXLoc[i] == snakeXLoc && tailYLoc[i] == snakeYLoc)
            return true;
}
void TailIncrease()
{
    if (snakeXLoc == fruitXLoc && snakeYLoc == fruitYLoc)
    {
        score += 10;
        fruitXLoc = rand() % width;
        fruitYLoc = rand() % height;
        numTails++;
    }
}
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
}
void Logic()
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

    GameOverCheck();
    TailIncrease();
}
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
}