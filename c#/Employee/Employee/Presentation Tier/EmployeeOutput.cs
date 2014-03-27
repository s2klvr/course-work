//Program Header
//Class Name: EmployeeOutput
//Programmer: Arron Thornton
//CIS247
//Class Description: This class provides output functionality for
//displaying information from the objects

using System;

namespace Employee
{
    class EmployeeOutput
    {
        //this method invokes the ToString and WriteToFile methods of the provided object
        public static void DisplayEmployeeInformation(Employee theEmployee)
        {
            Console.WriteLine("\n*************" + theEmployee.EmployeeName + "*************\n");
            Console.WriteLine(theEmployee.ToString());
            theEmployee.WriteToFile();
        }
        //this method displays the static variable containing the number of created objects
        public static void DisplayNumberObjects()
        {
            ApplicationUtilities.DisplayDivider("Number of Employee Object(s): " + Employee.NumOfEmployees);
        }
    }
}
