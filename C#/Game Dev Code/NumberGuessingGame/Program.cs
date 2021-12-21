using System;

namespace NumberGuessingGame
{
    class Program
    {
        public static void Main(string[] args)
        {
            bool win = false;
            Random r = new Random();
            int newNum = r.Next(0, 200);

            Console.WriteLine("Welcome to the guessing game!\n");
            Console.WriteLine("What's your name?");
            bool flag = false;
            while (!flag)
            {
                String name = Console.ReadLine();
                if (name != "")
                {
                    Console.WriteLine("\nHello, " + name + "!\nLet's start the game!\n");
                    flag = true;
                } else
                {
                    Console.WriteLine("Please enter your name!");
                }
            }

            int turn = 0;
            while (!win)
            {
                try
                {
                    Console.WriteLine("Type in your guessing number: ");
                    int guess = Convert.ToInt32(Console.ReadLine());

                    if (guess > newNum)
                    {
                        Console.WriteLine("Too high, go lower!\n");
                        turn++;
                    }
                    else if (guess < newNum)
                    {
                        Console.WriteLine("Too low, go higher!\n");
                        turn++;
                    }
                    else
                    {
                        Console.WriteLine("You got the number!!!\n");
                        turn++;
                        win = true;
                    }
                } catch (FormatException e)
                {
                    Console.WriteLine("Invalid Number!\nPlease type in a number!\n");
                    Console.WriteLine("Type in your guessing number: ");
                    int guess = Convert.ToInt32(Console.ReadLine());

                    if (guess > newNum)
                    {
                        Console.WriteLine("Too high, go lower!\n");
                        turn++;
                    }
                    else if (guess < newNum)
                    {
                        Console.WriteLine("Too low, go higher!\n");
                        turn++;
                    }
                    else
                    {
                        Console.WriteLine("You got the number!!!\n");
                        turn++;
                        win = true;
                    }
                }
            }
            Console.WriteLine("You took " + turn.ToString() + " tries to guess the number.");
        }
    }
}
