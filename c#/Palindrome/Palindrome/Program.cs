using System;


namespace Palindrome
{
    class Program
    {
        static void Main(string[] args)
        {
            string userInput = "";
            string reversedString = "";

            Console.WriteLine("Enter a string to see if its a palindrome:  ");
            userInput = Console.ReadLine().Trim( );
            reversedString = userInput;

            char[] array = reversedString.ToCharArray();
            Array.Reverse(array);
            reversedString = new string(array);
            if (userInput == reversedString)
            {
                Console.WriteLine("String is a Palindrome!");
            }
            else
            {
                Console.WriteLine("String is NOT a palindrome.");
            }
            Console.ReadLine();
        }
    }
}
