using System;

namespace Avatar
{
    class Program
    {
        static void Main(string[] args)
        {
            bool quit = false;
            while (quit)
            {
                Console.WriteLine("Welcome to Avatar!\n");
                sleep();
                Console.Write("What is your name?\n");
                sleep();
                string pName = Console.ReadLine();
                sleep();
                Console.WriteLine("\nHello, " + pName + "!\n");
                sleep();

                int replay = 0;
                int pScore = 0;
                int cScore = 0;
                int nCounter = 0;

                while (replay == 0)
                {
                    Console.WriteLine("Choose Fire, Water, Earth, Wind,Lightning, or Metal?\n");
                    sleep();
                    Console.WriteLine("1 - Fire\n2 - Water\n3 - Earth\n4 - Air\n5 - Lightning\n6 - Metal\n7 - Yin-Yang\n");
                    sleep();
                    int pChoice = Convert.ToInt32(Console.ReadLine());
                    Random rand = new Random();
                    int chance = rand.Next(1, 5);
                    Console.WriteLine(chance);
                    sleep();
                    if (pChoice == 6)
                    {
                        Console.WriteLine(pName = " wins!");
                        nCounter += 1;
                        pChoice += 1;
                        sleep();
                    }
                    if (pChoice != chance)
                    {
                        if (pChoice == 1 && chance == 3)
                        {
                            Console.WriteLine(pName + " wins!");
                            pScore += 1;
                            sleep();
                        }
                        else if (pChoice == 1 && chance == 5)
                        {
                            Console.WriteLine(pName + " wins!");
                            pScore += 1;
                            sleep();
                        }
                        else if (pChoice == 1 && chance == 6)
                        {
                            Console.WriteLine(pName + " wins!");
                            pScore += 1;
                            sleep();
                        }
                        else if (pChoice == 2 && chance == 1)
                        {
                            Console.WriteLine(pName + " wins!");
                            pScore += 1;
                            sleep();
                        }
                        else if (pChoice == 2 && chance == 3)
                        {
                            Console.WriteLine(pName + " wins!");
                            pScore += 1;
                            sleep();
                        }
                        else if (pChoice == 3 && chance == 1)
                        {
                            Console.WriteLine(pName + " wins!");
                            pScore += 1;
                            sleep();
                        }
                        else if (pChoice == 3 && chance == 2)
                        {
                            Console.WriteLine(pName + " wins!");
                            pScore += 1;
                            sleep();
                        }
                        else if (pChoice == 3 && chance == 4)
                        {
                            Console.WriteLine(pName + " wins!");
                            pScore += 1;
                            sleep();
                        }
                        else if (pChoice == 3 && chance == 5)
                        {
                            Console.WriteLine(pName + " wins!");
                            pScore += 1;
                            sleep();
                        }
                        else if (pChoice == 4 && chance == 1)
                        {
                            Console.WriteLine(pName + " wins!");
                            pScore += 1;
                            sleep();
                        }
                        else if (pChoice == 4 && chance == 2)
                        {
                            Console.WriteLine(pName + " wins!");
                            pScore += 1;
                            sleep();
                        }
                        else if (pChoice == 4 && chance == 5)
                        {
                            Console.WriteLine(pName + " wins!");
                            pScore += 1;
                            sleep();
                        }
                        else if (pChoice == 5 && chance == 2)
                        {
                            Console.WriteLine(pName + " wins!");
                            pScore += 1;
                            sleep();
                        }
                        else if (pChoice == 5 && chance == 3)
                        {
                            Console.WriteLine(pName + " wins!");
                            pScore += 1;
                            sleep();
                        }
                        else if (pChoice == 6 && chance == 3)
                        {
                            Console.WriteLine(pName + " wins!");
                            pScore += 1;
                            sleep();
                        }
                        else if (pChoice == 6 && chance == 4)
                        {
                            Console.WriteLine(pName + " wins!");
                            pScore += 1;
                            sleep();
                        }
                        else if (pChoice == 1 && chance == 2)
                        {
                            Console.WriteLine("Computer wins!");
                            cScore += 1;
                            sleep();
                        }
                        else if (pChoice == 1 && chance == 4)
                        {
                            Console.WriteLine("Computer wins!");
                            cScore += 1;
                            sleep();
                        }
                        else if (pChoice == 2 && chance == 3)
                        {
                            Console.WriteLine("Computer wins!");
                            cScore += 1;
                            sleep();
                        }
                        else if (pChoice == 2 && chance == 4)
                        {
                            Console.WriteLine("Computer wins!");
                            cScore += 1;
                            sleep();
                        }
                        else if (pChoice == 2 && chance == 5)
                        {
                            Console.WriteLine("Computer wins!");
                            cScore += 1;
                            sleep();
                        }
                        else if (pChoice == 3 && chance == 1)
                        {
                            Console.WriteLine("Computer wins!");
                            cScore += 1;
                            sleep();
                        }
                        else if (pChoice == 3 && chance == 5)
                        {
                            Console.WriteLine("Computer wins!");
                            cScore += 1;
                            sleep();
                        }
                        else if (pChoice == 3 && chance == 6)
                        {
                            Console.WriteLine("Computer wins!");
                            cScore += 1;
                            sleep();
                        }
                        else if (pChoice == 4 && chance == 3)
                        {
                            Console.WriteLine("Computer wins!");
                            cScore += 1;
                            sleep();
                        }
                        else if (pChoice == 4 && chance == 6)
                        {
                            Console.WriteLine("Computer wins!");
                            cScore += 1;
                            sleep();
                        }
                        else if (pChoice == 5 && chance == 2)
                        {
                            Console.WriteLine(pName + " wins!");
                            cScore += 1;
                            sleep();
                        }
                        else if (pChoice == 5 && chance == 3)
                        {
                            Console.WriteLine(pName + " wins!");
                            cScore += 1;
                            sleep();
                        }
                        else if (pChoice == 5 && chance == 6)
                        {
                            Console.WriteLine(pName + " wins!");
                            cScore += 1;
                            sleep();
                        }
                        else if (pChoice == 6 && chance == 1)
                        {
                            Console.WriteLine(pName + " wins!");
                            cScore += 1;
                            sleep();
                        }
                        else if (pChoice == 6 && chance == 5)
                        {
                            Console.WriteLine(pName + " wins!");
                            cScore += 1;
                            sleep();
                        }
                    }
                    else
                    {
                        Console.WriteLine("It's a tie!");
                        sleep();
                    }

                    if (nCounter >= 3)
                    {
                        Console.WriteLine("I don't want to play anymore!");
                        sleep();
                        replay = 2;
                        break;
                    }
                    else
                    {
                        Console.WriteLine("Computer: " + cScore + ", " + pName + ": " + pScore);
                        sleep();
                        Console.WriteLine("Play Again?");
                        sleep();
                        Console.WriteLine("1 - Yes, 2 - No");
                        replay = Convert.ToInt32(Console.ReadLine());
                    }
                    Console.WriteLine("Thanks for playing!");
                }
            }
        }

        static void sleep()
        {
            System.Threading.Thread.Sleep(1000);
        }
    }
}
