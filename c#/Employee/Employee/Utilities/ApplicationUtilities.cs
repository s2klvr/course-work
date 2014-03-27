//Program Header
//Class Name: ApplicationUtilities
//Programmer: Arron Thornton
//CIS247
//Class Description: This class provides utilities to be used in this
//program and in future programs.  Utilities includes Application information,
//a divider, an exit message, and a final output

using System;

namespace Employee
{
    public class ApplicationUtilities
    {
        public static void DisplayApplicationInformation()
        {
            Console.WriteLine("Welcome the Basic Employee Program");
            Console.WriteLine("CIS247A, Week 6 Lab");
            Console.WriteLine("Name: Arron Thornton");
            Console.WriteLine("This program gathers the employee information from the user\n" +
                              "and creates an object from the Employee class.");
            Console.WriteLine();
        }
        public static void DisplayDivider(string outputTitle)
        {
            Console.WriteLine("\n**************** {0} ****************\n", outputTitle);
        }
        public static void TerminateApplication()
        {
            DisplayDivider("Program Termination");
            Console.Write("Thank you.  Press any key to terminate the program...");
            Console.ReadKey();
        }
        public static void PauseExecution()
        {
            Console.Write("\nProgram paused, press any key to continue...");
            Console.ReadKey();
            Console.WriteLine();
        }
    }
}
