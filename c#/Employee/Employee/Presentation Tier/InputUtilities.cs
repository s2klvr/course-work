//Program Header
//Class Name: InputUtilities
//Programmer: Arron Thornton
//CIS247
//Class Description: This class provides utilities to be used in this
//program and in future programs.  Utilities include getting various
//types of data input and tests each input for validity

using System;

namespace Employee
{
    public class InputUtilities
    {
        private static string GetInput(string inputType)
        {
            string strInput = String.Empty;
            Console.Write("Enter the " + inputType + ": ");
            strInput = Console.ReadLine().Trim( );  // I added in .Trim( ) here to cut any whitespace infront
                                                    // of and behind the user input
            return strInput;
        }

        public static string getStringInputValue(string inputType)
        {
            string value = String.Empty;
            bool valid = false;
            string inputString = String.Empty;
            do
            {
                inputString = GetInput(inputType);
                if (!String.IsNullOrEmpty(inputString))
                {
                    value = inputString;
                    valid = true;
                }
                else
                {
                    value = "Invalid input";
                    valid = false;
                }
                if (!valid)
                    Console.WriteLine("Invalid " + inputType + " try again!"); 
            } while (!valid);

            return value;
        }
        public static int getIntegerInputValue(string inputType)
        {
            bool valid = false;
            int value = 0;
            string inputString = String.Empty;
            do
            {
                inputString = GetInput(inputType);
                if (!(String.IsNullOrEmpty(inputString)))
                {
                    valid = Int32.TryParse(inputString, out value);
                }
                if (!valid)
                    Console.WriteLine("Invalid " + inputType + " try again!"); 
            } while (!valid);
            
            return value;
        }
        public static double getDoubleInputValue(string inputType)
        {
            bool valid = false;
            double value = 0;
            string inputString = String.Empty;
            do
            {
                inputString = GetInput(inputType);
                if (!(String.IsNullOrEmpty(inputString)))
                {
                    valid = Double.TryParse(inputString, out value);
                }
                if (!valid)
                    Console.WriteLine("Invalid " + inputType + " try again!"); 
            } while (!valid);

            return value;
        }
        public static char getCharInputValue(string inputType)
        {
            bool valid = false;
            char value = 'u';
            string inputString = String.Empty;
            do
            {
                inputString = GetInput(inputType);
                if (!(String.IsNullOrEmpty(inputString)))
                {
                    valid = Char.TryParse(inputString, out value);
                }
                if (!valid)
                    Console.WriteLine("Invalid " + inputType + " try again!"); 
            } while (!valid);

            return value;
        }
        
        //added in this method to to change the first letter of a word to a capital letter
        public static string UppercaseFirst(string word)
        {
            if (string.IsNullOrEmpty(word))
            {
                return string.Empty;
            }
            char[] upper = word.ToCharArray();
            upper[0] = char.ToUpper(upper[0]);
            for (int i = 0; i < upper.Length; i++)
            {
                if (Char.IsWhiteSpace(upper[i]))
                {
                    i++;
                    upper[i] = char.ToUpper(upper[i]);
                }
            }
            return new string(upper);
        }
    }
}
