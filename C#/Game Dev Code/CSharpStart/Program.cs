using System;

namespace CSharpStart
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            Console.WriteLine("int - whole numbers");
            Console.WriteLine("float - decimals");
            Console.WriteLine("long - 64 bit int");
            Console.WriteLine("double - 64 bit floats");
            Console.WriteLine("byte - 8 bits");
            Console.WriteLine("booleans - True/False, Binary, 1-bit");
            Console.WriteLine("char - letters, symbols, etc. Only 1");
            Console.WriteLine("String - more than one char");

            int x = 25;
            float y = 1.245f;
            String name = "Destroyer of World";
            Console.WriteLine(name + " is a copyrighted name " + x.ToString());

            Console.WriteLine("Type a number in: ");
            int num1 = Convert.ToInt32(Console.ReadLine());
            int num3 = num1 + x;
            Console.WriteLine(num3);

            if (num1 == x)
            {
                Console.WriteLine("How did you know?");
            }
            else
            {
                Console.WriteLine("That's not the number I was thinking of.");
            }

            while (num1 == num3)
            {
                Console.WriteLine("Let's change the number: ");
                num1 = Convert.ToInt32(Console.ReadLine());
                Console.Beep();
            }

            for (int i = 0; i < 10; i++)
            {
                Console.Beep();
                Console.WriteLine("That's weird!");
            }
        }
    }
}
