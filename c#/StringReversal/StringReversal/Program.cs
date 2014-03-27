using System;
using System.Collections;

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

            Hashtable myH = new Hashtable();
            
        }

        public static string StringReverse(string input)
        {
            char[] inputString = input.ToCharArray();
            Array.Reverse(inputString);
            return new string(inputString);
        }
    }
}
