using System;
using System.Collections.Generic;

namespace Banking
{
    class BankApp
    {
        static Dictionary<string, double> bankAccounts = new Dictionary<string, double>();
        static void Main(string[] args)
        {
            bankApp();
        }

        static void bankApp()
        {
            double balance;
            int passTry = 0;
            bool quit = false;
            while (passTry <= 3 && quit == false)
            {
                Console.WriteLine("Hello dear customer!\n");
                sleep();
                Console.WriteLine("Welcome to the Bank!\n");
                Console.WriteLine("***********************\n");
                sleep();
                Console.WriteLine("May I ask what your name is?\n");
                string name = Console.ReadLine();
                sleep();
                Console.WriteLine("\nWelcome to the bank, " + name + "!\n");
                sleep();
                Console.Write("Please enter your account ID: ");
                string accID = Console.ReadLine();
                Console.Write("\nPlease enter the password: ");
                string password = Console.ReadLine();

                if (!bankAccounts.ContainsKey(accID))
                {
                    balance = 0;
                    bankAccounts.Add(accID, balance);
                }
                balance = bankAccounts[accID];

                if (accID == "anhtran2204" && password == "anhphantran2002@")
                {
                    sleep();
                    Console.WriteLine("\nAccess Granted!\n");

                    int replay = 0;
                    while (replay == 0)
                    {
                        if (balance == 0)
                        {
                            sleep();
                            Console.WriteLine("Your bank account is currently empty!\nPlease deposit money!\n");
                        }
                        sleep();
                        Console.WriteLine("What would you like to do?\n1 - Deposit.\n2 - Withdraw.\n3 - Exit application.\n");
                        sleep();

                        while (true)
                        {
                            Console.Write("Please enter your choice: ");
                            int choice = Convert.ToInt32(Console.ReadLine());
                            try
                            {
                                switch (choice)
                                {
                                    case 1:
                                        Console.Write("\nEnter the deposit amount: ");
                                        double deposit = Convert.ToDouble(Console.ReadLine());
                                        balance += deposit;
                                        sleep();
                                        Console.WriteLine("\nYou deposited " + deposit);
                                        sleep();
                                        Console.WriteLine("Current balance: " + balance + "\n");
                                        break;
                                    case 2:
                                        Console.Write("\nEnter the withdrawal amount: ");
                                        int withdraw = Convert.ToInt32(Console.ReadLine());
                                        balance -= withdraw;
                                        sleep();
                                        if (balance < 0)
                                        {
                                            Console.WriteLine("\nInsufficient Balance!\n");
                                        }
                                        else
                                        {
                                            Console.WriteLine("\nYou withdrew " + withdraw);
                                            sleep();
                                            Console.WriteLine("Current balance: " + balance + "\n");
                                        }
                                        break;

                                    case 3:
                                        replay = 1;
                                        sleep();
                                        Console.WriteLine("\nThanks for using our service!\n");
                                        quit = true;
                                        break;

                                    default:
                                        sleep();
                                        Console.WriteLine("Invalid Input!\nPlease enter again!\n");
                                        break;
                                }
                                break;
                            }
                            catch (System.FormatException e)
                            {
                                sleep();
                                Console.WriteLine("Invalid Inputs!\n");
                                sleep();
                                Console.WriteLine("Please try again!\n");
                                break;
                            }
                        }
                    }
                }
                else if (accID == null && password == null)
                {
                    sleep();
                    Console.WriteLine("Invalid Inputs!\n");
                    sleep();
                    Console.WriteLine("Please try again!\n");
                }
                else
                {
                    sleep();
                    Console.WriteLine("\nAccess Denied!\n");
                    sleep();
                    Console.WriteLine("Wrong account ID or password!\n");
                    sleep();
                    Console.WriteLine("Please try again!\n");
                    passTry++;
                }
                Console.WriteLine("------------------------\n");
            }

            if (passTry == 3)
            {
                sleep();
                Console.WriteLine("\nToo many failed login attempts\nAccount is temporarily locked!\n");
            }
        }
        static void sleep()
        {
            System.Threading.Thread.Sleep(1000);
        }
    }
}


