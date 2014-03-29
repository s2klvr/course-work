/*
Programmer: Arron Thornton
Description:  This is my derived solution to one of the many coding
challenges.
The task is, given a set of numbers in arithmatic progression, find and
output the missing variable
For example, given the AP of 1, 3, 5, 9, 11, the program would find that 7 is
missing from the progression and will output 7.
*/
using System;

namespace ArithmaticProgression
{
    class Program
    {
        static void Main(string[] args)
        {
            int n;
            int variation = 0;
            int missingVariable = 0;


            Console.WriteLine("Enter length of AP:");
            n = int.Parse(Console.ReadLine());

            int[] numArray = new int[n];

            for (int i = 0; i < numArray.Length; i++)
            {
                Console.Write("\nInteger {0}:\t", i + 1);
                numArray[i] = int.Parse(Console.ReadLine());

            }
            Array.Sort(numArray);

            for (int i = 0; i < n - 1; i++)
            {
                variation += numArray[i + 1] - numArray[i];
            }

            variation /= n;

            for (int i = 0; i < n - 1; i++)
            {
                if (numArray[i + 1] - numArray[i] > variation)
                {
                    missingVariable = numArray[i] + variation;
                }
            }

            Console.WriteLine("Variation:  {0}", variation);
            Console.WriteLine("Missing Variable:  {0}", missingVariable);
            Console.ReadLine();
        }
    }
}
