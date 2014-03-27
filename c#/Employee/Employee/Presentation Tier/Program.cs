//Program Header
//Program Name: Basic User Interface
//Programmer: Arron Thornton
//CIS247, Week 6 Lab
//Program Description: This program gathers Employee information
//from the user and then creates an object using the user input

using System;

namespace Employee
{
    class Program
    {
        static void Main(string[] args)
        {
            ApplicationUtilities.DisplayApplicationInformation();
            ApplicationUtilities.DisplayDivider("Start Program");
            //here we declare our object array
            Employee[] userEmployee = {new Hourly("Hourly"), new Salary("Salary")};
            //this for loop loops through all of the objects in our array and gathers the input depending
            //on if it is a hourly, salary, or base object
            for (int i = 0; i < userEmployee.Length; i++)
            {
                if (userEmployee[i] is Hourly)
                {
                    ApplicationUtilities.DisplayDivider("Enter Hourly Information");
                    EmployeeInput.CollectEmployeeInformation(userEmployee[i]);
                    EmployeeInput.CollectHourlyInformation((Hourly)userEmployee[i]);
                }
                else if (userEmployee[i] is Salary)
                {
                    ApplicationUtilities.DisplayDivider("Enter Salary Information");
                    EmployeeInput.CollectEmployeeInformation(userEmployee[i]);
                    EmployeeInput.CollectSalaryInformation((Salary)userEmployee[i]);
                }
                else
                {
                    ApplicationUtilities.DisplayDivider("Enter Employee's Information");
                    EmployeeInput.CollectEmployeeInformation(userEmployee[i]);
                }
                userEmployee[i].CalculateWeeklyPay();
                EmployeeOutput.DisplayEmployeeInformation(userEmployee[i]);
                ApplicationUtilities.PauseExecution();
            }
            EmployeeOutput.DisplayNumberObjects();

            Console.WriteLine();

            ApplicationUtilities.TerminateApplication();
        }
    }
}
