using System;

namespace StringReversal
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = "";
            Console.WriteLine("Please enter a string to be reversed:");
            input = Console.ReadLine();

            Console.WriteLine(StringReverse(input));
            Console.ReadLine();

            
        }

        public static string StringReverse(string input)
        {
            char[] inputString = input.ToCharArray();
            Array.Reverse(inputString);
            return new string(inputString);
        }
    }
}
